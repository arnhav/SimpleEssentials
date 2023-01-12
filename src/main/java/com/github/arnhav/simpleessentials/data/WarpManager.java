package com.github.arnhav.simpleessentials.data;

import com.github.arnhav.simpleessentials.util.WarpUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class WarpManager {

    private static FileConfiguration data;

    private static File warpsFolder;

    public WarpManager(JavaPlugin plugin) {
        warpsFolder = new File(plugin.getDataFolder(), "warps");
        if (!warpsFolder.exists()) {
            warpsFolder.mkdirs();
        } else {
            loadWarps(warpsFolder.listFiles());
        }
    }

    private void loadWarps(File[] files) {
        for (File file : files) {
            data = YamlConfiguration.loadConfiguration(file);

            String worldName = data.getString("world");
            if (worldName == null) continue;
            World world = Bukkit.createWorld(new WorldCreator(worldName));

            double x = data.getDouble("x");
            double y = data.getDouble("y");
            double z = data.getDouble("z");
            double yaw = data.getDouble("yaw");
            double pitch = data.getDouble("pitch");

            String name = data.getString("name");

            Location location = new Location(world, x, y, z, (float) yaw, (float) pitch);
            WarpUtil.warps.put(name, location);
        }
    }

    public static void saveWarp(String name, Location location) {
        if (location == null) return;
        name = name.replace(" ", "_");
        File file = new File(warpsFolder, name + ".yml");
        data = YamlConfiguration.loadConfiguration(file);
        data.set("world", location.getWorld().getName());
        data.set("x", location.getX());
        data.set("y", location.getY());
        data.set("z", location.getZ());
        data.set("yaw", location.getYaw());
        data.set("pitch", location.getPitch());
        data.set("name", name);
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeWarp(String name) {
        File file = new File(warpsFolder, name + ".yml");
        if (!file.exists()) return;
        file.delete();
    }

}
