package com.github.arnhav.simpleessentials;

import com.github.arnhav.simpleessentials.objects.System;
import com.github.arnhav.simpleessentials.systems.back.BackSystem;
import com.github.arnhav.simpleessentials.systems.feed.FeedSystem;
import com.github.arnhav.simpleessentials.systems.fix.FixSystem;
import com.github.arnhav.simpleessentials.systems.gamemode.GamemodeSystem;
import com.github.arnhav.simpleessentials.systems.heal.HealSystem;
import com.github.arnhav.simpleessentials.systems.message.MessageSystem;
import com.github.arnhav.simpleessentials.systems.speed.SpeedSystem;
import com.github.arnhav.simpleessentials.systems.warp.WarpSystem;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

@Getter
public final class SimpleEssentials extends JavaPlugin {

    Set<System> systems = new HashSet<>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        new WarpSystem();
        new BackSystem();
        new GamemodeSystem();
        new SpeedSystem();
        new FeedSystem();
        new FixSystem();
        new HealSystem();
        new MessageSystem();

        systems.forEach(System::enable);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        systems.forEach(System::disable);
    }

    public static SimpleEssentials instance() {
        return SimpleEssentials.getPlugin(SimpleEssentials.class);
    }
}
