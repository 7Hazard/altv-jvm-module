cmake_minimum_required(VERSION 3.10)
project(altv-jvm-module)

# find_package(Java REQUIRED COMPONENTS Development)
find_package(JNI REQUIRED)
# message(FATAL_ERROR "Location: ${JAVA_JVM_LIBRARY}")

set(JVM_MODULE_VERSION "debug" CACHE BOOL "Module Version")


if(CMAKE_SYSTEM_NAME STREQUAL "Windows")
    set(JVM_MODULE_PLATFORM "win32")
elseif(CMAKE_SYSTEM_NAME STREQUAL "Linux")
    set(JVM_MODULE_PLATFORM "linux")
else()
    message(FATAL_ERROR "UNSUPPORTED PLATFORM")
endif()

add_definitions(
    -D_UNICODE
    -DUNICODE
)

# Server
add_library(altv-jvm-module SHARED
    src/main.cpp
)
target_compile_definitions(altv-jvm-module PRIVATE
    ALT_SERVER_API
    JVM_MODULE_DLL
    JVM_MODULE_VERSION="${JVM_MODULE_VERSION}"
    CAPI_DLL
)
target_include_directories(altv-jvm-module PRIVATE
    src
    ${PROJECT_SOURCE_DIR}/../build/altv-capi
    ${JNI_INCLUDE_DIRS}
)
target_link_libraries(altv-jvm-module PRIVATE
    ${JAVA_JVM_LIBRARY}
)
set_target_properties(altv-jvm-module PROPERTIES
    # ARCHIVE_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/altv-jvm-module/lib
    LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/../build/${JVM_MODULE_PLATFORM}/altv-jvm-module
    RUNTIME_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/../build/${JVM_MODULE_PLATFORM}/altv-jvm-module
)

# Platform specific stuff
if(CMAKE_SYSTEM_NAME STREQUAL "Windows")
    set(CMAKE_CXX_STANDARD 17)
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} /EHsc")
    set(CMAKE_CXX_FLAGS_DEBUG "${CMAKE_CXX_FLAGS_DEBUG} /MDd")
    set(CMAKE_CXX_FLAGS_RELEASE "${CMAKE_CXX_FLAGS_RELEASE} /MD")

    target_link_libraries(altv-jvm-module PRIVATE
        ${PROJECT_SOURCE_DIR}/../build/altv-capi/altv-server.lib
    )
else()
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} --std=c++17 -fms-extensions -fdelayed-template-parsing -fexceptions")
endif()

