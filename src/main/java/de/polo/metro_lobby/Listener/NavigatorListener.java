package de.polo.metro_lobby.Listener;

import de.polo.metro_lobby.Utils.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class NavigatorListener implements Listener {
    @EventHandler
    public void onNavigator(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (player.getInventory().getItemInMainHand().getType() == Material.COMPASS) {
                Inventory inv = Bukkit.createInventory(player, 54, "§8» §cNavigator");
                inv.setItem(13, ItemManager.createItem(Material.CLOCK,1,0,"§cSpawn"));
                inv.setItem(20, ItemManager.createItem(Material.DIRT,1,0,"§2Freebuild"));
                inv.setItem(24, ItemManager.createItem(Material.STONE,1,0,"§6CityBuild"));
                inv.setItem(38, ItemManager.createItem(Material.WOODEN_AXE,1,0,"§7§lRust"));
                inv.setItem(42, ItemManager.createItem(Material.BEACON,1,0,"§3Community"));
                for (int i = 0; i < 54; i++) {
                    if (inv.getItem(i) == null) {
                        inv.setItem(i, ItemManager.createItem(Material.BLACK_STAINED_GLASS_PANE, 1, 0, "§8"));
                    }
                }
                player.openInventory(inv);
            }
        }
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (player.getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD) {
                Inventory inv = Bukkit.createInventory(player, 9, "§8» §bSpieler verstecken");
                inv.setItem(2, ItemManager.createItem(Material.RED_DYE,1,0,"§cAlle Spieler verstecken"));
                inv.setItem(4, ItemManager.createItem(Material.PURPLE_DYE,1,0,"§6Alle VIP Spieler anzeigen"));
                inv.setItem(6, ItemManager.createItem(Material.GREEN_DYE,1,0,"§aAlle Spieler anzeigen"));
                for (int i = 0; i < 9; i++) {
                    if (inv.getItem(i) == null) {
                        inv.setItem(i, ItemManager.createItem(Material.BLACK_STAINED_GLASS_PANE, 1, 0, "§8"));
                    }
                }
                player.openInventory(inv);
            }
        }
    }
}
