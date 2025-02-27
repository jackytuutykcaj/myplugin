package me.hysun.myplugin.Commands;

import me.hysun.myplugin.Myplugin;
import me.hysun.myplugin.Utils.CustomConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class SetHomeCommand implements CommandExecutor {
    private final Myplugin plugin;

    public SetHomeCommand(Myplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            UUID player_UUID = player.getUniqueId();
            if(strings.length == 0) {
                CustomConfig.checkIfFileExists(plugin, player_UUID, plugin.getDataFolder() + "/playerData", player_UUID + ".yml");
                if (strings.length == 0) {
                    CustomConfig.get().set("sethome.home", player.getLocation());
                }
                CustomConfig.save();
                player.sendMessage("Home set!");
            }
            if(strings.length == 1){
                CustomConfig.checkIfFileExists(plugin, player_UUID, plugin.getDataFolder() + "/playerData", player_UUID + ".yml");
                CustomConfig.get().set("sethome."+strings[0], player.getLocation());
                CustomConfig.save();
                player.sendMessage("Home set!");
            }
        }
        return true;
    }
}
