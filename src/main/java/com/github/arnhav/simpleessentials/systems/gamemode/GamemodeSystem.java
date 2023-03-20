package com.github.arnhav.simpleessentials.systems.gamemode;

import com.github.arnhav.simpleessentials.objects.System;

public class GamemodeSystem extends System {
    @Override
    public void enable() {
        new Gamemode("gm");
        new GM0("gm0");
        new GM0("gms");
        new GM1("gm1");
        new GM1("gmc");
        new GM2("gm2");
        new GM2("gma");
        new GM3("gm3");
        new GM3("gmsp");
    }

    @Override
    public void disable() {

    }
}
