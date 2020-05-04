# alt:V JVM Module

alt:V Java Virtual Machine module that runs a Java VM and exposes a Java API for
alt:V Server API.  

To use use this library as a dependency via JitPack:  
https://jitpack.io/#com.gitlab.7Hazard/altv-jvm-module

You can download the module files in
[Releases](https://gitlab.com/7Hazard/altv-jvm-module/-/releases).  
Place the `altv-jvm-module` folder in `modules/` in the server.  
Include it in `modules` list in `server.cfg`.

The module is based on JDK 11.

Currently, the Java API only exposes alt:V's Server C API and doesn't have an
user friendly or Java OOP friendly API.  
The primary goal of the JVM module is to bind the alt:V Server to the
Java Virtual Machine and it's environment.

Currently it requires that jvm.dll/so is found in PATH environment variable.
jvm.dll/so SHALL NOT be manually copied or placed anywhere else than where it
was when retrieved.
Usually it exists in the JDK distribution inside bin/server directory.
