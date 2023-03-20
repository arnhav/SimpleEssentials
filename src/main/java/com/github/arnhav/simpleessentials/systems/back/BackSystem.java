package com.github.arnhav.simpleessentials.systems.back;

import com.github.arnhav.simpleessentials.objects.System;

public class BackSystem extends System {
    @Override
    public void enable() {
        BackManager backManager = new BackManager();

        new Back("back", backManager);

        new BackListener(backManager);
    }

    @Override
    public void disable() {

    }
}
