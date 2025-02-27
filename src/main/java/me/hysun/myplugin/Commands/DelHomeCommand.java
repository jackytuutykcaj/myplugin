package me.hysun.myplugin.Commands;

import me.hysun.myplugin.Myplugin;
import me.hysun.myplugin.Utils.CustomConfig;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class DelHomeCommand implements CommandExecutor {
    private final Myplugin plugin;

    public DelHomeCommand(Myplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            UUID player_UUID = player.getUniqueId();
            if(strings.length == 1) {
                CustomConfig.checkIfFileExists(plugin, player_UUID, plugin.getDataFolder() + "/playerData", player_UUID + ".yml");
                Location location = CustomConfig.get().getLocation("sethome."+strings[0]);
                if(location != null) {
                    CustomConfig.get().set("sethome." + strings[0], null);
                    CustomConfig.save();
                    player.sendMessage("Home deleted!");
                }else{
                    player.sendMessage("That home doesn't exist.");
                }
            }
        }
        return true;
    }
}
