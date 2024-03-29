package com.github.arnhav.simpleessentials.systems.back;

import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.List;

public class Back extends CommandExecutor {

    BackManager backManager;

    public Back(String command, BackManager backManager) {
        super(command);

        this.backManager = backManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) return false;
        Location l = backManager.getLastLocation().get(p);
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
