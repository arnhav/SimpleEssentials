package com.github.arnhav.simpleessentials;

import com.github.arnhav.simpleessentials.commands.Back;
import com.github.arnhav.simpleessentials.commands.Fix;
import com.github.arnhav.simpleessentials.commands.Heal;
import com.github.arnhav.simpleessentials.commands.Speed;
import com.github.arnhav.simpleessentials.commands.gamemode.*;
import com.github.arnhav.simpleessentials.commands.warp.RemWarp;
import com.github.arnhav.simpleessentials.commands.warp.SetWarp;
import com.github.arnhav.simpleessentials.commands.warp.Warp;
import com.github.arnhav.simpleessentials.data.FileManager;
import com.github.arnhav.simpleessentials.listeners.BackListener;
import com.github.arnhav.simpleessentials.managers.BackManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleEssentials extends JavaPlugin {

    FileManager fileManager;
    BackManager backManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        fileManager = new FileManager(this);
        backManager = new BackManager();

        // Commands
        new Warp("warp", fileManager.getWarpManager());
        new SetWarp("setwarp");
        new RemWarp("remwarp", fileManager.getWarpManager());

        new Back("back");

        new Gamemode("gm");
        new GM0("gm0");
        new GM0("gms");
        new GM1("gm1");
        new GM1("gmc");
        new GM2("gm2");
        new GM2("gma");
        new GM3("gm3");
        new GM3("gmsp");

        new Fix("fix");
        new Heal("heal");
        new Speed("speed");

        // Listeners
        new BackListener(backManager);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static JavaPlugin instance() {
        return SimpleEssentials.getProvidingPlugin(SimpleEssentials.class);
    }
}
