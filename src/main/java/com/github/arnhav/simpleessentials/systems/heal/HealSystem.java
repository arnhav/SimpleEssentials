package com.github.arnhav.simpleessentials.systems.heal;

import com.github.arnhav.simpleessentials.objects.System;

public class HealSystem extends System {
    @Override
    public void enable() {
        new Heal("heal");
    }

    @Override
    public void disable() {

    }
}
