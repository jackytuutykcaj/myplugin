package me.hysun.myplugin.Commands;

import me.hysun.myplugin.Myplugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final Myplugin plugin;

    public SpawnCommand(Myplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Location location = plugin.getConfig().getLocation("spawn");
            if(location != null) {
                player.teleport(location);
                player.sendMessage("Player teleported to spawn");
            }else {
                player.sendMessage("There is no spawnpoint set. ");
            }
        }
        return true;
    }
}
