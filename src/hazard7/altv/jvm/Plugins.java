package hazard7.altv.jvm;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.jar.JarFile;

public class Plugins {
    @SuppressWarnings("unchecked")
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
            String jarfilename = name+".jar", mainclass = "";

            File jarfile = new File("modules/altv-jvm-module/plugins/"+name+"/"+jarfilename);
            if(!jarfile.isFile()) {
                Log.error("Could not open jar file 'plugins/"+jarfilename+"'");
                continue;
            }

            try {
                JarFile jar = new JarFile(jarfile);
                mainclass = jar.getManifest().getMainAttributes().getValue("Main-Class");
            } catch (Throwable e) {
                Log.error("Could not get Main-Class of 'plugins/"+jarfilename+"'");
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
            } catch (Throwable e) {
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
