package com.github.arnhav.simpleessentials.systems.message;

import com.github.arnhav.simpleessentials.objects.Listener;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;
import java.util.List;

public class MessageListener extends Listener {

    MessageManager messageManager;

    MiniMessage mm = MiniMessage.miniMessage();

    public MessageListener(MessageManager messageManager) {
        this.messageManager = messageManager;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage();
        if (!command.startsWith("/")) return;
        if (!(command.startsWith("/msg ") || command.startsWith("/w "))) return;

        event.setCancelled(true);

        Player sender = event.getPlayer();

        String[] args = command.split(" ");
        List<String> strings = Arrays.asList(args);

        if (strings.size() < 2) return;

        Player receiver = Bukkit.getPlayerExact(strings.get(1));

        if (receiver == null) {
            sender.sendMessage(mm.deserialize("<red>You must specify a player to send the message to!"));
            return;
        }
        if (!receiver.isOnline()) {
            sender.sendMessage(mm.deserialize("<red>That player is no longer online!"));
            return;
        }

        if (strings.size() < 3) return;

        messageManager.getLastMessaged().put(sender.getUniqueId(), receiver.getUniqueId());

        strings = strings.subList(2, strings.size() - 1);

        String message = String.join(" ", strings);

        sender.sendMessage(mm.deserialize("<dark_aqua>[You → " + receiver.getName() + "]<gray> " + message));
        receiver.sendMessage(mm.deserialize("<dark_aqua>[" + sender.getName() + " → You]<gray> " + message));
    }

}
