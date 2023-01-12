package com.github.arnhav.simpleessentials.commands.warp;

import com.github.arnhav.simpleessentials.data.WarpManager;
import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import com.github.arnhav.simpleessentials.util.WarpUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemWarp extends CommandExecutor {

    List<String> warps;

    public RemWarp(String command) {
        super(command);

        warps = new ArrayList<>(WarpUtil.warps.keySet());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) return true;
        String name = args[0];
        if (!WarpUtil.warps.containsKey(name)) return true;
        WarpManager.removeWarp(name);
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
