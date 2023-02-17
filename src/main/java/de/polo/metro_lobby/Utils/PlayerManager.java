package de.polo.metro_lobby.Utils;

import de.polo.metro_lobby.database.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerManager {
    public static int coins = 0;
    public static int playtime = 0;
    public static boolean isCreated(String uuid) {
        try {
            Statement statement = MySQL.getStatement();
            assert statement != null;
            ResultSet result = statement.executeQuery("SELECT `uuid` FROM `players` WHERE `uuid` = '" + uuid + "'");
            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Statement statement = MySQL.getStatement();
            ResultSet result = statement.executeQuery("SELECT `uuid` FROM `players` WHERE `uuid` = '" + uuid + "'");
            statement.execute("INSERT INTO `players` (`uuid`) VALUES ('" + uuid + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static int playerCoins(String uuid) {
        try {
            Statement statement = MySQL.getStatement();
            assert statement != null;
            ResultSet result = statement.executeQuery("SELECT `player_coins` FROM `players` WHERE `uuid` = '" + uuid + "'");
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int playerPlaytime(String uuid) {
        try {
            Statement statement = MySQL.getStatement();
            assert statement != null;
            ResultSet result = statement.executeQuery("SELECT `playtime_hours` FROM `players` WHERE `uuid` = '" + uuid + "'");
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
