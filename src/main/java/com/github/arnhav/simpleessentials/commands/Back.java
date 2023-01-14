package com.github.arnhav.simpleessentials.commands;

import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import com.github.arnhav.simpleessentials.util.BackUtil;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.List;

public class Back extends CommandExecutor {

    public Back(String command) {
        super(command);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) return false;
        Location l = BackUtil.lastLocation.get(p);
        if (l == null) {
            p.sendMessage(ChatColor.RED + "No location to go back to!");
            return true;
        }
        p.teleportAsync(l, PlayerTeleportEvent.TeleportCause.PLUGIN);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
