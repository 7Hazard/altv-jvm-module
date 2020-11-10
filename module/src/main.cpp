

#include "Util.hpp"
#include "VM.hpp"

alt_ICore *core = nullptr;
VM *vm = nullptr;

CAPI_EXPORT bool altMain(alt_ICore *c)
{
    core = c;
    vm = new VM();

    if (!vm->Start())
    {
        util::loge("[JVM] Could not start VM");
        delete vm;
        return false;
    }

    std::atexit([] {
        delete vm;
    });

    return true;
}

// #ifdef _DEBUG
// CAPI_SKIP_VERSION_CHECK;
// #endif

CAPI_EXPORT_SDK_VERSION;
