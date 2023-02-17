package de.polo.metro_lobby.Listener;

import de.polo.metro_lobby.Features.Scoreboard;
import de.polo.metro_lobby.Main;
import de.polo.metro_lobby.Utils.ItemManager;
import de.polo.metro_lobby.Utils.LocationManager;
import de.polo.metro_lobby.Utils.PlayerManager;
import de.polo.metro_lobby.Utils.ScoreboardBuilder;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;

public class JoinListener implements Listener  {
    public int coins;
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        try {
            System.out.println(event.getPlayer().getName() + " hat den Server betreten. \nSpieler-IP: " + InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println(event.getPlayer().getName() + " hat den Server betreten. \nSpieler-IP: Konnte nicht gefunden werden");
            throw new RuntimeException(e);
        }
        event.setJoinMessage("");
        event.getPlayer().setLevel(Calendar.getInstance().get(Calendar.YEAR));
        event.getPlayer().setExp(0);
        LocationManager.useLocation(event.getPlayer(), "Spawn");
        event.getPlayer().getWorld().playEffect(event.getPlayer().getLocation().add(0.0D, 0.0D, 0.0D), Effect.ENDER_SIGNAL, 1);
        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1,2);
        event.getPlayer().getInventory().clear();
        event.getPlayer().getInventory().setItem(1, ItemManager.createItem(Material.BLAZE_ROD, 1, 0, "§8 » §2Spieler verstecken"));
        event.getPlayer().getInventory().setItem(4, ItemManager.createItem(Material.COMPASS, 1, 0, "§8 » §cNavigator"));
        event.getPlayer().getInventory().setItem(7, ItemManager.createItem(Material.CLOCK, 1, 0, "§8 » §eLobby-Navigator"));
        if (PlayerManager.isCreated(String.valueOf(event.getPlayer().getUniqueId()))) {
            PlayerManager.coins = PlayerManager.playerCoins(String.valueOf(event.getPlayer().getUniqueId()));
        } else {
            event.getPlayer().sendMessage(" ");
            event.getPlayer().sendMessage("§cMetro §8»§7 Herzlich Wilkommen auf Metro " + event.getPlayer().getName() + "!");
            event.getPlayer().sendMessage(" ");
        }

        new Scoreboard(event.getPlayer());
    }
}
