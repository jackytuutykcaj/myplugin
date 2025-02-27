package me.hysun.myplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CookieSlapCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            ItemStack cookie = new ItemStack(Material.COOKIE);
            ItemMeta itemMeta = cookie.getItemMeta();
            if(itemMeta != null) {
                PersistentDataContainer data = itemMeta.getPersistentDataContainer();
                data.set(new NamespacedKey("myplugin", "god_cookie"), PersistentDataType.BYTE, (byte)1);
                cookie.setItemMeta(itemMeta);
                itemMeta.setDisplayName("God cookie");
                cookie.setItemMeta(itemMeta);
            }
            cookie.addUnsafeEnchantment(Enchantment.KNOCKBACK, 255);

            player.getInventory().addItem(cookie);
            player.sendMessage("Lul. Have fun!");
        }
        return true;
    }
}
