package me.hysun.myplugin.Listeners;

import me.hysun.myplugin.Myplugin;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {
    private final Myplugin plugin;

    public PlayerRespawnListener(Myplugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
        Location location = plugin.getConfig().getLocation("spawn");
        if(location != null) {
            event.setRespawnLocation(location);
        }
    }
}
