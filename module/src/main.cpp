#include "altv/capi.h"

#ifdef _WIN32
#include <windows.h>

#else

#endif

#include "Utils.hpp"
#include "VM.hpp"

EXPORT bool altMain(alt_server_t* server)
{
    if(!VM::Start(server))
        return false;

    return true;
}
