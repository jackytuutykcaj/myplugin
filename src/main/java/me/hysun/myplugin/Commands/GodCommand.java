package me.hysun.myplugin.Commands;

import me.hysun.myplugin.Myplugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
                if(player.isInvulnerable()){
                    player.setInvulnerable(false);
                    player.sendMessage("You are now mortal.");
                }else{
                    player.setInvulnerable(true);
                    player.setFoodLevel(20);
                    player.setHealth(20);
                    player.sendMessage("You are now immortal.");
                }
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
