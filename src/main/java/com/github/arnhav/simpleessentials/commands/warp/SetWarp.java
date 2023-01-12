package com.github.arnhav.simpleessentials.commands.warp;

import com.github.arnhav.simpleessentials.data.WarpManager;
import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SetWarp extends CommandExecutor {

    public SetWarp(String command) {
        super(command);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) return false;
        if (args.length == 0) return true;
        String name = args[0];
        WarpManager.saveWarp(name, p.getLocation());
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
