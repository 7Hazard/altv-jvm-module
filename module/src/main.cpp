#include "altv-capi.hpp"

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

CAPI_EXPORT_SDK_VERSION;
