package com.github.arnhav.simpleessentials.commands.gamemode;

import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class GM0 extends CommandExecutor {
    public GM0(String command) {
        super(command);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) return false;
        GameMode gameMode = GameMode.SURVIVAL;
        p.setGameMode(gameMode);
        p.sendMessage(ChatColor.GRAY + "Changed gamemode to: " + WordUtils.capitalize(gameMode.toString()));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
