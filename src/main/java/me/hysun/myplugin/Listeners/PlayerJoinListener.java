package me.hysun.myplugin.Listeners;

import me.hysun.myplugin.Myplugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final Myplugin plugin;

    public PlayerJoinListener(Myplugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if(!event.getPlayer().hasPlayedBefore()){
            Location location = plugin.getConfig().getLocation("spawn");
            Player player = event.getPlayer();
            String joinMessage = plugin.getConfig().getString("welcome-message");
            if(location != null && joinMessage != null){
                joinMessage = joinMessage.replace("%player%", player.getName());
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', joinMessage));
                player.teleport(location);
            }
        }
    }
}
