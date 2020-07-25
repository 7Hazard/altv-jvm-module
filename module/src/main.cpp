
#include "altv-capi-server.h"
alt_ICore* core = nullptr;

#ifdef _WIN32
#include <windows.h>

#else

#endif

#include "Util.hpp"
#include "VM.hpp"

VM* vm = nullptr;

CAPI_EXPORT bool altMain(alt_ICore* c)
{
    core = c;
    vm = new VM();

    if(!vm->Start())
    {
        util::loge("[JVM] Could not start VM");
        delete vm;
        return false;
    }

    std::atexit([]{
        delete vm;
    });

    return true;
}

CAPI_SKIP_VERSION_CHECK;
