package com.github.arnhav.simpleessentials.systems.back;

import com.github.arnhav.simpleessentials.objects.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class BackListener extends Listener {

    BackManager backManager;

    public BackListener(BackManager backManager) {
        this.backManager = backManager;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        backManager.getLastLocation().put(event.getEntity(), event.getEntity().getLocation().clone());
    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event) {
        backManager.getLastLocation().put(event.getPlayer(), event.getFrom());
    }

}
