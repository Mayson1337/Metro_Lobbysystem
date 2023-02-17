package de.polo.metro_lobby.Listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockPlaceEvent event) {
        Player player = (Player) event.getPlayer();
        if (player.getGameMode() == GameMode.SURVIVAL) {
            event.setCancelled(true);
        }
    }
}