package me.hysun.myplugin.Commands;

import me.hysun.myplugin.Myplugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InvCommand implements CommandExecutor {
    private final Myplugin plugin;

    public InvCommand(Myplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            if(strings.length == 1) {
                Player player = (Player) sender;
                Player targetplayer = plugin.getServer().getPlayer(strings[0]);
                if(targetplayer != null) {
                    if (targetplayer.isOnline()) {
                        Inventory inventory = targetplayer.getInventory();
                        player.openInventory(inventory);
                    }
                }else{
                    player.sendMessage("This player is not online");
                }
            }
        }
        return true;
    }
}
