package de.polo.metro_lobby.database;

import java.sql.*;

public class MySQL {
    static String url = "jdbc:mysql://localhost/minecraft";
    static String user = "root";
    static String password = "password";
    static int port = 3306;
    private static boolean error;
    public static Connection connection;
    public static Connection getConnection() throws SQLException {
        if(connection != null) {
            return connection;
        }
        Connection connection = DriverManager.getConnection(url, user, password);

        for (int i = 0; i < 5; i++) {
            System.out.println("[MySQL]: Datenbank verbunden");
        }
        return connection;
    }

    public static Statement getStatement() throws SQLException {
        if(connection != null) {
            return (Statement) connection;
        }
        Connection connection = DriverManager.getConnection(url, user, password);

        return connection.createStatement();
    }
    public static boolean isError() {
        return error;
    }

    public static void setError(boolean error) {
        MySQL.error = error;
    }

    public static void endConnection() throws SQLException {
        MySQL.connection.close();
    }

}
