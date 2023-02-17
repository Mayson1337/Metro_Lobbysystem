package de.polo.metro_lobby.Listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = (Player) event.getPlayer();
        if (player.getGameMode() == GameMode.SURVIVAL) {
            event.setCancelled(true);
        }
    }
}
