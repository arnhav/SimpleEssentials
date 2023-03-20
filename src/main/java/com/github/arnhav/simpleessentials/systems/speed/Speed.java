package com.github.arnhav.simpleessentials.systems.speed;

import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Speed extends CommandExecutor {

    public Speed(String command) {
        super(command);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) return false;
        if (args.length == 0) return false;
        double value = 0;
        try {
            double speed = Double.parseDouble(args[0]);
            if (speed > 10) return false;
            value = speed / 10;
        } catch (NumberFormatException ignored) {
        }
        value += 0.2;
        if (p.isFlying()) {
            p.setFlySpeed((float) value);
            p.sendMessage(ChatColor.GRAY + "Fly speed set to " + args[0]);
        } else {
            p.setWalkSpeed((float) value);
            p.sendMessage(ChatColor.GRAY + "Walk speed set to " + args[0]);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    }
}
