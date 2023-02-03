package com.github.arnhav.simpleessentials.commands.warp;

import com.github.arnhav.simpleessentials.data.WarpManager;
import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Warp extends CommandExecutor {

    WarpManager warpManager;

    List<String> warps;

    public Warp(String command, WarpManager warpManager) {
        super(command);

        this.warpManager = warpManager;

        warps = new ArrayList<>(warpManager.getWarps().keySet());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player p)) return false;
        if (args.length == 0) return true;
        String name = args[0];
        Location warp = warpManager.getWarps().get(name);
        if (warp == null) {
            p.sendMessage(ChatColor.RED + "No warp with that name!");
            return true;
        }

        if (args.length == 1) {
            p.teleport(warp, PlayerTeleportEvent.TeleportCause.PLUGIN);
        }

        if (args.length == 2) {
            Player player = Bukkit.getPlayerExact(args[1]);
            if (player == null) {
                p.sendMessage(ChatColor.RED + "Invalid player: " + args[1]);
                return true;
            }
            player.teleportAsync(warp, PlayerTeleportEvent.TeleportCause.PLUGIN);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args.length <= 1 && !warps.contains(args[0])) {
            return warps.stream()
                    .filter(b -> b.toLowerCase().startsWith(args[args.length - 1].toLowerCase()))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
