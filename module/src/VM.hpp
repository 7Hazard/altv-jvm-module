#include <jni.h>

class VM
{
    public:
    static JavaVM*& jvm()
    {
        static JavaVM* jvm;
        return jvm;
    }

    static bool Start()
    {
        alt_server_log_info("[Kotlin] Starting Java VM");

        JNIEnv *env; /* pointer to native method interface */
        JavaVMInitArgs vm_args; /* JDK/JRE 6 VM initialization arguments */

        // Options
        JavaVMOption options[4];
        options[0].optionString = "-Djava.class.path=modules/altv-jvm-module;modules/altv-jvm-module/altv-jvm-module.jar";
        options[1].optionString = "-Djava.library.path=modules/altv-jvm-module";
        options[2].optionString = "-verbose:jni";
        options[3].optionString = "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9009";
        vm_args.nOptions = 4;
        vm_args.options = options;

        vm_args.version = JNI_VERSION_1_6;
        vm_args.ignoreUnrecognized = false;

        jint vmres = JNI_CreateJavaVM(&jvm(), (void**)&env, &vm_args);
        if(vmres < 0)
        {
            alt_server_log_error(("[Kotlin] Could not start JVM\n\t\t Error code: "+std::to_string(vmres)).c_str());
            return false;
        }

        jclass cls = env->FindClass("alt/v/jvm/Main");
        jmethodID mid = env->GetStaticMethodID(cls, "main", "()V");
        env->CallStaticVoidMethod(cls, mid, 100);

        return true;
    }

    static void Dispose()
    {
        jvm()->DestroyJavaVM();
    }
};
