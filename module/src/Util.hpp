#pragma once

#include <filesystem>
#include <time.h>
#include <string>
#include "altv-capi-server.h"

namespace util
{


// inline auto AbsolutePath(std::string relativePath)
// {
//     return std::filesystem::absolute(relativePath).string();
// }

// // Adds shared library path
// inline bool AddPath(std::string path)
// {
// #ifdef _WIN32
//     AddDllDirectoryA(path.c_str());
// #else
//     static_assert(false, "NOT IMPLEMENTED");
// #endif
// }

// inline std::string GetEnvironmentVariable(std::string name)
// {
// #ifdef _WIN32
//     char buf[1024];
//     GetEnvironmentVariableA(name.c_str(), buf, sizeof(buf));
//     return buf;
// #else
//     static_assert(false, "NOT IMPLEMENTED");
// #endif
// }

inline auto GetTimestamp()
{
    time_t rawtime;
    struct tm * timeinfo;
    char buffer[80];

    time (&rawtime);
    timeinfo = localtime(&rawtime);

    strftime(buffer,sizeof(buffer),"%d-%m-%Y-%H:%M:%S", timeinfo);
    std::string str(buffer);

    return str;
}

template<std::size_t N>
inline void logi(alt_ICore* core, const char (&str)[N])
{
    alt_StringView sw{(char*)str, N+1};
    alt_ICore_LogInfo(core, &sw);
}

inline void logi(alt_ICore* core, const std::string& str)
{
    alt_StringView sw {(char*)str.c_str(), str.length()+1};
    alt_ICore_LogInfo(core, &sw);
}

template<std::size_t N>
inline void loge(alt_ICore* core, const char (&str)[N])
{
    alt_StringView sw{(char*)str, N+1};
    alt_ICore_LogError(core, &sw);
}

inline void loge(alt_ICore* core, const std::string& str)
{
    alt_StringView sw {(char*)str.c_str(), str.length()+1};
    alt_ICore_LogError(core, &sw);
}

template<std::size_t N>
inline bool FileExists(alt_ICore* core, const char (&str)[N])
{
    alt_StringView sw{(char*)str, N+1};
    return alt_ICore_FileExists(core, &sw);
}

}