package alt.v.jvm;

public class CAPI
{
    public static final CAPIFunctions func = jnr.ffi.LibraryLoader.create(CAPIFunctions.class).load("altv-capi-server");
    public static jnr.ffi.Runtime runtime = jnr.ffi.Runtime.getRuntime(func);
    public static jnr.ffi.Pointer core;
    
    public static enum alt_CEvent_Type implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ALT_CEVENT_TYPE_NONE(0),
        ALT_CEVENT_TYPE_PLAYER_CONNECT(1),
        ALT_CEVENT_TYPE_PLAYER_DISCONNECT(2),
        ALT_CEVENT_TYPE_RESOURCE_START(3),
        ALT_CEVENT_TYPE_RESOURCE_STOP(4),
        ALT_CEVENT_TYPE_RESOURCE_ERROR(5),
        ALT_CEVENT_TYPE_SERVER_SCRIPT_EVENT(6),
        ALT_CEVENT_TYPE_CLIENT_SCRIPT_EVENT(7),
        ALT_CEVENT_TYPE_META_CHANGE(8),
        ALT_CEVENT_TYPE_SYNCED_META_CHANGE(9),
        ALT_CEVENT_TYPE_PLAYER_DAMAGE(10),
        ALT_CEVENT_TYPE_PLAYER_DEATH(11),
        ALT_CEVENT_TYPE_FIRE_EVENT(12),
        ALT_CEVENT_TYPE_EXPLOSION_EVENT(13),
        ALT_CEVENT_TYPE_WEAPON_DAMAGE_EVENT(14),
        ALT_CEVENT_TYPE_CHECKPOINT_EVENT(15),
        ALT_CEVENT_TYPE_COLSHAPE_EVENT(16),
        ALT_CEVENT_TYPE_PLAYER_ENTER_VEHICLE(17),
        ALT_CEVENT_TYPE_PLAYER_LEAVE_VEHICLE(18),
        ALT_CEVENT_TYPE_PLAYER_CHANGE_VEHICLE_SEAT(19),
        ALT_CEVENT_TYPE_REMOVE_ENTITY_EVENT(20),
        ALT_CEVENT_TYPE_DATA_NODE_RECEIVED_EVENT(21),
        ALT_CEVENT_TYPE_CONSOLE_COMMAND_EVENT(22),
        ALT_CEVENT_TYPE_CONNECTION_COMPLETE(23),
        ALT_CEVENT_TYPE_DISCONNECT_EVENT(24),
        ALT_CEVENT_TYPE_WEB_VIEW_EVENT(25),
        ALT_CEVENT_TYPE_KEYBOARD_EVENT(26),
        ALT_CEVENT_TYPE_GAME_ENTITY_CREATE(27),
        ALT_CEVENT_TYPE_GAME_ENTITY_DESTROY(28),
        ALT_CEVENT_TYPE_ALL(29),
        ALT_CEVENT_TYPE_SIZE(30);

