#include "VM.hpp"

#include <jni.h>
#include <string>
#include <filesystem>
#include <vector>
#include <unordered_map>
#include <fstream>
#include <sstream>
#include <regex>
#include "Util.hpp"
#include "altv-capi-server.h"

#define JAR_NAME "altv-jvm-module.jar"
#define JAR_RELATIVE_PATH "modules/altv-jvm-module/" JAR_NAME
#define JAR_MAIN_CLASS "hazard7/altv/jvm/Main"

#ifdef _WIN32
#include <Windows.h>
std::string JavaHomePath = []() {
    char buf[1024];
    GetEnvironmentVariableA("JAVA_HOME", buf, 1024);
    std::string ret = buf;
    return ret;
}();
using Library = HMODULE;
auto OpenLibrary = LoadLibraryA;
auto GetLibraryFunction = GetProcAddress;
std::string JVMLibraryName = "jvm.dll";
std::string JVMJDKPath = JavaHomePath + "/bin/server/" + JVMLibraryName;
std::string JVMJREPath = JavaHomePath + "/jre/bin/server/" + JVMLibraryName;
LONG GetStringRegKey(HKEY hKey, const std::string &strValueName, std::string &strValue, const std::string &strDefaultValue)
{
    strValue = strDefaultValue;
    CHAR szBuffer[1024];
    DWORD dwBufferSize = sizeof(szBuffer);
    ULONG nError = RegQueryValueExA(hKey, strValueName.c_str(), 0, NULL, (LPBYTE)szBuffer, &dwBufferSize);
    if (nError == ERROR_SUCCESS)
    {
        strValue = szBuffer;
    }
    return nError;
}
#else
#include <dlfcn.h>
std::string JavaHomePath = std::getenv("JAVA_HOME");
using Library = void *;
Library OpenLibrary(const char *name)
{
    return dlopen(name, RTLD_LAZY);
}
constexpr auto GetLibraryFunction = dlsym;
std::string JVMLibraryName = "libjvm.so";
std::string JVMJDKPath = JavaHomePath + "/lib/server/" + JVMLibraryName;
std::string JVMJREPath = JavaHomePath + "/jre/lib/server/" + JVMLibraryName;
#endif

struct JavaVersion
{
    int major = 0;
};
JavaVersion GetJavaVersion(std::string javapath)
{
    std::ifstream file(javapath + "/release");
    if (!file.good())
        return JavaVersion{};
    std::string line;
    while (std::getline(file, line))
    {
        if (line.find("JAVA_VERSION") != std::string::npos)
        {
            std::string ver = std::regex_replace(line, std::regex("JAVA_VERSION"), "");
            ver = std::regex_replace(ver, std::regex("="), "");
            ver = std::regex_replace(ver, std::regex("\""), "");
            // util::logi(ver);
            JavaVersion v;
            v.major = std::stoi(ver.substr(0, ver.find(".")));
            // util::logi(std::to_string(v.major));
            return v;
        }
    }

    return JavaVersion{};
}

std::unordered_map<std::string, JavaVersion> javaPaths;

