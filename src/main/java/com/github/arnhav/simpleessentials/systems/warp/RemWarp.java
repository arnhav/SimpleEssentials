package com.github.arnhav.simpleessentials.systems.warp;

import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemWarp extends CommandExecutor {

    WarpManager warpManager;

    List<String> warps;

    public RemWarp(String command, WarpManager warpManager) {
        super(command);

        this.warpManager = warpManager;

        warps = new ArrayList<>(warpManager.getWarps().keySet());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) return true;
        String name = args[0];
        if (!warpManager.getWarps().containsKey(name)) return true;
        warpManager.removeWarp(name);
        sender.sendMessage(Component.text("Removed warp: " + name, NamedTextColor.YELLOW));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length <= 1 && !warps.contains(args[0])) {
            return warps.stream()
                    .filter(b -> b.toLowerCase().startsWith(args[args.length - 1].toLowerCase()))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
