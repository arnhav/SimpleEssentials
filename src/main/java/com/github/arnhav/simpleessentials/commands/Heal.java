package com.github.arnhav.simpleessentials.commands;

import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.List;

public class Heal extends CommandExecutor {
    public Heal(String command) {
        super(command);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) return false;
        AttributeInstance ai = p.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (ai != null) {
            p.setHealth(ai.getBaseValue());
        }
        p.setFoodLevel(20);
        p.setSaturation(20);
        for (PotionEffect potionEffect : p.getActivePotionEffects()) {
            p.removePotionEffect(potionEffect.getType());
        }
        p.sendMessage(ChatColor.GRAY + "You have been healed!");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
