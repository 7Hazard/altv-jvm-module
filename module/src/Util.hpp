#pragma once

#include <filesystem>
#include "altv-capi.hpp"

namespace util {

inline auto AbsolutePath(std::string relativePath)
{
    return std::filesystem::absolute(relativePath).string();
}

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
inline void logi(alt_ICore* core, char (&str)[N])
{
    alt_StringView sw{str, n+1};
    alt_ICore_LogInfo(core, &sw);
}

inline void logi(alt_ICore* core, const std::string& str)
{
    alt_StringView sw {(char*)str.c_str(), str.length()+1};
    alt_ICore_LogInfo(core, &sw);
}

template<std::size_t N>
inline void loge(alt_ICore* core, char (&str)[N])
{
    alt_StringView sw{str, n+1};
    alt_ICore_LogError(core, &sw);
}

inline void loge(alt_ICore* core, const std::string& str)
{
    alt_StringView sw {(char*)str.c_str(), str.length()+1};
    alt_ICore_LogError(core, &sw);
}

}