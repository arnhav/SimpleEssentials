package com.github.arnhav.simpleessentials.objects;

import com.github.arnhav.simpleessentials.SimpleEssentials;

public abstract class Listener implements org.bukkit.event.Listener {

    public Listener() {
        SimpleEssentials.instance().getServer().getPluginManager().registerEvents(this, SimpleEssentials.instance());
    }

}
