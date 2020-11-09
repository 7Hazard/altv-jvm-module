#pragma once

#include <filesystem>
#include <time.h>
#include <string>
#include "altv-capi-server.h"

namespace util
{

    inline auto GetTimestamp()
    {
        time_t rawtime;
        struct tm *timeinfo;
        char buffer[80];

        time(&rawtime);
        timeinfo = localtime(&rawtime);

        strftime(buffer, sizeof(buffer), "%d-%m-%Y-%H:%M:%S", timeinfo);
        std::string str(buffer);

        return str;
    }

    template <std::size_t N>
    inline void logi(const char (&str)[N])
    {
        alt_StringView sw{(char *)str, N + 1};
        alt_ICore_LogInfo(core, &sw);
    }

    inline void logi(const std::string &str)
    {
        alt_StringView sw{(char *)str.data(), str.length() + 1};
        alt_ICore_LogInfo(core, &sw);
    }

    template <std::size_t N>
    inline void loge(const char (&str)[N])
    {
        alt_StringView sw{(char *)str, N + 1};
        alt_ICore_LogError(core, &sw);
    }

    inline void loge(const std::string &str)
    {
        alt_StringView sw{(char *)str.data(), str.length() + 1};
        alt_ICore_LogError(core, &sw);
    }

    template <std::size_t N>
    inline bool FileExists(const char (&str)[N])
    {
        alt_StringView sw{(char *)str, N + 1};
        return alt_ICore_FileExists(core, &sw);
    }

} // namespace util