package me.hysun.myplugin.Commands;

import me.hysun.myplugin.Myplugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickCommand implements CommandExecutor {
    private final Myplugin plugin;

    public NickCommand(Myplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            if(strings.length == 0){
                Player player = (Player) sender;
                player.setDisplayName(player.getName());
                player.sendMessage("Your nickname has been removed.");
            }
            if(strings.length == 1) {
                Player player = (Player) sender;
                player.setDisplayName(strings[0]);
                player.sendMessage("Your nickname has been set to " + strings[0]);
            }
            if(strings.length == 2){
                Player player = plugin.getServer().getPlayer(strings[0]);
                if(player != null){
                    player.setDisplayName(strings[1]);
                    player.sendMessage("Your nickname has been set to " + strings[1]);
                    sender.sendMessage("You have set " + player.getName() + " to " + strings[1]);
                }else{
                    ((Player) sender).getPlayer().sendMessage("That player is not on the server");
                }
            }
        }
        return true;
    }
}
