/**
 * Script for auto-wrapping CAPI to Java
 * using JNR FFI
 */

const execSync = require('child_process').execSync;
const fs = require("fs")

let TypeKind = {
    "fundamental": 0,
    "enumeral": 1,
    "reference": 2,
    "pointer": 3,
    "array": 4,
    "function_pointer": 5,
    "struct": 6,
}

let javacallbacks = []

function getJavaType(type, callbackName = "unnamedCallback"+javacallbacks.length)
{
    switch (type.kind) {
        case TypeKind.enumeral:
        {
            return type.name;
        }

        case TypeKind.array:
        case TypeKind.reference:
        case TypeKind.pointer:
        {
            if(type.name == "char*" || type.name == "const char*")
            {
                return `@jnr.ffi.annotations.Encoding("UTF-8") String`
            }

            return "jnr.ffi.Pointer";
        }
        
        case TypeKind.struct:
        {
            return type.name;
        }
        
        case TypeKind.function_pointer:
        {
            let interface = 
`
    public interface ${callbackName}
    {
        @jnr.ffi.annotations.Delegate public ${getJavaType(type.returns)} callback(${getJavaParams(type.params, callbackName)});
    }
`
            javacallbacks.push(interface)

            return callbackName
        }

        case TypeKind.fundamental:
        {
            switch (type.name) {
                case "void":
                    return "void"

                case "bool":
                case "_Bool":
                    return "boolean"

                case "float":
                    return "float"

                case "double":
                    return "double"

                case "char":
                    return "@jnr.ffi.types.int8_t byte"

                case "unsigned char":
                    return "@jnr.ffi.types.u_int8_t byte"

                case "short":
                    return "@jnr.ffi.types.int32_t int"

                case "unsigned short":
                    return "@jnr.ffi.types.u_int16_t short"

                case "int":
                        return "@jnr.ffi.types.int32_t int"

                case "unsigned int":
                    return "@jnr.ffi.types.u_int32_t int"

                case "long long":
                    return "@jnr.ffi.types.int64_t long"

                case "unsigned long long":
                    return "@jnr.ffi.types.u_int64_t long"
                
            
                default:
                    throw "UNHANDLED FUNDAMENTAL TYPE"
                    break;
            }
        }
    
        default:
            throw "UNHANDLED TYPE KIND"
            break;
    }
}

function getJavaStructField(field)
{
    let stype = "";

    switch (field.type.kind) {
        case TypeKind.enumeral:
        {
            stype = `jnr.ffi.Struct.Enum32<${field.type.name}>`;
            break;
        }

        case TypeKind.array:
        case TypeKind.pointer:
        {
            
            if (field.type.name == "char*" || field.type.name == "const char*")
            {
                stype = "jnr.ffi.Struct.UTF8StringRef"
            }
            else {
                stype = "jnr.ffi.Struct.Pointer"
            }

            break;
        }

        case TypeKind.fundamental:
        {
            switch (field.type.name) {
                case "void":
                {        
                    stype = "void";
                    break;
                }
                case "bool":
                case "_Bool":
                {
                    stype = "jnr.ffi.Struct.Boolean";
                    break;
                }
                case "float":
                {
                    stype = "jnr.ffi.Struct.Float"
                    break;
                }
                case "double":
                {
                    stype = "jnr.ffi.Struct.Double"
                    break;
                }
                case "unsigned char":
                {
                    stype = "jnr.ffi.Struct.u_int8_t"
                    break;
                }
                case "unsigned short":
                {
                    stype = "jnr.ffi.Struct.u_int16_t"
                    break;
                }
                case "unsigned int":
                {
                    stype = "jnr.ffi.Struct.u_int32_t"
                    break;
                }
                case "long long":
                {
                    stype = "jnr.ffi.Struct.int64_t"
                    break;
                }
                case "unsigned long long":
                {
                    stype = "jnr.ffi.Struct.u_int64_t";
                    break;
                }
            
                default:
                    throw "Unrecognized fundamental type for Struct Type"
                    break;
            }
            
            break;
        }

        // just the type itself
        case TypeKind.struct:
        case TypeKind.function_pointer:
        {
            stype = field.type.name;
            break;
        }
    
        default:
        {
            throw "Unhandled struct type kind";
            break;
        }
    }
    
    return `public final ${stype} ${field.name} = new ${stype}(${field.type.kind == TypeKind.enumeral ? field.type.name+".class" : ""});`
}


function getJavaParams(params, funcname)
{
    if(params == undefined || params == null) return ""
    let jparams = []
    for (const param of params) {
        let jparam = `${getJavaType(param.type, funcname+"_"+param.name+"_Callback")} ${param.name}`
        jparams.push(jparam)
    }
    return jparams.join(", ")
}


////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

console.log("Wrapping CAPI to Java")

// Read the capi.json
let capiinfo = JSON.parse(fs.readFileSync(__dirname + "/build/altv-capi.json"))

let javatypes = []
let javafuncs = []

// Process all enums
for(let [enumname, enumcontent] of Object.entries(capiinfo.enums))
{
    let values = []
    enumcontent.enumerators.forEach(e => {
        values.push(`${e.name}(${e.value})`)
    });

    let javatype = 
`
    public static enum ${enumname} implements jnr.ffi.util.EnumMapper.IntegerEnum
    {
        ${values.join(",\n        ")};

        ${enumname}(int value) {
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

// Process all structs
for(let [structname, struct] of Object.entries(capiinfo.structs))
{
    let fields = []
    // let ctorparams = []
    // let ctorassigns = []

    struct.fields.forEach(field => {
        fields.push(getJavaStructField(field))
        
        // let jtype = getJavaType(field.type, false, "@jnr.ffi.types.int32_t int")
        // ctorparams.push(`${jtype} ${field.name}`)
        // ctorassigns.push(`this.${field.name}.set(${field.name});`)
    });

    let javatype = 
`
    public static class ${structname} extends jnr.ffi.Struct
    {
        ${fields.join("\n        ")}
        
        public ${structname}()
        {
            super(runtime);
        }
        public ${structname}(jnr.ffi.Runtime runtime)
        {
            super(runtime);
        }
    }
`
    javatypes.push(javatype)
}

// Process all functions
for(let [funcname, func] of Object.entries(capiinfo.functions))
{
    let params = getJavaParams(func.params, funcname)
    let ret = getJavaType(func.returns);
    javafuncs.push(`${func.comment != "" ? func.comment+"        " : ""}${ret} ${funcname}(${params});\n`)
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
    ${javacallbacks.join("")}

    public static interface CAPIFunctions
    {
        ${javafuncs.join("\n        ")}
    }
}
`


fs.writeFileSync(__dirname+"/src/alt/v/jvm/CAPI.java", javasrc)

console.log("Done wrapping to Java")