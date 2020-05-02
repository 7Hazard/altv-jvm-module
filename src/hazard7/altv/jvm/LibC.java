package hazard7.altv.jvm;

import jnr.ffi.Platform;
import jnr.ffi.Pointer;

public class LibC
{
    static boolean debug = false;

    public static String getStandardCLibraryName() {
        var plat = Platform.getNativePlatform();
        switch (plat.getOS()) {
        case LINUX:
            return "libc.so.6";
        case SOLARIS:
            return "c";
        case FREEBSD:
        case NETBSD:
            return "c";
        case AIX:
            return runtime.addressSize() == 32
                ? "libc.a(shr.o)"
                : "libc.a(shr_64.o)";
        case WINDOWS:
            return debug 
                ? "ucrtbased"
                : "ucrtbase";
        default:
            return "c";
        }
    }

    public static void load()
    {
        func = jnr.ffi.LibraryLoader.create(LibCFunctions.class).load(getStandardCLibraryName());
        runtime = jnr.ffi.Runtime.getRuntime(func);
    }

    // public static final LibCFunctions func = jnr.ffi.LibraryLoader.create(LibCFunctions.class).load(Platform.getNativePlatform().getStandardCLibraryName());
    public static LibCFunctions func;
    public static jnr.ffi.Runtime runtime;

    public static interface LibCFunctions
    {
        void free(Pointer pointer);
        Pointer malloc(long size);
    }
}
