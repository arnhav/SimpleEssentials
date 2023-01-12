package com.github.arnhav.simpleessentials.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.WeakHashMap;

public class BackUtil {

    public static Map<Player, Location> lastLocation = new WeakHashMap<>();

}
