package com.github.arnhav.simpleessentials.systems.warp;

import com.github.arnhav.simpleessentials.SimpleEssentials;
import com.github.arnhav.simpleessentials.objects.System;

public class WarpSystem extends System {

    @Override
    public void enable() {
        WarpManager warpManager = new WarpManager(SimpleEssentials.instance());
        new Warp("warp", warpManager);
        new SetWarp("setwarp", warpManager);
        new RemWarp("remwarp", warpManager);
    }

    @Override
    public void disable() {

    }
}
