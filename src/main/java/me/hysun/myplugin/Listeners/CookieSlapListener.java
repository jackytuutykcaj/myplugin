package me.hysun.myplugin.Listeners;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CookieSlapListener implements Listener {
    @EventHandler
    public void OnCookieSlap(EntityDamageByEntityEvent event){
        Player player = (Player) event.getDamager();
        ItemStack item = player.getInventory().getItemInMainHand();

        if(item.getType() == Material.COOKIE){
            ItemMeta meta = item.getItemMeta();
            if(meta != null){
                PersistentDataContainer data = meta.getPersistentDataContainer();
                if(data.has(new NamespacedKey("myplugin", "god_cookie"), PersistentDataType.BYTE)){
                    player.sendMessage("Lol cya!");
                }

            }
        }
    }
}
