
#include "altv-capi-server.h"
alt_ICore* core = nullptr;

#ifdef _WIN32
#include <windows.h>

#else

#endif

#include "Util.hpp"
#include "VM.hpp"

CAPI_EXPORT bool altMain(alt_ICore* c)
{
    core = c;
    auto vm = new VM();

    if(!vm->Start())
    {
        util::loge("[JVM] Could not start VM");
        delete vm;
        return false;
    }

    return true;
}

CAPI_SKIP_VERSION_CHECK;
