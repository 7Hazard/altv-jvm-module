
package alt.v.jvm;

public class CAPI
{
    public static final CAPIFunctions func = jnr.ffi.LibraryLoader.create(CAPIFunctions.class).load("altv-capi");
    static jnr.ffi.Runtime runtime = jnr.ffi.Runtime.getRuntime(func);

    
    public static class alt_mvalue_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer data = new jnr.ffi.Struct.Pointer();

        public alt_mvalue_t(jnr.ffi.Pointer data)
        {
            super(CAPI.runtime);
            
            this.data.set(data);
        }

        public alt_mvalue_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }
    public static enum alt_event_type_t implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        EVENT_NONE(0),
        EVENT_PLAYER_CONNECT(1),
        EVENT_PLAYER_DISCONNECT(2),
        EVENT_SERVER_SCRIPT_EVENT(3),
        EVENT_CLIENT_SCRIPT_EVENT(4),
        EVENT_PLAYER_DAMAGE(5),
        EVENT_PLAYER_DEAD(6),
        EVENT_CHECKPOINT_EVENT(7),
        EVENT_VEHICLE_ENTER_EVENT(8),
        EVENT_VEHICLE_LEAVE_EVENT(9),
        EVENT_VEHICLE_CHANGE_SEAT_EVENT(10),
        EVENT_REMOVE_ENTITY_EVENT(11),
        EVENT_ALL(12),
        EVENT_SIZE(13);
        
        alt_event_type_t(int value) {
            this.value = value;
        }
        
        public int intValue() {
            return value;
        }
        private final int value;
    }
    public static class alt_mvalue_array_t extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer data = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int64_t size = new jnr.ffi.Struct.u_int64_t();

        public alt_mvalue_array_t(jnr.ffi.Pointer data, @jnr.ffi.types.u_int64_t long size)
        {
            super(CAPI.runtime);
            
            this.data.set(data);
            this.size.set(size);
        }

        public alt_mvalue_array_t(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }
    public static enum alt_entity_type_t implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ENTITY_PLAYER(0),
        ENTITY_VEHICLE(1),
        ENTITY_CHECKPOINT(2),
        ENTITY_BLIP(3);
        
        alt_entity_type_t(int value) {
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

        public alt_position_t(float x, float y, float z)
        {
            super(CAPI.runtime);
            
            this.x.set(x);
            this.y.set(y);
            this.z.set(z);
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

        public alt_rotation_t(float pitch, float roll, float yaw)
        {
            super(CAPI.runtime);
            
            this.pitch.set(pitch);
            this.roll.set(roll);
            this.yaw.set(yaw);
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

        public alt_rgba_t(@jnr.ffi.types.u_int8_t byte r, @jnr.ffi.types.u_int8_t byte g, @jnr.ffi.types.u_int8_t byte b, @jnr.ffi.types.u_int8_t byte a)
        {
            super(CAPI.runtime);
            
            this.r.set(r);
            this.g.set(g);
            this.b.set(b);
            this.a.set(a);
        }

        public alt_rgba_t(jnr.ffi.Runtime runtime)
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
        @jnr.ffi.annotations.Delegate public void callback(@jnr.ffi.annotations.Encoding("UTF-8") String a1, @jnr.ffi.annotations.Encoding("UTF-8") String a2, jnr.ffi.Pointer a2Size);
    }

    public static interface CAPIFunctions
    {
        alt_mvalue_t alt_mvalue_create_nil();
        alt_mvalue_t alt_mvalue_create_bool(boolean val);
        alt_mvalue_t alt_mvalue_create_int(@jnr.ffi.types.int64_t long val);
        alt_mvalue_t alt_mvalue_create_uint(@jnr.ffi.types.u_int64_t long val);
        alt_mvalue_t alt_mvalue_create_double(double val);
        alt_mvalue_t alt_mvalue_create_str(jnr.ffi.Pointer val);
        alt_event_type_t alt_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_event_cancel(jnr.ffi.Pointer instance);
        alt_event_type_t alt_player_connect_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_player_connect_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_player_connect_event_cancel(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String _reason);
        jnr.ffi.Pointer alt_player_connect_event_get_target(jnr.ffi.Pointer instance);
        @jnr.ffi.annotations.Encoding("UTF-8") String alt_player_connect_event_get_reason(jnr.ffi.Pointer instance);
        alt_event_type_t alt_player_disconnect_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_player_disconnect_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_player_disconnect_event_cancel(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_player_disconnect_event_get_target(jnr.ffi.Pointer instance);
        @jnr.ffi.annotations.Encoding("UTF-8") String alt_player_disconnect_event_get_reason(jnr.ffi.Pointer instance);
        alt_event_type_t alt_server_script_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_server_script_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_server_script_event_cancel(jnr.ffi.Pointer instance);
        @jnr.ffi.annotations.Encoding("UTF-8") String alt_server_script_event_get_name(jnr.ffi.Pointer instance);
        alt_mvalue_array_t alt_server_script_event_get_args(jnr.ffi.Pointer instance);
        alt_event_type_t alt_client_script_event_get_type(jnr.ffi.Pointer instance);
        boolean alt_client_script_event_was_cancelled(jnr.ffi.Pointer instance);
        void alt_client_script_event_cancel(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_client_script_event_get_target(jnr.ffi.Pointer instance);
        @jnr.ffi.annotations.Encoding("UTF-8") String alt_client_script_event_get_name(jnr.ffi.Pointer instance);
        alt_mvalue_array_t alt_client_script_event_get_args(jnr.ffi.Pointer instance);
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
        alt_entity_type_t alt_entity_get_type(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int16_t short alt_entity_get_id(jnr.ffi.Pointer instance);
        alt_position_t alt_entity_get_position(jnr.ffi.Pointer instance);
        void alt_entity_set_position(jnr.ffi.Pointer instance, float x, float y, float z);
        alt_rotation_t alt_entity_get_rotation(jnr.ffi.Pointer instance);
        void alt_entity_set_rotation(jnr.ffi.Pointer instance, float x, float y, float z);
        @jnr.ffi.types.u_int16_t short alt_entity_get_dimension(jnr.ffi.Pointer instance);
        void alt_entity_set_dimension(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short dimension);
        void alt_entity_set_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, alt_mvalue_t val);
        alt_mvalue_t alt_entity_get_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        void alt_entity_set_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, alt_mvalue_t val);
        alt_mvalue_t alt_entity_get_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        alt_entity_type_t alt_checkpoint_get_type(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int16_t short alt_checkpoint_get_id(jnr.ffi.Pointer instance);
        alt_position_t alt_checkpoint_get_position(jnr.ffi.Pointer instance);
        void alt_checkpoint_set_position(jnr.ffi.Pointer instance, alt_position_t pos);
        void alt_checkpoint_set_position2(jnr.ffi.Pointer instance, float x, float y, float z);
        alt_rotation_t alt_checkpoint_get_rotation(jnr.ffi.Pointer instance);
        void alt_checkpoint_set_rotation(jnr.ffi.Pointer instance, alt_rotation_t rot);
        void alt_checkpoint_set_rotation2(jnr.ffi.Pointer instance, float x, float y, float z);
        @jnr.ffi.types.u_int16_t short alt_checkpoint_get_dimension(jnr.ffi.Pointer instance);
        void alt_checkpoint_set_dimension(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short dimension);
        void alt_checkpoint_set_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, alt_mvalue_t val);
        alt_mvalue_t alt_checkpoint_get_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        void alt_checkpoint_set_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, alt_mvalue_t val);
        alt_mvalue_t alt_checkpoint_get_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        boolean alt_checkpoint_is_global(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_checkpoint_get_checkpoint_type(jnr.ffi.Pointer instance);
        float alt_checkpoint_get_height(jnr.ffi.Pointer instance);
        float alt_checkpoint_get_radius(jnr.ffi.Pointer instance);
        alt_rgba_t alt_checkpoint_get_color(jnr.ffi.Pointer instance);
        alt_entity_type_t alt_blip_get_type(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int16_t short alt_blip_get_id(jnr.ffi.Pointer instance);
        alt_position_t alt_blip_get_position(jnr.ffi.Pointer instance);
        void alt_blip_set_position(jnr.ffi.Pointer instance, alt_position_t pos);
        void alt_blip_set_position2(jnr.ffi.Pointer instance, float x, float y, float z);
        alt_rotation_t alt_blip_get_rotation(jnr.ffi.Pointer instance);
        void alt_blip_set_rotation(jnr.ffi.Pointer instance, alt_rotation_t rot);
        void alt_blip_set_rotation2(jnr.ffi.Pointer instance, float x, float y, float z);
        @jnr.ffi.types.u_int16_t short alt_blip_get_dimension(jnr.ffi.Pointer instance);
        void alt_blip_set_dimension(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short dimension);
        void alt_blip_set_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, alt_mvalue_t val);
        alt_mvalue_t alt_blip_get_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        void alt_blip_set_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, alt_mvalue_t val);
        alt_mvalue_t alt_blip_get_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        boolean alt_blip_is_global(jnr.ffi.Pointer instance);
        boolean alt_blip_is_attached(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_blip_attached_to(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_blip_get_blip_type(jnr.ffi.Pointer instance);
        void alt_blip_set_sprite(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short sprite);
        void alt_blip_set_color(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte color);
        void alt_blip_set_route(jnr.ffi.Pointer instance, boolean state);
        void alt_blip_set_route_color(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte color);
        alt_entity_type_t alt_player_get_type(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int16_t short alt_player_get_id(jnr.ffi.Pointer instance);
        alt_position_t alt_player_get_position(jnr.ffi.Pointer instance);
        void alt_player_set_position(jnr.ffi.Pointer instance, alt_position_t pos);
        void alt_player_set_position2(jnr.ffi.Pointer instance, float x, float y, float z);
        alt_rotation_t alt_player_get_rotation(jnr.ffi.Pointer instance);
        void alt_player_set_rotation(jnr.ffi.Pointer instance, alt_rotation_t rot);
        void alt_player_set_rotation2(jnr.ffi.Pointer instance, float x, float y, float z);
        @jnr.ffi.types.u_int16_t short alt_player_get_dimension(jnr.ffi.Pointer instance);
        void alt_player_set_dimension(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short dimension);
        void alt_player_set_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, alt_mvalue_t val);
        alt_mvalue_t alt_player_get_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        void alt_player_set_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, alt_mvalue_t val);
        alt_mvalue_t alt_player_get_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        boolean alt_player_is_connected(jnr.ffi.Pointer instance);
        void alt_player_spawn(jnr.ffi.Pointer instance, alt_position_t pos);
        void alt_player_despawn(jnr.ffi.Pointer instance);
        @jnr.ffi.annotations.Encoding("UTF-8") String alt_player_get_name(jnr.ffi.Pointer instance);
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
        alt_position_t alt_player_get_aim_pos(jnr.ffi.Pointer instance);
        alt_rotation_t alt_player_get_head_rotation(jnr.ffi.Pointer instance);
        boolean alt_player_is_in_vehicle(jnr.ffi.Pointer instance);
        jnr.ffi.Pointer alt_player_get_vehicle(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_player_get_seat(jnr.ffi.Pointer instance);
        void alt_player_kick(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String reason);
        alt_entity_type_t alt_vehicle_get_type(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int16_t short alt_vehicle_get_id(jnr.ffi.Pointer instance);
        alt_position_t alt_vehicle_get_position(jnr.ffi.Pointer instance);
        void alt_vehicle_set_position(jnr.ffi.Pointer instance, alt_position_t pos);
        void alt_vehicle_set_position2(jnr.ffi.Pointer instance, float x, float y, float z);
        alt_rotation_t alt_vehicle_get_rotation(jnr.ffi.Pointer instance);
        void alt_vehicle_set_rotation(jnr.ffi.Pointer instance, alt_rotation_t rot);
        void alt_vehicle_set_rotation2(jnr.ffi.Pointer instance, float x, float y, float z);
        @jnr.ffi.types.u_int16_t short alt_vehicle_get_dimension(jnr.ffi.Pointer instance);
        void alt_vehicle_set_dimension(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int16_t short dimension);
        void alt_vehicle_set_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, alt_mvalue_t val);
        alt_mvalue_t alt_vehicle_get_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        void alt_vehicle_set_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key, alt_mvalue_t val);
        alt_mvalue_t alt_vehicle_get_synced_meta_data(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String key);
        jnr.ffi.Pointer alt_vehicle_get_driver(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_mod(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte category);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_mods_count(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte category);
        boolean alt_vehicle_set_mod(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte category, @jnr.ffi.types.u_int8_t byte id);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_mod_kits_count(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_mod_kit(jnr.ffi.Pointer instance);
        boolean alt_vehicle_set_mod_kit(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte id);
        boolean alt_vehicle_is_primary_color_rgb(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_primary_color(jnr.ffi.Pointer instance);
        alt_rgba_t alt_vehicle_get_primary_color_rgb(jnr.ffi.Pointer instance);
        void alt_vehicle_set_primary_color(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte color);
        void alt_vehicle_set_primary_color_rgb(jnr.ffi.Pointer instance, alt_rgba_t color);
        boolean alt_vehicle_is_secondary_color_rgb(jnr.ffi.Pointer instance);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_secondary_color(jnr.ffi.Pointer instance);
        alt_rgba_t alt_vehicle_get_secondary_color_rgb(jnr.ffi.Pointer instance);
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
        alt_rgba_t alt_vehicle_get_tire_smoke_color(jnr.ffi.Pointer instance);
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
        @jnr.ffi.annotations.Encoding("UTF-8") String alt_vehicle_get_number_plate_text(jnr.ffi.Pointer instance);
        void alt_vehicle_set_number_plate_text(jnr.ffi.Pointer instance, @jnr.ffi.annotations.Encoding("UTF-8") String text);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_window_tint(jnr.ffi.Pointer instance);
        void alt_vehicle_set_window_tint(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte tint);
        @jnr.ffi.types.u_int8_t byte alt_vehicle_get_dirt_level(jnr.ffi.Pointer instance);
        void alt_vehicle_set_dirt_level(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte level);
        boolean alt_vehicle_is_extra_on(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte extraID);
        void alt_vehicle_toggle_extra(jnr.ffi.Pointer instance, @jnr.ffi.types.u_int8_t byte extraID, boolean state);
        void alt_vehicle_get_neon_active(jnr.ffi.Pointer instance, boolean left, boolean right, boolean top, boolean back);
        void alt_vehicle_set_neon_active(jnr.ffi.Pointer instance, boolean left, boolean right, boolean top, boolean back);
        alt_rgba_t alt_vehicle_get_neon_color(jnr.ffi.Pointer instance);
        void alt_vehicle_set_neon_color(jnr.ffi.Pointer instance, alt_rgba_t color);
        boolean alt_resource_is_loaded(jnr.ffi.Pointer instance);
        boolean alt_resource_is_started(jnr.ffi.Pointer instance);
        @jnr.ffi.annotations.Encoding("UTF-8") String alt_resource_get_name(jnr.ffi.Pointer instance);
        @jnr.ffi.annotations.Encoding("UTF-8") String alt_resource_get_type(jnr.ffi.Pointer instance);
        @jnr.ffi.annotations.Encoding("UTF-8") String alt_resource_get_main(jnr.ffi.Pointer instance);
        void alt_server_log_info(@jnr.ffi.annotations.Encoding("UTF-8") String str);
        void alt_server_log_debug(@jnr.ffi.annotations.Encoding("UTF-8") String str);
        void alt_server_log_warning(@jnr.ffi.annotations.Encoding("UTF-8") String str);
        void alt_server_log_error(@jnr.ffi.annotations.Encoding("UTF-8") String str);
        void alt_server_log_colored(@jnr.ffi.annotations.Encoding("UTF-8") String str);
        @jnr.ffi.types.u_int32_t int alt_server_hash(@jnr.ffi.annotations.Encoding("UTF-8") String str);
        boolean alt_server_register_resource_type(@jnr.ffi.annotations.Encoding("UTF-8") String resourceType, jnr.ffi.Pointer manager);
        void alt_server_subscribe_event(alt_event_type_t ev, alt_event_callback_t cb);
        void alt_server_subscribe_update(alt_tick_callback_t cb);
        void alt_server_subscribe_command(@jnr.ffi.annotations.Encoding("UTF-8") String cmd, alt_command_callback_t cb);
        void alt_server_trigger_server_event(@jnr.ffi.annotations.Encoding("UTF-8") String ev, alt_mvalue_array_t args);
        void alt_server_trigger_client_event(jnr.ffi.Pointer target, @jnr.ffi.annotations.Encoding("UTF-8") String ev, alt_mvalue_array_t args);
        jnr.ffi.Pointer alt_server_get_entity_by_id(@jnr.ffi.types.u_int16_t short id);
        jnr.ffi.Pointer alt_server_create_vehicle(@jnr.ffi.types.u_int32_t int model, alt_position_t pos, float heading);
        jnr.ffi.Pointer alt_server_create_checkpoint(jnr.ffi.Pointer target, @jnr.ffi.types.u_int8_t byte type, alt_position_t pos, float radius, float height, alt_rgba_t color);
        jnr.ffi.Pointer alt_server_create_blip(jnr.ffi.Pointer target, @jnr.ffi.types.u_int8_t byte type, jnr.ffi.Pointer attachTo);
        void alt_server_remove_entity(jnr.ffi.Pointer entity);
        jnr.ffi.Pointer alt_server_get_players_by_name(@jnr.ffi.annotations.Encoding("UTF-8") String name, jnr.ffi.Pointer retSize);
        jnr.ffi.Pointer alt_server_get_entities(jnr.ffi.Pointer retSize);
        jnr.ffi.Pointer alt_server_get_players(jnr.ffi.Pointer retSize);
        jnr.ffi.Pointer alt_server_get_vehicles(jnr.ffi.Pointer retSize);
        
    }
}