        alt_CEvent_Type(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static enum alt_CExplosionEvent_ExplosionType implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_GRENADE(0),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_GRENADELAUNCHER(1),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_STICKYBOMB(2),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_MOLOTOV(3),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_ROCKET(4),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_TANKSHELL(5),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_HI_OCTANE(6),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_CAR(7),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_PLANE(8),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_PETROL_PUMP(9),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_BIKE(10),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_DIR_STEAM(11),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_DIR_FLAME(12),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_DIR_WATER_HYDRANT(13),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_DIR_GAS_CANISTER(14),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_BOAT(15),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_SHIP_DESTROY(16),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_TRUCK(17),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_BULLET(18),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_SMOKEGRENADELAUNCHER(19),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_SMOKEGRENADE(20),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_BZGAS(21),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_FLARE(22),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_GAS_CANISTER(23),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_EXTINGUISHER(24),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_PROGRAMMABLEAR(25),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_TRAIN(26),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_BARREL(27),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_PROPANE(28),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_BLIMP(29),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_DIR_FLAME_EXPLODE(30),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_TANKER(31),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_PLANE_ROCKET(32),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_VEHICLE_BULLET(33),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_GAS_TANK(34),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_FIREWORK(35),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_SNOWBALL(36),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_PROXMINE(37),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_VALKYRIE_CANNON(38),
        ALT_CEXPLOSIONEVENT_EXPLOSIONTYPE_UNKNOWN(255);

        alt_CExplosionEvent_ExplosionType(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static enum alt_CWeaponDamageEvent_BodyPart implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ALT_CWEAPONDAMAGEEVENT_BODYPART_PELVIS(0),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_LEFT_HIP(1),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_LEFT_LEG(2),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_LEFT_FOOT(3),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_RIGHT_HIP(4),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_RIGHT_LEG(5),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_RIGHT_FOOT(6),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_LOWER_TORSO(7),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_UPPER_TORSO(8),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_CHEST(9),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_UNDER_NECK(10),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_LEFT_SHOULDER(11),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_LEFT_UPPER_ARM(12),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_LEFT_ELBROW(13),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_LEFT_WRIST(14),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_RIGHT_SHOULDER(15),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_RIGHT_UPPER_ARM(16),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_RIGHT_ELBROW(17),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_RIGHT_WRIST(18),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_NECK(19),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_HEAD(20),
        ALT_CWEAPONDAMAGEEVENT_BODYPART_UNKNOWN(255);

        alt_CWeaponDamageEvent_BodyPart(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static enum alt_IBaseObject_Type implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ALT_IBASEOBJECT_TYPE_PLAYER(0),
        ALT_IBASEOBJECT_TYPE_VEHICLE(1),
        ALT_IBASEOBJECT_TYPE_BLIP(2),
        ALT_IBASEOBJECT_TYPE_WEBVIEW(3),
        ALT_IBASEOBJECT_TYPE_VOICE_CHANNEL(4),
        ALT_IBASEOBJECT_TYPE_COLSHAPE(5),
        ALT_IBASEOBJECT_TYPE_CHECKPOINT(6);

        alt_IBaseObject_Type(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static enum alt_IBlip_BlipType implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ALT_IBLIP_BLIPTYPE_VEHICLE(1),
        ALT_IBLIP_BLIPTYPE_PED(2),
        ALT_IBLIP_BLIPTYPE_OBJECT(3),
        ALT_IBLIP_BLIPTYPE_DESTINATION(4),
        ALT_IBLIP_BLIPTYPE_CONT(5),
        ALT_IBLIP_BLIPTYPE_PICKUP_UNK(6),
        ALT_IBLIP_BLIPTYPE_RADIUS(7),
        ALT_IBLIP_BLIPTYPE_PICKUP(8),
        ALT_IBLIP_BLIPTYPE_COP(9),
        ALT_IBLIP_BLIPTYPE_AREA(11),
        ALT_IBLIP_BLIPTYPE_GALLERY(12),
        ALT_IBLIP_BLIPTYPE_PICKUP_OBJECT(13);

        alt_IBlip_BlipType(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static enum alt_IColShape_ColShapeType implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ALT_ICOLSHAPE_COLSHAPETYPE_SPHERE(0),
        ALT_ICOLSHAPE_COLSHAPETYPE_CYLINDER(1),
        ALT_ICOLSHAPE_COLSHAPETYPE_CIRCLE(2),
        ALT_ICOLSHAPE_COLSHAPETYPE_CUBOID(3),
        ALT_ICOLSHAPE_COLSHAPETYPE_RECT(4),
        ALT_ICOLSHAPE_COLSHAPETYPE_CHECKPOINT_CYLINDER(5);

        alt_IColShape_ColShapeType(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static enum alt_IMValue_Type implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ALT_IMVALUE_TYPE_NONE(0),
        ALT_IMVALUE_TYPE_NIL(1),
        ALT_IMVALUE_TYPE_BOOL(2),
        ALT_IMVALUE_TYPE_INT(3),
        ALT_IMVALUE_TYPE_UINT(4),
        ALT_IMVALUE_TYPE_DOUBLE(5),
        ALT_IMVALUE_TYPE_STRING(6),
        ALT_IMVALUE_TYPE_LIST(7),
        ALT_IMVALUE_TYPE_DICT(8),
        ALT_IMVALUE_TYPE_BASE_OBJECT(9),
        ALT_IMVALUE_TYPE_FUNCTION(10),
        ALT_IMVALUE_TYPE_VECTOR3(11),
        ALT_IMVALUE_TYPE_RGBA(12),
        ALT_IMVALUE_TYPE_BYTE_ARRAY(13);

        alt_IMValue_Type(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static enum alt_IPackage_Mode implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ALT_IPACKAGE_MODE_READ(0),
        ALT_IPACKAGE_MODE_WRITE(1);

        alt_IPackage_Mode(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static enum alt_IPackage_SeekOrigin implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ALT_IPACKAGE_SEEKORIGIN_SET(0),
        ALT_IPACKAGE_SEEKORIGIN_CUR(1),
        ALT_IPACKAGE_SEEKORIGIN_END(2);

        alt_IPackage_SeekOrigin(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static class alt_Array_RefBase_RefStore_constIMValue extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer data = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int64_t size = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.u_int64_t capacity = new jnr.ffi.Struct.u_int64_t();
        
        public alt_Array_RefBase_RefStore_constIMValue()
        {
            super(runtime);
        }
        public alt_Array_RefBase_RefStore_constIMValue(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_Array_RefBase_RefStore_constIMValue(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_Array_String extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer data = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int64_t size = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.u_int64_t capacity = new jnr.ffi.Struct.u_int64_t();
        
        public alt_Array_String()
        {
            super(runtime);
        }
        public alt_Array_String(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_Array_String(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_Array_StringView extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer data = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int64_t size = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.u_int64_t capacity = new jnr.ffi.Struct.u_int64_t();
        
        public alt_Array_StringView()
        {
            super(runtime);
        }
        public alt_Array_StringView(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_Array_StringView(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CClientScriptEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_RefBase_RefStore_IPlayer target = inner(new alt_RefBase_RefStore_IPlayer());
        public final alt_String name = inner(new alt_String());
        public final alt_Array_RefBase_RefStore_constIMValue args = inner(new alt_Array_RefBase_RefStore_constIMValue());
        
        public alt_CClientScriptEvent()
        {
            super(runtime);
        }
        public alt_CClientScriptEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CClientScriptEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CColShapeEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_RefBase_RefStore_IColShape target = inner(new alt_RefBase_RefStore_IColShape());
        public final alt_RefBase_RefStore_IEntity entity = inner(new alt_RefBase_RefStore_IEntity());
        public final jnr.ffi.Struct.Boolean state = new jnr.ffi.Struct.Boolean();
        
        public alt_CColShapeEvent()
        {
            super(runtime);
        }
        public alt_CColShapeEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CColShapeEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CConsoleCommandEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_StringView name = inner(new alt_StringView());
        public final alt_Array_StringView args = inner(new alt_Array_StringView());
        
        public alt_CConsoleCommandEvent()
        {
            super(runtime);
        }
        public alt_CConsoleCommandEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CConsoleCommandEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CDataNodeReceivedEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_String name = inner(new alt_String());
        public final alt_String json = inner(new alt_String());
        
        public alt_CDataNodeReceivedEvent()
        {
            super(runtime);
        }
        public alt_CDataNodeReceivedEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CDataNodeReceivedEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        
        public alt_CEvent()
        {
            super(runtime);
        }
        public alt_CEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CExplosionEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_RefBase_RefStore_IPlayer source = inner(new alt_RefBase_RefStore_IPlayer());
        public final jnr.ffi.Struct.Enum16<alt_CExplosionEvent_ExplosionType> explosionType = new jnr.ffi.Struct.Enum16<alt_CExplosionEvent_ExplosionType>(alt_CExplosionEvent_ExplosionType.class);
        public final alt_Vector_float_3_PointLayout position = inner(new alt_Vector_float_3_PointLayout());
        public final jnr.ffi.Struct.u_int32_t explosionFX = new jnr.ffi.Struct.u_int32_t();
        
        public alt_CExplosionEvent()
        {
            super(runtime);
        }
        public alt_CExplosionEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CExplosionEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerChangeVehicleSeatEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_RefBase_RefStore_IVehicle target = inner(new alt_RefBase_RefStore_IVehicle());
        public final alt_RefBase_RefStore_IPlayer player = inner(new alt_RefBase_RefStore_IPlayer());
        public final jnr.ffi.Struct.u_int8_t oldSeat = new jnr.ffi.Struct.u_int8_t();
        public final jnr.ffi.Struct.u_int8_t newSeat = new jnr.ffi.Struct.u_int8_t();
        
        public alt_CPlayerChangeVehicleSeatEvent()
        {
            super(runtime);
        }
        public alt_CPlayerChangeVehicleSeatEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CPlayerChangeVehicleSeatEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerConnectEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_RefBase_RefStore_IPlayer target = inner(new alt_RefBase_RefStore_IPlayer());
        public final alt_String reason = inner(new alt_String());
        
        public alt_CPlayerConnectEvent()
        {
            super(runtime);
        }
        public alt_CPlayerConnectEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CPlayerConnectEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerDamageEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_RefBase_RefStore_IPlayer target = inner(new alt_RefBase_RefStore_IPlayer());
        public final alt_RefBase_RefStore_IEntity attacker = inner(new alt_RefBase_RefStore_IEntity());
        public final jnr.ffi.Struct.u_int16_t damage = new jnr.ffi.Struct.u_int16_t();
        public final jnr.ffi.Struct.u_int32_t weapon = new jnr.ffi.Struct.u_int32_t();
        
        public alt_CPlayerDamageEvent()
        {
            super(runtime);
        }
        public alt_CPlayerDamageEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CPlayerDamageEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerDeathEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_RefBase_RefStore_IPlayer target = inner(new alt_RefBase_RefStore_IPlayer());
        public final alt_RefBase_RefStore_IEntity killer = inner(new alt_RefBase_RefStore_IEntity());
        public final jnr.ffi.Struct.u_int32_t weapon = new jnr.ffi.Struct.u_int32_t();
        
        public alt_CPlayerDeathEvent()
        {
            super(runtime);
        }
        public alt_CPlayerDeathEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CPlayerDeathEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerDisconnectEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_RefBase_RefStore_IPlayer target = inner(new alt_RefBase_RefStore_IPlayer());
        public final alt_String reason = inner(new alt_String());
        
        public alt_CPlayerDisconnectEvent()
        {
            super(runtime);
        }
        public alt_CPlayerDisconnectEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CPlayerDisconnectEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerEnterVehicleEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_RefBase_RefStore_IVehicle target = inner(new alt_RefBase_RefStore_IVehicle());
        public final alt_RefBase_RefStore_IPlayer player = inner(new alt_RefBase_RefStore_IPlayer());
        public final jnr.ffi.Struct.u_int8_t seat = new jnr.ffi.Struct.u_int8_t();
        
        public alt_CPlayerEnterVehicleEvent()
        {
            super(runtime);
        }
        public alt_CPlayerEnterVehicleEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CPlayerEnterVehicleEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerLeaveVehicleEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_RefBase_RefStore_IVehicle target = inner(new alt_RefBase_RefStore_IVehicle());
        public final alt_RefBase_RefStore_IPlayer player = inner(new alt_RefBase_RefStore_IPlayer());
        public final jnr.ffi.Struct.u_int8_t seat = new jnr.ffi.Struct.u_int8_t();
        
        public alt_CPlayerLeaveVehicleEvent()
        {
            super(runtime);
        }
        public alt_CPlayerLeaveVehicleEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CPlayerLeaveVehicleEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CRemoveEntityEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_RefBase_RefStore_IEntity target = inner(new alt_RefBase_RefStore_IEntity());
        
        public alt_CRemoveEntityEvent()
        {
            super(runtime);
        }
        public alt_CRemoveEntityEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CRemoveEntityEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CResourceErrorEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer resource = new jnr.ffi.Struct.Pointer();
        
        public alt_CResourceErrorEvent()
        {
            super(runtime);
        }
        public alt_CResourceErrorEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CResourceErrorEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CResourceStartEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer resource = new jnr.ffi.Struct.Pointer();
        
        public alt_CResourceStartEvent()
        {
            super(runtime);
        }
        public alt_CResourceStartEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CResourceStartEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CResourceStopEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer resource = new jnr.ffi.Struct.Pointer();
        
        public alt_CResourceStopEvent()
        {
            super(runtime);
        }
        public alt_CResourceStopEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CResourceStopEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CServerScriptEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_String name = inner(new alt_String());
        public final alt_Array_RefBase_RefStore_constIMValue args = inner(new alt_Array_RefBase_RefStore_constIMValue());
        
        public alt_CServerScriptEvent()
        {
            super(runtime);
        }
        public alt_CServerScriptEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CServerScriptEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CSyncedMetaDataChangeEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_RefBase_RefStore_IEntity target = inner(new alt_RefBase_RefStore_IEntity());
        public final alt_String key = inner(new alt_String());
        public final alt_RefBase_RefStore_IMValue val = inner(new alt_RefBase_RefStore_IMValue());
        
        public alt_CSyncedMetaDataChangeEvent()
        {
            super(runtime);
        }
        public alt_CSyncedMetaDataChangeEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CSyncedMetaDataChangeEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CWeaponDamageEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum16<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum16<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_RefBase_RefStore_IPlayer source = inner(new alt_RefBase_RefStore_IPlayer());
        public final alt_RefBase_RefStore_IEntity target = inner(new alt_RefBase_RefStore_IEntity());
        public final jnr.ffi.Struct.u_int32_t weaponHash = new jnr.ffi.Struct.u_int32_t();
        public final jnr.ffi.Struct.u_int16_t damageValue = new jnr.ffi.Struct.u_int16_t();
        public final alt_Vector_float_3_VectorLayout_float_3 shotOffset = inner(new alt_Vector_float_3_VectorLayout_float_3());
        public final jnr.ffi.Struct.Enum16<alt_CWeaponDamageEvent_BodyPart> bodyPart = new jnr.ffi.Struct.Enum16<alt_CWeaponDamageEvent_BodyPart>(alt_CWeaponDamageEvent_BodyPart.class);
        
        public alt_CWeaponDamageEvent()
        {
            super(runtime);
        }
        public alt_CWeaponDamageEvent(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_CWeaponDamageEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_DiscordOAuth2Token extends jnr.ffi.Struct
    {
        public final alt_String token = inner(new alt_String());
        public final jnr.ffi.Struct.int64_t expires = new jnr.ffi.Struct.int64_t();
        public final alt_String scopes = inner(new alt_String());
        
        public alt_DiscordOAuth2Token()
        {
            super(runtime);
        }
        public alt_DiscordOAuth2Token(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_DiscordOAuth2Token(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_IMValueFunction_Impl extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.u_int64_t refCount = new jnr.ffi.Struct.u_int64_t();
        
        public alt_IMValueFunction_Impl()
        {
            super(runtime);
        }
        public alt_IMValueFunction_Impl(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_IMValueFunction_Impl(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_IResource_CreationInfo extends jnr.ffi.Struct
    {
        public final alt_String type = inner(new alt_String());
        public final alt_String name = inner(new alt_String());
        public final alt_String main = inner(new alt_String());
        public final jnr.ffi.Struct.Pointer pkg = new jnr.ffi.Struct.Pointer();
        
        public alt_IResource_CreationInfo()
        {
            super(runtime);
        }
        public alt_IResource_CreationInfo(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_IResource_CreationInfo(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_PointLayout extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Float x = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float y = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float z = new jnr.ffi.Struct.Float();
        
        public alt_PointLayout()
        {
            super(runtime);
        }
        public alt_PointLayout(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_PointLayout(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_PointPaddedLayout extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Float x = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float y = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float z = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float pad = new jnr.ffi.Struct.Float();
        
        public alt_PointPaddedLayout()
        {
            super(runtime);
        }
        public alt_PointPaddedLayout(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_PointPaddedLayout(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RGBA extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.u_int8_t r = new jnr.ffi.Struct.u_int8_t();
        public final jnr.ffi.Struct.u_int8_t g = new jnr.ffi.Struct.u_int8_t();
        public final jnr.ffi.Struct.u_int8_t b = new jnr.ffi.Struct.u_int8_t();
        public final jnr.ffi.Struct.u_int8_t a = new jnr.ffi.Struct.u_int8_t();
        
        public alt_RGBA()
        {
            super(runtime);
        }
        public alt_RGBA(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RGBA(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefBase_RefStore_IBaseObject extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefBase_RefStore_IBaseObject()
        {
            super(runtime);
        }
        public alt_RefBase_RefStore_IBaseObject(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefBase_RefStore_IBaseObject(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefBase_RefStore_IColShape extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefBase_RefStore_IColShape()
        {
            super(runtime);
        }
        public alt_RefBase_RefStore_IColShape(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefBase_RefStore_IColShape(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefBase_RefStore_IEntity extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefBase_RefStore_IEntity()
        {
            super(runtime);
        }
        public alt_RefBase_RefStore_IEntity(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefBase_RefStore_IEntity(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefBase_RefStore_IMValue extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefBase_RefStore_IMValue()
        {
            super(runtime);
        }
        public alt_RefBase_RefStore_IMValue(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefBase_RefStore_IMValue(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefBase_RefStore_IPlayer extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefBase_RefStore_IPlayer()
        {
            super(runtime);
        }
        public alt_RefBase_RefStore_IPlayer(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefBase_RefStore_IPlayer(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefBase_RefStore_IVehicle extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefBase_RefStore_IVehicle()
        {
            super(runtime);
        }
        public alt_RefBase_RefStore_IVehicle(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefBase_RefStore_IVehicle(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefBase_RefStore_constIMValue extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefBase_RefStore_constIMValue()
        {
            super(runtime);
        }
        public alt_RefBase_RefStore_constIMValue(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefBase_RefStore_constIMValue(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefStore_IBaseObject extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefStore_IBaseObject()
        {
            super(runtime);
        }
        public alt_RefStore_IBaseObject(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefStore_IBaseObject(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefStore_IColShape extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefStore_IColShape()
        {
            super(runtime);
        }
        public alt_RefStore_IColShape(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefStore_IColShape(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefStore_IEntity extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefStore_IEntity()
        {
            super(runtime);
        }
        public alt_RefStore_IEntity(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefStore_IEntity(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefStore_IMValue extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefStore_IMValue()
        {
            super(runtime);
        }
        public alt_RefStore_IMValue(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefStore_IMValue(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefStore_IPlayer extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefStore_IPlayer()
        {
            super(runtime);
        }
        public alt_RefStore_IPlayer(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefStore_IPlayer(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefStore_IVehicle extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefStore_IVehicle()
        {
            super(runtime);
        }
        public alt_RefStore_IVehicle(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefStore_IVehicle(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RefStore_constIMValue extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer ptr = new jnr.ffi.Struct.Pointer();
        
        public alt_RefStore_constIMValue()
        {
            super(runtime);
        }
        public alt_RefStore_constIMValue(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RefStore_constIMValue(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RotationLayout extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Float roll = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float pitch = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float yaw = new jnr.ffi.Struct.Float();
        
        public alt_RotationLayout()
        {
            super(runtime);
        }
        public alt_RotationLayout(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RotationLayout(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_RotationPaddedLayout extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Float roll = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float pitch = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float yaw = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float pad = new jnr.ffi.Struct.Float();
        
        public alt_RotationPaddedLayout()
        {
            super(runtime);
        }
        public alt_RotationPaddedLayout(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_RotationPaddedLayout(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_String extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer data = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int64_t size = new jnr.ffi.Struct.u_int64_t();
        
        public alt_String()
        {
            super(runtime);
        }
        public alt_String(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_String(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_StringView extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer data = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int64_t size = new jnr.ffi.Struct.u_int64_t();
        
        public alt_StringView()
        {
            super(runtime);
        }
        public alt_StringView(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_StringView(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_VectorLayout_float_3 extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer elements = new jnr.ffi.Struct.Pointer();
        
        public alt_VectorLayout_float_3()
        {
            super(runtime);
        }
        public alt_VectorLayout_float_3(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_VectorLayout_float_3(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_VectorLayout_float_4 extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer elements = new jnr.ffi.Struct.Pointer();
        
        public alt_VectorLayout_float_4()
        {
            super(runtime);
        }
        public alt_VectorLayout_float_4(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_VectorLayout_float_4(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_Vector_float_3_PointLayout extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Float x = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float y = new jnr.ffi.Struct.Float();
        public final jnr.ffi.Struct.Float z = new jnr.ffi.Struct.Float();
        
        public alt_Vector_float_3_PointLayout()
        {
            super(runtime);
        }
        public alt_Vector_float_3_PointLayout(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_Vector_float_3_PointLayout(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_Vector_float_3_VectorLayout_float_3 extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer elements = new jnr.ffi.Struct.Pointer();
        
        public alt_Vector_float_3_VectorLayout_float_3()
        {
            super(runtime);
        }
        public alt_Vector_float_3_VectorLayout_float_3(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_Vector_float_3_VectorLayout_float_3(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_Vector_float_4_VectorLayout_float_4 extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer elements = new jnr.ffi.Struct.Pointer();
        
        public alt_Vector_float_4_VectorLayout_float_4()
        {
            super(runtime);
        }
        public alt_Vector_float_4_VectorLayout_float_4(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_Vector_float_4_VectorLayout_float_4(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_ViewMatrixLayout extends jnr.ffi.Struct
    {
        public final alt_Vector_float_4_VectorLayout_float_4 right = inner(new alt_Vector_float_4_VectorLayout_float_4());
        public final alt_Vector_float_4_VectorLayout_float_4 up = inner(new alt_Vector_float_4_VectorLayout_float_4());
        public final alt_Vector_float_4_VectorLayout_float_4 forward = inner(new alt_Vector_float_4_VectorLayout_float_4());
        public final alt_Vector_float_4_VectorLayout_float_4 pos = inner(new alt_Vector_float_4_VectorLayout_float_4());
        
        public alt_ViewMatrixLayout()
        {
            super(runtime);
        }
        public alt_ViewMatrixLayout(jnr.ffi.Pointer pointer)
        {
            super(runtime);
            this.useMemory(pointer);
        }
        public alt_ViewMatrixLayout(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    

    public static interface CAPIFunctions
    {
        jnr.ffi.Pointer alt_Array_RefBase_RefStore_constIMValue_Access_uint64_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_Array_RefBase_RefStore_constIMValue_Access_uint64_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_Array_RefBase_RefStore_constIMValue_Assign_Array_RefBase_RefStore_constIMValueRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        void alt_Array_RefBase_RefStore_constIMValue_Assign_constArray_RefBase_RefStore_constIMValueRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_Array_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_Array_RefBase_RefStore_constIMValue_Create();

        /**
         * Return ptr must be manually freed with alt_Array_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_Array_RefBase_RefStore_constIMValue_Create_1(jnr.ffi.Pointer _data, @jnr.ffi.types.u_int64_t long _size);

        /**
         * Return ptr must be manually freed with alt_Array_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_Array_RefBase_RefStore_constIMValue_Create_2(@jnr.ffi.types.u_int64_t long _size, jnr.ffi.Pointer fill);

        /**
         * Return ptr must be manually freed with alt_Array_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_Array_RefBase_RefStore_constIMValue_Create_3(jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_Array_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_Array_RefBase_RefStore_constIMValue_Create_4(jnr.ffi.Pointer that);

        @jnr.ffi.types.u_int64_t long alt_Array_RefBase_RefStore_constIMValue_GetCapacity(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_Array_RefBase_RefStore_constIMValue_GetSize(jnr.ffi.Pointer _instance);

        void alt_Array_RefBase_RefStore_constIMValue_Push(jnr.ffi.Pointer _instance, jnr.ffi.Pointer el);

        jnr.ffi.Pointer alt_Array_RefBase_RefStore_constIMValue_begin(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_RefBase_RefStore_constIMValue_begin_1(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_RefBase_RefStore_constIMValue_end(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_RefBase_RefStore_constIMValue_end_1(jnr.ffi.Pointer _instance);

        void alt_Array_RefBase_RefStore_constIMValue_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_Array_StringView_Access_uint64_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_Array_StringView_Access_uint64_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_Array_StringView_Assign_Array_StringViewRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        void alt_Array_StringView_Assign_constArray_StringViewRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_Array_StringView_free()
         */
        jnr.ffi.Pointer alt_Array_StringView_Create();

        /**
         * Return ptr must be manually freed with alt_Array_StringView_free()
         */
        jnr.ffi.Pointer alt_Array_StringView_Create_1(jnr.ffi.Pointer _data, @jnr.ffi.types.u_int64_t long _size);

        /**
         * Return ptr must be manually freed with alt_Array_StringView_free()
         */
        jnr.ffi.Pointer alt_Array_StringView_Create_2(@jnr.ffi.types.u_int64_t long _size, jnr.ffi.Pointer fill);

        /**
         * Return ptr must be manually freed with alt_Array_StringView_free()
         */
        jnr.ffi.Pointer alt_Array_StringView_Create_3(jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_Array_StringView_free()
         */
        jnr.ffi.Pointer alt_Array_StringView_Create_4(jnr.ffi.Pointer that);

        @jnr.ffi.types.u_int64_t long alt_Array_StringView_GetCapacity(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_Array_StringView_GetSize(jnr.ffi.Pointer _instance);

        void alt_Array_StringView_Push(jnr.ffi.Pointer _instance, jnr.ffi.Pointer el);

        jnr.ffi.Pointer alt_Array_StringView_begin(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_StringView_begin_1(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_StringView_end(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_StringView_end_1(jnr.ffi.Pointer _instance);

        void alt_Array_StringView_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_Array_String_Access_uint64_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_Array_String_Access_uint64_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_Array_String_Assign_Array_StringRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        void alt_Array_String_Assign_constArray_StringRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_Array_String_free()
         */
        jnr.ffi.Pointer alt_Array_String_Create();

        /**
         * Return ptr must be manually freed with alt_Array_String_free()
         */
        jnr.ffi.Pointer alt_Array_String_Create_1(jnr.ffi.Pointer _data, @jnr.ffi.types.u_int64_t long _size);

        /**
         * Return ptr must be manually freed with alt_Array_String_free()
         */
        jnr.ffi.Pointer alt_Array_String_Create_2(@jnr.ffi.types.u_int64_t long _size, jnr.ffi.Pointer fill);

        /**
         * Return ptr must be manually freed with alt_Array_String_free()
         */
        jnr.ffi.Pointer alt_Array_String_Create_3(jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_Array_String_free()
         */
        jnr.ffi.Pointer alt_Array_String_Create_4(jnr.ffi.Pointer that);

        @jnr.ffi.types.u_int64_t long alt_Array_String_GetCapacity(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_Array_String_GetSize(jnr.ffi.Pointer _instance);

        void alt_Array_String_Push(jnr.ffi.Pointer _instance, jnr.ffi.Pointer el);

        jnr.ffi.Pointer alt_Array_String_begin(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_String_begin_1(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_String_end(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_String_end_1(jnr.ffi.Pointer _instance);

        void alt_Array_String_free(jnr.ffi.Pointer ptr);

        void alt_CClientScriptEvent_Assign_CClientScriptEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CClientScriptEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CClientScriptEvent_Assign_constCClientScriptEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CClientScriptEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CClientScriptEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CClientScriptEvent_free()
         */
        jnr.ffi.Pointer alt_CClientScriptEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CClientScriptEvent_free()
         */
        jnr.ffi.Pointer alt_CClientScriptEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CClientScriptEvent_free()
         */
        jnr.ffi.Pointer alt_CClientScriptEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CClientScriptEvent_free()
         */
        jnr.ffi.Pointer alt_CClientScriptEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _name, jnr.ffi.Pointer _args);

        /**
         * Return ptr must be manually freed with alt_CClientScriptEvent_free()
         */
        jnr.ffi.Pointer alt_CClientScriptEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CClientScriptEvent_free()
         */
        jnr.ffi.Pointer alt_CClientScriptEvent_Create_5(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CClientScriptEvent_GetArgs(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_CClientScriptEvent_GetName(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_CClientScriptEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CClientScriptEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CClientScriptEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CClientScriptEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CClientScriptEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CColShapeEvent_Assign_CColShapeEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CColShapeEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CColShapeEvent_Assign_constCColShapeEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CColShapeEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CColShapeEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CColShapeEvent_free()
         */
        jnr.ffi.Pointer alt_CColShapeEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CColShapeEvent_free()
         */
        jnr.ffi.Pointer alt_CColShapeEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CColShapeEvent_free()
         */
        jnr.ffi.Pointer alt_CColShapeEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CColShapeEvent_free()
         */
        jnr.ffi.Pointer alt_CColShapeEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _entity, boolean _state);

        /**
         * Return ptr must be manually freed with alt_CColShapeEvent_free()
         */
        jnr.ffi.Pointer alt_CColShapeEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CColShapeEvent_free()
         */
        jnr.ffi.Pointer alt_CColShapeEvent_Create_5(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_CColShapeEvent_GetEntity(jnr.ffi.Pointer _instance);

        boolean alt_CColShapeEvent_GetState(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_CColShapeEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CColShapeEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CColShapeEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CColShapeEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CColShapeEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CConsoleCommandEvent_Assign_CConsoleCommandEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CConsoleCommandEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CConsoleCommandEvent_Assign_constCConsoleCommandEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CConsoleCommandEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CConsoleCommandEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CConsoleCommandEvent_free()
         */
        jnr.ffi.Pointer alt_CConsoleCommandEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CConsoleCommandEvent_free()
         */
        jnr.ffi.Pointer alt_CConsoleCommandEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CConsoleCommandEvent_free()
         */
        jnr.ffi.Pointer alt_CConsoleCommandEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CConsoleCommandEvent_free()
         */
        jnr.ffi.Pointer alt_CConsoleCommandEvent_Create_3(jnr.ffi.Pointer _name, jnr.ffi.Pointer _args);

        /**
         * Return ptr must be manually freed with alt_CConsoleCommandEvent_free()
         */
        jnr.ffi.Pointer alt_CConsoleCommandEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CConsoleCommandEvent_free()
         */
        jnr.ffi.Pointer alt_CConsoleCommandEvent_Create_5(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CConsoleCommandEvent_GetArgs(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_CConsoleCommandEvent_GetName(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CConsoleCommandEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CConsoleCommandEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CConsoleCommandEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CConsoleCommandEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CDataNodeReceivedEvent_Assign_CDataNodeReceivedEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CDataNodeReceivedEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CDataNodeReceivedEvent_Assign_constCDataNodeReceivedEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CDataNodeReceivedEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CDataNodeReceivedEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CDataNodeReceivedEvent_free()
         */
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CDataNodeReceivedEvent_free()
         */
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CDataNodeReceivedEvent_free()
         */
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CDataNodeReceivedEvent_free()
         */
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_Create_3(jnr.ffi.Pointer _name, jnr.ffi.Pointer _logJson);

        /**
         * Return ptr must be manually freed with alt_CDataNodeReceivedEvent_free()
         */
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CDataNodeReceivedEvent_free()
         */
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_Create_5(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_GetJson(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_GetName(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CDataNodeReceivedEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CDataNodeReceivedEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CDataNodeReceivedEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CEvent_free()
         */
        jnr.ffi.Pointer alt_CEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CEvent_free()
         */
        jnr.ffi.Pointer alt_CEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CEvent_free()
         */
        jnr.ffi.Pointer alt_CEvent_Create_2(jnr.ffi.Pointer _p0);

        alt_CEvent_Type alt_CEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CEvent_to_alt_CClientScriptEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CColShapeEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CConsoleCommandEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CDataNodeReceivedEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CExplosionEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CPlayerChangeVehicleSeatEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CPlayerConnectEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CPlayerDamageEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CPlayerDeathEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CPlayerDisconnectEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CPlayerEnterVehicleEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CPlayerLeaveVehicleEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CRemoveEntityEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CResourceErrorEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CResourceStartEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CResourceStopEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CServerScriptEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CSyncedMetaDataChangeEvent(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CEvent_to_alt_CWeaponDamageEvent(jnr.ffi.Pointer from);

        void alt_CExplosionEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CExplosionEvent_Assign_CExplosionEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CExplosionEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CExplosionEvent_Assign_constCExplosionEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CExplosionEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CExplosionEvent_free()
         */
        jnr.ffi.Pointer alt_CExplosionEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CExplosionEvent_free()
         */
        jnr.ffi.Pointer alt_CExplosionEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CExplosionEvent_free()
         */
        jnr.ffi.Pointer alt_CExplosionEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CExplosionEvent_free()
         */
        jnr.ffi.Pointer alt_CExplosionEvent_Create_3(jnr.ffi.Pointer _source, alt_CExplosionEvent_ExplosionType _explosionType, jnr.ffi.Pointer _position, @jnr.ffi.types.u_int32_t int _explosionFX);

        /**
         * Return ptr must be manually freed with alt_CExplosionEvent_free()
         */
        jnr.ffi.Pointer alt_CExplosionEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CExplosionEvent_free()
         */
        jnr.ffi.Pointer alt_CExplosionEvent_Create_5(jnr.ffi.Pointer _p0);

        @jnr.ffi.types.u_int32_t int alt_CExplosionEvent_GetExplosionFX(jnr.ffi.Pointer _instance);

        alt_CExplosionEvent_ExplosionType alt_CExplosionEvent_GetExplosionType(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_CExplosionEvent_GetPosition(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_CExplosionEvent_GetSource(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CExplosionEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CExplosionEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CExplosionEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CExplosionEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CPlayerChangeVehicleSeatEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerChangeVehicleSeatEvent_Assign_CPlayerChangeVehicleSeatEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerChangeVehicleSeatEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerChangeVehicleSeatEvent_Assign_constCPlayerChangeVehicleSeatEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerChangeVehicleSeatEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CPlayerChangeVehicleSeatEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CPlayerChangeVehicleSeatEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerChangeVehicleSeatEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerChangeVehicleSeatEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _player, @jnr.ffi.types.u_int8_t byte _oldSeat, @jnr.ffi.types.u_int8_t byte _newSeat);

        /**
         * Return ptr must be manually freed with alt_CPlayerChangeVehicleSeatEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerChangeVehicleSeatEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_Create_5(jnr.ffi.Pointer _p0);

        @jnr.ffi.types.u_int8_t byte alt_CPlayerChangeVehicleSeatEvent_GetNewSeat(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_CPlayerChangeVehicleSeatEvent_GetOldSeat(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_GetPlayer(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerChangeVehicleSeatEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerChangeVehicleSeatEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerChangeVehicleSeatEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CPlayerConnectEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerConnectEvent_Assign_CPlayerConnectEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerConnectEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerConnectEvent_Assign_constCPlayerConnectEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerConnectEvent_Cancel(jnr.ffi.Pointer _instance);

        void alt_CPlayerConnectEvent_Cancel_1(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _reason);

        /**
         * Return ptr must be manually freed with alt_CPlayerConnectEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerConnectEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CPlayerConnectEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerConnectEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerConnectEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerConnectEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerConnectEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerConnectEvent_Create_3(jnr.ffi.Pointer _target);

        /**
         * Return ptr must be manually freed with alt_CPlayerConnectEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerConnectEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerConnectEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerConnectEvent_Create_5(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_CPlayerConnectEvent_GetReason(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_CPlayerConnectEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerConnectEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerConnectEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerConnectEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CPlayerConnectEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CPlayerDamageEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDamageEvent_Assign_CPlayerDamageEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDamageEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDamageEvent_Assign_constCPlayerDamageEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDamageEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CPlayerDamageEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDamageEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CPlayerDamageEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDamageEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerDamageEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDamageEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerDamageEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDamageEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _attacker, @jnr.ffi.types.u_int16_t short _damage, @jnr.ffi.types.u_int32_t int _weapon);

        /**
         * Return ptr must be manually freed with alt_CPlayerDamageEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDamageEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerDamageEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDamageEvent_Create_5(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_CPlayerDamageEvent_GetAttacker(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_CPlayerDamageEvent_GetDamage(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_CPlayerDamageEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerDamageEvent_GetType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_CPlayerDamageEvent_GetWeapon(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerDamageEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerDamageEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CPlayerDamageEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CPlayerDeathEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDeathEvent_Assign_CPlayerDeathEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDeathEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDeathEvent_Assign_constCPlayerDeathEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDeathEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CPlayerDeathEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDeathEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CPlayerDeathEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDeathEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerDeathEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDeathEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerDeathEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDeathEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _killer, @jnr.ffi.types.u_int32_t int _weapon);

        /**
         * Return ptr must be manually freed with alt_CPlayerDeathEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDeathEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerDeathEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDeathEvent_Create_5(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_CPlayerDeathEvent_GetKiller(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_CPlayerDeathEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerDeathEvent_GetType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_CPlayerDeathEvent_GetWeapon(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerDeathEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerDeathEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CPlayerDeathEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CPlayerDisconnectEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDisconnectEvent_Assign_CPlayerDisconnectEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDisconnectEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDisconnectEvent_Assign_constCPlayerDisconnectEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDisconnectEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CPlayerDisconnectEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CPlayerDisconnectEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerDisconnectEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerDisconnectEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _reason);

        /**
         * Return ptr must be manually freed with alt_CPlayerDisconnectEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerDisconnectEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_Create_5(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_GetReason(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerDisconnectEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerDisconnectEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerDisconnectEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CPlayerEnterVehicleEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerEnterVehicleEvent_Assign_CPlayerEnterVehicleEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerEnterVehicleEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerEnterVehicleEvent_Assign_constCPlayerEnterVehicleEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerEnterVehicleEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CPlayerEnterVehicleEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CPlayerEnterVehicleEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerEnterVehicleEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerEnterVehicleEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _player, @jnr.ffi.types.u_int8_t byte _seat);

        /**
         * Return ptr must be manually freed with alt_CPlayerEnterVehicleEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerEnterVehicleEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_Create_5(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_GetPlayer(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_CPlayerEnterVehicleEvent_GetSeat(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerEnterVehicleEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerEnterVehicleEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerEnterVehicleEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CPlayerLeaveVehicleEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerLeaveVehicleEvent_Assign_CPlayerLeaveVehicleEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerLeaveVehicleEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerLeaveVehicleEvent_Assign_constCPlayerLeaveVehicleEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerLeaveVehicleEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CPlayerLeaveVehicleEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CPlayerLeaveVehicleEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerLeaveVehicleEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerLeaveVehicleEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _player, @jnr.ffi.types.u_int8_t byte _seat);

        /**
         * Return ptr must be manually freed with alt_CPlayerLeaveVehicleEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CPlayerLeaveVehicleEvent_free()
         */
        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_Create_5(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_GetPlayer(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_CPlayerLeaveVehicleEvent_GetSeat(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerLeaveVehicleEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerLeaveVehicleEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerLeaveVehicleEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CRefCountable_AddRef(jnr.ffi.Pointer _instance);

        void alt_CRefCountable_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        @jnr.ffi.types.u_int64_t long alt_CRefCountable_GetRefCount(jnr.ffi.Pointer _instance);

        void alt_CRefCountable_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_CRefCountable_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IBaseObject(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IBlip(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_ICheckpoint(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IColShape(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IEntity(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValue(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueBaseObject(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueBool(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueByteArray(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueDict(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueDouble(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueFunction(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueInt(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueList(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueNil(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueNone(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueRGBA(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueString(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueUInt(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IMValueVector3(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IPlayer(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IVehicle(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IVoiceChannel(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_CRefCountable_to_alt_IWorldObject(jnr.ffi.Pointer from);

        void alt_CRemoveEntityEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CRemoveEntityEvent_Assign_CRemoveEntityEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CRemoveEntityEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CRemoveEntityEvent_Assign_constCRemoveEntityEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CRemoveEntityEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CRemoveEntityEvent_free()
         */
        jnr.ffi.Pointer alt_CRemoveEntityEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CRemoveEntityEvent_free()
         */
        jnr.ffi.Pointer alt_CRemoveEntityEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CRemoveEntityEvent_free()
         */
        jnr.ffi.Pointer alt_CRemoveEntityEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CRemoveEntityEvent_free()
         */
        jnr.ffi.Pointer alt_CRemoveEntityEvent_Create_3(jnr.ffi.Pointer _target);

        /**
         * Return ptr must be manually freed with alt_CRemoveEntityEvent_free()
         */
        jnr.ffi.Pointer alt_CRemoveEntityEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CRemoveEntityEvent_free()
         */
        jnr.ffi.Pointer alt_CRemoveEntityEvent_Create_5(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_CRemoveEntityEvent_GetEntity(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CRemoveEntityEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CRemoveEntityEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CRemoveEntityEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CRemoveEntityEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CResourceErrorEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CResourceErrorEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CResourceErrorEvent_Assign_constCResourceErrorEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CResourceErrorEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CResourceErrorEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceErrorEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CResourceErrorEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceErrorEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CResourceErrorEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceErrorEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CResourceErrorEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceErrorEvent_Create_3(jnr.ffi.Pointer _resource);

        /**
         * Return ptr must be manually freed with alt_CResourceErrorEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceErrorEvent_Create_4(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CResourceErrorEvent_GetResource(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CResourceErrorEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CResourceErrorEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CResourceErrorEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CResourceErrorEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CResourceStartEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CResourceStartEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CResourceStartEvent_Assign_constCResourceStartEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CResourceStartEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CResourceStartEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceStartEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CResourceStartEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceStartEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CResourceStartEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceStartEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CResourceStartEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceStartEvent_Create_3(jnr.ffi.Pointer _resource);

        /**
         * Return ptr must be manually freed with alt_CResourceStartEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceStartEvent_Create_4(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CResourceStartEvent_GetResource(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CResourceStartEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CResourceStartEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CResourceStartEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CResourceStartEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CResourceStopEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CResourceStopEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CResourceStopEvent_Assign_constCResourceStopEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CResourceStopEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CResourceStopEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceStopEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CResourceStopEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceStopEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CResourceStopEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceStopEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CResourceStopEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceStopEvent_Create_3(jnr.ffi.Pointer _resource);

        /**
         * Return ptr must be manually freed with alt_CResourceStopEvent_free()
         */
        jnr.ffi.Pointer alt_CResourceStopEvent_Create_4(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CResourceStopEvent_GetResource(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CResourceStopEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CResourceStopEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CResourceStopEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CResourceStopEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CServerScriptEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CServerScriptEvent_Assign_CServerScriptEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CServerScriptEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CServerScriptEvent_Assign_constCServerScriptEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CServerScriptEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CServerScriptEvent_free()
         */
        jnr.ffi.Pointer alt_CServerScriptEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CServerScriptEvent_free()
         */
        jnr.ffi.Pointer alt_CServerScriptEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CServerScriptEvent_free()
         */
        jnr.ffi.Pointer alt_CServerScriptEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CServerScriptEvent_free()
         */
        jnr.ffi.Pointer alt_CServerScriptEvent_Create_3(jnr.ffi.Pointer _name, jnr.ffi.Pointer _args);

        /**
         * Return ptr must be manually freed with alt_CServerScriptEvent_free()
         */
        jnr.ffi.Pointer alt_CServerScriptEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CServerScriptEvent_free()
         */
        jnr.ffi.Pointer alt_CServerScriptEvent_Create_5(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CServerScriptEvent_GetArgs(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_CServerScriptEvent_GetName(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CServerScriptEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CServerScriptEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CServerScriptEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CServerScriptEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CSyncedMetaDataChangeEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CSyncedMetaDataChangeEvent_Assign_CSyncedMetaDataChangeEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CSyncedMetaDataChangeEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CSyncedMetaDataChangeEvent_Assign_constCSyncedMetaDataChangeEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CSyncedMetaDataChangeEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CSyncedMetaDataChangeEvent_free()
         */
        jnr.ffi.Pointer alt_CSyncedMetaDataChangeEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CSyncedMetaDataChangeEvent_free()
         */
        jnr.ffi.Pointer alt_CSyncedMetaDataChangeEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CSyncedMetaDataChangeEvent_free()
         */
        jnr.ffi.Pointer alt_CSyncedMetaDataChangeEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CSyncedMetaDataChangeEvent_free()
         */
        jnr.ffi.Pointer alt_CSyncedMetaDataChangeEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _key, jnr.ffi.Pointer _val);

        /**
         * Return ptr must be manually freed with alt_CSyncedMetaDataChangeEvent_free()
         */
        jnr.ffi.Pointer alt_CSyncedMetaDataChangeEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CSyncedMetaDataChangeEvent_free()
         */
        jnr.ffi.Pointer alt_CSyncedMetaDataChangeEvent_Create_5(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_CSyncedMetaDataChangeEvent_GetKey(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_CSyncedMetaDataChangeEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CSyncedMetaDataChangeEvent_GetType(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_CSyncedMetaDataChangeEvent_GetVal(jnr.ffi.Pointer _instance);

        boolean alt_CSyncedMetaDataChangeEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CSyncedMetaDataChangeEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CSyncedMetaDataChangeEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_CWeaponDamageEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CWeaponDamageEvent_Assign_CWeaponDamageEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CWeaponDamageEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CWeaponDamageEvent_Assign_constCWeaponDamageEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CWeaponDamageEvent_Cancel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_CWeaponDamageEvent_free()
         */
        jnr.ffi.Pointer alt_CWeaponDamageEvent_Create(alt_CEvent_Type _type);

        /**
         * Return ptr must be manually freed with alt_CWeaponDamageEvent_free()
         */
        jnr.ffi.Pointer alt_CWeaponDamageEvent_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CWeaponDamageEvent_free()
         */
        jnr.ffi.Pointer alt_CWeaponDamageEvent_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CWeaponDamageEvent_free()
         */
        jnr.ffi.Pointer alt_CWeaponDamageEvent_Create_3(jnr.ffi.Pointer _source, jnr.ffi.Pointer _target, @jnr.ffi.types.u_int32_t int _weaponHash, @jnr.ffi.types.u_int16_t short _damageValue, jnr.ffi.Pointer _shotOffset, alt_CWeaponDamageEvent_BodyPart _bodyPart);

        /**
         * Return ptr must be manually freed with alt_CWeaponDamageEvent_free()
         */
        jnr.ffi.Pointer alt_CWeaponDamageEvent_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_CWeaponDamageEvent_free()
         */
        jnr.ffi.Pointer alt_CWeaponDamageEvent_Create_5(jnr.ffi.Pointer _p0);

        alt_CWeaponDamageEvent_BodyPart alt_CWeaponDamageEvent_GetBodyPart(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_CWeaponDamageEvent_GetDamageValue(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_CWeaponDamageEvent_GetShotOffset(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_CWeaponDamageEvent_GetSource(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_CWeaponDamageEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CWeaponDamageEvent_GetType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_CWeaponDamageEvent_GetWeaponHash(jnr.ffi.Pointer _instance);

        boolean alt_CWeaponDamageEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CWeaponDamageEvent_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_CWeaponDamageEvent_to_alt_CEvent(jnr.ffi.Pointer from);

        void alt_DiscordOAuth2Token_Assign_DiscordOAuth2TokenRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_DiscordOAuth2Token_free()
         */
        jnr.ffi.Pointer alt_DiscordOAuth2Token_Create(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_DiscordOAuth2Token_free()
         */
        jnr.ffi.Pointer alt_DiscordOAuth2Token_Create_1(jnr.ffi.Pointer _p0);

        void alt_DiscordOAuth2Token_free(jnr.ffi.Pointer ptr);

        void alt_IBaseObject_AddRef(jnr.ffi.Pointer _instance);

        void alt_IBaseObject_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IBaseObject_DeleteMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IBaseObject_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        @jnr.ffi.types.u_int64_t long alt_IBaseObject_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IBaseObject_Type alt_IBaseObject_GetType(jnr.ffi.Pointer _instance);

        boolean alt_IBaseObject_HasMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        void alt_IBaseObject_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IBaseObject_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IBaseObject_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        jnr.ffi.Pointer alt_IBaseObject_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IBaseObject_to_alt_IBlip(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IBaseObject_to_alt_ICheckpoint(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IBaseObject_to_alt_IColShape(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IBaseObject_to_alt_IEntity(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IBaseObject_to_alt_IPlayer(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IBaseObject_to_alt_IVehicle(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IBaseObject_to_alt_IVoiceChannel(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IBaseObject_to_alt_IWorldObject(jnr.ffi.Pointer from);

        void alt_IBlip_AddRef(jnr.ffi.Pointer _instance);

        void alt_IBlip_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_IBlip_AttachedTo(jnr.ffi.Pointer _instance);

        void alt_IBlip_DeleteMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        alt_IBlip_BlipType alt_IBlip_GetBlipType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_IBlip_GetDimension(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IBlip_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_IBlip_GetPosition(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IBlip_GetRefCount(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_IBlip_GetTarget(jnr.ffi.Pointer _instance);

        alt_IBaseObject_Type alt_IBlip_GetType(jnr.ffi.Pointer _instance);

        boolean alt_IBlip_HasMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        boolean alt_IBlip_IsAttached(jnr.ffi.Pointer _instance);

        boolean alt_IBlip_IsGlobal(jnr.ffi.Pointer _instance);

        void alt_IBlip_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IBlip_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IBlip_SetColor(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte color);

        void alt_IBlip_SetDimension(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int dimension);

        void alt_IBlip_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IBlip_SetPosition(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos);

        void alt_IBlip_SetRoute(jnr.ffi.Pointer _instance, boolean state);

        void alt_IBlip_SetRouteColor(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte color);

        void alt_IBlip_SetSprite(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int16_t short sprite);

        jnr.ffi.Pointer alt_IBlip_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IBlip_to_alt_IBaseObject(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IBlip_to_alt_IWorldObject(jnr.ffi.Pointer from);

        void alt_ICheckpoint_AddRef(jnr.ffi.Pointer _instance);

        void alt_ICheckpoint_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_ICheckpoint_DeleteMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        @jnr.ffi.types.u_int8_t byte alt_ICheckpoint_GetCheckpointType(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RGBA_free()
         */
        jnr.ffi.Pointer alt_ICheckpoint_GetColor(jnr.ffi.Pointer _instance);

        alt_IColShape_ColShapeType alt_ICheckpoint_GetColshapeType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_ICheckpoint_GetDimension(jnr.ffi.Pointer _instance);

        float alt_ICheckpoint_GetHeight(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_ICheckpoint_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_ICheckpoint_GetPosition(jnr.ffi.Pointer _instance);

        float alt_ICheckpoint_GetRadius(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_ICheckpoint_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IBaseObject_Type alt_ICheckpoint_GetType(jnr.ffi.Pointer _instance);

        boolean alt_ICheckpoint_HasMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        boolean alt_ICheckpoint_IsEntityIn(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ent);

        boolean alt_ICheckpoint_IsPointIn(jnr.ffi.Pointer _instance, jnr.ffi.Pointer p);

        void alt_ICheckpoint_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_ICheckpoint_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_ICheckpoint_SetDimension(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int dimension);

        void alt_ICheckpoint_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_ICheckpoint_SetPosition(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos);

        jnr.ffi.Pointer alt_ICheckpoint_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_ICheckpoint_to_alt_IBaseObject(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_ICheckpoint_to_alt_IColShape(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_ICheckpoint_to_alt_IWorldObject(jnr.ffi.Pointer from);

        void alt_IColShape_AddRef(jnr.ffi.Pointer _instance);

        void alt_IColShape_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IColShape_DeleteMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        alt_IColShape_ColShapeType alt_IColShape_GetColshapeType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_IColShape_GetDimension(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IColShape_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_IColShape_GetPosition(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IColShape_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IBaseObject_Type alt_IColShape_GetType(jnr.ffi.Pointer _instance);

        boolean alt_IColShape_HasMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        boolean alt_IColShape_IsEntityIn(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ent);

        boolean alt_IColShape_IsPointIn(jnr.ffi.Pointer _instance, jnr.ffi.Pointer p);

        void alt_IColShape_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IColShape_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IColShape_SetDimension(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int dimension);

        void alt_IColShape_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IColShape_SetPosition(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos);

        jnr.ffi.Pointer alt_IColShape_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IColShape_to_alt_IBaseObject(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IColShape_to_alt_ICheckpoint(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IColShape_to_alt_IWorldObject(jnr.ffi.Pointer from);

        void alt_ICore_Assign_constICoreRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IBlip_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateBlip(jnr.ffi.Pointer _instance, jnr.ffi.Pointer target, alt_IBlip_BlipType type, jnr.ffi.Pointer pos);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IBlip_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateBlip_1(jnr.ffi.Pointer _instance, jnr.ffi.Pointer target, alt_IBlip_BlipType type, jnr.ffi.Pointer attachTo);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_ICheckpoint_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateCheckpoint(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte type, jnr.ffi.Pointer pos, float radius, float height, jnr.ffi.Pointer color);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateColShapeCircle(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos, float radius);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateColShapeCube(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos, jnr.ffi.Pointer pos2);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateColShapeCylinder(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos, float radius, float height);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateColShapeRectangle(jnr.ffi.Pointer _instance, float x1, float y1, float x2, float y2, float z);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateColShapeSphere(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos, float radius);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueBaseObject_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueBaseObject(jnr.ffi.Pointer _instance, jnr.ffi.Pointer val);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueBool_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueBool(jnr.ffi.Pointer _instance, boolean val);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueByteArray_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueByteArray(jnr.ffi.Pointer _instance, jnr.ffi.Pointer data, @jnr.ffi.types.u_int64_t long size);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueByteArray_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueByteArray_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long size);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueDict_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueDict(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueDouble_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueDouble(jnr.ffi.Pointer _instance, double val);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueFunction_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueFunction(jnr.ffi.Pointer _instance, jnr.ffi.Pointer impl);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueInt_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueInt(jnr.ffi.Pointer _instance, @jnr.ffi.types.int64_t long val);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueList_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueList(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long size);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueNil_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueNil(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueNone_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueNone(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueRGBA_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueRGBA(jnr.ffi.Pointer _instance, jnr.ffi.Pointer val);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueString_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueString(jnr.ffi.Pointer _instance, jnr.ffi.Pointer val);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueUInt_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueUInt(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long val);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueVector3_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateMValueVector3(jnr.ffi.Pointer _instance, jnr.ffi.Pointer val);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateVehicle(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int model, jnr.ffi.Pointer pos, jnr.ffi.Pointer rot);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IVoiceChannel_free()
         */
        jnr.ffi.Pointer alt_ICore_CreateVoiceChannel(jnr.ffi.Pointer _instance, boolean spatial, float maxDistance);

        void alt_ICore_DestroyBaseObject(jnr.ffi.Pointer _instance, jnr.ffi.Pointer handle);

        boolean alt_ICore_FileExists(jnr.ffi.Pointer _instance, jnr.ffi.Pointer path);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_ICore_FileRead(jnr.ffi.Pointer _instance, jnr.ffi.Pointer path);

        /**
         * Return ptr must be manually freed with alt_Array_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_ICore_GetEntities(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_ICore_GetEntityByID(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int16_t short id);

        @jnr.ffi.types.u_int32_t int alt_ICore_GetNetTime(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Array_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_ICore_GetPlayers(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Array_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_ICore_GetPlayersByName(jnr.ffi.Pointer _instance, jnr.ffi.Pointer name);

        jnr.ffi.Pointer alt_ICore_GetResource(jnr.ffi.Pointer _instance, jnr.ffi.Pointer name);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_ICore_GetRootDirectory(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Array_RefBase_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_ICore_GetVehicles(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_ICore_Hash(jnr.ffi.Pointer _instance, jnr.ffi.Pointer str);

        jnr.ffi.Pointer alt_ICore_Instance();

        void alt_ICore_LogColored(jnr.ffi.Pointer _instance, jnr.ffi.Pointer str);

        void alt_ICore_LogDebug(jnr.ffi.Pointer _instance, jnr.ffi.Pointer str);

        void alt_ICore_LogError(jnr.ffi.Pointer _instance, jnr.ffi.Pointer str);

        void alt_ICore_LogInfo(jnr.ffi.Pointer _instance, jnr.ffi.Pointer str);

        void alt_ICore_LogWarning(jnr.ffi.Pointer _instance, jnr.ffi.Pointer str);

        boolean alt_ICore_RegisterScriptRuntime(jnr.ffi.Pointer _instance, jnr.ffi.Pointer resourceType, jnr.ffi.Pointer runtime);

        jnr.ffi.Pointer alt_ICore_RestartResource(jnr.ffi.Pointer _instance, jnr.ffi.Pointer name);

        void alt_ICore_SetInstance(jnr.ffi.Pointer server);

        jnr.ffi.Pointer alt_ICore_StartResource(jnr.ffi.Pointer _instance, jnr.ffi.Pointer name);

        void alt_ICore_StopResource(jnr.ffi.Pointer _instance, jnr.ffi.Pointer name);

        void alt_ICore_TriggerClientEvent(jnr.ffi.Pointer _instance, jnr.ffi.Pointer target, jnr.ffi.Pointer ev, jnr.ffi.Pointer args);

        void alt_ICore_TriggerLocalEvent(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ev, jnr.ffi.Pointer args);

        void alt_IEntity_AddRef(jnr.ffi.Pointer _instance);

        void alt_IEntity_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IEntity_DeleteMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        void alt_IEntity_DeleteStreamSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        void alt_IEntity_DeleteSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        @jnr.ffi.types.int32_t int alt_IEntity_GetDimension(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IEntity_GetID(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IEntity_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        @jnr.ffi.types.u_int32_t int alt_IEntity_GetModel(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_IEntity_GetNetworkOwner(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_IEntity_GetPosition(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IEntity_GetRefCount(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_RotationLayout_free()
         */
        jnr.ffi.Pointer alt_IEntity_GetRotation(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IEntity_GetStreamSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IEntity_GetSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        alt_IBaseObject_Type alt_IEntity_GetType(jnr.ffi.Pointer _instance);

        boolean alt_IEntity_HasMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        boolean alt_IEntity_HasStreamSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        boolean alt_IEntity_HasSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        void alt_IEntity_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IEntity_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IEntity_SetDimension(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int dimension);

        void alt_IEntity_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IEntity_SetPosition(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos);

        void alt_IEntity_SetRotation(jnr.ffi.Pointer _instance, jnr.ffi.Pointer rot);

        void alt_IEntity_SetStreamSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IEntity_SetSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        jnr.ffi.Pointer alt_IEntity_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IEntity_to_alt_IBaseObject(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IEntity_to_alt_IPlayer(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IEntity_to_alt_IVehicle(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IEntity_to_alt_IWorldObject(jnr.ffi.Pointer from);

        void alt_IMValueBaseObject_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueBaseObject_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueBaseObject_Clone(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueBaseObject_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueBaseObject_GetType(jnr.ffi.Pointer _instance);

        void alt_IMValueBaseObject_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueBaseObject_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        double alt_IMValueBaseObject_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueBaseObject_ToString(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IBaseObject_free()
         */
        jnr.ffi.Pointer alt_IMValueBaseObject_Value(jnr.ffi.Pointer _instance);

        void alt_IMValueBaseObject_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueBaseObject_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueBaseObject_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValueBool_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueBool_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueBool_Clone(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueBool_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueBool_GetType(jnr.ffi.Pointer _instance);

        void alt_IMValueBool_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueBool_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        double alt_IMValueBool_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueBool_ToString(jnr.ffi.Pointer _instance);

        boolean alt_IMValueBool_Value(jnr.ffi.Pointer _instance);

        void alt_IMValueBool_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueBool_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueBool_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValueByteArray_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueByteArray_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueByteArray_Clone(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IMValueByteArray_GetData(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IMValueByteArray_GetData_1(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueByteArray_GetRefCount(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueByteArray_GetSize(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueByteArray_GetType(jnr.ffi.Pointer _instance);

        void alt_IMValueByteArray_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueByteArray_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        double alt_IMValueByteArray_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueByteArray_ToString(jnr.ffi.Pointer _instance);

        void alt_IMValueByteArray_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueByteArray_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueByteArray_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValueDict_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueDict_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        jnr.ffi.Pointer alt_IMValueDict_Begin(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueDict_Clone(jnr.ffi.Pointer _instance);

        void alt_IMValueDict_Delete(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueDict_Get(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        @jnr.ffi.types.u_int64_t long alt_IMValueDict_GetRefCount(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueDict_GetSize(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueDict_GetType(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueDict_Get_1(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        void alt_IMValueDict_Iterator_Assign_IMValueDict_IteratorRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IMValueDict_Iterator_Assign_constIMValueDict_IteratorRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueDict_Iterator_GetKey(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueDict_Iterator_GetValue(jnr.ffi.Pointer _instance);

        void alt_IMValueDict_Iterator_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueDict_Next(jnr.ffi.Pointer _instance);

        void alt_IMValueDict_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueDict_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IMValueDict_Set(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IMValueDict_SetConst(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        double alt_IMValueDict_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueDict_ToString(jnr.ffi.Pointer _instance);

        void alt_IMValueDict_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueDict_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueDict_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValueDouble_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueDouble_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueDouble_Clone(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueDouble_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueDouble_GetType(jnr.ffi.Pointer _instance);

        void alt_IMValueDouble_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueDouble_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        double alt_IMValueDouble_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueDouble_ToString(jnr.ffi.Pointer _instance);

        double alt_IMValueDouble_Value(jnr.ffi.Pointer _instance);

        void alt_IMValueDouble_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueDouble_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueDouble_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValueFunction_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueFunction_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueFunction_Call(jnr.ffi.Pointer _instance, jnr.ffi.Pointer args);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueFunction_Clone(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueFunction_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueFunction_GetType(jnr.ffi.Pointer _instance);

        void alt_IMValueFunction_Impl_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueFunction_Impl_Assign_constIMValueFunction_ImplRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueFunction_Impl_Call(jnr.ffi.Pointer _instance, jnr.ffi.Pointer args);

        void alt_IMValueFunction_Impl_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueFunction_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueFunction_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        double alt_IMValueFunction_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueFunction_ToString(jnr.ffi.Pointer _instance);

        void alt_IMValueFunction_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueFunction_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueFunction_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValueInt_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueInt_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueInt_Clone(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueInt_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueInt_GetType(jnr.ffi.Pointer _instance);

        void alt_IMValueInt_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueInt_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        double alt_IMValueInt_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueInt_ToString(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int64_t long alt_IMValueInt_Value(jnr.ffi.Pointer _instance);

        void alt_IMValueInt_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueInt_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueInt_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValueList_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueList_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueList_Clone(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueList_Get(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long i);

        @jnr.ffi.types.u_int64_t long alt_IMValueList_GetRefCount(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueList_GetSize(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueList_GetType(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueList_Get_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long i);

        void alt_IMValueList_Push(jnr.ffi.Pointer _instance, jnr.ffi.Pointer val);

        void alt_IMValueList_PushConst(jnr.ffi.Pointer _instance, jnr.ffi.Pointer val);

        void alt_IMValueList_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueList_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IMValueList_Set(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long i, jnr.ffi.Pointer val);

        void alt_IMValueList_SetConst(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long i, jnr.ffi.Pointer val);

        double alt_IMValueList_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueList_ToString(jnr.ffi.Pointer _instance);

        void alt_IMValueList_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueList_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueList_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValueNil_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueNil_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueNil_Clone(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueNil_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueNil_GetType(jnr.ffi.Pointer _instance);

        void alt_IMValueNil_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueNil_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        double alt_IMValueNil_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueNil_ToString(jnr.ffi.Pointer _instance);

        void alt_IMValueNil_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueNil_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueNil_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValueNone_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueNone_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueNone_Clone(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueNone_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueNone_GetType(jnr.ffi.Pointer _instance);

        void alt_IMValueNone_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueNone_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        double alt_IMValueNone_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueNone_ToString(jnr.ffi.Pointer _instance);

        void alt_IMValueNone_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueNone_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueNone_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValueRGBA_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueRGBA_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueRGBA_Clone(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueRGBA_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueRGBA_GetType(jnr.ffi.Pointer _instance);

        void alt_IMValueRGBA_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueRGBA_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        double alt_IMValueRGBA_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueRGBA_ToString(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RGBA_free()
         */
        jnr.ffi.Pointer alt_IMValueRGBA_Value(jnr.ffi.Pointer _instance);

        void alt_IMValueRGBA_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueRGBA_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueRGBA_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValueString_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueString_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueString_Clone(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueString_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueString_GetType(jnr.ffi.Pointer _instance);

        void alt_IMValueString_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueString_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        double alt_IMValueString_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueString_ToString(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_IMValueString_Value(jnr.ffi.Pointer _instance);

        void alt_IMValueString_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueString_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueString_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValueUInt_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueUInt_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueUInt_Clone(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueUInt_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueUInt_GetType(jnr.ffi.Pointer _instance);

        void alt_IMValueUInt_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueUInt_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        double alt_IMValueUInt_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueUInt_ToString(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueUInt_Value(jnr.ffi.Pointer _instance);

        void alt_IMValueUInt_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueUInt_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueUInt_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValueVector3_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValueVector3_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValueVector3_Clone(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValueVector3_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValueVector3_GetType(jnr.ffi.Pointer _instance);

        void alt_IMValueVector3_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValueVector3_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        double alt_IMValueVector3_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValueVector3_ToString(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_IMValueVector3_Value(jnr.ffi.Pointer _instance);

        void alt_IMValueVector3_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_IMValueVector3_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValueVector3_to_alt_IMValue(jnr.ffi.Pointer from);

        void alt_IMValue_AddRef(jnr.ffi.Pointer _instance);

        void alt_IMValue_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_IMValue_Clone(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IMValue_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IMValue_Type alt_IMValue_GetType(jnr.ffi.Pointer _instance);

        void alt_IMValue_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IMValue_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        double alt_IMValue_ToNumber(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IMValue_ToString(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IMValue_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueBaseObject(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueBool(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueByteArray(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueDict(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueDouble(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueFunction(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueInt(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueList(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueNil(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueNone(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueRGBA(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueString(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueUInt(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IMValue_to_alt_IMValueVector3(jnr.ffi.Pointer from);

        void alt_IPackage_CloseFile(jnr.ffi.Pointer _instance, jnr.ffi.Pointer file);

        boolean alt_IPackage_FileExists(jnr.ffi.Pointer _instance, jnr.ffi.Pointer path);

        void alt_IPackage_File_Assign_constIPackage_FileRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IPackage_File_free(jnr.ffi.Pointer ptr);

        @jnr.ffi.types.u_int64_t long alt_IPackage_GetFileSize(jnr.ffi.Pointer _instance, jnr.ffi.Pointer file);

        alt_IPackage_Mode alt_IPackage_GetMode(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IPackage_OpenFile(jnr.ffi.Pointer _instance, jnr.ffi.Pointer path);

        @jnr.ffi.types.u_int64_t long alt_IPackage_ReadFile(jnr.ffi.Pointer _instance, jnr.ffi.Pointer file, jnr.ffi.Pointer buffer, @jnr.ffi.types.u_int64_t long size);

        void alt_IPackage_SeekFile(jnr.ffi.Pointer _instance, jnr.ffi.Pointer file, @jnr.ffi.types.u_int64_t long offset, alt_IPackage_SeekOrigin origin);

        @jnr.ffi.types.u_int64_t long alt_IPackage_TellFile(jnr.ffi.Pointer _instance, jnr.ffi.Pointer file);

        @jnr.ffi.types.u_int64_t long alt_IPackage_WriteFile(jnr.ffi.Pointer _instance, jnr.ffi.Pointer file, jnr.ffi.Pointer buffer, @jnr.ffi.types.u_int64_t long size);

        void alt_IPackage_free(jnr.ffi.Pointer ptr);

        void alt_IPlayer_AddRef(jnr.ffi.Pointer _instance);

        void alt_IPlayer_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IPlayer_AddWeaponComponent(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int weapon, @jnr.ffi.types.u_int32_t int component);

        void alt_IPlayer_DeleteMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        void alt_IPlayer_DeleteStreamSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        void alt_IPlayer_DeleteSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        void alt_IPlayer_Despawn(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetAimPos(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IPlayer_GetAmmo(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IPlayer_GetArmour(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetAuthToken(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IPlayer_GetCurrentWeapon(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Array_unsignedint_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetCurrentWeaponComponents(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IPlayer_GetCurrentWeaponTintIndex(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_IPlayer_GetDimension(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetEntityAimOffset(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetEntityAimingAt(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_RotationLayout_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetHeadRotation(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IPlayer_GetHealth(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IPlayer_GetHwidExHash(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IPlayer_GetHwidHash(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IPlayer_GetID(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetIP(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IPlayer_GetMaxArmour(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IPlayer_GetMaxHealth(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        @jnr.ffi.types.u_int32_t int alt_IPlayer_GetModel(jnr.ffi.Pointer _instance);

        float alt_IPlayer_GetMoveSpeed(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetName(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetNetworkOwner(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IPlayer_GetPing(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetPosition(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IPlayer_GetRefCount(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_RotationLayout_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetRotation(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IPlayer_GetSeat(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IPlayer_GetSocialID(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetStreamSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        alt_IBaseObject_Type alt_IPlayer_GetType(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_IPlayer_GetVehicle(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IPlayer_GetWeapon(jnr.ffi.Pointer _instance);

        void alt_IPlayer_GiveWeapon(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int weapon, @jnr.ffi.types.int32_t int ammo, boolean selectWeapon);

        boolean alt_IPlayer_HasMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        boolean alt_IPlayer_HasStreamSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        boolean alt_IPlayer_HasSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        boolean alt_IPlayer_IsAiming(jnr.ffi.Pointer _instance);

        boolean alt_IPlayer_IsConnected(jnr.ffi.Pointer _instance);

        boolean alt_IPlayer_IsDead(jnr.ffi.Pointer _instance);

        boolean alt_IPlayer_IsFlashlightActive(jnr.ffi.Pointer _instance);

        boolean alt_IPlayer_IsInRagdoll(jnr.ffi.Pointer _instance);

        boolean alt_IPlayer_IsInVehicle(jnr.ffi.Pointer _instance);

        boolean alt_IPlayer_IsJumping(jnr.ffi.Pointer _instance);

        boolean alt_IPlayer_IsReloading(jnr.ffi.Pointer _instance);

        boolean alt_IPlayer_IsShooting(jnr.ffi.Pointer _instance);

        void alt_IPlayer_Kick(jnr.ffi.Pointer _instance, jnr.ffi.Pointer reason);

        void alt_IPlayer_RemoveAllWeapons(jnr.ffi.Pointer _instance);

        void alt_IPlayer_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IPlayer_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IPlayer_RemoveWeapon(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int weapon);

        void alt_IPlayer_RemoveWeaponComponent(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int weapon, @jnr.ffi.types.u_int32_t int component);

        void alt_IPlayer_SetArmour(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int16_t short armor);

        void alt_IPlayer_SetCurrentWeapon(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int weapon);

        void alt_IPlayer_SetDateTime(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int day, @jnr.ffi.types.int32_t int month, @jnr.ffi.types.int32_t int year, @jnr.ffi.types.int32_t int hour, @jnr.ffi.types.int32_t int minute, @jnr.ffi.types.int32_t int second);

        void alt_IPlayer_SetDimension(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int dimension);

        void alt_IPlayer_SetHealth(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int16_t short health);

        void alt_IPlayer_SetMaxArmour(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int16_t short armor);

        void alt_IPlayer_SetMaxHealth(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int16_t short health);

        void alt_IPlayer_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IPlayer_SetModel(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int model);

        void alt_IPlayer_SetPosition(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos);

        void alt_IPlayer_SetRotation(jnr.ffi.Pointer _instance, jnr.ffi.Pointer rot);

        void alt_IPlayer_SetStreamSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IPlayer_SetSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IPlayer_SetWeaponTintIndex(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int weapon, @jnr.ffi.types.u_int8_t byte tintIndex);

        void alt_IPlayer_SetWeather(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int weather);

        void alt_IPlayer_Spawn(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos, @jnr.ffi.types.u_int32_t int delayMs);

        jnr.ffi.Pointer alt_IPlayer_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IPlayer_to_alt_IBaseObject(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IPlayer_to_alt_IEntity(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IPlayer_to_alt_IWorldObject(jnr.ffi.Pointer from);

        void alt_IResource_Assign_constIResourceRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IResource_CreationInfo_Assign_IResource_CreationInfoRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_IResource_CreationInfo_free()
         */
        jnr.ffi.Pointer alt_IResource_CreationInfo_Create(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_IResource_CreationInfo_free()
         */
        jnr.ffi.Pointer alt_IResource_CreationInfo_Create_1(jnr.ffi.Pointer _p0);

        void alt_IResource_CreationInfo_free(jnr.ffi.Pointer ptr);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValueDict_free()
         */
        jnr.ffi.Pointer alt_IResource_GetExports(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IResource_GetImpl(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_IResource_GetMain(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_IResource_GetName(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IResource_GetPackage(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_IResource_GetPath(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IResource_GetRuntime(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_IResource_GetType(jnr.ffi.Pointer _instance);

        void alt_IResource_Impl_Assign_constIResource_ImplRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        boolean alt_IResource_Impl_MakeClient(jnr.ffi.Pointer _instance, jnr.ffi.Pointer info, jnr.ffi.Pointer files);

        void alt_IResource_Impl_OnCreateBaseObject(jnr.ffi.Pointer _instance, jnr.ffi.Pointer object);

        boolean alt_IResource_Impl_OnEvent(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ev);

        void alt_IResource_Impl_OnRemoveBaseObject(jnr.ffi.Pointer _instance, jnr.ffi.Pointer object);

        void alt_IResource_Impl_OnTick(jnr.ffi.Pointer _instance);

        boolean alt_IResource_Impl_Start(jnr.ffi.Pointer _instance);

        boolean alt_IResource_Impl_Stop(jnr.ffi.Pointer _instance);

        void alt_IResource_Impl_free(jnr.ffi.Pointer ptr);

        boolean alt_IResource_IsStarted(jnr.ffi.Pointer _instance);

        void alt_IResource_SetExports(jnr.ffi.Pointer _instance, jnr.ffi.Pointer exports);

        void alt_IScriptRuntime_Assign_constIScriptRuntimeRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_IScriptRuntime_CreateImpl(jnr.ffi.Pointer _instance, jnr.ffi.Pointer resource);

        void alt_IScriptRuntime_DestroyImpl(jnr.ffi.Pointer _instance, jnr.ffi.Pointer impl);

        void alt_IScriptRuntime_OnDispose(jnr.ffi.Pointer _instance);

        void alt_IScriptRuntime_OnTick(jnr.ffi.Pointer _instance);

        void alt_IScriptRuntime_free(jnr.ffi.Pointer ptr);

        void alt_IVehicle_AddRef(jnr.ffi.Pointer _instance);

        void alt_IVehicle_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IVehicle_DeleteMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        void alt_IVehicle_DeleteStreamSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        void alt_IVehicle_DeleteSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        boolean alt_IVehicle_DoesWheelHasTire(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetAppearanceDataBase64(jnr.ffi.Pointer _instance);

        float alt_IVehicle_GetArmoredWindowHealth(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetArmoredWindowShootCount(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId);

        @jnr.ffi.types.u_int32_t int alt_IVehicle_GetBodyAdditionalHealth(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IVehicle_GetBodyHealth(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetBumperDamageLevel(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte bumperId);

        boolean alt_IVehicle_GetCustomTires(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetDamageDataBase64(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetDashboardColor(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_IVehicle_GetDimension(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetDirtLevel(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetDoorState(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte doorId);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetDriver(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_IVehicle_GetEngineHealth(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetGameStateBase64(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetHeadlightColor(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetHealthDataBase64(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IVehicle_GetID(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetInteriorColor(jnr.ffi.Pointer _instance);

        float alt_IVehicle_GetLightsMultiplier(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetLivery(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetLockState(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetMod(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte category);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetModKit(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetModKitsCount(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IVehicle_GetModel(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetModsCount(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte category);

        void alt_IVehicle_GetNeonActive(jnr.ffi.Pointer _instance, jnr.ffi.Pointer left, jnr.ffi.Pointer right, jnr.ffi.Pointer front, jnr.ffi.Pointer back);

        /**
         * Return ptr must be manually freed with alt_RGBA_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetNeonColor(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetNetworkOwner(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IVehicle_GetNumberplateIndex(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetNumberplateText(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetPartBulletHoles(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte partId);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetPartDamageLevel(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte partId);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetPearlColor(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_IVehicle_GetPetrolTankHealth(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetPosition(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetPrimaryColor(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RGBA_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetPrimaryColorRGB(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IVehicle_GetRadioStationIndex(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetRearWheelVariation(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IVehicle_GetRefCount(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetRepairsCount(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetRoofLivery(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_RotationLayout_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetRotation(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetScriptDataBase64(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetSecondaryColor(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RGBA_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetSecondaryColorRGB(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetSpecialDarkness(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetStreamSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        /**
         * Return ptr must be manually freed with alt_RGBA_free()
         */
        jnr.ffi.Pointer alt_IVehicle_GetTireSmokeColor(jnr.ffi.Pointer _instance);

        alt_IBaseObject_Type alt_IVehicle_GetType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetWheelColor(jnr.ffi.Pointer _instance);

        float alt_IVehicle_GetWheelHealth(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetWheelType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetWheelVariation(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetWheelsCount(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetWindowTint(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_HasArmoredWindows(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_HasMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        boolean alt_IVehicle_HasStreamSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        boolean alt_IVehicle_HasSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        boolean alt_IVehicle_IsDaylightOn(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_IsEngineOn(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_IsExtraOn(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte extraID);

        boolean alt_IVehicle_IsFlamethrowerActive(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_IsHandbrakeActive(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_IsLightDamaged(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte lightId);

        boolean alt_IVehicle_IsManualEngineControl(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_IsNeonActive(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_IsNightlightOn(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_IsPrimaryColorRGB(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_IsRoofOpened(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_IsSecondaryColorRGB(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_IsSirenActive(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_IsSpecialLightDamaged(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte specialLightId);

        boolean alt_IVehicle_IsTireSmokeColorCustom(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_IsWheelBurst(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId);

        boolean alt_IVehicle_IsWheelDetached(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId);

        boolean alt_IVehicle_IsWheelOnFire(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId);

        boolean alt_IVehicle_IsWindowDamaged(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId);

        boolean alt_IVehicle_IsWindowOpened(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId);

        void alt_IVehicle_LoadAppearanceDataFromBase64(jnr.ffi.Pointer _instance, jnr.ffi.Pointer base64);

        void alt_IVehicle_LoadDamageDataFromBase64(jnr.ffi.Pointer _instance, jnr.ffi.Pointer base64);

        void alt_IVehicle_LoadGameStateFromBase64(jnr.ffi.Pointer _instance, jnr.ffi.Pointer base64);

        void alt_IVehicle_LoadHealthDataFromBase64(jnr.ffi.Pointer _instance, jnr.ffi.Pointer base64);

        void alt_IVehicle_LoadScriptDataFromBase64(jnr.ffi.Pointer _instance, jnr.ffi.Pointer base64);

        void alt_IVehicle_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IVehicle_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IVehicle_SetArmoredWindowHealth(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId, float health);

        void alt_IVehicle_SetArmoredWindowShootCount(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId, @jnr.ffi.types.u_int8_t byte count);

        void alt_IVehicle_SetBodyAdditionalHealth(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int health);

        void alt_IVehicle_SetBodyHealth(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int health);

        void alt_IVehicle_SetBumperDamageLevel(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte bumperId, @jnr.ffi.types.u_int8_t byte damageLevel);

        void alt_IVehicle_SetCustomTires(jnr.ffi.Pointer _instance, boolean state);

        void alt_IVehicle_SetDashboardColor(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte color);

        void alt_IVehicle_SetDimension(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int dimension);

        void alt_IVehicle_SetDirtLevel(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte level);

        void alt_IVehicle_SetDoorState(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte doorId, @jnr.ffi.types.u_int8_t byte state);

        void alt_IVehicle_SetEngineHealth(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int health);

        void alt_IVehicle_SetEngineOn(jnr.ffi.Pointer _instance, boolean state);

        void alt_IVehicle_SetHeadlightColor(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte color);

        void alt_IVehicle_SetInteriorColor(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte color);

        void alt_IVehicle_SetLightDamaged(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte lightId, boolean isDamaged);

        void alt_IVehicle_SetLightsMultiplier(jnr.ffi.Pointer _instance, float multiplier);

        void alt_IVehicle_SetLivery(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte livery);

        void alt_IVehicle_SetLockState(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte state);

        void alt_IVehicle_SetManualEngineControl(jnr.ffi.Pointer _instance, boolean state);

        void alt_IVehicle_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        boolean alt_IVehicle_SetMod(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte category, @jnr.ffi.types.u_int8_t byte id);

        boolean alt_IVehicle_SetModKit(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte id);

        void alt_IVehicle_SetNeonActive(jnr.ffi.Pointer _instance, boolean left, boolean right, boolean front, boolean back);

        void alt_IVehicle_SetNeonColor(jnr.ffi.Pointer _instance, jnr.ffi.Pointer color);

        void alt_IVehicle_SetNumberplateIndex(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int index);

        void alt_IVehicle_SetNumberplateText(jnr.ffi.Pointer _instance, jnr.ffi.Pointer text);

        void alt_IVehicle_SetPartBulletHoles(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte partId, @jnr.ffi.types.u_int8_t byte shootsCount);

        void alt_IVehicle_SetPartDamageLevel(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte partId, @jnr.ffi.types.u_int8_t byte damage);

        void alt_IVehicle_SetPearlColor(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte color);

        void alt_IVehicle_SetPetrolTankHealth(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int health);

        void alt_IVehicle_SetPosition(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos);

        void alt_IVehicle_SetPrimaryColor(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte color);

        void alt_IVehicle_SetPrimaryColorRGB(jnr.ffi.Pointer _instance, jnr.ffi.Pointer color);

        void alt_IVehicle_SetRadioStationIndex(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int stationIndex);

        void alt_IVehicle_SetRearWheels(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte variation);

        void alt_IVehicle_SetRoofLivery(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte roofLivery);

        void alt_IVehicle_SetRoofOpened(jnr.ffi.Pointer _instance, boolean state);

        void alt_IVehicle_SetRotation(jnr.ffi.Pointer _instance, jnr.ffi.Pointer rot);

        void alt_IVehicle_SetSecondaryColor(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte color);

        void alt_IVehicle_SetSecondaryColorRGB(jnr.ffi.Pointer _instance, jnr.ffi.Pointer color);

        void alt_IVehicle_SetSirenActive(jnr.ffi.Pointer _instance, boolean state);

        void alt_IVehicle_SetSpecialDarkness(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte value);

        void alt_IVehicle_SetSpecialLightDamaged(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte specialLightId, boolean isDamaged);

        void alt_IVehicle_SetStreamSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IVehicle_SetSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IVehicle_SetTireSmokeColor(jnr.ffi.Pointer _instance, jnr.ffi.Pointer color);

        void alt_IVehicle_SetWheelBurst(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId, boolean state);

        void alt_IVehicle_SetWheelColor(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte color);

        void alt_IVehicle_SetWheelDetached(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId, boolean state);

        void alt_IVehicle_SetWheelHasTire(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId, boolean state);

        void alt_IVehicle_SetWheelHealth(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId, float health);

        void alt_IVehicle_SetWheelOnFire(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId, boolean state);

        void alt_IVehicle_SetWheels(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte type, @jnr.ffi.types.u_int8_t byte variation);

        void alt_IVehicle_SetWindowDamaged(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId, boolean isDamaged);

        void alt_IVehicle_SetWindowOpened(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId, boolean state);

        void alt_IVehicle_SetWindowTint(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte tint);

        void alt_IVehicle_ToggleExtra(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte extraID, boolean state);

        jnr.ffi.Pointer alt_IVehicle_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IVehicle_to_alt_IBaseObject(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IVehicle_to_alt_IEntity(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IVehicle_to_alt_IWorldObject(jnr.ffi.Pointer from);

        void alt_IVoiceChannel_AddPlayer(jnr.ffi.Pointer _instance, jnr.ffi.Pointer player);

        void alt_IVoiceChannel_AddRef(jnr.ffi.Pointer _instance);

        void alt_IVoiceChannel_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IVoiceChannel_DeleteMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        float alt_IVoiceChannel_GetMaxDistance(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IVoiceChannel_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        @jnr.ffi.types.u_int64_t long alt_IVoiceChannel_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IBaseObject_Type alt_IVoiceChannel_GetType(jnr.ffi.Pointer _instance);

        boolean alt_IVoiceChannel_HasMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        boolean alt_IVoiceChannel_HasPlayer(jnr.ffi.Pointer _instance, jnr.ffi.Pointer player);

        boolean alt_IVoiceChannel_IsPlayerMuted(jnr.ffi.Pointer _instance, jnr.ffi.Pointer player);

        boolean alt_IVoiceChannel_IsSpatial(jnr.ffi.Pointer _instance);

        void alt_IVoiceChannel_MutePlayer(jnr.ffi.Pointer _instance, jnr.ffi.Pointer player);

        void alt_IVoiceChannel_RemovePlayer(jnr.ffi.Pointer _instance, jnr.ffi.Pointer player);

        void alt_IVoiceChannel_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IVoiceChannel_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IVoiceChannel_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IVoiceChannel_UnmutePlayer(jnr.ffi.Pointer _instance, jnr.ffi.Pointer player);

        jnr.ffi.Pointer alt_IVoiceChannel_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IVoiceChannel_to_alt_IBaseObject(jnr.ffi.Pointer from);

        void alt_IWeakRef_Assign_IWeakRefRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IWeakRef_Assign_constIWeakRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IWeakRef_OnDestroy(jnr.ffi.Pointer _instance);

        void alt_IWeakRef_free(jnr.ffi.Pointer ptr);

        void alt_IWorldObject_AddRef(jnr.ffi.Pointer _instance);

        void alt_IWorldObject_AddWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IWorldObject_DeleteMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        @jnr.ffi.types.int32_t int alt_IWorldObject_GetDimension(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_IWorldObject_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_IWorldObject_GetPosition(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IWorldObject_GetRefCount(jnr.ffi.Pointer _instance);

        alt_IBaseObject_Type alt_IWorldObject_GetType(jnr.ffi.Pointer _instance);

        boolean alt_IWorldObject_HasMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        void alt_IWorldObject_RemoveRef(jnr.ffi.Pointer _instance);

        void alt_IWorldObject_RemoveWeakRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ref);

        void alt_IWorldObject_SetDimension(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int dimension);

        void alt_IWorldObject_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IWorldObject_SetPosition(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos);

        jnr.ffi.Pointer alt_IWorldObject_to_alt_CRefCountable(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IWorldObject_to_alt_IBaseObject(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IWorldObject_to_alt_IBlip(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IWorldObject_to_alt_ICheckpoint(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IWorldObject_to_alt_IColShape(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IWorldObject_to_alt_IEntity(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IWorldObject_to_alt_IPlayer(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_IWorldObject_to_alt_IVehicle(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_PointLayout_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_PointLayout_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_PointLayout_Assign_PointLayoutRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_PointLayout_Assign_constPointLayoutRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_PointLayout_free()
         */
        jnr.ffi.Pointer alt_PointLayout_Create();

        /**
         * Return ptr must be manually freed with alt_PointLayout_free()
         */
        jnr.ffi.Pointer alt_PointLayout_Create_1(float _x, float _y, float _z);

        /**
         * Return ptr must be manually freed with alt_PointLayout_free()
         */
        jnr.ffi.Pointer alt_PointLayout_Create_2(jnr.ffi.Pointer elements);

        /**
         * Return ptr must be manually freed with alt_PointLayout_free()
         */
        jnr.ffi.Pointer alt_PointLayout_Create_3(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_PointLayout_free()
         */
        jnr.ffi.Pointer alt_PointLayout_Create_4(jnr.ffi.Pointer _p0);

        void alt_PointLayout_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_PointLayout_to_alt_PointPaddedLayout(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_PointLayout_to_alt_Vector_float_3_PointLayout(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_PointPaddedLayout_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_PointPaddedLayout_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_PointPaddedLayout_Assign_PointLayoutRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_PointPaddedLayout_Assign_constPointLayoutRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_PointPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_PointPaddedLayout_Create();

        /**
         * Return ptr must be manually freed with alt_PointPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_1(float _x, float _y, float _z);

        /**
         * Return ptr must be manually freed with alt_PointPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_2(jnr.ffi.Pointer elements);

        /**
         * Return ptr must be manually freed with alt_PointPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_3(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_PointPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_PointPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_5();

        /**
         * Return ptr must be manually freed with alt_PointPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_6(float x, float y, float z);

        /**
         * Return ptr must be manually freed with alt_PointPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_7(jnr.ffi.Pointer elements);

        void alt_PointPaddedLayout_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_PointPaddedLayout_to_alt_PointLayout(jnr.ffi.Pointer from);

        /**
         * Return ptr must be manually freed with alt_RGBA_free()
         */
        jnr.ffi.Pointer alt_RGBA_Create();

        /**
         * Return ptr must be manually freed with alt_RGBA_free()
         */
        jnr.ffi.Pointer alt_RGBA_Create_1(@jnr.ffi.types.u_int8_t byte _r, @jnr.ffi.types.u_int8_t byte _g, @jnr.ffi.types.u_int8_t byte _b, @jnr.ffi.types.u_int8_t byte _a);

        void alt_RGBA_free(jnr.ffi.Pointer ptr);

        void alt_RefBase_RefStore_IBaseObject_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        void alt_RefBase_RefStore_IBaseObject_Assign_constRefBase_RefStore_IBaseObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IBaseObject_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IBaseObject_Create();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IBaseObject_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IBaseObject_Create_1();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IBaseObject_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IBaseObject_Create_2(jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IBaseObject_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IBaseObject_Create_3(jnr.ffi.Pointer other);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IBaseObject_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IBaseObject_Create_4(jnr.ffi.Pointer other);

        void alt_RefBase_RefStore_IBaseObject_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefBase_RefStore_IBaseObject_Get(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_IBaseObject_IsEmpty(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_IBaseObject_To__Bool(jnr.ffi.Pointer _instance);

        void alt_RefBase_RefStore_IBaseObject_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefBase_RefStore_IBaseObject_to_alt_RefStore_IBaseObject(jnr.ffi.Pointer from);

        void alt_RefBase_RefStore_IColShape_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        void alt_RefBase_RefStore_IColShape_Assign_constRefBase_RefStore_IColShapeRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IColShape_Create();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IColShape_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IColShape_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IColShape_Create_3();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IColShape_Create_4(jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IColShape_Create_5(jnr.ffi.Pointer other);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IColShape_Create_6(jnr.ffi.Pointer other);

        void alt_RefBase_RefStore_IColShape_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefBase_RefStore_IColShape_Get(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_IColShape_IsEmpty(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_IColShape_To__Bool(jnr.ffi.Pointer _instance);

        void alt_RefBase_RefStore_IColShape_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefBase_RefStore_IColShape_to_alt_RefStore_IColShape(jnr.ffi.Pointer from);

        void alt_RefBase_RefStore_IEntity_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        void alt_RefBase_RefStore_IEntity_Assign_constRefBase_RefStore_IEntityRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IEntity_Create();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IEntity_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IEntity_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IEntity_Create_3();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IEntity_Create_4(jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IEntity_Create_5(jnr.ffi.Pointer other);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IEntity_Create_6(jnr.ffi.Pointer other);

        void alt_RefBase_RefStore_IEntity_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefBase_RefStore_IEntity_Get(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_IEntity_IsEmpty(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_IEntity_To__Bool(jnr.ffi.Pointer _instance);

        void alt_RefBase_RefStore_IEntity_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefBase_RefStore_IEntity_to_alt_RefStore_IEntity(jnr.ffi.Pointer from);

        void alt_RefBase_RefStore_IMValue_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        void alt_RefBase_RefStore_IMValue_Assign_constRefBase_RefStore_IMValueRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IMValue_Create();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IMValue_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IMValue_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IMValue_Create_3();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IMValue_Create_4(jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IMValue_Create_5(jnr.ffi.Pointer other);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IMValue_Create_6(jnr.ffi.Pointer other);

        void alt_RefBase_RefStore_IMValue_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefBase_RefStore_IMValue_Get(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_IMValue_IsEmpty(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_IMValue_To__Bool(jnr.ffi.Pointer _instance);

        void alt_RefBase_RefStore_IMValue_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefBase_RefStore_IMValue_to_alt_RefStore_IMValue(jnr.ffi.Pointer from);

        void alt_RefBase_RefStore_IPlayer_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        void alt_RefBase_RefStore_IPlayer_Assign_constRefBase_RefStore_IPlayerRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IPlayer_Create();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IPlayer_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IPlayer_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IPlayer_Create_3();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IPlayer_Create_4(jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IPlayer_Create_5(jnr.ffi.Pointer other);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IPlayer_Create_6(jnr.ffi.Pointer other);

        void alt_RefBase_RefStore_IPlayer_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefBase_RefStore_IPlayer_Get(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_IPlayer_IsEmpty(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_IPlayer_To__Bool(jnr.ffi.Pointer _instance);

        void alt_RefBase_RefStore_IPlayer_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefBase_RefStore_IPlayer_to_alt_RefStore_IPlayer(jnr.ffi.Pointer from);

        void alt_RefBase_RefStore_IVehicle_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        void alt_RefBase_RefStore_IVehicle_Assign_constRefBase_RefStore_IVehicleRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IVehicle_Create();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IVehicle_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IVehicle_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IVehicle_Create_3();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IVehicle_Create_4(jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IVehicle_Create_5(jnr.ffi.Pointer other);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_IVehicle_Create_6(jnr.ffi.Pointer other);

        void alt_RefBase_RefStore_IVehicle_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefBase_RefStore_IVehicle_Get(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_IVehicle_IsEmpty(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_IVehicle_To__Bool(jnr.ffi.Pointer _instance);

        void alt_RefBase_RefStore_IVehicle_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefBase_RefStore_IVehicle_to_alt_RefStore_IVehicle(jnr.ffi.Pointer from);

        void alt_RefBase_RefStore_constIMValue_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        void alt_RefBase_RefStore_constIMValue_Assign_constRefBase_RefStore_constIMValueRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_constIMValue_Create();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_constIMValue_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_constIMValue_Create_2(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_constIMValue_Create_3();

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_constIMValue_Create_4(jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_constIMValue_Create_5(jnr.ffi.Pointer other);

        /**
         * Return ptr must be manually freed with alt_RefBase_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_RefBase_RefStore_constIMValue_Create_6(jnr.ffi.Pointer other);

        void alt_RefBase_RefStore_constIMValue_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefBase_RefStore_constIMValue_Get(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_constIMValue_IsEmpty(jnr.ffi.Pointer _instance);

        boolean alt_RefBase_RefStore_constIMValue_To__Bool(jnr.ffi.Pointer _instance);

        void alt_RefBase_RefStore_constIMValue_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefBase_RefStore_constIMValue_to_alt_RefStore_constIMValue(jnr.ffi.Pointer from);

        void alt_RefStore_IBaseObject_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefStore_IBaseObject_free()
         */
        jnr.ffi.Pointer alt_RefStore_IBaseObject_Create();

        void alt_RefStore_IBaseObject_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefStore_IBaseObject_Get(jnr.ffi.Pointer _instance);

        void alt_RefStore_IBaseObject_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefStore_IBaseObject_to_alt_RefBase_RefStore_IBaseObject(jnr.ffi.Pointer from);

        void alt_RefStore_IColShape_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_RefStore_IColShape_Create();

        /**
         * Return ptr must be manually freed with alt_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_RefStore_IColShape_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefStore_IColShape_free()
         */
        jnr.ffi.Pointer alt_RefStore_IColShape_Create_2(jnr.ffi.Pointer _p0);

        void alt_RefStore_IColShape_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefStore_IColShape_Get(jnr.ffi.Pointer _instance);

        void alt_RefStore_IColShape_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefStore_IColShape_to_alt_RefBase_RefStore_IColShape(jnr.ffi.Pointer from);

        void alt_RefStore_IEntity_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_RefStore_IEntity_Create();

        /**
         * Return ptr must be manually freed with alt_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_RefStore_IEntity_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefStore_IEntity_free()
         */
        jnr.ffi.Pointer alt_RefStore_IEntity_Create_2(jnr.ffi.Pointer _p0);

        void alt_RefStore_IEntity_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefStore_IEntity_Get(jnr.ffi.Pointer _instance);

        void alt_RefStore_IEntity_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefStore_IEntity_to_alt_RefBase_RefStore_IEntity(jnr.ffi.Pointer from);

        void alt_RefStore_IMValue_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_RefStore_IMValue_Create();

        /**
         * Return ptr must be manually freed with alt_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_RefStore_IMValue_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefStore_IMValue_free()
         */
        jnr.ffi.Pointer alt_RefStore_IMValue_Create_2(jnr.ffi.Pointer _p0);

        void alt_RefStore_IMValue_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefStore_IMValue_Get(jnr.ffi.Pointer _instance);

        void alt_RefStore_IMValue_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefStore_IMValue_to_alt_RefBase_RefStore_IMValue(jnr.ffi.Pointer from);

        void alt_RefStore_IPlayer_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_RefStore_IPlayer_Create();

        /**
         * Return ptr must be manually freed with alt_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_RefStore_IPlayer_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefStore_IPlayer_free()
         */
        jnr.ffi.Pointer alt_RefStore_IPlayer_Create_2(jnr.ffi.Pointer _p0);

        void alt_RefStore_IPlayer_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefStore_IPlayer_Get(jnr.ffi.Pointer _instance);

        void alt_RefStore_IPlayer_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefStore_IPlayer_to_alt_RefBase_RefStore_IPlayer(jnr.ffi.Pointer from);

        void alt_RefStore_IVehicle_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_RefStore_IVehicle_Create();

        /**
         * Return ptr must be manually freed with alt_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_RefStore_IVehicle_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefStore_IVehicle_free()
         */
        jnr.ffi.Pointer alt_RefStore_IVehicle_Create_2(jnr.ffi.Pointer _p0);

        void alt_RefStore_IVehicle_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefStore_IVehicle_Get(jnr.ffi.Pointer _instance);

        void alt_RefStore_IVehicle_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefStore_IVehicle_to_alt_RefBase_RefStore_IVehicle(jnr.ffi.Pointer from);

        void alt_RefStore_constIMValue_Assign(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _ptr);

        /**
         * Return ptr must be manually freed with alt_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_RefStore_constIMValue_Create();

        /**
         * Return ptr must be manually freed with alt_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_RefStore_constIMValue_Create_1(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RefStore_constIMValue_free()
         */
        jnr.ffi.Pointer alt_RefStore_constIMValue_Create_2(jnr.ffi.Pointer _p0);

        void alt_RefStore_constIMValue_Free(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_RefStore_constIMValue_Get(jnr.ffi.Pointer _instance);

        void alt_RefStore_constIMValue_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RefStore_constIMValue_to_alt_RefBase_RefStore_constIMValue(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_RotationLayout_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_RotationLayout_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        /**
         * Return ptr must be manually freed with alt_RotationLayout_free()
         */
        jnr.ffi.Pointer alt_RotationLayout_Create(float _roll, float _pitch, float _yaw);

        /**
         * Return ptr must be manually freed with alt_RotationLayout_free()
         */
        jnr.ffi.Pointer alt_RotationLayout_Create_1();

        /**
         * Return ptr must be manually freed with alt_RotationLayout_free()
         */
        jnr.ffi.Pointer alt_RotationLayout_Create_2(jnr.ffi.Pointer elements);

        /**
         * Return ptr must be manually freed with alt_RotationLayout_free()
         */
        jnr.ffi.Pointer alt_RotationLayout_Create_3(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RotationLayout_free()
         */
        jnr.ffi.Pointer alt_RotationLayout_Create_4(jnr.ffi.Pointer _p0);

        void alt_RotationLayout_Normalize(jnr.ffi.Pointer _instance);

        void alt_RotationLayout_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RotationLayout_to_alt_RotationPaddedLayout(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_RotationPaddedLayout_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_RotationPaddedLayout_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        /**
         * Return ptr must be manually freed with alt_RotationPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create(float _roll, float _pitch, float _yaw);

        /**
         * Return ptr must be manually freed with alt_RotationPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_1();

        /**
         * Return ptr must be manually freed with alt_RotationPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_2(jnr.ffi.Pointer elements);

        /**
         * Return ptr must be manually freed with alt_RotationPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_3(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RotationPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_RotationPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_5();

        /**
         * Return ptr must be manually freed with alt_RotationPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_6(float roll, float pitch, float yaw);

        /**
         * Return ptr must be manually freed with alt_RotationPaddedLayout_free()
         */
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_7(jnr.ffi.Pointer elements);

        void alt_RotationPaddedLayout_Normalize(jnr.ffi.Pointer _instance);

        void alt_RotationPaddedLayout_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RotationPaddedLayout_to_alt_RotationLayout(jnr.ffi.Pointer from);

        @jnr.ffi.types.int8_t byte alt_StringView_Access_uint64_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_StringView_Assign_StringViewRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_StringView_Assign_constStringViewRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        @jnr.ffi.annotations.Encoding("UTF-8") String alt_StringView_CStr(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_StringView_Create(@jnr.ffi.annotations.Encoding("UTF-8") String _data, @jnr.ffi.types.u_int64_t long _size);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_StringView_Create_1();

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_StringView_Create_2(@jnr.ffi.annotations.Encoding("UTF-8") String _str);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_StringView_Create_4(jnr.ffi.Pointer _str);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_StringView_Create_6(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_StringView_free()
         */
        jnr.ffi.Pointer alt_StringView_Create_7(jnr.ffi.Pointer _p0);

        boolean alt_StringView_Equals_StringView(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        @jnr.ffi.annotations.Encoding("UTF-8") String alt_StringView_GetData(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_StringView_GetSize(jnr.ffi.Pointer _instance);

        boolean alt_StringView_IsEmpty(jnr.ffi.Pointer _instance);

        boolean alt_StringView_NotEquals_StringView(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_StringView_To_String(jnr.ffi.Pointer _instance);

        void alt_StringView_free(jnr.ffi.Pointer ptr);

        @jnr.ffi.annotations.Encoding("UTF-8") String alt_String_Access_uint64_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        @jnr.ffi.types.int8_t byte alt_String_Access_uint64_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_String_Assign_StringRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        void alt_String_Assign_constStringRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        @jnr.ffi.annotations.Encoding("UTF-8") String alt_String_CStr(jnr.ffi.Pointer _instance);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_String_Create(@jnr.ffi.types.u_int64_t long _size, @jnr.ffi.types.int8_t byte fill);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_String_Create_1(@jnr.ffi.annotations.Encoding("UTF-8") String _data, @jnr.ffi.types.u_int64_t long size);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_String_Create_2();

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_String_Create_3(@jnr.ffi.annotations.Encoding("UTF-8") String _str);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_String_Create_5(jnr.ffi.Pointer that);

        /**
         * Return ptr must be manually freed with alt_String_free()
         */
        jnr.ffi.Pointer alt_String_Create_6(jnr.ffi.Pointer that);

        boolean alt_String_Equals_String(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        @jnr.ffi.annotations.Encoding("UTF-8") String alt_String_GetData(jnr.ffi.Pointer _instance);

        @jnr.ffi.annotations.Encoding("UTF-8") String alt_String_GetData_1(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_String_GetSize(jnr.ffi.Pointer _instance);

        boolean alt_String_IsEmpty(jnr.ffi.Pointer _instance);

        boolean alt_String_NotEquals_String(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        void alt_String_Resize(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long new_size);

        void alt_String_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_VectorLayout_float_3_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_VectorLayout_float_3_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_VectorLayout_float_3_Assign_VectorLayout_float_3RefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_VectorLayout_float_3_Assign_constVectorLayout_float_3Ref(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_VectorLayout_float_3_Create();

        /**
         * Return ptr must be manually freed with alt_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_VectorLayout_float_3_Create_1(jnr.ffi.Pointer _elements);

        /**
         * Return ptr must be manually freed with alt_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_VectorLayout_float_3_Create_2(jnr.ffi.Pointer el);

        /**
         * Return ptr must be manually freed with alt_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_VectorLayout_float_3_Create_3(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_VectorLayout_float_3_Create_4(jnr.ffi.Pointer _p0);

        void alt_VectorLayout_float_3_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_VectorLayout_float_3_to_alt_Vector_float_3_VectorLayout_float_3(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_VectorLayout_float_4_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_VectorLayout_float_4_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_VectorLayout_float_4_Assign_VectorLayout_float_4RefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_VectorLayout_float_4_Assign_constVectorLayout_float_4Ref(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_VectorLayout_float_4_Create();

        /**
         * Return ptr must be manually freed with alt_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_VectorLayout_float_4_Create_1(jnr.ffi.Pointer _elements);

        /**
         * Return ptr must be manually freed with alt_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_VectorLayout_float_4_Create_2(jnr.ffi.Pointer el);

        /**
         * Return ptr must be manually freed with alt_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_VectorLayout_float_4_Create_3(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_VectorLayout_float_4_Create_4(jnr.ffi.Pointer _p0);

        void alt_VectorLayout_float_4_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_VectorLayout_float_4_to_alt_Vector_float_4_VectorLayout_float_4(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_Vector_float_3_PointLayout_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_Vector_float_3_PointLayout_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_Vector_float_3_PointLayout_Assign_PointLayoutRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_Vector_float_3_PointLayout_Assign_Vector_float_3_PointLayoutRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_Vector_float_3_PointLayout_Assign_constPointLayoutRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_Vector_float_3_PointLayout_Assign_constVector_float_3_PointLayoutRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_PointLayout_Create();

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_PointLayout_Create_1(float _x, float _y, float _z);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_PointLayout_Create_2(jnr.ffi.Pointer elements);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_PointLayout_Create_3(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_PointLayout_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_PointLayout_Create_5();

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_PointLayout_Create_6(jnr.ffi.Pointer _elements);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_PointLayout_Create_7(jnr.ffi.Pointer layout);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_PointLayout_Create_8(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_PointLayout_Create_9(jnr.ffi.Pointer _p0);

        float alt_Vector_float_3_PointLayout_Length(jnr.ffi.Pointer _instance);

        float alt_Vector_float_3_PointLayout_LengthSqr(jnr.ffi.Pointer _instance);

        void alt_Vector_float_3_PointLayout_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_Vector_float_3_PointLayout_to_alt_PointLayout(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_Vector_float_3_VectorLayout_float_3_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_Vector_float_3_VectorLayout_float_3_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_Vector_float_3_VectorLayout_float_3_Assign_VectorLayout_float_3RefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_Vector_float_3_VectorLayout_float_3_Assign_Vector_float_3_VectorLayout_float_3RefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_Vector_float_3_VectorLayout_float_3_Assign_constVectorLayout_float_3Ref(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_Vector_float_3_VectorLayout_float_3_Assign_constVector_float_3_VectorLayout_float_3Ref(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_VectorLayout_float_3_Create();

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_VectorLayout_float_3_Create_1(jnr.ffi.Pointer _elements);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_VectorLayout_float_3_Create_2(jnr.ffi.Pointer el);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_VectorLayout_float_3_Create_3(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_VectorLayout_float_3_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_VectorLayout_float_3_Create_5();

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_VectorLayout_float_3_Create_6(jnr.ffi.Pointer _elements);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_VectorLayout_float_3_Create_7(jnr.ffi.Pointer layout);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_VectorLayout_float_3_Create_8(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_Vector_float_3_VectorLayout_float_3_free()
         */
        jnr.ffi.Pointer alt_Vector_float_3_VectorLayout_float_3_Create_9(jnr.ffi.Pointer _p0);

        float alt_Vector_float_3_VectorLayout_float_3_Length(jnr.ffi.Pointer _instance);

        float alt_Vector_float_3_VectorLayout_float_3_LengthSqr(jnr.ffi.Pointer _instance);

        void alt_Vector_float_3_VectorLayout_float_3_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_Vector_float_3_VectorLayout_float_3_to_alt_VectorLayout_float_3(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_Vector_float_4_VectorLayout_float_4_Assign_VectorLayout_float_4RefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_Vector_float_4_VectorLayout_float_4_Assign_Vector_float_4_VectorLayout_float_4RefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_Vector_float_4_VectorLayout_float_4_Assign_constVectorLayout_float_4Ref(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_Vector_float_4_VectorLayout_float_4_Assign_constVector_float_4_VectorLayout_float_4Ref(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create();

        /**
         * Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_1(jnr.ffi.Pointer _elements);

        /**
         * Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_2(jnr.ffi.Pointer el);

        /**
         * Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_3(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_4(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_5();

        /**
         * Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_6(jnr.ffi.Pointer _elements);

        /**
         * Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_7(jnr.ffi.Pointer layout);

        /**
         * Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_8(jnr.ffi.Pointer _p0);

        /**
         * Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
         */
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_9(jnr.ffi.Pointer _p0);

        float alt_Vector_float_4_VectorLayout_float_4_Length(jnr.ffi.Pointer _instance);

        float alt_Vector_float_4_VectorLayout_float_4_LengthSqr(jnr.ffi.Pointer _instance);

        void alt_Vector_float_4_VectorLayout_float_4_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_to_alt_VectorLayout_float_4(jnr.ffi.Pointer from);

        jnr.ffi.Pointer alt_ViewMatrixLayout_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_ViewMatrixLayout_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        /**
         * Return ptr must be manually freed with alt_ViewMatrixLayout_free()
         */
        jnr.ffi.Pointer alt_ViewMatrixLayout_Create();

        /**
         * Return ptr must be manually freed with alt_ViewMatrixLayout_free()
         */
        jnr.ffi.Pointer alt_ViewMatrixLayout_Create_1(jnr.ffi.Pointer _rows);

        /**
         * Return ptr must be manually freed with alt_ViewMatrixLayout_free()
         */
        jnr.ffi.Pointer alt_ViewMatrixLayout_Create_2(jnr.ffi.Pointer row);

        /**
         * Return ptr must be manually freed with alt_ViewMatrixLayout_free()
         */
        jnr.ffi.Pointer alt_ViewMatrixLayout_Create_3(jnr.ffi.Pointer elements);

        /**
         * Return ptr must be manually freed with alt_ViewMatrixLayout_free()
         */
        jnr.ffi.Pointer alt_ViewMatrixLayout_Create_4(jnr.ffi.Pointer _right, jnr.ffi.Pointer _up, jnr.ffi.Pointer _forward, jnr.ffi.Pointer _pos);

        void alt_ViewMatrixLayout_free(jnr.ffi.Pointer ptr);

    }
}
