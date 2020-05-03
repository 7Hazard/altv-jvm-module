#define JVM_JAR_NAME "altv-jvm-module.jar"

#include "altv-capi-server.h"

#ifdef _WIN32
#include <windows.h>

#else

#endif

#include "Util.hpp"
#include "VM.hpp"

CAPI_EXPORT bool altMain(alt_ICore* core)
{
    if(!VM::Start(core))
    {
        util::loge(core, "[JVM] Could not start VM");
        return false;
    }

    return true;
}

CAPI_SKIP_VERSION_CHECK;
