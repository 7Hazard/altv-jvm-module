package alt.v.jvm;

public class CAPI
{
    public static final CAPIFunctions func = jnr.ffi.LibraryLoader.create(CAPIFunctions.class).load("altv-capi");
    public static jnr.ffi.Runtime runtime = jnr.ffi.Runtime.getRuntime(func);
    public static jnr.ffi.Pointer server;
    

    
    public static enum alt_mvalue_type_t implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        NIL(0),
        BOOL(1),
        INT(2),
        UINT(3),
        DOUBLE(4),
        STRING(5),
        LIST(6),
        DICT(7),
        ENTITY(8),
        FUNCTION(9);
    
        alt_mvalue_type_t(int value) {
            this.value = value;
        }
    
        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static class alt_position_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Float x = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float y = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float z = new jnr.ffi.Struct.Float();
        
        public alt_position_t()
        {
            super(runtime);
        }
        public alt_position_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_rotation_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Float pitch = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float roll = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float yaw = new jnr.ffi.Struct.Float();
        
        public alt_rotation_t()
        {
            super(runtime);
        }
        public alt_rotation_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_rgba_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.u_int8_t r = new jnr.ffi.Struct.u_int8_t();
        public final jnr.ffi.Struct.u_int8_t g = new jnr.ffi.Struct.u_int8_t();
        public final jnr.ffi.Struct.u_int8_t b = new jnr.ffi.Struct.u_int8_t();
        public final jnr.ffi.Struct.u_int8_t a = new jnr.ffi.Struct.u_int8_t();
        
        public alt_rgba_t()
        {
            super(runtime);
        }
        public alt_rgba_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static enum alt_base_object_type_t implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        PLAYER(0),
        VEHICLE(1),
        CHECKPOINT(2),
        BLIP(3),
        WEBVIEW(4);
    
        alt_base_object_type_t(int value) {
            this.value = value;
        }
    
        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static enum alt_event_type_t implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        NONE(0),
        PLAYER_CONNECT(1),
        PLAYER_DISCONNECT(2),
        SERVER_SCRIPT_EVENT(3),
        CLIENT_SCRIPT_EVENT(4),
        PLAYER_DAMAGE(5),
        PLAYER_DEAD(6),
        CHECKPOINT_EVENT(7),
        VEHICLE_ENTER_EVENT(8),
        VEHICLE_LEAVE_EVENT(9),
        VEHICLE_CHANGE_SEAT_EVENT(10),
        REMOVE_ENTITY_EVENT(11),
        WEB_VIEW_EVENT(12),
        KEYBOARD_EVENT(13),
        ALL(14),
        SIZE(15);
    
