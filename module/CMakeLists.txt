cmake_minimum_required(VERSION 3.10)
project(altv-jvm-module)

set(JVM_MODULE_VERSION "debug" CACHE BOOL "Module Version")

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
)
target_include_directories(altv-jvm-module PRIVATE
    src
    ${PROJECT_SOURCE_DIR}/../build/altv-capi-server/include/server
)
target_link_libraries(altv-jvm-module PRIVATE
    ${PROJECT_SOURCE_DIR}/../build/altv-capi-server/lib/altv-capi-server.lib
)
set_target_properties(altv-jvm-module PROPERTIES
    # ARCHIVE_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/altv-jvm-module/lib
    # LIBRARY_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/altv-jvm-module/lib
    RUNTIME_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/../build/altv-jvm-module
)

# Platform specific stuff
if(CMAKE_SYSTEM_NAME STREQUAL "Windows")
    set(CMAKE_CXX_STANDARD 17)
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} /EHsc")
    set(CMAKE_CXX_FLAGS_DEBUG "${CMAKE_CXX_FLAGS_DEBUG} /MDd")
    set(CMAKE_CXX_FLAGS_RELEASE "${CMAKE_CXX_FLAGS_RELEASE} /MD")

    target_include_directories(altv-jvm-module PRIVATE
        "C:/Program Files/RedHat/java-11-openjdk-11.0.4-1/include"
        "C:/Program Files/RedHat/java-11-openjdk-11.0.4-1/include/win32"
    )
    target_link_libraries(altv-jvm-module PRIVATE
        "C:/Program Files/RedHat/java-11-openjdk-11.0.4-1/lib/jvm.lib"
    )
else()
    # set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} --std=c++17 -fms-extensions -fdelayed-template-parsing -fexceptions")
    message(FATAL_ERROR "LINUX NOT SUPPORTED")
endif()

