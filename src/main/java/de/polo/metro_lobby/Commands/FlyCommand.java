package de.polo.metro_lobby.Commands;

import de.polo.metro_lobby.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class FlyCommand implements CommandExecutor {

    private boolean flightMode = false;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args){
        Player p = (Player) sender;
        if (sender.hasPermission("metro.fly")) {
            if (flightMode) {
                flightMode = false;
                sender.sendMessage(Main.prefix + "Du kannst nun nicht mehr fliegen.");
                ((Player) sender).setAllowFlight(false);
                ((Player) sender).setFlying(false);
            } else {
                flightMode = true;
                sender.sendMessage(Main.prefix + "Du kannst nun fliegen.");
                ((Player) sender).setAllowFlight(true);
            }
        } else {
            sender.sendMessage(Main.err_noperms);
        }
        return false;
    }

}