Library jvmlib = nullptr;
bool LoadLib()
{
    std::string path;
    JavaVersion version{};

#ifdef _WIN32
    { // find through registry
        constexpr auto maxkeylen = 1024;
        HKEY hKey;
        CHAR achKey[maxkeylen];              // buffer for subkey name
        DWORD cbName;                        // size of name string
        TCHAR achClass[MAX_PATH] = TEXT(""); // buffer for class name
        DWORD cchClassName = MAX_PATH;       // size of class string
        DWORD cSubKeys = 0;                  // number of subkeys
        DWORD cbMaxSubKey;                   // longest subkey size
        DWORD cchMaxClass;                   // longest class string
        DWORD cValues;                       // number of values for key
        DWORD cchMaxValue;                   // longest value name
        DWORD cbMaxValueData;                // longest value data
        DWORD cbSecurityDescriptor;          // size of security descriptor
        FILETIME ftLastWriteTime;            // last write time
        auto GetKeyInfo = [&]() {
            RegQueryInfoKey(
                hKey,                  // key handle
                achClass,              // buffer for class name
                &cchClassName,         // size of class string
                NULL,                  // reserved
                &cSubKeys,             // number of subkeys
                &cbMaxSubKey,          // longest subkey size
                &cchMaxClass,          // longest class string
                &cValues,              // number of values for this key
                &cchMaxValue,          // longest value name
                &cbMaxValueData,       // longest value data
                &cbSecurityDescriptor, // security descriptor
                &ftLastWriteTime);     // last write time
        };
        std::string regpath = "SOFTWARE\\JavaSoft\\Java Runtime Environment";
        auto retCode = RegOpenKeyExA(HKEY_LOCAL_MACHINE, regpath.c_str(), 0, KEY_READ, &hKey);
        if (retCode == ERROR_SUCCESS)
        {
            GetKeyInfo();
            for (int i = 0; i < cSubKeys; i++)
            {
                cbName = maxkeylen;
                retCode = RegEnumKeyExA(hKey, i,
                                        achKey,
                                        &cbName,
                                        NULL,
                                        NULL,
                                        NULL,
                                        &ftLastWriteTime);
                if (retCode == ERROR_SUCCESS)
                {
                    auto sregpath = regpath + ("\\") + achKey;
                    HKEY hKey2;
                    auto retCode = RegOpenKeyExA(HKEY_LOCAL_MACHINE, sregpath.c_str(), 0, KEY_READ, &hKey2);
                    if (retCode == ERROR_SUCCESS)
                    {
                        std::string val;
                        retCode = GetStringRegKey(hKey2, "JavaHome", val, "");
                        if (retCode == ERROR_SUCCESS)
                        {
                            // util::logi(val);
                            auto v = GetJavaVersion(val);
                            if (v.major > version.major)
                            {
                                version = v;
                                path = val + "\\bin\\server\\jvm.dll";
                                javaPaths[path] = version;
                            }
                        }
                    }
                }
            }
        }

        regpath = "SOFTWARE\\JavaSoft\\JDK";
        retCode = RegOpenKeyExA(HKEY_LOCAL_MACHINE, regpath.c_str(), 0, KEY_READ, &hKey);
        if (retCode == ERROR_SUCCESS)
        {
            GetKeyInfo();
            for (int i = 0; i < cSubKeys; i++)
            {
                cbName = maxkeylen;
                retCode = RegEnumKeyExA(hKey, i,
                                        achKey,
                                        &cbName,
                                        NULL,
                                        NULL,
                                        NULL,
                                        &ftLastWriteTime);
                if (retCode == ERROR_SUCCESS)
                {
                    auto sregpath = regpath + ("\\") + achKey;
                    HKEY hKey2;
                    auto retCode = RegOpenKeyExA(HKEY_LOCAL_MACHINE, sregpath.c_str(), 0, KEY_READ, &hKey2);
                    if (retCode == ERROR_SUCCESS)
                    {
                        std::string val;
                        retCode = GetStringRegKey(hKey2, "JavaHome", val, "");
                        if (retCode == ERROR_SUCCESS)
                        {
                            // util::logi(val);
                            auto v = GetJavaVersion(val);
                            if (v.major > version.major)
                            {
                                version = v;
                                path = val + "\\bin\\server\\jvm.dll";
                                javaPaths[path] = version;
                            }
                        }
                    }
                }
            }
        }
    }
    { // find through common paths
        // util::logi("PATHS");
        for (auto &p : std::filesystem::directory_iterator("C:/Program Files/Java"))
        {
            // util::logi(p.path().string());
            auto v = GetJavaVersion(p.path().string());
            if (v.major > version.major)
            {
                version = v;
                path = p.path().string() + "\\bin\\server\\jvm.dll";
                javaPaths[path] = version;
            }
        }
    }
#endif

    if (!path.empty())
    {
        jvmlib = OpenLibrary(path.c_str());
    }
    else if (!JavaHomePath.empty())
    {
        bool found = false;
        if (std::filesystem::exists(path = JVMJDKPath))
            found = true;
        else if (std::filesystem::exists(path = JVMJREPath))
            found = true;

        if (found)
        {
            jvmlib = OpenLibrary(path.c_str());
            if (jvmlib)
            {
                util::logi("[JVM] Loaded JVM from JAVA_HOME (" + path + ")");
                return true;
            }
        }
    }
    else
    {
        // Try loading from PATH or anywhere else the system looks
        jvmlib = OpenLibrary(JVMLibraryName.c_str());
        if (!jvmlib)
        {
            util::loge("[JVM] Could not load find a valid Java installation");
            return false;
        }
    }

    return true;
}

jint(JNICALL *CreateJavaVM)(JavaVM **pvm, void **penv, void *args) = nullptr;

uint8_t failedFuncs = 0;
void *LoadFunc(const std::string &name)
{
    auto addr = (void *)GetLibraryFunction(jvmlib, name.c_str());
    if (!addr)
    {
        util::loge("Could not load " + name + " from jvm.dll");
        failedFuncs++;
    }
    return addr;
}

