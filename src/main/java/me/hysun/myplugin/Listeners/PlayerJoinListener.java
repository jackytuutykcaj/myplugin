package me.hysun.myplugin.Listeners;

import me.hysun.myplugin.Myplugin;
import me.hysun.myplugin.Utils.CustomConfig;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class PlayerJoinListener implements Listener {
    private final Myplugin plugin;
    private static File file;
    private static FileConfiguration customFile;

    public PlayerJoinListener(Myplugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if(!event.getPlayer().hasPlayedBefore()){
            Location location = plugin.getConfig().getLocation("spawn");
            Player player = event.getPlayer();
            String joinMessage = plugin.getConfig().getString("welcome-message");
            UUID player_UUID = player.getUniqueId();
            if(location != null && joinMessage != null){
                joinMessage = joinMessage.replace("%player%", player.getName());
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', joinMessage));
                player.teleport(location);
            }
            CustomConfig.checkIfFileExists(plugin, player_UUID, plugin.getDataFolder()+"/playerData", player_UUID+".yml");
            CustomConfig.get().set("nickname", player.getName());
            CustomConfig.get().set("UUID", player_UUID);
            CustomConfig.save();
        }
        Player player = event.getPlayer();
        UUID player_UUID = player.getUniqueId();
        CustomConfig.checkIfFileExists(plugin, player_UUID, plugin.getDataFolder()+"/playerData", player_UUID+".yml");
        player.setDisplayName(CustomConfig.get().getString("nickname"));
        CustomConfig.save();
    }
}
