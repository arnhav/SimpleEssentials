package com.github.arnhav.simpleessentials.objects;

import com.github.arnhav.simpleessentials.SimpleEssentials;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.permissions.Permission;

public abstract class CommandExecutor implements org.bukkit.command.CommandExecutor, TabCompleter {

    public CommandExecutor(String command) {
        PluginCommand c = SimpleEssentials.instance().getCommand(command);
        if (c == null) return;
        String permissionString = "simpleessentials." + command.toLowerCase();
        c.setPermission(permissionString);
        Permission permission = new Permission(permissionString);
        if (SimpleEssentials.instance().getServer().getPluginManager().getPermission(permissionString) == null) {
            SimpleEssentials.instance().getServer().getPluginManager().addPermission(permission);
        }
        c.setExecutor(this);
        c.setTabCompleter(this);
    }

}
