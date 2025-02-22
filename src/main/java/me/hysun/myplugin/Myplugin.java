package me.hysun.myplugin;

import me.hysun.myplugin.Commands.SetSpawnCommand;
import me.hysun.myplugin.Commands.SpawnCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Myplugin extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Myplugin has started");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Myplugin has stoppped");
    }

}
