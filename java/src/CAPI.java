package alt.v.jvm;

import jnr.ffi.LibraryLoader;

public class CAPI {
    public static final CAPIFunctions func = LibraryLoader.create(CAPIFunctions.class).load("altv-capi");

    public static interface CAPIFunctions {
        void alt_server_log_info(String msg);
    }
}
