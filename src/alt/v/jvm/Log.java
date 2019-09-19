package alt.v.jvm;

import java.io.File;
import java.nio.charset.Charset;

import jnr.ffi.Memory;
import jnr.ffi.Pointer;
import jnr.ffi.Struct;

/**
 * Log
 */
public final class Log
{
    static boolean init() {
        var logdir = new File("logs/jvm");

        if(!logdir.exists())
        {
            if(!logdir.mkdirs())
            {
                Log.error("Could not open 'logs/jvm' directory");
                return false;
            }
        }

        return true;
    }

    public static void info(String msg)
    {
        var sw = new AltStringView(msg);
        CAPI.func.alt_ICore_LogInfo(CAPI.core, sw.ptr());
    }

    public static void error(String msg) {
        var sw = new AltStringView(msg);
        CAPI.func.alt_ICore_LogError(CAPI.core, sw.ptr());
    }
}