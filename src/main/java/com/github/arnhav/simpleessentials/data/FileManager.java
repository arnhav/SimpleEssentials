package com.github.arnhav.simpleessentials.data;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class FileManager {

    WarpManager warpManager;

    public FileManager(JavaPlugin plugin) {
        warpManager = new WarpManager(plugin);
    }

}
