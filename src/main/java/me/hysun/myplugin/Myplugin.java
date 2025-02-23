package me.hysun.myplugin;

import me.hysun.myplugin.Commands.*;
import me.hysun.myplugin.Listeners.PlayerJoinListener;
import me.hysun.myplugin.Listeners.PlayerLeaveListener;
import me.hysun.myplugin.Listeners.PlayerRespawnListener;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Myplugin extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Myplugin has started");
        //getConfig().options().copyDefaults();
        saveDefaultConfig();
        Location location = this.getServer().getWorlds().get(0).getSpawnLocation();
        if(this.getConfig().getLocation("location") == null){
            System.out.println("No spawn point set in config.");
            System.out.println("Setting one now.");
            this.getConfig().set("spawn", location);
            this.saveConfig();
        }
        File playerDataFolder = new File(this.getDataFolder(), "playerData");
        if(!playerDataFolder.exists()){
            playerDataFolder.mkdirs();
        }
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("joinmessage").setExecutor(new JoinMessageCommand(this));
        getCommand("god").setExecutor(new GodCommand(this));
        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("nick").setExecutor(new NickCommand(this));
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerLeaveListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Myplugin has stoppped");
    }

}
