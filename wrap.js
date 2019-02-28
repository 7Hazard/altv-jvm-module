const execSync = require('child_process').execSync;
const fs = require("fs")

function getJavaType(type, name)
{
    if(type.cname == "void")
    {
        return 'void'
    }
    else if(type.cname == "bool")
    {
        return 'boolean'
    }
    else if(type.cname == "float")
    {
        return 'float'
    }
    else if(type.cname == "size_t")
    {
        return '@jnr.ffi.types.u_int64_t long'
    }
    else if(type.isFuncPtr)
    {
        return type.cname
    }
    else if(type.isPtr || type.isParamPtr || type.isArray)
    {
        return `jnr.ffi.Pointer`
    }
    else if(type.cname == "const char *")
    {
        return `@jnr.ffi.annotations.Encoding("UTF-8") String`
    }
    else if(type.cname == "int8_t")
    {
        return `@jnr.ffi.types.int8_t byte`
    }
    else if(type.cname == "uint8_t")
    {
        return '@jnr.ffi.types.u_int8_t byte'
    }
    else if(type.cname == "uint16_t")
    {
        return '@jnr.ffi.types.u_int16_t short'
    }
    else if(type.cname == "uint32_t")
    {
        return '@jnr.ffi.types.u_int32_t int'
    }
    else if(type.cname == "int64_t")
    {
        return '@jnr.ffi.types.int64_t long'
    }
    else if(type.cname == "uint64_t")
    {
        return '@jnr.ffi.types.u_int64_t long'
    }
    else {
        console.warn(`Unrecognized type "${type.cname}", returning ${type.cname}`)
        return type.cname
    }
}

function getJavaStructType(type)
{
    if(type.cname == "void")
    {
        return 'void'
    }
    else if(type.cname == "bool")
    {
        return "jnr.ffi.Struct.Boolean"
    }
    else if(type.cname == "float")
    {
        return "jnr.ffi.Struct.Float"
    }
    else if(type.cname == "size_t")
    {
        return "jnr.ffi.Struct.u_int64_t"
    }
    else if (type.isFuncPtr)
    {
        return type.cname
    }
    else if(type.isPtr || type.isArray)
    {
        return "jnr.ffi.Struct.Pointer"
    }
    else if(type.cname == "const char *")
    {
        return "jnr.ffi.Struct.UTF8StringRef"
    }
    else if(type.cname == "int8_t")
    {
        return "jnr.ffi.Struct.int8_t"
    }
    else if(type.cname == "uint8_t")
    {
        return "jnr.ffi.Struct.u_int8_t"
    }
    else if(type.cname == "uint16_t")
    {
        return "jnr.ffi.Struct.u_int16_t"
    }
    else if(type.cname == "uint32_t")
    {
        return "jnr.ffi.Struct.u_int32_t"
    }
    else if(type.cname == "int64_t")
    {
        return "jnr.ffi.Struct.int64_t"
    }
    else if(type.cname == "uint64_t")
    {
        return "jnr.ffi.Struct.u_int64_t"
    }
    else if(type.isEnum)
    {
        return `jnr.ffi.Struct.Enum32<${type.cname}>`
    }
    else {
        throw "Unrecognized type for Struct Type"
    }
}

function getJavaParams(params)
{
    let jparams = []
    for (const param of params.params) {
        let jparam = `${getJavaType(param.type)} ${param.name}`
        jparams.push(jparam)
    }
    return jparams.join(", ")
}

////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

console.log("Wrapping CAPI to Java")

// Read the capi.json
let capiinfo = JSON.parse(fs.readFileSync(__dirname + "/altv-capi/build/capi.json"))

// Process all functions
let javafuncs = []
for (let [cppname, funcs] of Object.entries(capiinfo.funcs)) {
    // Loop all overloads of the function
    funcs.forEach(func => {
        // Skip instance getters
        if(func.isInstanceGetter) return

        // Add jfunc
        javafuncs.push(`${getJavaType(func.returnType)} ${func.cname}(${getJavaParams(func.params)});`)
    });
}

let javatypes = []
for (let [cppname, type] of Object.entries(capiinfo.types)) {
    if(type.isFieldStruct)
    {
        let fields = []
        let ctorparams = []
        let ctorassigns = []

        type.fields.forEach(field => {
            let stype = getJavaStructType(field.type)
            fields.push(`public final ${stype} ${field.name} = new ${stype}(${stype.startsWith("jnr.ffi.Struct.Enum") ? field.type.cname+".class" : ""});`)

            let jtype = getJavaType(field.type, false, "@jnr.ffi.types.int32_t int")
            ctorparams.push(`${jtype} ${field.name}`)
            ctorassigns.push(`this.${field.name}.set(${field.name});`)
        });

        let javatype = 
`
    public static class ${type.unqualifiedCName} extends jnr.ffi.Struct
    {
        ${fields.join("\n        ")}
        
        public ${type.unqualifiedCName}()
        {
            super(runtime);
        }
        public ${type.unqualifiedCName}(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }
`
        javatypes.push(javatype)
    }
    if(type.isEnum)
    {
        let values = []
        type.values.forEach(value => {
            values.push(`${value.name}(${value.value})`)
        });

        let javatype = 
`
    public static enum ${type.unqualifiedCName} implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ${values.join(",\n        ")};
    
        ${type.unqualifiedCName}(int value) {
            this.value = value;
        }
    
        public int intValue() {
            return value;
        }
        private final int value;
    }
`
        javatypes.push(javatype)
    }
    else if(type.isFuncPtr)
    {
        let javatype = 
`
    public interface ${type.unqualifiedCName}
    {
        @jnr.ffi.annotations.Delegate public ${getJavaType(type.returnType)} callback(${getJavaParams(type.params)});
    }
`
        javatypes.push(javatype)
    }
}

// Write the java source
let javasrc =
`package alt.v.jvm;

public class CAPI
{
    public static final CAPIFunctions func = jnr.ffi.LibraryLoader.create(CAPIFunctions.class).load("altv-capi");
    public static jnr.ffi.Runtime runtime = jnr.ffi.Runtime.getRuntime(func);
    public static jnr.ffi.Pointer server;
    

    ${javatypes.join("")}

    public static interface CAPIFunctions
    {
        ${javafuncs.join("\n        ")}
    }
}
`
fs.writeFileSync(__dirname+"/src/alt/v/jvm/CAPI.java", javasrc)

console.log("Done wrapping to Java")
