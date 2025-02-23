package me.hysun.myplugin.Listeners;

import me.hysun.myplugin.Myplugin;
import me.hysun.myplugin.Utils.CustomConfig;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class PlayerLeaveListener implements Listener {
    private final Myplugin plugin;
    private static File file;
    private static FileConfiguration customFile;

    public PlayerLeaveListener(Myplugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Player player = event.getPlayer();
        UUID player_UUID = player.getUniqueId();
        Location location = player.getLocation();
        CustomConfig.checkIfFileExists(plugin, player_UUID, plugin.getDataFolder()+"/playerData", player_UUID+".yml");
        CustomConfig.get().set("last-online", format.format(date));
        CustomConfig.get().set("location", location);
        CustomConfig.save();
        event.setQuitMessage(ChatColor.YELLOW + "~" + player.getDisplayName() + " left the game");
    }
}
