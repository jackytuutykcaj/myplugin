package me.hysun.myplugin.Commands;

import me.hysun.myplugin.Myplugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinMessageCommand implements CommandExecutor {
    private final Myplugin plugin;

    public JoinMessageCommand(Myplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(strings.length > 0) {
            String joinmessage = String.join(" ", strings);
            plugin.getConfig().set("welcome-message", joinmessage);
            plugin.saveConfig();
            Player player = (Player) sender;
            player.sendMessage("Join message changed.");
        }else{
            if(sender instanceof Player){
                Player player = (Player) sender;
                player.sendMessage("Error setting join message");
            }
            System.out.println("Error setting join message");
        }
        return true;
    }
}
