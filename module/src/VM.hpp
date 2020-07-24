#pragma once

#include <jni.h>
#include <string>
#include <filesystem>
#include "Util.hpp"

#define JAR_NAME "altv-jvm-module.jar"
#define JAR_RELATIVE_PATH "modules/altv-jvm-module/" JAR_NAME
#define JAR_MAIN_CLASS "hazard7/altv/jvm/Main"

class VM
{
public:

    HMODULE jvmlib = nullptr;
    void LoadLib()
    {
        std::string javahome = std::getenv("JAVA_HOME");
        if(!javahome.empty())
        {
            auto path = javahome + "/bin/server/jvm.dll";
            jvmlib = LoadLibraryA(path.c_str());
        }
        
        if(!jvmlib) {
            // Try loading from PATH or anywhere else the system looks
            jvmlib = LoadLibraryA("jvm.dll");
        }

        if(!jvmlib)
        {
            util::loge("[JVM] Could not load jvm.dll - JAVA_HOME environment variable was not specified or pointed to an invalid Java installation");
        }        
    }

    jint (JNICALL *CreateJavaVM)(JavaVM **pvm, void **penv, void *args) = nullptr;
    
    uint8_t failedFuncs = 0;
    void* LoadFunc(const std::string& name)
    {
        auto addr = (void*)GetProcAddress(jvmlib, name.c_str());
        if(!addr)
        {
            util::loge("Could not load " + name + " from jvm.dll");
            failedFuncs++;
        }
        return addr;
    }

    JavaVM* jvm = nullptr;

    bool Start()
    {
        // Checks
        if(!std::filesystem::exists(JAR_RELATIVE_PATH))
        {
            util::loge("[JVM] Could not find file '" JAR_RELATIVE_PATH "'");
            return false;
        }

        // Dynamic load jvm
        LoadLib();
        if(jvmlib == nullptr) return false;

        // dynamic load jni funcs
        CreateJavaVM = (decltype(CreateJavaVM))LoadFunc("JNI_CreateJavaVM");
        if(failedFuncs > 0)
        {
            // util::loge("[JVM] Could not properly load all JNI functions");
            return false;
        }

        util::logi("[JVM] Starting Java VM (Module Version '" JVM_MODULE_VERSION "')");

        JNIEnv *env; /* pointer to native method interface */
        JavaVMInitArgs vm_args; /* JDK/JRE 6 VM initialization arguments */
        // memset(&vm_args, 0, sizeof(vm_args));

        // Options
        JavaVMOption options[5];
        // memset(&options, 0, sizeof(options));
        vm_args.nOptions = 5;
        vm_args.options = options;
        // OBS: SYNTAX MISTAKES CAN CAUSE INSTA-CRASH
        options[0].optionString = "-Djava.class.path=modules/altv-jvm-module;" JAR_RELATIVE_PATH;
        options[1].optionString = "-Djava.library.path=modules/altv-jvm-module";
        options[2].optionString = "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005";
        options[3].optionString = "-XX:+ShowMessageBoxOnError";
        options[4].optionString = "-XX:ErrorFile=logs/jvm/fatal-error.log";
        //options[5].optionString = "-verbose:jni";
        
        vm_args.version = JNI_VERSION_1_6;
        vm_args.ignoreUnrecognized = JNI_TRUE;

        jint vmres = CreateJavaVM(&jvm, (void**)&env, &vm_args);
        if(vmres < 0)
        {
            util::loge("[JVM] Could not start JVM\n\t\t Error code: "+std::to_string(vmres));
            return false;
        }
        
        vmres = jvm->AttachCurrentThread((void**)&env, nullptr);
        if(vmres < 0)
        {
            util::loge("[JVM] Could not Attach JVM to thread\n\t\t Error code: "+std::to_string(vmres));
            return false;
        }

        // std::string vmver = "[JVM] Started Java VM version " + std::to_string(env->GetVersion());
        // util::logi(vmver);
        
        jclass cls = env->FindClass(JAR_MAIN_CLASS);
        if(cls == nullptr)
        {
            util::loge("[JVM] " JAR_NAME " is corrupted: could not load class " JAR_MAIN_CLASS);
            return false;
        }
        jmethodID mid = env->GetStaticMethodID(cls, "main", "(JZ)V");
        if(mid == nullptr)
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

    void Dispose()
    {
        jvm->DestroyJavaVM();
    }
};
