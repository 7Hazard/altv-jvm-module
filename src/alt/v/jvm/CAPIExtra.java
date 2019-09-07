package alt.v.jvm;

public class CAPIExtra
{
    public static final CAPIExtraFunctions func = jnr.ffi.LibraryLoader.create(CAPIExtraFunctions.class).load("altv-capi");

    public interface CreateResourceFn
    {
        // Returns alt_IResource*
        @jnr.ffi.annotations.Delegate public jnr.ffi.Pointer callback(
            jnr.ffi.Pointer runtime, // alt_IScriptRuntime*
            jnr.ffi.Pointer info // alt_IResource_CreationInfo*
        );
    }

    public interface RemoveResourceFn
    {
        @jnr.ffi.annotations.Delegate public void callback(
            jnr.ffi.Pointer runtime, // alt_IScriptRuntime*
            jnr.ffi.Pointer resource // alt_IResource*
        );
    }

    public interface OnRuntimeTickFn
    {
        @jnr.ffi.annotations.Delegate public void callback(
            jnr.ffi.Pointer runtime // alt_IScriptRuntime*
        );
    }

    public interface MakeClientFn
    {
        @jnr.ffi.annotations.Delegate public void callback(
            jnr.ffi.Pointer resource, // alt_IResource*
            jnr.ffi.Pointer info, // alt_IResource_CreationInfo*
            jnr.ffi.Pointer files // alt_Array_String*
        );
    }

    public interface InstantiateFn
    {
        @jnr.ffi.annotations.Delegate public boolean callback(
            jnr.ffi.Pointer resource // alt_IResource*
        );
    }

    public interface StartFn
    {
        @jnr.ffi.annotations.Delegate public boolean callback(
            jnr.ffi.Pointer resource // alt_IResource*
        );
    }

    public interface StopFn
    {
        @jnr.ffi.annotations.Delegate public boolean callback(
            jnr.ffi.Pointer resource // alt_IResource*
        );
    }

    public interface OnEventFn
    {
        @jnr.ffi.annotations.Delegate public boolean callback(
            jnr.ffi.Pointer resource, // alt_IResource*
            jnr.ffi.Pointer event // alt_CEvent*
        );
    }

    public interface OnResourceTickFn
    {
        @jnr.ffi.annotations.Delegate public void callback(
            jnr.ffi.Pointer resource // alt_IResource*
        );
    }

    public interface OnCreateBaseObjectFn
    {
        @jnr.ffi.annotations.Delegate public void callback(
            jnr.ffi.Pointer resource, // alt_IResource*
            jnr.ffi.Pointer object // alt_IBaseObject*
        );
    }

    public interface OnRemoveBaseObjectFn
    {
        @jnr.ffi.annotations.Delegate public void callback(
            jnr.ffi.Pointer resource, // alt_IResource*
            jnr.ffi.Pointer object // alt_IBaseObject*
        );
    }

    public static interface CAPIExtraFunctions
    {
        // Returns pointer to script runtime
        jnr.ffi.Pointer alt_CAPIScriptRuntime_Create(
            CreateResourceFn create,
            RemoveResourceFn remove,
            OnRuntimeTickFn tick
        );

        // Returns pointer to resource
        jnr.ffi.Pointer alt_CAPIResource_Create(
            jnr.ffi.Pointer info,
            MakeClientFn onmakeclient,
            InstantiateFn oninstantiate,
            StartFn onstart,
            StopFn onstop,
            OnEventFn onevent,
            OnResourceTickFn ontick,
            OnCreateBaseObjectFn oncreatebaseobject,
            OnRemoveBaseObjectFn onremovebaseobject
        );

        void alt_CAPIResource_SetExtra(jnr.ffi.Pointer resource, jnr.ffi.Pointer extra);
        jnr.ffi.Pointer alt_CAPIResource_GetExtra(jnr.ffi.Pointer resource);
    }
}
