package de.polo.metro_lobby.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        System.out.println(event.getPlayer().getName() + " hat den Server verlassen.");
        event.setQuitMessage("");
    }
}
