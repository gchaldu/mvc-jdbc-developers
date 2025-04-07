package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final String URL = "jdbc:mysql://localhost:3306/developers";
    private final String USER = "root";
    private final String PASSWORD = "devtalles";

    private static DatabaseConnection instance;
    private final Connection connection;

    private DatabaseConnection() throws SQLException {
        this.connection = DriverManager.getConnection(URL,USER,PASSWORD);
        System.out.println("Conectado...");
    }

    public static synchronized DatabaseConnection getInstance() throws SQLException {
        if(instance==null || instance.connection.isClosed()){
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