void VM::ReadOptions()
{
    std::ifstream file("server.cfg", std::ios::binary | std::ios::ate);
    std::streamsize size = file.tellg();
    file.seekg(0, std::ios::beg);
    std::vector<char> buffer(size);
    if (file.read(buffer.data(), size))
    {
        auto ReadBool = [](alt_config_Node* node, std::string optionname){
            bool ret = false;
            util::Try([&]{
                auto n = alt_config_Node_Access_charPtr(node, "debug");
                if(alt_config_Node_IsScalar(n))
                {
                    ret = alt_config_Node_ToBool_1(n, false);
                }
            }, [&]{
                util::loge("[JVM] Exception while reading option " + optionname);
            });

            return ret;
        };

        auto parser = alt_config_Parser_Create_2_CAPI_Heap(buffer.data(), size);
        auto node = alt_config_Parser_Parse_CAPI_Heap(parser);
        auto optionsnode = alt_config_Node_Access_charPtr(node, "jvm");
        if(alt_config_Node_IsDict(optionsnode)) {
            option.debug = ReadBool(optionsnode, "debug");
        }

        alt_config_Node_CAPI_Free(node);
        alt_config_Parser_CAPI_Free(parser);
    }
    else
    {
        util::loge("[JVM] Could not read server.cfg");
    }
}

JavaVM *jvm = nullptr;
bool VM::Start()
{
    ReadOptions();

    // Checks
    if (!std::filesystem::exists(JAR_RELATIVE_PATH))
    {
        util::loge("[JVM] Could not find file '" JAR_RELATIVE_PATH "'");
        return false;
    }

    // Dynamic load jvm
    if (!LoadLib())
        return false;

    // dynamic load jni funcs
    CreateJavaVM = (decltype(CreateJavaVM))LoadFunc("JNI_CreateJavaVM");
    if (failedFuncs > 0)
    {
        // util::loge("[JVM] Could not properly load all JNI functions");
        return false;
    }

    util::logi("[JVM] Starting Java VM (Module Version '" JVM_MODULE_VERSION "')");

    JNIEnv *env;            /* pointer to native method interface */
    JavaVMInitArgs vm_args; /* JDK/JRE 6 VM initialization arguments */
    // memset(&vm_args, 0, sizeof(vm_args));

    // Options
    // OBS: SYNTAX MISTAKES CAN CAUSE INSTA-CRASH
    std::vector<JavaVMOption> options = {
        JavaVMOption{(char *)"-Djava.class.path=modules/altv-jvm-module;" JAR_RELATIVE_PATH, nullptr},
        JavaVMOption{(char *)"-Djava.library.path=modules/altv-jvm-module", nullptr},
        JavaVMOption{(char *)"-XX:+ShowMessageBoxOnError", nullptr},
        JavaVMOption{(char *)"-XX:ErrorFile=logs/jvm/fatal-error.log", nullptr},
        JavaVMOption{(char *)"-XX:+AllowUserSignalHandlers", nullptr},
        // JavaVMOption{(char*)"-verbose:class,gc,jni", nullptr},
    };
    if (option.debug)
    {
        util::logi("[JVM] Debug mode");
        options.push_back(JavaVMOption{(char *)"-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", nullptr});
    }

    vm_args.nOptions = options.size();
    vm_args.options = options.data();
    vm_args.version = JNI_VERSION_10;
    vm_args.ignoreUnrecognized = false;

    jint vmres = CreateJavaVM(&jvm, (void **)&env, &vm_args);
    if (vmres < 0)
    {
        util::loge("[JVM] Could not start JVM\n\t\t Error code: " + std::to_string(vmres));
        return false;
    }

    jclass cls = env->FindClass(JAR_MAIN_CLASS);
    if (cls == nullptr)
    {
        util::loge("[JVM] " JAR_NAME " is corrupted: could not load class " JAR_MAIN_CLASS);
        return false;
    }
    jmethodID mid = env->GetStaticMethodID(cls, "main", "(JZ)V");
    if (mid == nullptr)
    {
        util::loge("[JVM] " JAR_NAME " is corrupted: could not find 'void Main::main(long, boolean)' in " JAR_MAIN_CLASS);
        return false;
    }

#ifdef _DEBUG
    util::logi("[JVM] Debug Build");
    env->CallStaticVoidMethod(cls, mid, core, true);
#else
    env->CallStaticVoidMethod(cls, mid, core, false);
#endif

    jboolean flag = env->ExceptionCheck();
    if (flag)
    {
        util::loge("[JVM] Exception occurred while executing Java entry point");
        env->ExceptionDescribe();
        env->ExceptionClear();
    }

    return true;
}

VM::~VM()
{
    jvm->DestroyJavaVM();
}
