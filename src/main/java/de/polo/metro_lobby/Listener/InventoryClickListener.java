package de.polo.metro_lobby.Listener;

import de.polo.metro_lobby.Main;
import de.polo.metro_lobby.Utils.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onNavigator(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (player.getGameMode() == GameMode.SURVIVAL) {
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase("§8» §cNavigator")) {
            if (event.getCurrentItem().getType() == Material.DIRT) {
                LocationManager.useLocation(player, "Freebuild");
                player.sendMessage(Main.prefix + "Du wurdest zu §2Freebuild§7 teleportiert!");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1,2);
            } else if (event.getCurrentItem().getType() == Material.STONE) {
                LocationManager.useLocation(player, "CityBuild");
                player.sendMessage(Main.prefix + "Du wurdest zu §6CityBuild§7 teleportiert!");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1,2);
            } else if (event.getCurrentItem().getType() == Material.CLOCK) {
                LocationManager.useLocation(player, "Spawn");
                player.sendMessage(Main.prefix + "Du wurdest zum §cSpawn§7 teleportiert!");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1,2);
            } else if (event.getCurrentItem().getType() == Material.WOODEN_AXE) {
                LocationManager.useLocation(player, "Rust");
                player.sendMessage(Main.prefix + "Du wurdest zum §7§lRust§7 teleportiert!");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1,2);
            } else if (event.getCurrentItem().getType() == Material.BEACON) {
                LocationManager.useLocation(player, "Community");
                player.sendMessage(Main.prefix + "Du wurdest zu §3Community§7 teleportiert!");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1,2);
            }
        }
        if (event.getView().getTitle().equalsIgnoreCase("§8» §bSpieler verstecken")) {
            if (event.getCurrentItem().getType() == Material.RED_DYE) {
                player.sendMessage(Main.prefix + "Du siehst nun §ckeine §7Spieler mehr!");
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,2);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    player.hidePlayer(all);
                }
                player.closeInventory();
            } else if (event.getCurrentItem().getType() == Material.PURPLE_DYE) {
                player.sendMessage(Main.prefix + "Du siehst nun alle §6VIP §7Spieler!");
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,2);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.hasPermission("metro.isVIP")) {
                        player.showPlayer(p);
                    } else {
                        player.hidePlayer(p);
                    }
                }
                player.closeInventory();
            } else if (event.getCurrentItem().getType() == Material.GREEN_DYE) {
                player.sendMessage(Main.prefix + "Du siehst nun §aalle §7Spieler!");
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,2);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(all);
                }
                player.closeInventory();
            }
        }
    }
}
