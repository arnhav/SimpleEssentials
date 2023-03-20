package com.github.arnhav.simpleessentials.systems.speed;

import com.github.arnhav.simpleessentials.objects.System;

public class SpeedSystem extends System {
    @Override
    public void enable() {
        new Speed("speed");
    }

    @Override
    public void disable() {

    }
}
