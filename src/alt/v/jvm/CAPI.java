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
        ALT_CEVENT_TYPE_SERVER_SCRIPT_EVENT(3),
        ALT_CEVENT_TYPE_CLIENT_SCRIPT_EVENT(4),
        ALT_CEVENT_TYPE_META_CHANGE(5),
        ALT_CEVENT_TYPE_SYNCED_META_CHANGE(6),
        ALT_CEVENT_TYPE_PLAYER_DAMAGE(7),
        ALT_CEVENT_TYPE_PLAYER_DEATH(8),
        ALT_CEVENT_TYPE_CHECKPOINT_EVENT(9),
        ALT_CEVENT_TYPE_COLSHAPE_EVENT(10),
        ALT_CEVENT_TYPE_PLAYER_ENTER_VEHICLE(11),
        ALT_CEVENT_TYPE_PLAYER_LEAVE_VEHICLE(12),
        ALT_CEVENT_TYPE_PLAYER_CHANGE_VEHICLE_SEAT(13),
        ALT_CEVENT_TYPE_REMOVE_ENTITY_EVENT(14),
        ALT_CEVENT_TYPE_DATA_NODE_RECEIVED_EVENT(15),
        ALT_CEVENT_TYPE_CONSOLE_COMMAND_EVENT(16),
        ALT_CEVENT_TYPE_CONNECTION_COMPLETE(17),
        ALT_CEVENT_TYPE_DISCONNECT_EVENT(18),
        ALT_CEVENT_TYPE_WEB_VIEW_EVENT(19),
        ALT_CEVENT_TYPE_KEYBOARD_EVENT(20),
        ALT_CEVENT_TYPE_GAME_ENTITY_CREATE(21),
        ALT_CEVENT_TYPE_GAME_ENTITY_DESTROY(22),
        ALT_CEVENT_TYPE_ALL(23),
        ALT_CEVENT_TYPE_SIZE(24);

        alt_CEvent_Type(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static enum alt_ColShapeType implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ALT_COLSHAPETYPE_ColshapeSphere(0),
        ALT_COLSHAPETYPE_ColshapeCylinder(1),
        ALT_COLSHAPETYPE_ColshapeCircle(2),
        ALT_COLSHAPETYPE_ColshapeCube(3),
        ALT_COLSHAPETYPE_ColshapeRect(4);

        alt_ColShapeType(int value) {
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
        ALT_IBASEOBJECT_TYPE_CHECKPOINT(2),
        ALT_IBASEOBJECT_TYPE_BLIP(3),
        ALT_IBASEOBJECT_TYPE_WEBVIEW(4),
        ALT_IBASEOBJECT_TYPE_VOICE_CHANNEL(5),
        ALT_IBASEOBJECT_TYPE_COLSHAPE(6);

        alt_IBaseObject_Type(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static enum alt_IBlip_Type implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ALT_IBLIP_TYPE_VEHICLE(1),
        ALT_IBLIP_TYPE_PED(2),
        ALT_IBLIP_TYPE_OBJECT(3),
        ALT_IBLIP_TYPE_DESTINATION(4),
        ALT_IBLIP_TYPE_CONT(5),
        ALT_IBLIP_TYPE_PICKUP_UNK(6),
        ALT_IBLIP_TYPE_RADIUS(7),
        ALT_IBLIP_TYPE_PICKUP(8),
        ALT_IBLIP_TYPE_COP(9),
        ALT_IBLIP_TYPE_AREA(11),
        ALT_IBLIP_TYPE_GALLERY(12),
        ALT_IBLIP_TYPE_PICKUP_OBJECT(13);

        alt_IBlip_Type(int value) {
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

    public static enum alt_MValue_Type implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ALT_MVALUE_TYPE_NIL(0),
        ALT_MVALUE_TYPE_BOOL(1),
        ALT_MVALUE_TYPE_INT(2),
        ALT_MVALUE_TYPE_UINT(3),
        ALT_MVALUE_TYPE_DOUBLE(4),
        ALT_MVALUE_TYPE_STRING(5),
        ALT_MVALUE_TYPE_LIST(6),
        ALT_MVALUE_TYPE_DICT(7),
        ALT_MVALUE_TYPE_ENTITY(8),
        ALT_MVALUE_TYPE_FUNCTION(9);

        alt_MValue_Type(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
        private final int value;
    }

    public static class alt_Array_MValue extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer data = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int64_t size = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.u_int64_t capacity = new jnr.ffi.Struct.u_int64_t();
        
        public alt_Array_MValue()
        {
            super(runtime);
        }
        public alt_Array_MValue(jnr.ffi.Runtime runtime)
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
        public alt_Array_StringView(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CCheckpointEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Pointer entity = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Boolean state = new jnr.ffi.Struct.Boolean();
        
        public alt_CCheckpointEvent()
        {
            super(runtime);
        }
        public alt_CCheckpointEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CClientScriptEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final alt_String name = new alt_String();
        public final alt_MValueList args = new alt_MValueList();
        
        public alt_CClientScriptEvent()
        {
            super(runtime);
        }
        public alt_CClientScriptEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CColShapeEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Pointer entity = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Boolean state = new jnr.ffi.Struct.Boolean();
        
        public alt_CColShapeEvent()
        {
            super(runtime);
        }
        public alt_CColShapeEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CConsoleCommandEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_StringView name = new alt_StringView();
        public final alt_Array_StringView args = new alt_Array_StringView();
        
        public alt_CConsoleCommandEvent()
        {
            super(runtime);
        }
        public alt_CConsoleCommandEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CDataNodeReceivedEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_String name = new alt_String();
        public final alt_String json = new alt_String();
        
        public alt_CDataNodeReceivedEvent()
        {
            super(runtime);
        }
        public alt_CDataNodeReceivedEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        
        public alt_CEvent()
        {
            super(runtime);
        }
        public alt_CEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerChangeVehicleSeatEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Pointer player = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int8_t oldSeat = new jnr.ffi.Struct.u_int8_t();
        public final jnr.ffi.Struct.u_int8_t newSeat = new jnr.ffi.Struct.u_int8_t();
        
        public alt_CPlayerChangeVehicleSeatEvent()
        {
            super(runtime);
        }
        public alt_CPlayerChangeVehicleSeatEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerConnectEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final alt_String reason = new alt_String();
        
        public alt_CPlayerConnectEvent()
        {
            super(runtime);
        }
        public alt_CPlayerConnectEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerDamageEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Pointer attacker = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int16_t damage = new jnr.ffi.Struct.u_int16_t();
        public final jnr.ffi.Struct.u_int32_t weapon = new jnr.ffi.Struct.u_int32_t();
        
        public alt_CPlayerDamageEvent()
        {
            super(runtime);
        }
        public alt_CPlayerDamageEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerDeathEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Pointer killer = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int32_t weapon = new jnr.ffi.Struct.u_int32_t();
        
        public alt_CPlayerDeathEvent()
        {
            super(runtime);
        }
        public alt_CPlayerDeathEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerDisconnectEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final alt_String reason = new alt_String();
        
        public alt_CPlayerDisconnectEvent()
        {
            super(runtime);
        }
        public alt_CPlayerDisconnectEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerEnterVehicleEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Pointer player = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int8_t seat = new jnr.ffi.Struct.u_int8_t();
        
        public alt_CPlayerEnterVehicleEvent()
        {
            super(runtime);
        }
        public alt_CPlayerEnterVehicleEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CPlayerLeaveVehicleEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.Pointer player = new jnr.ffi.Struct.Pointer();
        public final jnr.ffi.Struct.u_int8_t seat = new jnr.ffi.Struct.u_int8_t();
        
        public alt_CPlayerLeaveVehicleEvent()
        {
            super(runtime);
        }
        public alt_CPlayerLeaveVehicleEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CRemoveEntityEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final jnr.ffi.Struct.Pointer target = new jnr.ffi.Struct.Pointer();
        
        public alt_CRemoveEntityEvent()
        {
            super(runtime);
        }
        public alt_CRemoveEntityEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_CServerScriptEvent extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_CEvent_Type> type = new jnr.ffi.Struct.Enum32<alt_CEvent_Type>(alt_CEvent_Type.class);
        public final jnr.ffi.Struct.Boolean cancelled = new jnr.ffi.Struct.Boolean();
        public final alt_String name = new alt_String();
        public final alt_MValueList args = new alt_MValueList();
        
        public alt_CServerScriptEvent()
        {
            super(runtime);
        }
        public alt_CServerScriptEvent(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_IResource_CreationInfo extends jnr.ffi.Struct
    {
        public final alt_String type = new alt_String();
        public final alt_String name = new alt_String();
        public final alt_String path = new alt_String();
        public final alt_String main = new alt_String();
        public final alt_Array_String deps = new alt_Array_String();
        public final jnr.ffi.Struct.Pointer pkg = new jnr.ffi.Struct.Pointer();
        
        public alt_IResource_CreationInfo()
        {
            super(runtime);
        }
        public alt_IResource_CreationInfo(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValue extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_MValue_Type> type = new jnr.ffi.Struct.Enum32<alt_MValue_Type>(alt_MValue_Type.class);
        public final jnr.ffi.Struct.Pointer storage = new jnr.ffi.Struct.Pointer();
        
        public alt_MValue()
        {
            super(runtime);
        }
        public alt_MValue(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValueDict extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_MValue_Type> type = new jnr.ffi.Struct.Enum32<alt_MValue_Type>(alt_MValue_Type.class);
        public final jnr.ffi.Struct.Pointer storage = new jnr.ffi.Struct.Pointer();
        
        public alt_MValueDict()
        {
            super(runtime);
        }
        public alt_MValueDict(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValueFunction extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_MValue_Type> type = new jnr.ffi.Struct.Enum32<alt_MValue_Type>(alt_MValue_Type.class);
        public final jnr.ffi.Struct.Pointer storage = new jnr.ffi.Struct.Pointer();
        
        public alt_MValueFunction()
        {
            super(runtime);
        }
        public alt_MValueFunction(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValueList extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Enum32<alt_MValue_Type> type = new jnr.ffi.Struct.Enum32<alt_MValue_Type>(alt_MValue_Type.class);
        public final jnr.ffi.Struct.Pointer storage = new jnr.ffi.Struct.Pointer();
        
        public alt_MValueList()
        {
            super(runtime);
        }
        public alt_MValueList(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValue_Function extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.Pointer invoker = new jnr.ffi.Struct.Pointer();
        
        public alt_MValue_Function()
        {
            super(runtime);
        }
        public alt_MValue_Function(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValue_Storage_Array_MValue extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.u_int64_t refCount = new jnr.ffi.Struct.u_int64_t();
        public final alt_Array_MValue value = new alt_Array_MValue();
        
        public alt_MValue_Storage_Array_MValue()
        {
            super(runtime);
        }
        public alt_MValue_Storage_Array_MValue(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValue_Storage_IBaseObjectPtr extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.u_int64_t refCount = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.Pointer value = new jnr.ffi.Struct.Pointer();
        
        public alt_MValue_Storage_IBaseObjectPtr()
        {
            super(runtime);
        }
        public alt_MValue_Storage_IBaseObjectPtr(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValue_Storage_MValue_Function extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.u_int64_t refCount = new jnr.ffi.Struct.u_int64_t();
        public final alt_MValue_Function value = new alt_MValue_Function();
        
        public alt_MValue_Storage_MValue_Function()
        {
            super(runtime);
        }
        public alt_MValue_Storage_MValue_Function(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValue_Storage_String extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.u_int64_t refCount = new jnr.ffi.Struct.u_int64_t();
        public final alt_String value = new alt_String();
        
        public alt_MValue_Storage_String()
        {
            super(runtime);
        }
        public alt_MValue_Storage_String(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValue_Storage__Bool extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.u_int64_t refCount = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.Boolean value = new jnr.ffi.Struct.Boolean();
        
        public alt_MValue_Storage__Bool()
        {
            super(runtime);
        }
        public alt_MValue_Storage__Bool(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValue_Storage_double extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.u_int64_t refCount = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.Double value = new jnr.ffi.Struct.Double();
        
        public alt_MValue_Storage_double()
        {
            super(runtime);
        }
        public alt_MValue_Storage_double(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValue_Storage_longlong extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.u_int64_t refCount = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.int64_t value = new jnr.ffi.Struct.int64_t();
        
        public alt_MValue_Storage_longlong()
        {
            super(runtime);
        }
        public alt_MValue_Storage_longlong(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValue_Storage_unsignedlonglong extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.u_int64_t refCount = new jnr.ffi.Struct.u_int64_t();
        public final jnr.ffi.Struct.u_int64_t value = new jnr.ffi.Struct.u_int64_t();
        
        public alt_MValue_Storage_unsignedlonglong()
        {
            super(runtime);
        }
        public alt_MValue_Storage_unsignedlonglong(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_MValue__Storage extends jnr.ffi.Struct
    {
        public final jnr.ffi.Struct.u_int64_t refCount = new jnr.ffi.Struct.u_int64_t();
        
        public alt_MValue__Storage()
        {
            super(runtime);
        }
        public alt_MValue__Storage(jnr.ffi.Runtime runtime)
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
        public alt_RGBA(jnr.ffi.Runtime runtime)
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
        public alt_StringView(jnr.ffi.Runtime runtime)
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
        public alt_VectorLayout_float_4(jnr.ffi.Runtime runtime)
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
        public alt_Vector_float_4_VectorLayout_float_4(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    public static class alt_ViewMatrixLayout extends jnr.ffi.Struct
    {
        public final alt_Vector_float_4_VectorLayout_float_4 right = new alt_Vector_float_4_VectorLayout_float_4();
        public final alt_Vector_float_4_VectorLayout_float_4 up = new alt_Vector_float_4_VectorLayout_float_4();
        public final alt_Vector_float_4_VectorLayout_float_4 forward = new alt_Vector_float_4_VectorLayout_float_4();
        public final alt_Vector_float_4_VectorLayout_float_4 pos = new alt_Vector_float_4_VectorLayout_float_4();
        
        public alt_ViewMatrixLayout()
        {
            super(runtime);
        }
        public alt_ViewMatrixLayout(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }

    

    public static interface CAPIFunctions
    {
        jnr.ffi.Pointer alt_Array_MValue_Access_uint64_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_Array_MValue_Access_uint64_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_Array_MValue_Assign_Array_MValueRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        void alt_Array_MValue_Assign_constArray_MValueRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_Array_MValue_free()
        jnr.ffi.Pointer alt_Array_MValue_Create();

        // Return ptr must be manually freed with alt_Array_MValue_free()
        jnr.ffi.Pointer alt_Array_MValue_Create_1(jnr.ffi.Pointer _data, @jnr.ffi.types.u_int64_t long _size);

        // Return ptr must be manually freed with alt_Array_MValue_free()
        jnr.ffi.Pointer alt_Array_MValue_Create_2(@jnr.ffi.types.u_int64_t long _size, jnr.ffi.Pointer fill);

        // Return ptr must be manually freed with alt_Array_MValue_free()
        jnr.ffi.Pointer alt_Array_MValue_Create_3(jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_Array_MValue_free()
        jnr.ffi.Pointer alt_Array_MValue_Create_4(jnr.ffi.Pointer that);

        @jnr.ffi.types.u_int64_t long alt_Array_MValue_GetCapacity(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_Array_MValue_GetSize(jnr.ffi.Pointer _instance);

        void alt_Array_MValue_Push(jnr.ffi.Pointer _instance, jnr.ffi.Pointer el);

        jnr.ffi.Pointer alt_Array_MValue_begin(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_MValue_begin_1(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_MValue_end(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_MValue_end_1(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_StringView_Access_uint64_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_Array_StringView_Access_uint64_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_Array_StringView_Assign_Array_StringViewRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        void alt_Array_StringView_Assign_constArray_StringViewRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_Array_StringView_free()
        jnr.ffi.Pointer alt_Array_StringView_Create();

        // Return ptr must be manually freed with alt_Array_StringView_free()
        jnr.ffi.Pointer alt_Array_StringView_Create_1(jnr.ffi.Pointer _data, @jnr.ffi.types.u_int64_t long _size);

        // Return ptr must be manually freed with alt_Array_StringView_free()
        jnr.ffi.Pointer alt_Array_StringView_Create_2(@jnr.ffi.types.u_int64_t long _size, jnr.ffi.Pointer fill);

        // Return ptr must be manually freed with alt_Array_StringView_free()
        jnr.ffi.Pointer alt_Array_StringView_Create_3(jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_Array_StringView_free()
        jnr.ffi.Pointer alt_Array_StringView_Create_4(jnr.ffi.Pointer that);

        @jnr.ffi.types.u_int64_t long alt_Array_StringView_GetCapacity(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_Array_StringView_GetSize(jnr.ffi.Pointer _instance);

        void alt_Array_StringView_Push(jnr.ffi.Pointer _instance, jnr.ffi.Pointer el);

        jnr.ffi.Pointer alt_Array_StringView_begin(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_StringView_begin_1(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_StringView_end(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_StringView_end_1(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_String_Access_uint64_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_Array_String_Access_uint64_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_Array_String_Assign_Array_StringRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        void alt_Array_String_Assign_constArray_StringRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_Array_String_free()
        jnr.ffi.Pointer alt_Array_String_Create();

        // Return ptr must be manually freed with alt_Array_String_free()
        jnr.ffi.Pointer alt_Array_String_Create_1(jnr.ffi.Pointer _data, @jnr.ffi.types.u_int64_t long _size);

        // Return ptr must be manually freed with alt_Array_String_free()
        jnr.ffi.Pointer alt_Array_String_Create_2(@jnr.ffi.types.u_int64_t long _size, jnr.ffi.Pointer fill);

        // Return ptr must be manually freed with alt_Array_String_free()
        jnr.ffi.Pointer alt_Array_String_Create_3(jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_Array_String_free()
        jnr.ffi.Pointer alt_Array_String_Create_4(jnr.ffi.Pointer that);

        @jnr.ffi.types.u_int64_t long alt_Array_String_GetCapacity(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_Array_String_GetSize(jnr.ffi.Pointer _instance);

        void alt_Array_String_Push(jnr.ffi.Pointer _instance, jnr.ffi.Pointer el);

        jnr.ffi.Pointer alt_Array_String_begin(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_String_begin_1(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_String_end(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_Array_String_end_1(jnr.ffi.Pointer _instance);

        void alt_CCheckpointEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CCheckpointEvent_Assign_constCCheckpointEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CCheckpointEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CCheckpointEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CCheckpointEvent_free()
        jnr.ffi.Pointer alt_CCheckpointEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CCheckpointEvent_free()
        jnr.ffi.Pointer alt_CCheckpointEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CCheckpointEvent_free()
        jnr.ffi.Pointer alt_CCheckpointEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CCheckpointEvent_free()
        jnr.ffi.Pointer alt_CCheckpointEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _entity, boolean _state);

        // Return ptr must be manually freed with alt_CCheckpointEvent_free()
        jnr.ffi.Pointer alt_CCheckpointEvent_Create_4(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CCheckpointEvent_GetEntity(jnr.ffi.Pointer _instance);

        boolean alt_CCheckpointEvent_GetState(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_CCheckpointEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CCheckpointEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CCheckpointEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CCheckpointEvent_free(jnr.ffi.Pointer ptr);

        void alt_CClientScriptEvent_Assign_CClientScriptEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CClientScriptEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CClientScriptEvent_Assign_constCClientScriptEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CClientScriptEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CClientScriptEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CClientScriptEvent_free()
        jnr.ffi.Pointer alt_CClientScriptEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CClientScriptEvent_free()
        jnr.ffi.Pointer alt_CClientScriptEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CClientScriptEvent_free()
        jnr.ffi.Pointer alt_CClientScriptEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CClientScriptEvent_free()
        jnr.ffi.Pointer alt_CClientScriptEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _name, jnr.ffi.Pointer _args);

        // Return ptr must be manually freed with alt_CClientScriptEvent_free()
        jnr.ffi.Pointer alt_CClientScriptEvent_Create_4(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CClientScriptEvent_free()
        jnr.ffi.Pointer alt_CClientScriptEvent_Create_5(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_CClientScriptEvent_GetArgs(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_CClientScriptEvent_GetName(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_CClientScriptEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CClientScriptEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CClientScriptEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CClientScriptEvent_free(jnr.ffi.Pointer ptr);

        void alt_CColShapeEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CColShapeEvent_Assign_constCColShapeEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CColShapeEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CColShapeEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CColShapeEvent_free()
        jnr.ffi.Pointer alt_CColShapeEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CColShapeEvent_free()
        jnr.ffi.Pointer alt_CColShapeEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CColShapeEvent_free()
        jnr.ffi.Pointer alt_CColShapeEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CColShapeEvent_free()
        jnr.ffi.Pointer alt_CColShapeEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _entity, boolean _state);

        // Return ptr must be manually freed with alt_CColShapeEvent_free()
        jnr.ffi.Pointer alt_CColShapeEvent_Create_4(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CColShapeEvent_GetEntity(jnr.ffi.Pointer _instance);

        boolean alt_CColShapeEvent_GetState(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_CColShapeEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CColShapeEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CColShapeEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CColShapeEvent_free(jnr.ffi.Pointer ptr);

        void alt_CConsoleCommandEvent_Assign_CConsoleCommandEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CConsoleCommandEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CConsoleCommandEvent_Assign_constCConsoleCommandEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CConsoleCommandEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CConsoleCommandEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CConsoleCommandEvent_free()
        jnr.ffi.Pointer alt_CConsoleCommandEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CConsoleCommandEvent_free()
        jnr.ffi.Pointer alt_CConsoleCommandEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CConsoleCommandEvent_free()
        jnr.ffi.Pointer alt_CConsoleCommandEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CConsoleCommandEvent_free()
        jnr.ffi.Pointer alt_CConsoleCommandEvent_Create_3(jnr.ffi.Pointer _name, jnr.ffi.Pointer _args);

        // Return ptr must be manually freed with alt_CConsoleCommandEvent_free()
        jnr.ffi.Pointer alt_CConsoleCommandEvent_Create_4(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CConsoleCommandEvent_free()
        jnr.ffi.Pointer alt_CConsoleCommandEvent_Create_5(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CConsoleCommandEvent_GetArgs(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_CConsoleCommandEvent_GetName(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CConsoleCommandEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CConsoleCommandEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CConsoleCommandEvent_free(jnr.ffi.Pointer ptr);

        void alt_CDataNodeReceivedEvent_Assign_CDataNodeReceivedEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CDataNodeReceivedEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CDataNodeReceivedEvent_Assign_constCDataNodeReceivedEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CDataNodeReceivedEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CDataNodeReceivedEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CDataNodeReceivedEvent_free()
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CDataNodeReceivedEvent_free()
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CDataNodeReceivedEvent_free()
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CDataNodeReceivedEvent_free()
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_Create_3(jnr.ffi.Pointer _name, jnr.ffi.Pointer _logJson);

        // Return ptr must be manually freed with alt_CDataNodeReceivedEvent_free()
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_Create_4(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CDataNodeReceivedEvent_free()
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_Create_5(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_GetJson(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_CDataNodeReceivedEvent_GetName(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CDataNodeReceivedEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CDataNodeReceivedEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CDataNodeReceivedEvent_free(jnr.ffi.Pointer ptr);

        void alt_CEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CEvent_free()
        jnr.ffi.Pointer alt_CEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CEvent_free()
        jnr.ffi.Pointer alt_CEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CEvent_free()
        jnr.ffi.Pointer alt_CEvent_Create_2(jnr.ffi.Pointer _p0);

        alt_CEvent_Type alt_CEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CEvent_free(jnr.ffi.Pointer ptr);

        void alt_CPlayerChangeVehicleSeatEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerChangeVehicleSeatEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerChangeVehicleSeatEvent_Assign_constCPlayerChangeVehicleSeatEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerChangeVehicleSeatEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CPlayerChangeVehicleSeatEvent_free()
        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CPlayerChangeVehicleSeatEvent_free()
        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerChangeVehicleSeatEvent_free()
        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerChangeVehicleSeatEvent_free()
        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _player, @jnr.ffi.types.u_int8_t byte _oldSeat, @jnr.ffi.types.u_int8_t byte _newSeat);

        // Return ptr must be manually freed with alt_CPlayerChangeVehicleSeatEvent_free()
        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_Create_4(jnr.ffi.Pointer _p0);

        @jnr.ffi.types.u_int8_t byte alt_CPlayerChangeVehicleSeatEvent_GetNewSeat(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_CPlayerChangeVehicleSeatEvent_GetOldSeat(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_GetPlayer(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_CPlayerChangeVehicleSeatEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerChangeVehicleSeatEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerChangeVehicleSeatEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerChangeVehicleSeatEvent_free(jnr.ffi.Pointer ptr);

        void alt_CPlayerConnectEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerConnectEvent_Assign_CPlayerConnectEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerConnectEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerConnectEvent_Assign_constCPlayerConnectEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerConnectEvent_Cancel(jnr.ffi.Pointer _instance);

        void alt_CPlayerConnectEvent_Cancel_1(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _reason);

        // Return ptr must be manually freed with alt_CPlayerConnectEvent_free()
        jnr.ffi.Pointer alt_CPlayerConnectEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CPlayerConnectEvent_free()
        jnr.ffi.Pointer alt_CPlayerConnectEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerConnectEvent_free()
        jnr.ffi.Pointer alt_CPlayerConnectEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerConnectEvent_free()
        jnr.ffi.Pointer alt_CPlayerConnectEvent_Create_3(jnr.ffi.Pointer _target);

        // Return ptr must be manually freed with alt_CPlayerConnectEvent_free()
        jnr.ffi.Pointer alt_CPlayerConnectEvent_Create_4(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerConnectEvent_free()
        jnr.ffi.Pointer alt_CPlayerConnectEvent_Create_5(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_CPlayerConnectEvent_GetReason(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_CPlayerConnectEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerConnectEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerConnectEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerConnectEvent_free(jnr.ffi.Pointer ptr);

        void alt_CPlayerDamageEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDamageEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDamageEvent_Assign_constCPlayerDamageEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDamageEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CPlayerDamageEvent_free()
        jnr.ffi.Pointer alt_CPlayerDamageEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CPlayerDamageEvent_free()
        jnr.ffi.Pointer alt_CPlayerDamageEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerDamageEvent_free()
        jnr.ffi.Pointer alt_CPlayerDamageEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerDamageEvent_free()
        jnr.ffi.Pointer alt_CPlayerDamageEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _attacker, @jnr.ffi.types.u_int16_t short _damage, @jnr.ffi.types.u_int32_t int _weapon);

        // Return ptr must be manually freed with alt_CPlayerDamageEvent_free()
        jnr.ffi.Pointer alt_CPlayerDamageEvent_Create_4(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CPlayerDamageEvent_GetAttacker(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_CPlayerDamageEvent_GetDamage(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_CPlayerDamageEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerDamageEvent_GetType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_CPlayerDamageEvent_GetWeapon(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerDamageEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerDamageEvent_free(jnr.ffi.Pointer ptr);

        void alt_CPlayerDeathEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDeathEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDeathEvent_Assign_constCPlayerDeathEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDeathEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CPlayerDeathEvent_free()
        jnr.ffi.Pointer alt_CPlayerDeathEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CPlayerDeathEvent_free()
        jnr.ffi.Pointer alt_CPlayerDeathEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerDeathEvent_free()
        jnr.ffi.Pointer alt_CPlayerDeathEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerDeathEvent_free()
        jnr.ffi.Pointer alt_CPlayerDeathEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _killer, @jnr.ffi.types.u_int32_t int _weapon);

        // Return ptr must be manually freed with alt_CPlayerDeathEvent_free()
        jnr.ffi.Pointer alt_CPlayerDeathEvent_Create_4(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CPlayerDeathEvent_GetKiller(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_CPlayerDeathEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerDeathEvent_GetType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_CPlayerDeathEvent_GetWeapon(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerDeathEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerDeathEvent_free(jnr.ffi.Pointer ptr);

        void alt_CPlayerDisconnectEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDisconnectEvent_Assign_CPlayerDisconnectEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDisconnectEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDisconnectEvent_Assign_constCPlayerDisconnectEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerDisconnectEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CPlayerDisconnectEvent_free()
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CPlayerDisconnectEvent_free()
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerDisconnectEvent_free()
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerDisconnectEvent_free()
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _reason);

        // Return ptr must be manually freed with alt_CPlayerDisconnectEvent_free()
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_Create_4(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerDisconnectEvent_free()
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_Create_5(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_GetReason(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_CPlayerDisconnectEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerDisconnectEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerDisconnectEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerDisconnectEvent_free(jnr.ffi.Pointer ptr);

        void alt_CPlayerEnterVehicleEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerEnterVehicleEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerEnterVehicleEvent_Assign_constCPlayerEnterVehicleEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerEnterVehicleEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CPlayerEnterVehicleEvent_free()
        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CPlayerEnterVehicleEvent_free()
        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerEnterVehicleEvent_free()
        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerEnterVehicleEvent_free()
        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _player, @jnr.ffi.types.u_int8_t byte _seat);

        // Return ptr must be manually freed with alt_CPlayerEnterVehicleEvent_free()
        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_Create_4(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_GetPlayer(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_CPlayerEnterVehicleEvent_GetSeat(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_CPlayerEnterVehicleEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerEnterVehicleEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerEnterVehicleEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerEnterVehicleEvent_free(jnr.ffi.Pointer ptr);

        void alt_CPlayerLeaveVehicleEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerLeaveVehicleEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerLeaveVehicleEvent_Assign_constCPlayerLeaveVehicleEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CPlayerLeaveVehicleEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CPlayerLeaveVehicleEvent_free()
        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CPlayerLeaveVehicleEvent_free()
        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerLeaveVehicleEvent_free()
        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CPlayerLeaveVehicleEvent_free()
        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_Create_3(jnr.ffi.Pointer _target, jnr.ffi.Pointer _player, @jnr.ffi.types.u_int8_t byte _seat);

        // Return ptr must be manually freed with alt_CPlayerLeaveVehicleEvent_free()
        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_Create_4(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_GetPlayer(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_CPlayerLeaveVehicleEvent_GetSeat(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_CPlayerLeaveVehicleEvent_GetTarget(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CPlayerLeaveVehicleEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CPlayerLeaveVehicleEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CPlayerLeaveVehicleEvent_free(jnr.ffi.Pointer ptr);

        void alt_CRemoveEntityEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CRemoveEntityEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CRemoveEntityEvent_Assign_constCRemoveEntityEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CRemoveEntityEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CRemoveEntityEvent_free()
        jnr.ffi.Pointer alt_CRemoveEntityEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CRemoveEntityEvent_free()
        jnr.ffi.Pointer alt_CRemoveEntityEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CRemoveEntityEvent_free()
        jnr.ffi.Pointer alt_CRemoveEntityEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CRemoveEntityEvent_free()
        jnr.ffi.Pointer alt_CRemoveEntityEvent_Create_3(jnr.ffi.Pointer _target);

        // Return ptr must be manually freed with alt_CRemoveEntityEvent_free()
        jnr.ffi.Pointer alt_CRemoveEntityEvent_Create_4(jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_CRemoveEntityEvent_GetEntity(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CRemoveEntityEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CRemoveEntityEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CRemoveEntityEvent_free(jnr.ffi.Pointer ptr);

        void alt_CServerScriptEvent_Assign_CEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CServerScriptEvent_Assign_CServerScriptEventRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CServerScriptEvent_Assign_constCEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CServerScriptEvent_Assign_constCServerScriptEventRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_CServerScriptEvent_Cancel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_CServerScriptEvent_free()
        jnr.ffi.Pointer alt_CServerScriptEvent_Create(alt_CEvent_Type _type);

        // Return ptr must be manually freed with alt_CServerScriptEvent_free()
        jnr.ffi.Pointer alt_CServerScriptEvent_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CServerScriptEvent_free()
        jnr.ffi.Pointer alt_CServerScriptEvent_Create_2(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CServerScriptEvent_free()
        jnr.ffi.Pointer alt_CServerScriptEvent_Create_3(jnr.ffi.Pointer _name, jnr.ffi.Pointer _args);

        // Return ptr must be manually freed with alt_CServerScriptEvent_free()
        jnr.ffi.Pointer alt_CServerScriptEvent_Create_4(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_CServerScriptEvent_free()
        jnr.ffi.Pointer alt_CServerScriptEvent_Create_5(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_CServerScriptEvent_GetArgs(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_CServerScriptEvent_GetName(jnr.ffi.Pointer _instance);

        alt_CEvent_Type alt_CServerScriptEvent_GetType(jnr.ffi.Pointer _instance);

        boolean alt_CServerScriptEvent_WasCancelled(jnr.ffi.Pointer _instance);

        void alt_CServerScriptEvent_free(jnr.ffi.Pointer ptr);

        void alt_IBaseObject_Assign_constIBaseObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_IBaseObject_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        alt_IBaseObject_Type alt_IBaseObject_GetType(jnr.ffi.Pointer _instance);

        void alt_IBaseObject_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IBlip_Assign_constIBaseObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IBlip_Assign_constIBlipRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IBlip_Assign_constIWorldObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_IBlip_AttachedTo(jnr.ffi.Pointer _instance);

        alt_IBlip_Type alt_IBlip_GetBlipType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_IBlip_GetDimension(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_IBlip_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        // Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
        jnr.ffi.Pointer alt_IBlip_GetPosition(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IBlip_GetTarget(jnr.ffi.Pointer _instance);

        alt_IBaseObject_Type alt_IBlip_GetType(jnr.ffi.Pointer _instance);

        boolean alt_IBlip_IsAttached(jnr.ffi.Pointer _instance);

        boolean alt_IBlip_IsGlobal(jnr.ffi.Pointer _instance);

        void alt_IBlip_SetColor(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte color);

        void alt_IBlip_SetDimension(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int dimension);

        void alt_IBlip_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IBlip_SetPosition(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos);

        void alt_IBlip_SetRoute(jnr.ffi.Pointer _instance, boolean state);

        void alt_IBlip_SetRouteColor(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte color);

        void alt_IBlip_SetSprite(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int16_t short sprite);

        void alt_ICheckpoint_Assign_constIBaseObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_ICheckpoint_Assign_constICheckpointRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_ICheckpoint_Assign_constIWorldObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        @jnr.ffi.types.u_int8_t byte alt_ICheckpoint_GetCheckpointType(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_RGBA_free()
        jnr.ffi.Pointer alt_ICheckpoint_GetColor(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_ICheckpoint_GetDimension(jnr.ffi.Pointer _instance);

        float alt_ICheckpoint_GetHeight(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_ICheckpoint_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        // Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
        jnr.ffi.Pointer alt_ICheckpoint_GetPosition(jnr.ffi.Pointer _instance);

        float alt_ICheckpoint_GetRadius(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_ICheckpoint_GetTarget(jnr.ffi.Pointer _instance);

        alt_IBaseObject_Type alt_ICheckpoint_GetType(jnr.ffi.Pointer _instance);

        boolean alt_ICheckpoint_IsEntityIn(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ent);

        boolean alt_ICheckpoint_IsGlobal(jnr.ffi.Pointer _instance);

        void alt_ICheckpoint_SetDimension(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int dimension);

        void alt_ICheckpoint_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_ICheckpoint_SetPosition(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos);

        void alt_IColShape_Assign_constIBaseObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IColShape_Assign_constIColShapeRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IColShape_Assign_constIWorldObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        alt_ColShapeType alt_IColShape_GetColshapeType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_IColShape_GetDimension(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_IColShape_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        // Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
        jnr.ffi.Pointer alt_IColShape_GetPosition(jnr.ffi.Pointer _instance);

        alt_IBaseObject_Type alt_IColShape_GetType(jnr.ffi.Pointer _instance);

        boolean alt_IColShape_IsEntityIn(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ent);

        void alt_IColShape_SetDimension(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int dimension);

        void alt_IColShape_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IColShape_SetPosition(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos);

        void alt_ICore_Assign_constICoreRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_ICore_CreateBlip(jnr.ffi.Pointer _instance, jnr.ffi.Pointer target, alt_IBlip_Type type, jnr.ffi.Pointer pos);

        jnr.ffi.Pointer alt_ICore_CreateBlip_1(jnr.ffi.Pointer _instance, jnr.ffi.Pointer target, alt_IBlip_Type type, jnr.ffi.Pointer attachTo);

        jnr.ffi.Pointer alt_ICore_CreateCheckpoint(jnr.ffi.Pointer _instance, jnr.ffi.Pointer target, @jnr.ffi.types.u_int8_t byte type, jnr.ffi.Pointer pos, float radius, float height, jnr.ffi.Pointer color);

        jnr.ffi.Pointer alt_ICore_CreateColShapeCircle(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos, float radius);

        jnr.ffi.Pointer alt_ICore_CreateColShapeCube(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos, jnr.ffi.Pointer pos2);

        jnr.ffi.Pointer alt_ICore_CreateColShapeCylinder(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos, float radius, float height);

        jnr.ffi.Pointer alt_ICore_CreateColShapeRectangle(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos, jnr.ffi.Pointer pos2);

        jnr.ffi.Pointer alt_ICore_CreateColShapeSphere(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos, float radius);

        jnr.ffi.Pointer alt_ICore_CreateVehicle(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int model, jnr.ffi.Pointer pos, jnr.ffi.Pointer rot);

        jnr.ffi.Pointer alt_ICore_CreateVoiceChannel(jnr.ffi.Pointer _instance, boolean spatial, float maxDistance);

        void alt_ICore_DestroyBaseObject(jnr.ffi.Pointer _instance, jnr.ffi.Pointer handle);

        // Return ptr must be manually freed with alt_Array_IEntityPtr_free()
        jnr.ffi.Pointer alt_ICore_GetEntities(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_ICore_GetEntityByID(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int16_t short id);

        @jnr.ffi.types.u_int32_t int alt_ICore_GetNetTime(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Array_IPlayerPtr_free()
        jnr.ffi.Pointer alt_ICore_GetPlayers(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Array_IPlayerPtr_free()
        jnr.ffi.Pointer alt_ICore_GetPlayersByName(jnr.ffi.Pointer _instance, jnr.ffi.Pointer name);

        jnr.ffi.Pointer alt_ICore_GetResource(jnr.ffi.Pointer _instance, jnr.ffi.Pointer name);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_ICore_GetRootDirectory(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Array_IVehiclePtr_free()
        jnr.ffi.Pointer alt_ICore_GetVehicles(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_ICore_Hash(jnr.ffi.Pointer _instance, jnr.ffi.Pointer str);

        jnr.ffi.Pointer alt_ICore_Instance();

        void alt_ICore_LogColored(jnr.ffi.Pointer _instance, jnr.ffi.Pointer str);

        void alt_ICore_LogDebug(jnr.ffi.Pointer _instance, jnr.ffi.Pointer str);

        void alt_ICore_LogError(jnr.ffi.Pointer _instance, jnr.ffi.Pointer str);

        void alt_ICore_LogInfo(jnr.ffi.Pointer _instance, jnr.ffi.Pointer str);

        void alt_ICore_LogWarning(jnr.ffi.Pointer _instance, jnr.ffi.Pointer str);

        boolean alt_ICore_RegisterScriptRuntime(jnr.ffi.Pointer _instance, jnr.ffi.Pointer resourceType, jnr.ffi.Pointer runtime);

        void alt_ICore_SetInstance(jnr.ffi.Pointer server);

        void alt_ICore_TriggerClientEvent(jnr.ffi.Pointer _instance, jnr.ffi.Pointer target, jnr.ffi.Pointer ev, jnr.ffi.Pointer args);

        void alt_ICore_TriggerServerEvent(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ev, jnr.ffi.Pointer args);

        void alt_IEntity_Assign_constIBaseObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IEntity_Assign_constIEntityRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IEntity_Assign_constIWorldObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        @jnr.ffi.types.int32_t int alt_IEntity_GetDimension(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IEntity_GetID(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_IEntity_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        @jnr.ffi.types.u_int32_t int alt_IEntity_GetModel(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
        jnr.ffi.Pointer alt_IEntity_GetPosition(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Vector_float_3_RotationLayout_free()
        jnr.ffi.Pointer alt_IEntity_GetRotation(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_IEntity_GetSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        alt_IBaseObject_Type alt_IEntity_GetType(jnr.ffi.Pointer _instance);

        void alt_IEntity_SetDimension(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int dimension);

        void alt_IEntity_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IEntity_SetPosition(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos);

        void alt_IEntity_SetRotation(jnr.ffi.Pointer _instance, jnr.ffi.Pointer rot);

        void alt_IEntity_SetSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IPackage_CloseFile(jnr.ffi.Pointer _instance, jnr.ffi.Pointer file);

        boolean alt_IPackage_FileExists(jnr.ffi.Pointer _instance, jnr.ffi.Pointer path);

        void alt_IPackage_File_Assign_constIPackage_FileRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        @jnr.ffi.types.u_int64_t long alt_IPackage_GetFileSize(jnr.ffi.Pointer _instance, jnr.ffi.Pointer file);

        alt_IPackage_Mode alt_IPackage_GetMode(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IPackage_OpenFile(jnr.ffi.Pointer _instance, jnr.ffi.Pointer path);

        @jnr.ffi.types.u_int64_t long alt_IPackage_ReadFile(jnr.ffi.Pointer _instance, jnr.ffi.Pointer file, jnr.ffi.Pointer buffer, @jnr.ffi.types.u_int64_t long size);

        void alt_IPackage_SeekFile(jnr.ffi.Pointer _instance, jnr.ffi.Pointer file, @jnr.ffi.types.u_int64_t long offset, alt_IPackage_SeekOrigin origin);

        @jnr.ffi.types.u_int64_t long alt_IPackage_TellFile(jnr.ffi.Pointer _instance, jnr.ffi.Pointer file);

        @jnr.ffi.types.u_int64_t long alt_IPackage_WriteFile(jnr.ffi.Pointer _instance, jnr.ffi.Pointer file, jnr.ffi.Pointer buffer, @jnr.ffi.types.u_int64_t long size);

        void alt_IPlayer_AddWeaponComponent(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int weapon, @jnr.ffi.types.u_int32_t int component);

        void alt_IPlayer_Assign_constIBaseObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IPlayer_Assign_constIEntityRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IPlayer_Assign_constIPlayerRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IPlayer_Assign_constIWorldObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IPlayer_Despawn(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
        jnr.ffi.Pointer alt_IPlayer_GetAimPos(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IPlayer_GetAmmo(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IPlayer_GetArmour(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_IPlayer_GetAuthToken(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IPlayer_GetCurrentWeapon(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Array_unsignedint_free()
        jnr.ffi.Pointer alt_IPlayer_GetCurrentWeaponComponents(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IPlayer_GetCurrentWeaponTintIndex(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_IPlayer_GetDimension(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
        jnr.ffi.Pointer alt_IPlayer_GetEntityAimOffset(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IPlayer_GetEntityAimingAt(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Vector_float_3_RotationLayout_free()
        jnr.ffi.Pointer alt_IPlayer_GetHeadRotation(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IPlayer_GetHealth(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IPlayer_GetHwidExHash(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IPlayer_GetHwidHash(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IPlayer_GetID(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_IPlayer_GetIP(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IPlayer_GetMaxArmour(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IPlayer_GetMaxHealth(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_IPlayer_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        @jnr.ffi.types.u_int32_t int alt_IPlayer_GetModel(jnr.ffi.Pointer _instance);

        float alt_IPlayer_GetMoveSpeed(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_IPlayer_GetName(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IPlayer_GetPing(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
        jnr.ffi.Pointer alt_IPlayer_GetPosition(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Vector_float_3_RotationLayout_free()
        jnr.ffi.Pointer alt_IPlayer_GetRotation(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IPlayer_GetSeat(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_IPlayer_GetSocialID(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_IPlayer_GetSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        alt_IBaseObject_Type alt_IPlayer_GetType(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IPlayer_GetVehicle(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IPlayer_GetWeapon(jnr.ffi.Pointer _instance);

        void alt_IPlayer_GiveWeapon(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int weapon, @jnr.ffi.types.int32_t int ammo, boolean selectWeapon);

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

        void alt_IPlayer_SetSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IPlayer_SetWeaponTintIndex(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int weapon, @jnr.ffi.types.u_int8_t byte tintIndex);

        void alt_IPlayer_SetWeather(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int32_t int weather);

        void alt_IPlayer_Spawn(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos, @jnr.ffi.types.u_int32_t int delayMs);

        void alt_IResource_Assign_constIResourceRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IResource_CreationInfo_Assign_IResource_CreationInfoRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_IResource_CreationInfo_free()
        jnr.ffi.Pointer alt_IResource_CreationInfo_Create(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_IResource_CreationInfo_free()
        jnr.ffi.Pointer alt_IResource_CreationInfo_Create_1(jnr.ffi.Pointer _p0);

        void alt_IResource_CreationInfo_free(jnr.ffi.Pointer ptr);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_IResource_GetExports(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IResource_GetImpl(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_IResource_GetMain(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_IResource_GetName(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IResource_GetPackage(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_IResource_GetPath(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_IResource_GetRuntime(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_IResource_GetType(jnr.ffi.Pointer _instance);

        void alt_IResource_Impl_Assign_constIResource_ImplRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        boolean alt_IResource_Impl_MakeClient(jnr.ffi.Pointer _instance, jnr.ffi.Pointer info, jnr.ffi.Pointer files);

        void alt_IResource_Impl_OnCreateBaseObject(jnr.ffi.Pointer _instance, jnr.ffi.Pointer object);

        boolean alt_IResource_Impl_OnEvent(jnr.ffi.Pointer _instance, jnr.ffi.Pointer ev);

        void alt_IResource_Impl_OnRemoveBaseObject(jnr.ffi.Pointer _instance, jnr.ffi.Pointer object);

        void alt_IResource_Impl_OnTick(jnr.ffi.Pointer _instance);

        boolean alt_IResource_Impl_Start(jnr.ffi.Pointer _instance);

        boolean alt_IResource_Impl_Stop(jnr.ffi.Pointer _instance);

        boolean alt_IResource_IsStarted(jnr.ffi.Pointer _instance);

        void alt_IResource_SetExports(jnr.ffi.Pointer _instance, jnr.ffi.Pointer exports);

        void alt_IScriptRuntime_Assign_constIScriptRuntimeRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        jnr.ffi.Pointer alt_IScriptRuntime_CreateImpl(jnr.ffi.Pointer _instance, jnr.ffi.Pointer resource);

        void alt_IScriptRuntime_DestroyImpl(jnr.ffi.Pointer _instance, jnr.ffi.Pointer impl);

        void alt_IScriptRuntime_OnTick(jnr.ffi.Pointer _instance);

        void alt_IVehicle_Assign_constIBaseObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IVehicle_Assign_constIEntityRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IVehicle_Assign_constIVehicleRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IVehicle_Assign_constIWorldObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        boolean alt_IVehicle_DoesWheelHasTire(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_IVehicle_GetAppearanceDataBase64(jnr.ffi.Pointer _instance);

        float alt_IVehicle_GetArmoredWindowHealth(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetArmoredWindowShootCount(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId);

        @jnr.ffi.types.u_int32_t int alt_IVehicle_GetBodyAdditionalHealth(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IVehicle_GetBodyHealth(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetBumperDamageLevel(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte bumperId);

        boolean alt_IVehicle_GetCustomTires(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_IVehicle_GetDamageDataBase64(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetDashboardColor(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_IVehicle_GetDimension(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetDirtLevel(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetDoorState(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte doorId);

        jnr.ffi.Pointer alt_IVehicle_GetDriver(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_IVehicle_GetEngineHealth(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_IVehicle_GetGameStateBase64(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetHeadlightColor(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_IVehicle_GetHealthDataBase64(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int16_t short alt_IVehicle_GetID(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetInteriorColor(jnr.ffi.Pointer _instance);

        float alt_IVehicle_GetLightsMultiplier(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetLivery(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetLockState(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_IVehicle_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetMod(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte category);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetModKit(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetModKitsCount(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IVehicle_GetModel(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetModsCount(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte category);

        void alt_IVehicle_GetNeonActive(jnr.ffi.Pointer _instance, jnr.ffi.Pointer left, jnr.ffi.Pointer right, jnr.ffi.Pointer front, jnr.ffi.Pointer back);

        // Return ptr must be manually freed with alt_RGBA_free()
        jnr.ffi.Pointer alt_IVehicle_GetNeonColor(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IVehicle_GetNumberplateIndex(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_IVehicle_GetNumberplateText(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetPartBulletHoles(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte partId);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetPartDamageLevel(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte partId);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetPearlColor(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int32_t int alt_IVehicle_GetPetrolTankHealth(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
        jnr.ffi.Pointer alt_IVehicle_GetPosition(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetPrimaryColor(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_RGBA_free()
        jnr.ffi.Pointer alt_IVehicle_GetPrimaryColorRGB(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int32_t int alt_IVehicle_GetRadioStationIndex(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetRepairsCount(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetRoofLivery(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Vector_float_3_RotationLayout_free()
        jnr.ffi.Pointer alt_IVehicle_GetRotation(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_IVehicle_GetScriptDataBase64(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetSecondaryColor(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_RGBA_free()
        jnr.ffi.Pointer alt_IVehicle_GetSecondaryColorRGB(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetSpecialDarkness(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_IVehicle_GetSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        // Return ptr must be manually freed with alt_RGBA_free()
        jnr.ffi.Pointer alt_IVehicle_GetTireSmokeColor(jnr.ffi.Pointer _instance);

        alt_IBaseObject_Type alt_IVehicle_GetType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetWheelColor(jnr.ffi.Pointer _instance);

        float alt_IVehicle_GetWheelHealth(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetWheelType(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetWheelVariation(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetWheelsCount(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int8_t byte alt_IVehicle_GetWindowTint(jnr.ffi.Pointer _instance);

        boolean alt_IVehicle_HasArmoredWindows(jnr.ffi.Pointer _instance);

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

        boolean alt_IVehicle_IsWindowDamaged(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId);

        boolean alt_IVehicle_IsWindowOpened(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId);

        void alt_IVehicle_LoadAppearanceDataFromBase64(jnr.ffi.Pointer _instance, jnr.ffi.Pointer base64);

        void alt_IVehicle_LoadDamageDataFromBase64(jnr.ffi.Pointer _instance, jnr.ffi.Pointer base64);

        void alt_IVehicle_LoadGameStateFromBase64(jnr.ffi.Pointer _instance, jnr.ffi.Pointer base64);

        void alt_IVehicle_LoadHealthDataFromBase64(jnr.ffi.Pointer _instance, jnr.ffi.Pointer base64);

        void alt_IVehicle_LoadScriptDataFromBase64(jnr.ffi.Pointer _instance, jnr.ffi.Pointer base64);

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

        void alt_IVehicle_SetRoofLivery(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte roofLivery);

        void alt_IVehicle_SetRoofOpened(jnr.ffi.Pointer _instance, boolean state);

        void alt_IVehicle_SetRotation(jnr.ffi.Pointer _instance, jnr.ffi.Pointer rot);

        void alt_IVehicle_SetSecondaryColor(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte color);

        void alt_IVehicle_SetSecondaryColorRGB(jnr.ffi.Pointer _instance, jnr.ffi.Pointer color);

        void alt_IVehicle_SetSirenActive(jnr.ffi.Pointer _instance, boolean state);

        void alt_IVehicle_SetSpecialDarkness(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte value);

        void alt_IVehicle_SetSpecialLightDamaged(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte specialLightId, boolean isDamaged);

        void alt_IVehicle_SetSyncedMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IVehicle_SetTireSmokeColor(jnr.ffi.Pointer _instance, jnr.ffi.Pointer color);

        void alt_IVehicle_SetWheelBurst(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId, boolean state);

        void alt_IVehicle_SetWheelColor(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte color);

        void alt_IVehicle_SetWheelHasTire(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId, boolean state);

        void alt_IVehicle_SetWheelHealth(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte wheelId, float health);

        void alt_IVehicle_SetWheels(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte type, @jnr.ffi.types.u_int8_t byte variation);

        void alt_IVehicle_SetWindowDamaged(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId, boolean isDamaged);

        void alt_IVehicle_SetWindowOpened(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte windowId, boolean state);

        void alt_IVehicle_SetWindowTint(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte tint);

        void alt_IVehicle_ToggleExtra(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int8_t byte extraID, boolean state);

        void alt_IVoiceChannel_AddPlayer(jnr.ffi.Pointer _instance, jnr.ffi.Pointer player);

        void alt_IVoiceChannel_Assign_constIBaseObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IVoiceChannel_Assign_constIVoiceChannelRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        float alt_IVoiceChannel_GetMaxDistance(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_IVoiceChannel_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        alt_IBaseObject_Type alt_IVoiceChannel_GetType(jnr.ffi.Pointer _instance);

        boolean alt_IVoiceChannel_IsPlayerConnected(jnr.ffi.Pointer _instance, jnr.ffi.Pointer player);

        boolean alt_IVoiceChannel_IsPlayerMuted(jnr.ffi.Pointer _instance, jnr.ffi.Pointer player);

        boolean alt_IVoiceChannel_IsSpatial(jnr.ffi.Pointer _instance);

        void alt_IVoiceChannel_MutePlayer(jnr.ffi.Pointer _instance, jnr.ffi.Pointer player);

        void alt_IVoiceChannel_RemovePlayer(jnr.ffi.Pointer _instance, jnr.ffi.Pointer player);

        void alt_IVoiceChannel_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IVoiceChannel_UnmutePlayer(jnr.ffi.Pointer _instance, jnr.ffi.Pointer player);

        void alt_IWorldObject_Assign_constIBaseObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_IWorldObject_Assign_constIWorldObjectRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        @jnr.ffi.types.int32_t int alt_IWorldObject_GetDimension(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_IWorldObject_GetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        // Return ptr must be manually freed with alt_Vector_float_3_PointLayout_free()
        jnr.ffi.Pointer alt_IWorldObject_GetPosition(jnr.ffi.Pointer _instance);

        alt_IBaseObject_Type alt_IWorldObject_GetType(jnr.ffi.Pointer _instance);

        void alt_IWorldObject_SetDimension(jnr.ffi.Pointer _instance, @jnr.ffi.types.int32_t int dimension);

        void alt_IWorldObject_SetMetaData(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key, jnr.ffi.Pointer val);

        void alt_IWorldObject_SetPosition(jnr.ffi.Pointer _instance, jnr.ffi.Pointer pos);

        jnr.ffi.Pointer alt_MValueDict_Access_constMValue_StringRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        void alt_MValueDict_Assign_MValueDictRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_MValueDict_Assign_constMValueRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create();

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_1(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_10(@jnr.ffi.types.int32_t int val);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_11(@jnr.ffi.types.u_int32_t int val);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_12(@jnr.ffi.annotations.Encoding("UTF-8") String val);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_14(jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_15();

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_17(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_18(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_19(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_2(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_3(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_4(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_5(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_6(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_8(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueDict_free()
        jnr.ffi.Pointer alt_MValueDict_Create_9(jnr.ffi.Pointer val);

        void alt_MValueDict_Delete(jnr.ffi.Pointer _instance, jnr.ffi.Pointer key);

        alt_MValue_Type alt_MValueDict_GetType(jnr.ffi.Pointer _instance);

        boolean alt_MValueDict_ToBool(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int64_t long alt_MValueDict_ToInt(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_MValueDict_ToString(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_MValueDict_ToUInt(jnr.ffi.Pointer _instance);

        void alt_MValueDict_free(jnr.ffi.Pointer ptr);

        void alt_MValueFunction_Assign_MValueFunctionRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_MValueFunction_Assign_constMValueRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create();

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_1(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_10(@jnr.ffi.types.int32_t int val);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_11(@jnr.ffi.types.u_int32_t int val);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_12(@jnr.ffi.annotations.Encoding("UTF-8") String val);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_14(jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_15(jnr.ffi.Pointer func);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_16(jnr.ffi.Pointer invoker);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_17(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_18(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_19(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_2(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_3(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_4(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_5(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_6(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_8(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueFunction_free()
        jnr.ffi.Pointer alt_MValueFunction_Create_9(jnr.ffi.Pointer val);

        jnr.ffi.Pointer alt_MValueFunction_GetInvoker(jnr.ffi.Pointer _instance);

        alt_MValue_Type alt_MValueFunction_GetType(jnr.ffi.Pointer _instance);

        void alt_MValueFunction_Invoker_Assign_MValueFunction_InvokerRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_MValueFunction_Invoker_Assign_constMValueFunction_InvokerRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValueFunction_Invoker_Invoke(jnr.ffi.Pointer _instance, jnr.ffi.Pointer args);

        void alt_MValueFunction_Invoker_free(jnr.ffi.Pointer ptr);

        boolean alt_MValueFunction_ToBool(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int64_t long alt_MValueFunction_ToInt(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_MValueFunction_ToString(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_MValueFunction_ToUInt(jnr.ffi.Pointer _instance);

        void alt_MValueFunction_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_MValueList_Access_uint64_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_MValueList_Assign_MValueListRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_MValueList_Assign_constMValueListRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_MValueList_Assign_constMValueRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create();

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_1(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_10(@jnr.ffi.types.int32_t int val);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_11(@jnr.ffi.types.u_int32_t int val);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_12(@jnr.ffi.annotations.Encoding("UTF-8") String val);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_14(jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_15();

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_16(@jnr.ffi.types.u_int64_t long size);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_17(jnr.ffi.Pointer list);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_18(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_19(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_2(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_20(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_3(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_4(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_5(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_6(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_8(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValueList_free()
        jnr.ffi.Pointer alt_MValueList_Create_9(jnr.ffi.Pointer val);

        @jnr.ffi.types.u_int64_t long alt_MValueList_GetSize(jnr.ffi.Pointer _instance);

        alt_MValue_Type alt_MValueList_GetType(jnr.ffi.Pointer _instance);

        void alt_MValueList_Push(jnr.ffi.Pointer _instance, jnr.ffi.Pointer val);

        boolean alt_MValueList_ToBool(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int64_t long alt_MValueList_ToInt(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_MValueList_ToString(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_MValueList_ToUInt(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_Array_MValue_free()
        jnr.ffi.Pointer alt_MValueList_To_Array_MValue(jnr.ffi.Pointer _instance);

        void alt_MValueList_free(jnr.ffi.Pointer ptr);

        void alt_MValue_Assign_constMValueRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValue_Create();

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValue_Create_1(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValue_Create_10(@jnr.ffi.types.int32_t int val);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValue_Create_11(@jnr.ffi.types.u_int32_t int val);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValue_Create_12(@jnr.ffi.annotations.Encoding("UTF-8") String val);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValue_Create_14(jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValue_Create_2(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValue_Create_3(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValue_Create_4(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValue_Create_5(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValue_Create_6(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValue_Create_8(jnr.ffi.Pointer val);

        // Return ptr must be manually freed with alt_MValue_free()
        jnr.ffi.Pointer alt_MValue_Create_9(jnr.ffi.Pointer val);

        void alt_MValue_Function_Assign_MValue_FunctionRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_MValue_Function_Assign_constMValue_FunctionRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValue_Function_free()
        jnr.ffi.Pointer alt_MValue_Function_Create();

        // Return ptr must be manually freed with alt_MValue_Function_free()
        jnr.ffi.Pointer alt_MValue_Function_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValue_Function_free()
        jnr.ffi.Pointer alt_MValue_Function_Create_2(jnr.ffi.Pointer _p0);

        void alt_MValue_Function_free(jnr.ffi.Pointer ptr);

        alt_MValue_Type alt_MValue_GetType(jnr.ffi.Pointer _instance);

        boolean alt_MValue_ToBool(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.int64_t long alt_MValue_ToInt(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_MValue_ToString(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_MValue_ToUInt(jnr.ffi.Pointer _instance);

        void alt_MValue_TypeMismatchException_Assign_MValue_TypeMismatchExceptionRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_MValue_TypeMismatchException_Assign_constMValue_TypeMismatchExceptionRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValue_TypeMismatchException_free()
        jnr.ffi.Pointer alt_MValue_TypeMismatchException_Create(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValue_TypeMismatchException_free()
        jnr.ffi.Pointer alt_MValue_TypeMismatchException_Create_1(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_MValue_TypeMismatchException_free()
        jnr.ffi.Pointer alt_MValue_TypeMismatchException_Create_2();

        void alt_MValue_TypeMismatchException_free(jnr.ffi.Pointer ptr);

        @jnr.ffi.annotations.Encoding("UTF-8") String alt_MValue_TypeMismatchException_what(jnr.ffi.Pointer _instance);

        jnr.ffi.Pointer alt_PointLayout_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_PointLayout_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        // Return ptr must be manually freed with alt_PointLayout_free()
        jnr.ffi.Pointer alt_PointLayout_Create();

        // Return ptr must be manually freed with alt_PointLayout_free()
        jnr.ffi.Pointer alt_PointLayout_Create_1(float _x, float _y, float _z);

        // Return ptr must be manually freed with alt_PointLayout_free()
        jnr.ffi.Pointer alt_PointLayout_Create_2(jnr.ffi.Pointer elements);

        // Return ptr must be manually freed with alt_PointLayout_free()
        jnr.ffi.Pointer alt_PointLayout_Create_3(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_PointLayout_free()
        jnr.ffi.Pointer alt_PointLayout_Create_4(jnr.ffi.Pointer _p0);

        void alt_PointLayout_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_PointPaddedLayout_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_PointPaddedLayout_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        // Return ptr must be manually freed with alt_PointPaddedLayout_free()
        jnr.ffi.Pointer alt_PointPaddedLayout_Create();

        // Return ptr must be manually freed with alt_PointPaddedLayout_free()
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_1(float _x, float _y, float _z);

        // Return ptr must be manually freed with alt_PointPaddedLayout_free()
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_2(jnr.ffi.Pointer elements);

        // Return ptr must be manually freed with alt_PointPaddedLayout_free()
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_3(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_PointPaddedLayout_free()
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_4(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_PointPaddedLayout_free()
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_5();

        // Return ptr must be manually freed with alt_PointPaddedLayout_free()
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_6(float x, float y, float z);

        // Return ptr must be manually freed with alt_PointPaddedLayout_free()
        jnr.ffi.Pointer alt_PointPaddedLayout_Create_7(jnr.ffi.Pointer elements);

        void alt_PointPaddedLayout_free(jnr.ffi.Pointer ptr);

        // Return ptr must be manually freed with alt_RGBA_free()
        jnr.ffi.Pointer alt_RGBA_Create();

        // Return ptr must be manually freed with alt_RGBA_free()
        jnr.ffi.Pointer alt_RGBA_Create_1(@jnr.ffi.types.u_int8_t byte _r, @jnr.ffi.types.u_int8_t byte _g, @jnr.ffi.types.u_int8_t byte _b, @jnr.ffi.types.u_int8_t byte _a);

        void alt_RGBA_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RotationLayout_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_RotationLayout_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        // Return ptr must be manually freed with alt_RotationLayout_free()
        jnr.ffi.Pointer alt_RotationLayout_Create(float _roll, float _pitch, float _yaw);

        // Return ptr must be manually freed with alt_RotationLayout_free()
        jnr.ffi.Pointer alt_RotationLayout_Create_1();

        // Return ptr must be manually freed with alt_RotationLayout_free()
        jnr.ffi.Pointer alt_RotationLayout_Create_2(jnr.ffi.Pointer elements);

        // Return ptr must be manually freed with alt_RotationLayout_free()
        jnr.ffi.Pointer alt_RotationLayout_Create_3(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_RotationLayout_free()
        jnr.ffi.Pointer alt_RotationLayout_Create_4(jnr.ffi.Pointer _p0);

        void alt_RotationLayout_Normalize(jnr.ffi.Pointer _instance);

        void alt_RotationLayout_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_RotationPaddedLayout_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_RotationPaddedLayout_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        // Return ptr must be manually freed with alt_RotationPaddedLayout_free()
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create(float _roll, float _pitch, float _yaw);

        // Return ptr must be manually freed with alt_RotationPaddedLayout_free()
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_1();

        // Return ptr must be manually freed with alt_RotationPaddedLayout_free()
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_2(jnr.ffi.Pointer elements);

        // Return ptr must be manually freed with alt_RotationPaddedLayout_free()
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_3(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_RotationPaddedLayout_free()
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_4(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_RotationPaddedLayout_free()
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_5();

        // Return ptr must be manually freed with alt_RotationPaddedLayout_free()
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_6(float roll, float pitch, float yaw);

        // Return ptr must be manually freed with alt_RotationPaddedLayout_free()
        jnr.ffi.Pointer alt_RotationPaddedLayout_Create_7(jnr.ffi.Pointer elements);

        void alt_RotationPaddedLayout_Normalize(jnr.ffi.Pointer _instance);

        void alt_RotationPaddedLayout_free(jnr.ffi.Pointer ptr);

        @jnr.ffi.types.int8_t byte alt_StringView_Access_uint64_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_StringView_Assign_StringViewRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_StringView_Assign_constStringViewRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        @jnr.ffi.annotations.Encoding("UTF-8") String alt_StringView_CStr(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_StringView_Create(@jnr.ffi.annotations.Encoding("UTF-8") String _data, @jnr.ffi.types.u_int64_t long _size);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_StringView_Create_1();

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_StringView_Create_2(@jnr.ffi.annotations.Encoding("UTF-8") String _str);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_StringView_Create_4(jnr.ffi.Pointer _str);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_StringView_Create_6(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_StringView_free()
        jnr.ffi.Pointer alt_StringView_Create_7(jnr.ffi.Pointer _p0);

        boolean alt_StringView_Equals_StringView(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        @jnr.ffi.annotations.Encoding("UTF-8") String alt_StringView_GetData(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_StringView_GetSize(jnr.ffi.Pointer _instance);

        boolean alt_StringView_IsEmpty(jnr.ffi.Pointer _instance);

        boolean alt_StringView_NotEquals_StringView(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_StringView_To_String(jnr.ffi.Pointer _instance);

        void alt_StringView_free(jnr.ffi.Pointer ptr);

        @jnr.ffi.annotations.Encoding("UTF-8") String alt_String_Access_uint64_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        @jnr.ffi.types.int8_t byte alt_String_Access_uint64_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_String_Assign_StringRefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        void alt_String_Assign_constStringRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        @jnr.ffi.annotations.Encoding("UTF-8") String alt_String_CStr(jnr.ffi.Pointer _instance);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_String_Create(@jnr.ffi.types.u_int64_t long _size, @jnr.ffi.types.int8_t byte fill);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_String_Create_1(@jnr.ffi.annotations.Encoding("UTF-8") String _data, @jnr.ffi.types.u_int64_t long size);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_String_Create_2();

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_String_Create_3(@jnr.ffi.annotations.Encoding("UTF-8") String _str);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_String_Create_5(jnr.ffi.Pointer that);

        // Return ptr must be manually freed with alt_String_free()
        jnr.ffi.Pointer alt_String_Create_6(jnr.ffi.Pointer that);

        boolean alt_String_Equals_String(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        @jnr.ffi.annotations.Encoding("UTF-8") String alt_String_GetData(jnr.ffi.Pointer _instance);

        @jnr.ffi.annotations.Encoding("UTF-8") String alt_String_GetData_1(jnr.ffi.Pointer _instance);

        @jnr.ffi.types.u_int64_t long alt_String_GetSize(jnr.ffi.Pointer _instance);

        boolean alt_String_IsEmpty(jnr.ffi.Pointer _instance);

        boolean alt_String_NotEquals_String(jnr.ffi.Pointer _instance, jnr.ffi.Pointer that);

        jnr.ffi.Pointer alt_VectorLayout_float_4_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_VectorLayout_float_4_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_VectorLayout_float_4_Assign_VectorLayout_float_4RefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_VectorLayout_float_4_Assign_constVectorLayout_float_4Ref(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_VectorLayout_float_4_Create();

        // Return ptr must be manually freed with alt_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_VectorLayout_float_4_Create_1(jnr.ffi.Pointer _elements);

        // Return ptr must be manually freed with alt_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_VectorLayout_float_4_Create_2(jnr.ffi.Pointer el);

        // Return ptr must be manually freed with alt_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_VectorLayout_float_4_Create_3(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_VectorLayout_float_4_Create_4(jnr.ffi.Pointer _p0);

        void alt_VectorLayout_float_4_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        void alt_Vector_float_4_VectorLayout_float_4_Assign_VectorLayout_float_4RefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_Vector_float_4_VectorLayout_float_4_Assign_Vector_float_4_VectorLayout_float_4RefRef(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_Vector_float_4_VectorLayout_float_4_Assign_constVectorLayout_float_4Ref(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        void alt_Vector_float_4_VectorLayout_float_4_Assign_constVector_float_4_VectorLayout_float_4Ref(jnr.ffi.Pointer _instance, jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create();

        // Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_1(jnr.ffi.Pointer _elements);

        // Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_2(jnr.ffi.Pointer el);

        // Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_3(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_4(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_5();

        // Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_6(jnr.ffi.Pointer _elements);

        // Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_7(jnr.ffi.Pointer layout);

        // Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_8(jnr.ffi.Pointer _p0);

        // Return ptr must be manually freed with alt_Vector_float_4_VectorLayout_float_4_free()
        jnr.ffi.Pointer alt_Vector_float_4_VectorLayout_float_4_Create_9(jnr.ffi.Pointer _p0);

        float alt_Vector_float_4_VectorLayout_float_4_Length(jnr.ffi.Pointer _instance);

        float alt_Vector_float_4_VectorLayout_float_4_LengthSqr(jnr.ffi.Pointer _instance);

        void alt_Vector_float_4_VectorLayout_float_4_free(jnr.ffi.Pointer ptr);

        jnr.ffi.Pointer alt_ViewMatrixLayout_Access_size_t(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        jnr.ffi.Pointer alt_ViewMatrixLayout_Access_size_t_1(jnr.ffi.Pointer _instance, @jnr.ffi.types.u_int64_t long key);

        // Return ptr must be manually freed with alt_ViewMatrixLayout_free()
        jnr.ffi.Pointer alt_ViewMatrixLayout_Create();

        // Return ptr must be manually freed with alt_ViewMatrixLayout_free()
        jnr.ffi.Pointer alt_ViewMatrixLayout_Create_1(jnr.ffi.Pointer _rows);

        // Return ptr must be manually freed with alt_ViewMatrixLayout_free()
        jnr.ffi.Pointer alt_ViewMatrixLayout_Create_2(jnr.ffi.Pointer row);

        // Return ptr must be manually freed with alt_ViewMatrixLayout_free()
        jnr.ffi.Pointer alt_ViewMatrixLayout_Create_3(jnr.ffi.Pointer elements);

        // Return ptr must be manually freed with alt_ViewMatrixLayout_free()
        jnr.ffi.Pointer alt_ViewMatrixLayout_Create_4(jnr.ffi.Pointer _right, jnr.ffi.Pointer _up, jnr.ffi.Pointer _forward, jnr.ffi.Pointer _pos);

        void alt_ViewMatrixLayout_free(jnr.ffi.Pointer ptr);

    }
}
