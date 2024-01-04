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
import java.util.UUID;

public class ReplyCommand extends CommandExecutor {

    MessageManager messageManager;

    MiniMessage mm = MiniMessage.miniMessage();

    public ReplyCommand(String command, MessageManager messageManager) {
        super(command);
        this.messageManager = messageManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;

        UUID uuid = messageManager.getLastMessaged().get(player.getUniqueId());
        if (uuid == null) {
            sender.sendMessage(mm.deserialize("<yellow>You haven't messaged anyone!"));
            return true;
        }

        Player receiver = Bukkit.getPlayer(uuid);
        if (receiver == null || !receiver.isOnline()) {
            sender.sendMessage(mm.deserialize("<red>That player is no longer online!"));
            return true;
        }

        String message = String.join(" ", args);

        sender.sendMessage(mm.deserialize("<dark_aqua>[You → " + receiver.getName() + "]<gray> " + message));
        receiver.sendMessage(mm.deserialize("<dark_aqua>[" + player.getName() + " → You]<gray> " + message));

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return List.of();
    }
}
