package com.github.arnhav.simpleessentials.systems.fix;

import com.github.arnhav.simpleessentials.objects.System;

public class FixSystem extends System {
    @Override
    public void enable() {
        new Fix("fix");
    }

    @Override
    public void disable() {

    }
}
