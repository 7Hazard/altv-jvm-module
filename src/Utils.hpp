#include <filesystem>

namespace utils {

inline auto AbsolutePath(std::string relativePath)
{
    return std::filesystem::absolute(relativePath).string();
}

}