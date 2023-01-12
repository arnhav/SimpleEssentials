package com.github.arnhav.simpleessentials.listeners;

import com.github.arnhav.simpleessentials.util.BackUtil;
import com.github.arnhav.simpleessentials.objects.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class BackListener extends Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        BackUtil.lastLocation.put(event.getEntity(), event.getEntity().getLocation().clone());
    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event) {
        BackUtil.lastLocation.put(event.getPlayer(), event.getFrom());
    }

}
