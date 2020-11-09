#pragma once

#include <jni.h>
#include <string>
#include <filesystem>
#include <vector>
#include "Util.hpp"

#define JAR_NAME "altv-jvm-module.jar"
#define JAR_RELATIVE_PATH "modules/altv-jvm-module/" JAR_NAME
#define JAR_MAIN_CLASS "hazard7/altv/jvm/Main"

std::string JavaHomePath = std::getenv("JAVA_HOME");
#ifdef _WIN32
#include <Windows.h>
using Library = HMODULE;
auto OpenLibrary = LoadLibraryA;
auto GetLibraryFunction = GetProcAddress;
std::string JVMLibraryName = "jvm.dll";
std::string JVMJDKPath = JavaHomePath + "/bin/server/" + JVMLibraryName;
std::string JVMJREPath = JavaHomePath + "/jre/bin/server/" + JVMLibraryName;
#else
#include <dlfcn.h>
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

class VM
{
public:
    Library jvmlib = nullptr;
    bool LoadLib()
    {
        std::string path;
        if (!JavaHomePath.empty())
        {
            bool found = false;
            if (std::filesystem::exists(path = JVMJDKPath))
                found = true;
            else if (std::filesystem::exists(path = JVMJREPath))
                found = true;

            if (found)
            {
                jvmlib = OpenLibrary(path.c_str());
            }
        }

        if (!jvmlib)
        {
            // Try loading from PATH or anywhere else the system looks
            jvmlib = OpenLibrary(JVMLibraryName.c_str());
        }
        else
        {
            util::logi("[JVM] Loaded JVM from JAVA_HOME (" + path + ")");
            return true;
        }

        if (!jvmlib)
        {
            util::loge("[JVM] Could not load jvm.dll - JAVA_HOME environment variable was not specified or pointed to an invalid Java installation");
            return false;
        }
        else
        {
            util::logi("[JVM] Loaded JVM from PATH (or local relative)");
            return true;
        }
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

    JavaVM *jvm = nullptr;
    bool Start()
    {
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
        if (true)
            options.push_back(JavaVMOption{(char *)"-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", nullptr});
        if (false)
            options.push_back(JavaVMOption{(char *)"-Djava.compiler=NONE", nullptr});

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

    ~VM()
    {
        jvm->DestroyJavaVM();
    }
};
