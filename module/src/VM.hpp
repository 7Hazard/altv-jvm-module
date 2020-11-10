#pragma once

#include "altv-capi-server.h"

class VM
{
public:
    struct
    {
        bool debug = false;
    } option;

    void ReadOptions();
    bool Start();

    ~VM();
};
