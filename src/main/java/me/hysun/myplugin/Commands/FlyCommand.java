package me.hysun.myplugin.Commands;

import me.hysun.myplugin.Myplugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    private final Myplugin plugin;

    public FlyCommand(Myplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            if(strings.length == 0){
                Player player = (Player) sender;
                if(player.getAllowFlight()){
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.sendMessage("Your flight has been disabled!");
                    System.out.println("Fly has been disabled for " + player.getName());
                }else{
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.sendMessage("You can fly now!");
                    System.out.println("Fly has been enabled for " + player.getName());
                }
            }else{
                Player player = plugin.getServer().getPlayer(strings[0]);
                if(player != null){
                    if(player.getAllowFlight()){
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        player.sendMessage("Your flight has been disabled!");
                        System.out.println("Fly has been disabled for " + player.getName());
                    }else{
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.sendMessage("You can fly now!");
                        System.out.println("Fly has been enabled for " + player.getName());
                    }
                }else{
                    ((Player) sender).getPlayer().sendMessage("This player is not on the server");
                }
            }
        }
        return true;
    }
}
