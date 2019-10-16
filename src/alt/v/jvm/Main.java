package alt.v.jvm;

import alt.v.jvm.CAPI;
import jnr.ffi.Pointer;
import jnr.ffi.types.uintptr_t;

public class Main {
    public static void main(@uintptr_t long coreptr, boolean debug)
    {
        CAPI.core = Pointer.wrap(CAPI.runtime, coreptr);

        // Prepare env
        Log.init();

        // LibC
        LibC.debug = debug;
        LibC.load();

        Log.info("[JVM] Module loaded");

        Plugins.Load();
    }
}
