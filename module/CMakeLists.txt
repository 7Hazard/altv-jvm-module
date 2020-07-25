cmake_minimum_required(VERSION 3.10)
project(altv-jvm-module)

# find_package(Java REQUIRED COMPONENTS Development)
if(NOT CMAKE_CROSS_COMPILING)
    find_package(JNI REQUIRED)
else()
    file(DOWNLOAD "https://download.java.net/openjdk/jdk11/ri/openjdk-11+28_windows-x64_bin.zip" "${CMAKE_BINARY_DIR}/jdk11.zip")
    execute_process(COMMAND ${CMAKE_COMMAND} -E tar -xf ${CMAKE_BINARY_DIR}/jdk11.zip WORKING_DIRECTORY ${CMAKE_BINARY_DIR})
    set(JNI_INCLUDE_DIRS "${CMAKE_BINARY_DIR}/jdk-11/include" "${CMAKE_BINARY_DIR}/jdk-11/include/win32")
    set(JAVA_JVM_LIBRARY "${CMAKE_BINARY_DIR}/jdk-11/lib/jvm.lib")
endif()
# message(FATAL_ERROR "Location: ${JAVA_JVM_LIBRARY}")

if(CMAKE_SYSTEM_NAME STREQUAL "Windows")
    set(JVM_MODULE_PLATFORM "win32")
elseif(CMAKE_SYSTEM_NAME STREQUAL "Linux")
    set(JVM_MODULE_PLATFORM "linux")
else()
    message(FATAL_ERROR "UNSUPPORTED PLATFORM")
endif()
set(JVM_MODULE_VERSION "none" CACHE BOOL "Module Version")

if(CMAKE_BUILD_TYPE MATCHES Debug)
    set(CAPI_LOCATION ${PROJECT_SOURCE_DIR}/../build/altv-capi-server-debug)
else()
    set(CAPI_LOCATION ${PROJECT_SOURCE_DIR}/../build/altv-capi-server-${JVM_MODULE_PLATFORM})
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
    _SILENCE_EXPERIMENTAL_FILESYSTEM_DEPRECATION_WARNING
    _CRT_SECURE_NO_WARNINGS
    # CAPI_DLL
)
target_include_directories(altv-jvm-module PRIVATE
    src
    ${CAPI_LOCATION}/include
    ${JNI_INCLUDE_DIRS}
)
target_link_libraries(altv-jvm-module PRIVATE
    # ${JAVA_JVM_LIBRARY}
)
set_target_properties(altv-jvm-module PROPERTIES
    CXX_STANDARD 17
    # ARCHIVE_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/altv-jvm-module/lib
    LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/../build/${JVM_MODULE_PLATFORM}/altv-jvm-module
    RUNTIME_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/../build/${JVM_MODULE_PLATFORM}/altv-jvm-module
)

# Platform specific stuff
if(CMAKE_SYSTEM_NAME STREQUAL "Windows")
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} /EHsc /permissive- -Wno-writable-strings -Wno-missing-declarations /RTC1")
    set(CMAKE_CXX_FLAGS_DEBUG "${CMAKE_CXX_FLAGS_DEBUG} /MDd")
    set(CMAKE_CXX_FLAGS_RELWITHDEBINFO "${CMAKE_CXX_FLAGS_RELWITHDEBINFO} /MD")

    target_link_libraries(altv-jvm-module PRIVATE
        ${PROJECT_SOURCE_DIR}/../build/altv-capi-server-${JVM_MODULE_PLATFORM}/lib/altv-capi-server.lib
    )
    add_custom_command(TARGET altv-jvm-module POST_BUILD # POST BUILD COMMANDS
        COMMAND ${CMAKE_COMMAND} -E copy ${CAPI_LOCATION}/bin/altv-capi-server.dll ${PROJECT_SOURCE_DIR}/../build/${JVM_MODULE_PLATFORM}/altv-jvm-module/altv-capi-server.dll
    )
else()
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} --std=c++17 -fms-extensions -fdelayed-template-parsing -fexceptions -Wno-writable-strings -Wno-missing-declarations")
endif()

