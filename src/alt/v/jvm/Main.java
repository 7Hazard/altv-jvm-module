package alt.v.jvm;

import alt.v.jvm.CAPI;
import jnr.ffi.Pointer;
import jnr.ffi.types.uintptr_t;

public class Main {
    public static void main(@uintptr_t long coreptr)
    {
        CAPI.core = Pointer.wrap(CAPI.runtime, coreptr);

        // Prepare env
        Log.init();

        Log.info("[JVM] Module loaded");

        Plugins.Load();

        // Log.info("[JVM] Creating runtime");
        // Pointer script_runtime = CAPIExtra.func.alt_CAPIScriptRuntime_Create(
        //     create_resource,
        //     remove_resource,
        //     on_tick
        // );
        // CAPI.func.alt_ICore_RegisterScriptRuntime(
        //     CAPI.core,
        //     new AltStringView("jvm").ptr(),
        //     script_runtime
        // );
        
        //CAPI.func.alt_server_subscribe_event(server, alt_event_type_t.PLAYER_CONNECT, OnConnect);
        //var ptr = CAPI.func.alt_script_runtime_create(create_resource, delete_resource, on_tick);
    }

    // static CAPIExtra.CreateImplFn create_resource = new CAPIExtra.CreateImplFn()
    // {
    //     @Override
    //     public Pointer callback(Pointer runtime, Pointer info) {
    //         // TODO Auto-generated method stub
    //         return null;
    //     }
    // };
    
    // static CAPIExtra.DestroyImplFn remove_resource = new CAPIExtra.DestroyImplFn()
    // {
    //     @Override
    //     public void callback(Pointer runtime, Pointer resource) {
    //         // TODO Auto-generated method stub

    //     }
    // };

    // static CAPIExtra.OnRuntimeTickFn on_tick = new CAPIExtra.OnRuntimeTickFn()
    // {
    //     @Override
    //     public void callback(Pointer runtime) {
            
    //     }
    // };

    // static CAPI.alt_event_callback_t OnConnect = new CAPI.alt_event_callback_t()
    // {
    //     public boolean callback(Pointer event) {
    //         Pointer ply = CAPI.func.alt_player_connect_event_get_target(event);
    //         ByteBuffer buffer = ByteBuffer.allocate(50);
    //         Pointer bufferptr = Pointer.wrap(CAPI.runtime, buffer);
    //         CAPI.func.alt_player_get_name(ply, bufferptr);
    //         String plyname = new String(buffer.array(), StandardCharsets.UTF_8).trim();
    //         CAPI.func.alt_server_log_info(server, "PLAYER "+plyname+" CONNECTED");

    //         // Set pos
    //         CAPI.func.alt_server_log_info(server, "SETTING POS");
    //         CAPI.alt_position_t pos = new CAPI.alt_position_t();
    //         pos.x.set(1500); pos.y.set(3200); pos.z.set(40);
    //         CAPI.func.alt_player_set_position(ply, Struct.getMemory(pos));

    //         // create veh
    //         CAPI.func.alt_server_log_info(server, "CREATING VEH");
    //         int vehhash = CAPI.func.alt_server_hash(server, "deluxo");
    //         CAPI.func.alt_server_create_vehicle(server, vehhash, Struct.getMemory(pos), 0);

    //         return true;
    //     }
    // };
}
