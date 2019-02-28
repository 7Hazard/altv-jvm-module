package alt.v.jvm;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Plugins {
    public static void Load() {
        for (File file : new File("modules/altv-jvm-module/plugins/").listFiles()) {
            if(!file.isDirectory()) continue;

            var name = file.getName();
            File jarfile = new File("modules/altv-jvm-module/plugins/"+name+"/"+name+".jar");
            if(!jarfile.isFile()) continue;

            CAPI.func.alt_server_log_info(CAPI.server, "[JVM] Loading plugin '"+name+"'");

            try {
                URLClassLoader child = new URLClassLoader(
                    new URL[] {jarfile.toURI().toURL()},
                    Plugins.class.getClassLoader()
                );
                Class classToLoad = Class.forName("alt.v.kotlin.MainKt", true, child);
                Method method = classToLoad.getDeclaredMethod("main");
                Object result = method.invoke(null);
            } catch (Exception e) {
                CAPI.func.alt_server_log_error(CAPI.server, 
                    "[JVM] Exception while loading plugin 'altv-kotlin'"
                    +"\n\t Message: "+e.getLocalizedMessage()
                    +"\n\t Cause: "+e.getCause()
                    +"\n\t Ext: "+e.toString()
                    //+"\n\tStack trace: "
                );
                e.printStackTrace();
            }
        }

        
    }
}
