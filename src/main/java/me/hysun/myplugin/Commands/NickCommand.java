package me.hysun.myplugin.Commands;

import me.hysun.myplugin.Myplugin;
import me.hysun.myplugin.Utils.CustomConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class NickCommand implements CommandExecutor {
    private final Myplugin plugin;

    public NickCommand(Myplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            UUID player_UUID = player.getUniqueId();
            CustomConfig.checkIfFileExists(plugin, player_UUID, plugin.getDataFolder()+"/playerData", player_UUID+".yml");
            if(strings.length == 0){
                CustomConfig.get().set("nickname", player.getName());
                player.setDisplayName(player.getName());
                player.sendMessage("Your nickname has been removed.");
            }
            if(strings.length == 1) {
                CustomConfig.get().set("nickname", strings[0]);
                player.setDisplayName(strings[0]);
                player.sendMessage("Your nickname has been set to " + strings[0]);
            }
            if(strings.length == 2){
                Player targetPlayer = plugin.getServer().getPlayer(strings[1]);
                UUID target_Player_UUID = targetPlayer.getUniqueId();
                CustomConfig.checkIfFileExists(plugin, target_Player_UUID, plugin.getDataFolder()+"/playerData", target_Player_UUID+".yml");
                if(targetPlayer != null){
                    CustomConfig.get().set("nickname", strings[1]);
                    targetPlayer.setDisplayName(strings[1]);
                    targetPlayer.sendMessage("Your nickname has been set to " + strings[1]);
                    sender.sendMessage("You have set " + player.getName() + " to " + strings[1]);
                }else{
                    ((Player) sender).getPlayer().sendMessage("That player is not on the server");
                }
            }
            CustomConfig.save();
        }
        return true;
    }
}
