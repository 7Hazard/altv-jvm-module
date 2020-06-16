package hazard7.altv.jvm;

import jnr.ffi.Memory;
import jnr.ffi.Pointer;
import jnr.ffi.Struct;

/**
 * Garbage collected alt_StringView
 */
public class AltStringView
{
    private final CAPI.alt_StringView sw = new CAPI.alt_StringView();

    /**
     * Garbage collected alt_StringView
     * @param str
     */
    public AltStringView(String str)
    {
        var buf = Memory.allocateDirect(CAPI.runtime, str.length()+1); // keep +1 or else crash
        buf.putString(0, str, str.length(), StringUtil.UTF8);
        sw.data.set(buf);
        sw.size.set(str.length());
    }
    
    public AltStringView(Pointer ptr)
    {
        sw.useMemory(ptr);
    }

    /**
     * Equivilent of getting the char*
     * @return String (no explicit freeing should be done)
     */
    public String str()
    {
        var p = ptr();
        if(p == null || p.address() == 0)
        {
            return "null";
        }
        return CAPI.func.alt_StringView_CStr(Struct.getMemory(sw));
        // return sw.data.get().getString(0, (int)sw.size.get(), StringUtil.UTF8);
    }

    public Pointer ptr()
    {
        return Struct.getMemory(sw);
    }
}
