package com.github.arnhav.simpleessentials.systems.warp;

import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SetWarp extends CommandExecutor {

    WarpManager warpManager;

    public SetWarp(String command, WarpManager warpManager) {
        super(command);

        this.warpManager = warpManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) return false;
        if (args.length == 0) return true;
        String name = args[0];
        warpManager.saveWarp(name, p.getLocation());
        p.sendMessage(Component.text("Created warp: " + name, NamedTextColor.GREEN));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
