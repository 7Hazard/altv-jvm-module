package alt.v.jvm;

import jnr.ffi.Memory;
import jnr.ffi.Pointer;
import jnr.ffi.Struct;

public class AltStringView implements AutoCloseable
{
    private final CAPI.alt_StringView sw = new CAPI.alt_StringView();

    /**
     * CREATING StringView THIS WAY SHOULD NOT BE CLOSED
     * @param str
     */
    public AltStringView(String str)
    {
        var buf = Memory.allocateDirect(CAPI.runtime, str.length());
        buf.putString(0, str, str.length(), StringUtil.UTF8);
        sw.data.set(buf);
        sw.size.set(str.length());
    }
    
    public AltStringView(Pointer ptr)
    {
        sw.useMemory(ptr);
    }

    public String str()
    {
        return sw.data.get().getString(0, (int)sw.size.get(), StringUtil.UTF8);
    }

    public Pointer ptr()
    {
        return Struct.getMemory(sw);
    }
    
    // public void free()
    // {
    //     CAPI.func.alt_StringView_free(Struct.getMemory(sw));
    // }

    @Override
    public void close() /*throws Exception*/ {
        CAPI.func.alt_StringView_free(Struct.getMemory(sw));
    }
}
