package com.github.arnhav.simpleessentials.commands.gamemode;

import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Gamemode extends CommandExecutor {

    public Gamemode(String command) {
        super(command);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) return false;
        if (args.length == 0) return false;
        GameMode gameMode = null;
        if (args[0].equals("0")) {
            gameMode = GameMode.SURVIVAL;
        }
        if (args[0].equals("1")) {
            gameMode = GameMode.CREATIVE;
        }
        if (args[0].equals("2")) {
            gameMode = GameMode.ADVENTURE;
        }
        if (args[0].equals("3")) {
            gameMode = GameMode.SPECTATOR;
        }
        if (gameMode == null) return false;
        p.setGameMode(gameMode);
        p.sendMessage(ChatColor.GRAY + "Changed gamemode to: " + WordUtils.capitalize(gameMode.toString()));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return List.of("0", "1", "2", "3");
    }
}
