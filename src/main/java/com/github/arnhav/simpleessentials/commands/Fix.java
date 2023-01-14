package com.github.arnhav.simpleessentials.commands;

import com.github.arnhav.simpleessentials.objects.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

import java.util.List;

public class Fix extends CommandExecutor {
    public Fix(String command) {
        super(command);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) return false;
        if (args.length == 1 && args[0].equals("all")) {
            ItemStack[] o = p.getInventory().getContents();
            for (int i = 0; i < o.length; i++) {
                ItemStack t = o[i];
                if (t == null) continue;
                if (t.getType() == Material.AIR) continue;
                o[i] = fixItem(t.clone());
            }
            p.getInventory().setContents(o);
            p.sendMessage(ChatColor.GRAY + "All damaged items in your inventory have been fixed!");
        } else {
            ItemStack itemStack = p.getInventory().getItemInMainHand();
            if (itemStack.getType().isAir()) {
                p.sendMessage(ChatColor.RED + "Invalid item!");
            }
            p.getInventory().setItemInMainHand(fixItem(itemStack));
            p.sendMessage(ChatColor.GRAY + "Fixed held item!");
        }
        return true;
    }

    private ItemStack fixItem(ItemStack itemStack) {
        if (!EnchantmentTarget.BREAKABLE.includes(itemStack)) return itemStack;
        Damageable d = (Damageable) itemStack.getItemMeta();
        if (d == null) return itemStack;
        if (!d.hasDamage()) return itemStack;
        d.setDamage(0);
        itemStack.setItemMeta(d);
        return itemStack;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return List.of("all");
    }
}
