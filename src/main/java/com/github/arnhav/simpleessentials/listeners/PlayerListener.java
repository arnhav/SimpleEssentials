package com.github.arnhav.simpleessentials.listeners;

import com.github.arnhav.simpleessentials.objects.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener extends Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.resetPlayerTime();
    }

}
