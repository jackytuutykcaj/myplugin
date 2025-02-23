package me.hysun.myplugin.Commands;

import me.hysun.myplugin.Myplugin;
import me.hysun.myplugin.Utils.CustomConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class VanishCommand implements CommandExecutor {
    private final Myplugin plugin;

    public VanishCommand(Myplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            UUID player_UUID = player.getUniqueId();
            CustomConfig.checkIfFileExists(plugin, player_UUID, plugin.getDataFolder()+"/playerData", player_UUID+".yml");
            if(player.isInvisible()){
                player.setInvisible((false));
                CustomConfig.get().set("vanish", false);
                player.sendMessage("You are now visible.");
            }else{
                player.setInvisible(true);
                CustomConfig.get().set("vanish", true);
                player.sendMessage("You are now invisible");
            }
            CustomConfig.save();
        }
        return true;
    }
}
