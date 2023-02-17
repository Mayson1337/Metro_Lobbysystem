package de.polo.metro_lobby;

import de.polo.metro_lobby.Listener.*;
import de.polo.metro_lobby.Commands.*;
import de.polo.metro_lobby.Utils.PlayerManager;
import de.polo.metro_lobby.database.MySQL;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.*;

public class Main extends JavaPlugin {

    public static String prefix = "§cLobby §8» §7";
    public static String err_noperms = "§cLobby §8» §cDie benötigte Berechtigung fehlt";
    public static PlayerManager playerManager;
    private static Main instance;


    public void onLoad() {
        instance = this;
    }

    public void onEnable() {
        getLogger().info(ChatColor.GREEN + "Metro-Lobby wurde gestartet.");
        try {
            MySQL.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        registerListener();
        registerCommands();

    }
    private void registerListener(){
        getServer().getPluginManager().registerEvents(new DoppelsprungListener(),this);
        getServer().getPluginManager().registerEvents(new JoinListener(),this);
        getServer().getPluginManager().registerEvents(new QuitListener(),this);
        getServer().getPluginManager().registerEvents(new PlayerDamageListener(),this);
        getServer().getPluginManager().registerEvents(new FoodChangeListener(),this);
        getServer().getPluginManager().registerEvents(new ItemDropListener(),this);
        getServer().getPluginManager().registerEvents(new NavigatorListener(),this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(),this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(),this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(),this);
        getServer().getPluginManager().registerEvents(new WeatherListener(),this);
        getServer().getPluginManager().registerEvents(new EntitySpawnListener(),this);
    }

    private void registerCommands(){
        getCommand("setloc").setExecutor(new LocationCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("fly").setExecutor(new FlyCommand());
    }

    @Override
    public void onDisable() {
        try {
            MySQL.endConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Main getInstance() {
        return instance;
    }
}
