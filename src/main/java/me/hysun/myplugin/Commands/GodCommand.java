package me.hysun.myplugin.Commands;

import me.hysun.myplugin.Myplugin;
import me.hysun.myplugin.Utils.CustomConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GodCommand implements CommandExecutor {
    private final Myplugin plugin;

    public GodCommand(Myplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            if(strings.length == 0){
                Player player = (Player) sender;
                UUID player_UUID = player.getUniqueId();
                CustomConfig.checkIfFileExists(plugin, player_UUID, plugin.getDataFolder()+"/playerData", player_UUID+".yml");
                if(player.isInvulnerable()){
                    player.setInvulnerable(false);
                    CustomConfig.get().set("god", false);
                    player.sendMessage("You are now mortal.");
                }else{
                    player.setInvulnerable(true);
                    player.setFoodLevel(20);
                    player.setHealth(20);
                    CustomConfig.get().set("god", true);
                    player.sendMessage("You are now immortal.");
                }
                CustomConfig.save();
            }else{
                Player player = plugin.getServer().getPlayer(strings[0]);
                if(player != null){
                    if(player.isInvulnerable()){
                        player.setInvulnerable(false);
                        player.sendMessage("You are now mortal.");
                    }else{
                        player.setInvulnerable(true);
                        player.setFoodLevel(20);
                        player.setHealth(20);
                        player.sendMessage("You are now immortal.");
                    }
                }
            }

        }
        return true;
    }
}
