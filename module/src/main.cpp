#include "altv-capi.hpp"

#ifdef _WIN32
#include <windows.h>

#else

#endif

#include "Util.hpp"
#include "VM.hpp"

CAPI_EXPORT bool altMain(alt_IServer* server)
{
    if(!VM::Start(server))
        return false;

    return true;
}

CAPI_EXPORT_SDK_VERSION;
