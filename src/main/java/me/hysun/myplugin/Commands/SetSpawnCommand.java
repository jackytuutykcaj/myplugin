package me.hysun.myplugin.Commands;

import me.hysun.myplugin.Myplugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final Myplugin plugin;

    public SetSpawnCommand(Myplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Location location = player.getLocation();
            plugin.getConfig().set("spawn", location);
            plugin.saveConfig();
            player.sendMessage("Spawnpoint has been set");
            System.out.println("Spawnpoint has been set");
        }
        return true;
    }
}
