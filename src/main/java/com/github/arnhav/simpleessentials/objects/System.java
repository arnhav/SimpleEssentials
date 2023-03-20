package com.github.arnhav.simpleessentials.objects;

import com.github.arnhav.simpleessentials.SimpleEssentials;

public abstract class System {

    public System() {
        SimpleEssentials.instance().getSystems().add(this);
    }

    public abstract void enable();

    public abstract void disable();

}
