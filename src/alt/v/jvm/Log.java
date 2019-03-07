package alt.v.jvm;

import java.io.File;

/**
 * Log
 */
public final class Log {

    public static boolean init() {
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

    public static void info(String msg) {
        CAPI.func.alt_server_log_info(CAPI.server, msg);
    }

    public static void error(String msg) {
        CAPI.func.alt_server_log_error(CAPI.server, msg);
    }
}