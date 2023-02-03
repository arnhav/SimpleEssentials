package com.github.arnhav.simpleessentials.managers;

import lombok.Data;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.WeakHashMap;

@Data
public class BackManager {

    private Map<Player, Location> lastLocation = new WeakHashMap<>();

}
