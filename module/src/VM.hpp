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

    static bool Start(alt_IServer* server)
    {
        util::logi(server, "[JVM] Starting Java VM (Module Version '" JVM_MODULE_VERSION "')");

        JNIEnv *env; /* pointer to native method interface */
        JavaVMInitArgs vm_args; /* JDK/JRE 6 VM initialization arguments */

        // Options
        JavaVMOption options[5];
        vm_args.nOptions = 5;
        vm_args.options = options;
        options[0].optionString = "-Djava.class.path=modules/altv-jvm-module;modules/altv-jvm-module/" JVM_JAR_NAME;
        options[1].optionString = "-Djava.library.path=modules/altv-jvm-module";
        options[2].optionString = "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005";
        options[3].optionString = "-XX:+ShowMessageBoxOnError";
        options[4].optionString = "-XX:ErrorFile=logs/jvm/fatal-error.log";
        //options[5].optionString = "-verbose:jni";

        vm_args.version = JNI_VERSION_1_6;
        vm_args.ignoreUnrecognized = false;

        jint vmres = JNI_CreateJavaVM(&jvm(), (void**)&env, &vm_args);
        if(vmres < 0)
        {
            util::loge(server, "[JVM] Could not start JVM\n\t\t Error code: "+std::to_string(vmres));
            return false;
        }

        jclass cls = env->FindClass("alt/v/jvm/Main");
        if(cls == nullptr)
        {
            util::loge(server, "[JVM] Module JAR is corrupt or '" JVM_JAR_NAME "' doesn't exist");
            return false;
        }
        jmethodID mid = env->GetStaticMethodID(cls, "main", "(J)V");
        if(mid == nullptr)
        {
            util::loge(server, "[JVM] Module JAR is corrupt");
            return false;
        }
        env->CallStaticVoidMethod(cls, mid, server);
        jboolean flag = env->ExceptionCheck();
        if (flag) {
            util::loge(server, "Exception occurred while executing Java entry point");
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
