#include "altv/capi.h"

#ifdef _WIN32
#include <windows.h>

#else

#endif

#include "Utils.hpp"
#include "VM.hpp"

EXPORT bool altvMain()
{
    if(!VM::Start())
        return false;

    return true;
}
