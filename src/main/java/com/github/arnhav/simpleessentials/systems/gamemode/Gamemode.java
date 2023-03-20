package com.github.arnhav.simpleessentials.systems.gamemode;

import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class Gamemode extends CommandExecutor {

    List<String> modes = List.of("0", "1", "2", "3", "s", "c", "a", "sp", "survival", "creative", "adventure", "spectator");

    public Gamemode(String command) {
        super(command);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) return false;
        Player p;
        if (args.length == 1) {
            p = Bukkit.getPlayerExact(args[0]);
        } else {
            if (!(sender instanceof Player)) return false;
            p = (Player) sender;
        }
        if (p == null) return true;
        GameMode gameMode = null;
        if (args[0].equals("0") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("survival")) {
            gameMode = GameMode.SURVIVAL;
        }
        if (args[0].equals("1") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative")) {
            gameMode = GameMode.CREATIVE;
        }
        if (args[0].equals("2") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("adventure")) {
            gameMode = GameMode.ADVENTURE;
        }
        if (args[0].equals("3") || args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("spectator")) {
            gameMode = GameMode.SPECTATOR;
        }
        if (gameMode == null) return false;
        p.setGameMode(gameMode);
        p.sendMessage(ChatColor.GRAY + "Changed gamemode to: " + WordUtils.capitalize(gameMode.toString()));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length <= 1 && !modes.contains(args[0])) {
            return modes.stream()
                    .filter(b -> b.toLowerCase().startsWith(args[args.length - 1].toLowerCase()))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