        alt_event_type_t(int value) {
            this.value = value;
        }
    
        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static class alt_event_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_event_type_t> type = new jnr.ffi.Struct.Enum32<alt_event_type_t>(alt_event_type_t.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        
        public alt_event_t()
        {
            super(runtime);
        }
        public alt_event_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_player_connect_event_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.UTF8StringRef reason = new jnr.ffi.Struct.UTF8StringRef();
        public final jnr.ffi.Struct.u_int64_t reason_size = new jnr.ffi.Struct.u_int64_t();
        
        public alt_player_connect_event_t()
        {
            super(runtime);
        }
        public alt_player_connect_event_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_player_disconnect_event_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.UTF8StringRef reason = new jnr.ffi.Struct.UTF8StringRef();
        public final jnr.ffi.Struct.u_int64_t reason_size = new jnr.ffi.Struct.u_int64_t();
        
        public alt_player_disconnect_event_t()
        {
            super(runtime);
        }
        public alt_player_disconnect_event_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_server_script_event_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.UTF8StringRef name = new jnr.ffi.Struct.UTF8StringRef();
        public final jnr.ffi.Struct.u_int64_t name_size = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.Pointer args = new jnr.ffi.Struct.Pointer();
        
        public alt_server_script_event_t()
        {
            super(runtime);
        }
        public alt_server_script_event_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_client_script_event_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.UTF8StringRef name = new jnr.ffi.Struct.UTF8StringRef();
        public final jnr.ffi.Struct.u_int64_t name_size = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.Pointer args = new jnr.ffi.Struct.Pointer();
        
        public alt_client_script_event_t()
        {
            super(runtime);
        }
        public alt_client_script_event_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_player_damage_event_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Pointer attacker = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int8_t damage = new jnr.ffi.Struct.u_int8_t();
        public final jnr.ffi.Struct.u_int32_t weapon = new jnr.ffi.Struct.u_int32_t();
        
        public alt_player_damage_event_t()
        {
            super(runtime);
        }
        public alt_player_damage_event_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_player_dead_event_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Pointer killer = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int32_t weapon = new jnr.ffi.Struct.u_int32_t();
        
        public alt_player_dead_event_t()
        {
            super(runtime);
        }
        public alt_player_dead_event_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_checkpoint_event_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Pointer entity = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Boolean state = new jnr.ffi.Struct.Boolean();
        
        public alt_checkpoint_event_t()
        {
            super(runtime);
        }
        public alt_checkpoint_event_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_vehicle_enter_event_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Pointer player = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.int8_t seat = new jnr.ffi.Struct.int8_t();
        
        public alt_vehicle_enter_event_t()
        {
            super(runtime);
        }
        public alt_vehicle_enter_event_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_vehicle_leave_event_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Pointer player = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.int8_t seat = new jnr.ffi.Struct.int8_t();
        
        public alt_vehicle_leave_event_t()
        {
            super(runtime);
        }
        public alt_vehicle_leave_event_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_vehicle_change_seat_event_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Pointer player = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.int8_t oldSeat = new jnr.ffi.Struct.int8_t();
        public final jnr.ffi.Struct.int8_t newSeat = new jnr.ffi.Struct.int8_t();
        
        public alt_vehicle_change_seat_event_t()
        {
            super(runtime);
        }
        public alt_vehicle_change_seat_event_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static enum alt_package_mode_t implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        READ(0),
        WRITE(1);
    
        alt_package_mode_t(int value) {
            this.value = value;
        }
    
        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static enum alt_package_seek_origin_t implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        SET(0),
        CUR(1),
        END(2);
    
        alt_package_seek_origin_t(int value) {
            this.value = value;
        }
    
        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static enum alt_resource_state_t implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        STOPPED(0),
        INSTANTIATING(1),
        STARTED(2);
    
        alt_resource_state_t(int value) {
            this.value = value;
        }
    
        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static class alt_resource_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.UTF8StringRef type = new jnr.ffi.Struct.UTF8StringRef();
        public final jnr.ffi.Struct.u_int64_t type_size = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.UTF8StringRef name = new jnr.ffi.Struct.UTF8StringRef();
        public final jnr.ffi.Struct.u_int64_t name_size = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.UTF8StringRef main = new jnr.ffi.Struct.UTF8StringRef();
        public final jnr.ffi.Struct.u_int64_t main_size = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.Pointer pkg = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Enum32<alt_resource_state_t> state = new jnr.ffi.Struct.Enum32<alt_resource_state_t>(alt_resource_state_t.class);
        public final jnr.ffi.Struct.Pointer exports = new jnr.ffi.Struct.Pointer();
        
        public alt_resource_t()
        {
            super(runtime);
        }
        public alt_resource_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_resource_creation_info_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.UTF8StringRef type = new jnr.ffi.Struct.UTF8StringRef();
        public final jnr.ffi.Struct.u_int64_t type_size = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.UTF8StringRef name = new jnr.ffi.Struct.UTF8StringRef();
        public final jnr.ffi.Struct.u_int64_t name_size = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.UTF8StringRef main = new jnr.ffi.Struct.UTF8StringRef();
        public final jnr.ffi.Struct.u_int64_t main_size = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.Pointer pkg = new jnr.ffi.Struct.Pointer();
        
        public alt_resource_creation_info_t()
        {
            super(runtime);
        }
        public alt_resource_creation_info_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public interface alt_event_callback_t
    {
        @jnr.ffi.annotations.Delegate public boolean callback(jnr.ffi.Pointer a1);
    }

    public interface alt_tick_callback_t
    {
        @jnr.ffi.annotations.Delegate public void callback();
    }

    public interface alt_command_callback_t
    {
        @jnr.ffi.annotations.Delegate public void callback(@jnr.ffi.annotations.Encoding("UTF-8") String a1, jnr.ffi.Pointer a2);
    }

    public interface alt_script_runtime_create_resource_callback_t
    {
        @jnr.ffi.annotations.Delegate public jnr.ffi.Pointer callback(jnr.ffi.Pointer a1);
    }

    public interface alt_script_runtime_delete_resource_callback_t
    {
        @jnr.ffi.annotations.Delegate public void callback(jnr.ffi.Pointer a1);
    }

    public interface alt_script_runtime_on_tick_callback_t
    {
        @jnr.ffi.annotations.Delegate public void callback();
    }

    public interface alt_resource_on_event_callback_t
    {
        @jnr.ffi.annotations.Delegate public boolean callback(jnr.ffi.Pointer a1);
    }

    public interface alt_resource_on_tick_callback_t
    {
        @jnr.ffi.annotations.Delegate public void callback();
    }


    public static interface CAPIFunctions
    {
        alt_base_object_type_t alt_base_object_get_type(jnr.ffi.Pointer instance);
        alt_event_type_t alt_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_event_cancel(jnr.ffi.Pointer instance);
        alt_event_type_t alt_player_connect_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_player_connect_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_player_connect_event_cancel(jnr.ffi.Pointer instance);
        void alt_player_connect_event_cancel2(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String _reason);
        jnr.ffi.Pointer alt_player_connect_event_get_target(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int64_t long alt_player_connect_event_get_reason_size(jnr.ffi.Pointer instance);
        void alt_player_connect_event_get_reason(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        alt_event_type_t alt_player_disconnect_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_player_disconnect_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_player_disconnect_event_cancel(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_player_disconnect_event_get_target(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int64_t long alt_player_disconnect_event_get_reason_size(jnr.ffi.Pointer instance);
        void alt_player_disconnect_event_get_reason(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        alt_event_type_t alt_server_script_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_server_script_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_server_script_event_cancel(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int64_t long alt_server_script_event_get_name_size(jnr.ffi.Pointer instance);
        void alt_server_script_event_get_name(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        jnr.ffi.Pointer alt_server_script_event_get_args(jnr.ffi.Pointer instance);
        alt_event_type_t alt_client_script_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_client_script_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_client_script_event_cancel(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int64_t long alt_client_script_event_get_name_size(jnr.ffi.Pointer instance);
        void alt_client_script_event_get_name(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        jnr.ffi.Pointer alt_client_script_event_get_args(jnr.ffi.Pointer instance);
        alt_event_type_t alt_player_damage_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_player_damage_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_player_damage_event_cancel(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_player_damage_event_get_target(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_player_damage_event_get_attacker(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_player_damage_event_get_damage(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int32_t int alt_player_damage_event_get_weapon(jnr.ffi.Pointer instance);
        alt_event_type_t alt_player_dead_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_player_dead_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_player_dead_event_cancel(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_player_dead_event_get_target(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_player_dead_event_get_killer(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int32_t int alt_player_dead_event_get_weapon(jnr.ffi.Pointer instance);
        alt_event_type_t alt_checkpoint_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_checkpoint_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_checkpoint_event_cancel(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_checkpoint_event_get_target(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_checkpoint_event_get_entity(jnr.ffi.Pointer instance);
        boolean alt_checkpoint_event_get_state(jnr.ffi.Pointer instance);
        alt_event_type_t alt_vehicle_enter_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_vehicle_enter_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_vehicle_enter_event_cancel(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_vehicle_enter_event_get_target(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_vehicle_enter_event_get_player(jnr.ffi.Pointer instance);
        @jnr.ffi.types.int8_t byte alt_vehicle_enter_event_get_seat(jnr.ffi.Pointer instance);
        alt_event_type_t alt_vehicle_leave_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_vehicle_leave_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_vehicle_leave_event_cancel(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_vehicle_leave_event_get_target(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_vehicle_leave_event_get_player(jnr.ffi.Pointer instance);
        @jnr.ffi.types.int8_t byte alt_vehicle_leave_event_get_seat(jnr.ffi.Pointer instance);
        alt_event_type_t alt_vehicle_change_seat_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_vehicle_change_seat_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_vehicle_change_seat_event_cancel(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_vehicle_change_seat_event_get_target(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_vehicle_change_seat_event_get_player(jnr.ffi.Pointer instance);
        @jnr.ffi.types.int8_t byte alt_vehicle_change_seat_event_get_old_seat(jnr.ffi.Pointer instance);
        @jnr.ffi.types.int8_t byte alt_vehicle_change_seat_event_get_new_seat(jnr.ffi.Pointer instance);
        alt_base_object_type_t alt_entity_get_type(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int16_t short alt_entity_get_id(jnr.ffi.Pointer instance);
        void alt_entity_get_position(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_entity_set_position(jnr.ffi.Pointer instance, jnr.ffi.Pointer pos);
        void alt_entity_set_position2(jnr.ffi.Pointer instance, float x, float y, float z);
        void alt_entity_get_rotation(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_entity_set_rotation(jnr.ffi.Pointer instance, jnr.ffi.Pointer rot);
        void alt_entity_set_rotation2(jnr.ffi.Pointer instance, float x, float y, float z);
        @jnr.ffi.types.u_int16_t short alt_entity_get_dimension(jnr.ffi.Pointer instance);
        void alt_entity_set_dimension(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short dimension);
        jnr.ffi.Pointer alt_entity_get_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        void alt_entity_set_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, jnr.ffi.Pointer val);
        jnr.ffi.Pointer alt_entity_get_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        @jnr.ffi.types.u_int16_t short alt_checkpoint_get_id(jnr.ffi.Pointer instance);
        void alt_checkpoint_get_position(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_checkpoint_set_position(jnr.ffi.Pointer instance, jnr.ffi.Pointer pos);
        void alt_checkpoint_set_position2(jnr.ffi.Pointer instance, float x, float y, float z);
        void alt_checkpoint_get_rotation(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_checkpoint_set_rotation(jnr.ffi.Pointer instance, jnr.ffi.Pointer rot);
        void alt_checkpoint_set_rotation2(jnr.ffi.Pointer instance, float x, float y, float z);
        @jnr.ffi.types.u_int16_t short alt_checkpoint_get_dimension(jnr.ffi.Pointer instance);
        void alt_checkpoint_set_dimension(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short dimension);
        jnr.ffi.Pointer alt_checkpoint_get_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        void alt_checkpoint_set_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, jnr.ffi.Pointer val);
        jnr.ffi.Pointer alt_checkpoint_get_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        boolean alt_checkpoint_is_global(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_checkpoint_get_checkpoint_type(jnr.ffi.Pointer instance);
        float alt_checkpoint_get_height(jnr.ffi.Pointer instance);
        float alt_checkpoint_get_radius(jnr.ffi.Pointer instance);
        void alt_checkpoint_get_color(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        @jnr.ffi.types.u_int16_t short alt_blip_get_id(jnr.ffi.Pointer instance);
        void alt_blip_get_position(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_blip_set_position(jnr.ffi.Pointer instance, jnr.ffi.Pointer pos);
        void alt_blip_set_position2(jnr.ffi.Pointer instance, float x, float y, float z);
        void alt_blip_get_rotation(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_blip_set_rotation(jnr.ffi.Pointer instance, jnr.ffi.Pointer rot);
        void alt_blip_set_rotation2(jnr.ffi.Pointer instance, float x, float y, float z);
        @jnr.ffi.types.u_int16_t short alt_blip_get_dimension(jnr.ffi.Pointer instance);
        void alt_blip_set_dimension(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short dimension);
        jnr.ffi.Pointer alt_blip_get_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        void alt_blip_set_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, jnr.ffi.Pointer val);
        jnr.ffi.Pointer alt_blip_get_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        boolean alt_blip_is_global(jnr.ffi.Pointer instance);
        boolean alt_blip_is_attached(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_blip_attached_to(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_blip_get_blip_type(jnr.ffi.Pointer instance);
        void alt_blip_set_sprite(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short sprite);
        void alt_blip_set_color(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte color);
        void alt_blip_set_route(jnr.ffi.Pointer instance, boolean state);
        void alt_blip_set_route_color(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte color);
        @jnr.ffi.types.u_int16_t short alt_player_get_id(jnr.ffi.Pointer instance);
        void alt_player_get_position(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_player_set_position(jnr.ffi.Pointer instance, jnr.ffi.Pointer pos);
        void alt_player_set_position2(jnr.ffi.Pointer instance, float x, float y, float z);
        void alt_player_get_rotation(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_player_set_rotation(jnr.ffi.Pointer instance, jnr.ffi.Pointer rot);
        void alt_player_set_rotation2(jnr.ffi.Pointer instance, float x, float y, float z);
        @jnr.ffi.types.u_int16_t short alt_player_get_dimension(jnr.ffi.Pointer instance);
        void alt_player_set_dimension(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short dimension);
        jnr.ffi.Pointer alt_player_get_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        void alt_player_set_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, jnr.ffi.Pointer val);
        jnr.ffi.Pointer alt_player_get_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        boolean alt_player_is_connected(jnr.ffi.Pointer instance);
        void alt_player_spawn(jnr.ffi.Pointer instance, jnr.ffi.Pointer pos);
        void alt_player_despawn(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int64_t long alt_player_get_name_size(jnr.ffi.Pointer instance);
        void alt_player_get_name(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_player_set_name(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String name);
        @jnr.ffi.types.u_int16_t short alt_player_get_health(jnr.ffi.Pointer instance);
        void alt_player_set_health(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short health);
        void alt_player_set_date_time(jnr.ffi.Pointer instance, int day, int month, int year, int hour, int minute, int second);
        void alt_player_set_weather(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int32_t int weather);
        boolean alt_player_is_dead(jnr.ffi.Pointer instance);
        boolean alt_player_is_jumping(jnr.ffi.Pointer instance);
        boolean alt_player_is_in_ragdoll(jnr.ffi.Pointer instance);
        boolean alt_player_is_aiming(jnr.ffi.Pointer instance);
        boolean alt_player_is_shooting(jnr.ffi.Pointer instance);
        boolean alt_player_is_reloading(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int16_t short alt_player_get_armor(jnr.ffi.Pointer instance);
        void alt_player_set_armor(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short armor);
        float alt_player_get_move_speed(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int32_t int alt_player_get_weapon(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int16_t short alt_player_get_ammo(jnr.ffi.Pointer instance);
        void alt_player_get_aim_pos(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_player_get_head_rotation(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        boolean alt_player_is_in_vehicle(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_player_get_vehicle(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_player_get_seat(jnr.ffi.Pointer instance);
        void alt_player_kick(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String reason);
        @jnr.ffi.types.u_int16_t short alt_vehicle_get_id(jnr.ffi.Pointer instance);
        void alt_vehicle_get_position(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_vehicle_set_position(jnr.ffi.Pointer instance, jnr.ffi.Pointer pos);
        void alt_vehicle_set_position2(jnr.ffi.Pointer instance, float x, float y, float z);
        void alt_vehicle_get_rotation(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_vehicle_set_rotation(jnr.ffi.Pointer instance, jnr.ffi.Pointer rot);
        void alt_vehicle_set_rotation2(jnr.ffi.Pointer instance, float x, float y, float z);
        @jnr.ffi.types.u_int16_t short alt_vehicle_get_dimension(jnr.ffi.Pointer instance);
        void alt_vehicle_set_dimension(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short dimension);
        jnr.ffi.Pointer alt_vehicle_get_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        void alt_vehicle_set_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, jnr.ffi.Pointer val);
        jnr.ffi.Pointer alt_vehicle_get_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        jnr.ffi.Pointer alt_vehicle_get_driver(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_mod(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte category);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_mods_count(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte category);
        boolean alt_vehicle_set_mod(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte category, @jnr.ffi.types.u_int8_t byte id);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_mod_kits_count(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_mod_kit(jnr.ffi.Pointer instance);
        boolean alt_vehicle_set_mod_kit(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte id);
        boolean alt_vehicle_is_primary_color_rgb(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_primary_color(jnr.ffi.Pointer instance);
        void alt_vehicle_get_primary_color_rgb(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_vehicle_set_primary_color(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte color);
        void alt_vehicle_set_primary_color_rgb(jnr.ffi.Pointer instance, alt_rgba_t color);
        boolean alt_vehicle_is_secondary_color_rgb(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_secondary_color(jnr.ffi.Pointer instance);
        void alt_vehicle_get_secondary_color_rgb(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_vehicle_set_secondary_color(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte color);
        void alt_vehicle_set_secondary_color_rgb(jnr.ffi.Pointer instance, alt_rgba_t color);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_pearl_color(jnr.ffi.Pointer instance);
        void alt_vehicle_set_pearl_color(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte color);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_wheel_color(jnr.ffi.Pointer instance);
        void alt_vehicle_set_wheel_color(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte color);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_interior_color(jnr.ffi.Pointer instance);
        void alt_vehicle_set_interior_color(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte color);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_dashboard_color(jnr.ffi.Pointer instance);
        void alt_vehicle_set_dashboard_color(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte color);
        void alt_vehicle_get_tire_smoke_color(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_vehicle_set_tire_smoke_color(jnr.ffi.Pointer instance, alt_rgba_t color);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_wheel_type(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_wheel_variation(jnr.ffi.Pointer instance);
        void alt_vehicle_set_wheels(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte type, @jnr.ffi.types.u_int8_t byte variation);
        boolean alt_vehicle_get_custom_tires(jnr.ffi.Pointer instance);
        void alt_vehicle_set_custom_tires(jnr.ffi.Pointer instance, boolean state);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_special_darkness(jnr.ffi.Pointer instance);
        void alt_vehicle_set_special_darkness(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte value);
        @jnr.ffi.types.u_int32_t int alt_vehicle_get_number_plate_index(jnr.ffi.Pointer instance);
        void alt_vehicle_set_number_plate_index(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int32_t int index);
        @jnr.ffi.types.u_int64_t long alt_vehicle_get_number_plate_text_size(jnr.ffi.Pointer instance);
        void alt_vehicle_get_number_plate_text(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_vehicle_set_number_plate_text(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String text);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_window_tint(jnr.ffi.Pointer instance);
        void alt_vehicle_set_window_tint(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte tint);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_dirt_level(jnr.ffi.Pointer instance);
        void alt_vehicle_set_dirt_level(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte level);
        boolean alt_vehicle_is_extra_on(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte extraID);
        void alt_vehicle_toggle_extra(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte extraID, boolean state);
        void alt_vehicle_get_neon_active(jnr.ffi.Pointer instance, jnr.ffi.Pointer left, jnr.ffi.Pointer right, jnr.ffi.Pointer top, jnr.ffi.Pointer back);
        void alt_vehicle_set_neon_active(jnr.ffi.Pointer instance, boolean left, boolean right, boolean top, boolean back);
        void alt_vehicle_get_neon_color(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        void alt_vehicle_set_neon_color(jnr.ffi.Pointer instance, alt_rgba_t color);
        alt_package_mode_t alt_package_get_mode(jnr.ffi.Pointer instance);
        boolean alt_package_file_exists(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String path);
        jnr.ffi.Pointer alt_package_open_file(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String path);
        void alt_package_close_file(jnr.ffi.Pointer instance, jnr.ffi.Pointer file);
        @jnr.ffi.types.u_int64_t long alt_package_get_file_size(jnr.ffi.Pointer instance, jnr.ffi.Pointer file);
        void alt_package_seek_file(jnr.ffi.Pointer instance, jnr.ffi.Pointer file, @jnr.ffi.types.u_int64_t long offset, alt_package_seek_origin_t origin);
        @jnr.ffi.types.u_int64_t long alt_package_tell_file(jnr.ffi.Pointer instance, jnr.ffi.Pointer file);
        @jnr.ffi.types.u_int64_t long alt_package_read_file(jnr.ffi.Pointer instance, jnr.ffi.Pointer file, jnr.ffi.Pointer buffer, @jnr.ffi.types.u_int64_t long size);
        @jnr.ffi.types.u_int64_t long alt_package_write_file(jnr.ffi.Pointer instance, jnr.ffi.Pointer file, jnr.ffi.Pointer buffer, @jnr.ffi.types.u_int64_t long size);
        alt_resource_state_t alt_resource_get_state(jnr.ffi.Pointer instance);
        boolean alt_resource_is_started(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int64_t long alt_resource_get_type_size(jnr.ffi.Pointer instance);
        void alt_resource_get_type(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        @jnr.ffi.types.u_int64_t long alt_resource_get_name_size(jnr.ffi.Pointer instance);
        void alt_resource_get_name(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        @jnr.ffi.types.u_int64_t long alt_resource_get_main_size(jnr.ffi.Pointer instance);
        void alt_resource_get_main(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        jnr.ffi.Pointer alt_resource_get_package(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_resource_get_exports(jnr.ffi.Pointer instance);
        boolean alt_resource_instantiate(jnr.ffi.Pointer instance);
        boolean alt_resource_start(jnr.ffi.Pointer instance);
        boolean alt_resource_stop(jnr.ffi.Pointer instance);
        boolean alt_resource_on_event(jnr.ffi.Pointer instance, jnr.ffi.Pointer ev);
        void alt_resource_on_tick(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_server_get_resource(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String name);
        boolean alt_server_require_resource(jnr.ffi.Pointer instance, jnr.ffi.Pointer referrer, jnr.ffi.Pointer resource);
        void alt_server_log_info(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String str);
        void alt_server_log_debug(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String str);
        void alt_server_log_warning(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String str);
        void alt_server_log_error(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String str);
        void alt_server_log_colored(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String str);
        @jnr.ffi.types.u_int32_t int alt_server_hash(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String str);
        boolean alt_server_register_script_runtime(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String resourceType, jnr.ffi.Pointer runtime);
        void alt_server_subscribe_event(jnr.ffi.Pointer instance, alt_event_type_t ev, alt_event_callback_t cb);
        void alt_server_subscribe_tick(jnr.ffi.Pointer instance, alt_tick_callback_t cb);
        void alt_server_subscribe_command(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String cmd, alt_command_callback_t cb);
        void alt_server_trigger_server_event(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String ev, jnr.ffi.Pointer args);
        void alt_server_trigger_client_event(jnr.ffi.Pointer instance, jnr.ffi.Pointer target, @jnr.ffi.annotations.Encoding("UTF-8") String ev, jnr.ffi.Pointer args);
        jnr.ffi.Pointer alt_server_get_entity_by_id(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short id);
        jnr.ffi.Pointer alt_server_create_vehicle(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int32_t int model, jnr.ffi.Pointer pos, float heading);
        jnr.ffi.Pointer alt_server_create_checkpoint(jnr.ffi.Pointer instance, jnr.ffi.Pointer target, @jnr.ffi.types.u_int8_t byte type, jnr.ffi.Pointer pos, float radius, float height, alt_rgba_t color);
        jnr.ffi.Pointer alt_server_create_blip(jnr.ffi.Pointer instance, jnr.ffi.Pointer target, @jnr.ffi.types.u_int8_t byte type, jnr.ffi.Pointer pos);
        jnr.ffi.Pointer alt_server_create_blip2(jnr.ffi.Pointer instance, jnr.ffi.Pointer target, @jnr.ffi.types.u_int8_t byte type, jnr.ffi.Pointer attachTo);
        void alt_server_remove_entity(jnr.ffi.Pointer instance, jnr.ffi.Pointer entity);
        jnr.ffi.Pointer alt_server_get_players_by_name(jnr.ffi.Pointer instance, jnr.ffi.Pointer retsize, @jnr.ffi.annotations.Encoding("UTF-8") String name);
        jnr.ffi.Pointer alt_server_get_entities(jnr.ffi.Pointer instance, jnr.ffi.Pointer retsize);
        jnr.ffi.Pointer alt_server_get_players(jnr.ffi.Pointer instance, jnr.ffi.Pointer retsize);
        jnr.ffi.Pointer alt_server_get_vehicles(jnr.ffi.Pointer instance, jnr.ffi.Pointer retsize);
        jnr.ffi.Pointer alt_mvalue_create_nil();
        jnr.ffi.Pointer alt_mvalue_create_bool(boolean value);
        jnr.ffi.Pointer alt_mvalue_create_int(@jnr.ffi.types.int64_t long value);
        jnr.ffi.Pointer alt_mvalue_create_string(@jnr.ffi.annotations.Encoding("UTF-8") String value);
        void alt_mvalue_dispose(jnr.ffi.Pointer instance);
        boolean alt_mvalue_get_bool(jnr.ffi.Pointer instance);
        @jnr.ffi.types.int64_t long alt_mvalue_get_int(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int64_t long alt_mvalue_get_string_size(jnr.ffi.Pointer instance);
        void alt_mvalue_get_string(jnr.ffi.Pointer instance, jnr.ffi.Pointer retbuffer);
        alt_mvalue_type_t alt_mvalue_get_type(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_mvalue_list_create();
        void alt_mvalue_list_push(jnr.ffi.Pointer instance, jnr.ffi.Pointer value);
        @jnr.ffi.types.u_int64_t long alt_mvalue_list_get_size(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_mvalue_list_get(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int64_t long index);
        jnr.ffi.Pointer alt_mvalue_dict_create();
        void alt_mvalue_dict_set(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, jnr.ffi.Pointer value);
        jnr.ffi.Pointer alt_mvalue_dict_get(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        jnr.ffi.Pointer alt_script_runtime_create(alt_script_runtime_create_resource_callback_t create_resource, alt_script_runtime_delete_resource_callback_t delete_resource, alt_script_runtime_on_tick_callback_t on_tick);
        jnr.ffi.Pointer alt_script_runtime_create_resource(jnr.ffi.Pointer info, alt_resource_on_event_callback_t on_event, alt_resource_on_tick_callback_t on_tick);
        void alt_script_runtime_dispose_resource(jnr.ffi.Pointer instance);
    }
}
