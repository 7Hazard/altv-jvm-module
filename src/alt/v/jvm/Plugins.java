package alt.v.jvm;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;

public class Plugins {
    public static void Load() {
        // Try to open the plugins folder
        var pluginsFolder = new File("modules/altv-jvm-module/plugins/");
        if(!pluginsFolder.isDirectory())
        {
            if(!pluginsFolder.mkdirs())
            {
                Log.error("[JVM] Could not open 'plugins' directory");
                return;
            }
        }

        for (File file : pluginsFolder.listFiles()) {
            if(!file.isDirectory()) continue;
            var name = file.getName();
            Log.info("[JVM] Loading plugin '"+name+"'");

            // Get plugin config
            String jarfilename = "", mainclass = "";
            try {
                var cfglines = Files.readAllLines(new File("modules/altv-jvm-module/plugins/"+name+"/plugin.cfg").toPath());
                jarfilename = cfglines.get(0);
                mainclass = cfglines.get(1);
            } catch (Exception e) {
                Log.error("[JVM] Could not read 'plugin.cfg' of '"+name+"'\n\t"+e.getCause());
            }

            File jarfile = new File("modules/altv-jvm-module/plugins/"+name+"/"+jarfilename);
            if(!jarfile.isFile()) {
                Log.error("Could not open jar file '"+jarfilename+"'");
                continue;
            }

            try {
                URLClassLoader child = new URLClassLoader(
                    new URL[] {jarfile.toURI().toURL()},
                    Plugins.class.getClassLoader()
                );
                Class classToLoad = Class.forName(mainclass, true, child);
                Method method = classToLoad.getDeclaredMethod("main");
                Object result = method.invoke(null);
            } catch (Exception e) {
                Log.error("[JVM] Exception while loading plugin '"+name+"'"
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
