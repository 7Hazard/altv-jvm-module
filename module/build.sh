#!/bin/bash


cmake . -B"BUILD-LINUX" -DJVM_MODULE_VERSION="$1" -DCMAKE_BUILD_TYPE=RelWithDebInfo -GNinja -DCMAKE_C_COMPILER='clang' -DCMAKE_CXX_COMPILER='clang++' -DCMAKE_LINKER='ld.lld'
cmake --build "BUILD-LINUX"
