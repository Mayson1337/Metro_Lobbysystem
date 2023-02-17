package de.polo.metro_lobby.Listener;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawnListener implements Listener {
    public void onEntitySpawn(EntitySpawnEvent event) {
        event.setCancelled(true);
    }
}
