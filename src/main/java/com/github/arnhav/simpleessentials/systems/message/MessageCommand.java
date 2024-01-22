package com.github.arnhav.simpleessentials.systems.message;

import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class MessageCommand extends CommandExecutor {

    MessageManager messageManager;

    MiniMessage mm = MiniMessage.miniMessage();

    public MessageCommand(String command, MessageManager messageManager) {
        super(command);
        this.messageManager = messageManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;

        if (args.length < 2) {
            sender.sendMessage(mm.deserialize("<yellow>/msg <player> <message>"));
            return true;
        }

        Player receiver = Bukkit.getPlayerExact(args[0]);

        if (receiver == null) {
            sender.sendMessage(mm.deserialize("<red>You must specify a player to send the message to!"));
            return true;
        }
        if (!receiver.isOnline()) {
            sender.sendMessage(mm.deserialize("<red>That player is no longer online!"));
            return true;
        }

        messageManager.getLastMessaged().put(player.getUniqueId(), receiver.getUniqueId());

        List<String> strings = Arrays.asList(args);
        strings = strings.subList(1, strings.size() - 1);

        String message = String.join(" ", strings);

        sender.sendMessage(mm.deserialize("<dark_aqua>[You → " + receiver.getName() + "]<gray> " + message));
        receiver.sendMessage(mm.deserialize("<dark_aqua>[" + sender.getName() + " → You]<gray> " + message));

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) return null;
        return List.of();
    }
}
