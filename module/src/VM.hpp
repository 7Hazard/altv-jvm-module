#pragma once

#include <jni.h>
#include <string>
#include "Util.hpp"

class VM
{
    public:
    static JavaVM*& jvm()
    {
        static JavaVM* jvm;
        return jvm;
    }

    static bool Start(alt_ICore* core)
    {
        util::logi(core, "[JVM] Starting Java VM (Module Version '" JVM_MODULE_VERSION "')");

        JNIEnv *env; /* pointer to native method interface */
        JavaVMInitArgs vm_args; /* JDK/JRE 6 VM initialization arguments */
        // memset(&vm_args, 0, sizeof(vm_args));

        // Options
        JavaVMOption options[5];
        // memset(&options, 0, sizeof(options));
        vm_args.nOptions = 5;
        vm_args.options = options;
        // OBS: SYNTAX MISTAKES CAN CAUSE INSTA-CRASH
        options[0].optionString = "-Djava.class.path=modules/altv-jvm-module;modules/altv-jvm-module/" JVM_JAR_NAME;
        options[1].optionString = "-Djava.library.path=modules/altv-jvm-module";
        options[2].optionString = "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005";
        options[3].optionString = "-XX:+ShowMessageBoxOnError";
        options[4].optionString = "-XX:ErrorFile=logs/jvm/fatal-error.log";
        //options[5].optionString = "-verbose:jni";

        vm_args.version = JNI_VERSION_1_6;
        vm_args.ignoreUnrecognized = JNI_TRUE;

        jint vmres = JNI_CreateJavaVM(&jvm(), (void**)&env, &vm_args);
        if(vmres < 0)
        {
            util::loge(core, "[JVM] Could not start JVM\n\t\t Error code: "+std::to_string(vmres));
            return false;
        }

        jclass cls = env->FindClass("alt/v/jvm/Main");
        if(cls == nullptr)
        {
            util::loge(core, "[JVM] Module JAR is corrupt or '" JVM_JAR_NAME "' doesn't exist");
            return false;
        }
        jmethodID mid = env->GetStaticMethodID(cls, "main", "(JZ)V");
        if(mid == nullptr)
        {
            util::loge(core, "[JVM] Could not find 'void Main::main(long, boolean)'");
            return false;
        }
#ifdef _DEBUG
        util::logi(core, "[JVM] Debug Build");
        env->CallStaticVoidMethod(cls, mid, core, true);
#else
        env->CallStaticVoidMethod(cls, mid, core, false);
#endif
        jboolean flag = env->ExceptionCheck();
        if (flag) {
            util::loge(core, "Exception occurred while executing Java entry point");
            env->ExceptionDescribe();
            env->ExceptionClear();
        }

        return true;
    }

    static void Dispose()
    {
        jvm()->DestroyJavaVM();
    }
};
