package alt.v.jvm;

public class CAPIExtra
{
    public static final CAPIExtraFunctions func = jnr.ffi.LibraryLoader.create(CAPIExtraFunctions.class).load("altv-capi-server");

    public interface CreateImplFn
    {
        // Returns alt_IResource_Impl*
        @jnr.ffi.annotations.Delegate public jnr.ffi.Pointer callback(
            jnr.ffi.Pointer runtime, // alt_IScriptRuntime*
            jnr.ffi.Pointer resource // alt_IResource*
        );
    }

    public interface DestroyImplFn
    {
        @jnr.ffi.annotations.Delegate public void callback(
            jnr.ffi.Pointer runtime, // alt_IScriptRuntime*
            jnr.ffi.Pointer resource_impl // alt_IResource_Impl*
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
        @jnr.ffi.annotations.Delegate public boolean callback(
            jnr.ffi.Pointer resource, // alt_IResource*
            jnr.ffi.Pointer info, // alt_IResource_CreationInfo*
            jnr.ffi.Pointer files // alt_Array_String*
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
            CreateImplFn create,
            DestroyImplFn remove,
            OnRuntimeTickFn tick
        );

        // Returns pointer to resource
        jnr.ffi.Pointer alt_CAPIResource_Impl_Create(
            jnr.ffi.Pointer resource,
            MakeClientFn onmakeclient,
            StartFn onstart,
            StopFn onstop,
            OnEventFn onevent,
            OnResourceTickFn ontick,
            OnCreateBaseObjectFn oncreatebaseobject,
            OnRemoveBaseObjectFn onremovebaseobject
        );

        void alt_CAPIResource_Impl_SetExtra(jnr.ffi.Pointer resource, jnr.ffi.Pointer extra);
        jnr.ffi.Pointer alt_CAPIResource_Impl_GetExtra(jnr.ffi.Pointer resource);
    }
}
