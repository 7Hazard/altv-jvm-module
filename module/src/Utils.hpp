#include <filesystem>

namespace utils {

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

}