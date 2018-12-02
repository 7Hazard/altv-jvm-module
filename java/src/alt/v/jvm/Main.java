package alt.v.jvm;

import alt.v.jvm.CAPI;
import alt.v.jvm.CAPI.alt_event_type_t;
import jnr.ffi.Pointer;

public class Main {
    public static void main() {
        CAPI.func.alt_server_log_info("[JVM] Module successfully loaded");
        
        CAPI.func.alt_server_subscribe_event(alt_event_type_t.EVENT_PLAYER_CONNECT, OnConnect);
    }

    static CAPI.alt_event_callback_t OnConnect = new CAPI.alt_event_callback_t() {
        public boolean callback(Pointer event) {
            Pointer ply = CAPI.func.alt_player_connect_event_get_target(event);
            String plyname = CAPI.func.alt_player_get_name(ply);
            CAPI.func.alt_server_log_info(plyname+" CONNECTED");

            // Set pos
            CAPI.func.alt_server_log_info("SETTING POS");
            CAPI.alt_position_t pos = new CAPI.alt_position_t(1500, 3200, 40);
            CAPI.func.alt_player_set_position(ply, pos);

            // create veh
            CAPI.func.alt_server_log_info("CREATING VEH");
            int vehhash = CAPI.func.alt_server_hash("deluxo");
            CAPI.func.alt_server_create_vehicle(vehhash, pos, 0);

            return true;
        }
    };
}
