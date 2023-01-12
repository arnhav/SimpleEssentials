package com.github.arnhav.simpleessentials;

import com.github.arnhav.simpleessentials.commands.*;
import com.github.arnhav.simpleessentials.commands.gamemode.*;
import com.github.arnhav.simpleessentials.commands.warp.RemWarp;
import com.github.arnhav.simpleessentials.commands.warp.SetWarp;
import com.github.arnhav.simpleessentials.commands.warp.Warp;
import com.github.arnhav.simpleessentials.data.FileManager;
import com.github.arnhav.simpleessentials.listeners.BackListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleEssentials extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new FileManager(this);

        // Commands
        new Warp("warp");
        new SetWarp("setwarp");
        new RemWarp("remwarp");

        new Back("back");

        new Gamemode("gm");
        new GM0("gm0");
        new GM1("gm1");
        new GM2("gm2");
        new GM3("gm3");

        new Fix("fix");
        new Heal("heal");
        new Speed("speed");

        // Listeners
        new BackListener();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static JavaPlugin instance() {
        return SimpleEssentials.getProvidingPlugin(SimpleEssentials.class);
    }
}
