package org.example.developer.persistence;

import org.example.connection.DatabaseConnection;
import org.example.developer.model.Developer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeveloperDAO {

    public void saveDeveloper(Developer developer) {
        String sql = "INSERT INTO developers (id, name, age) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, developer.getId());
                statement.setString(2, developer.getName());
                statement.setInt(3, developer.getAge());

                statement.executeUpdate();
                connection.commit();

            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Error al ejecutar statement: " + e.getMessage());
            } finally {
                connection.setAutoCommit(true);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener conexión o rollback fallido: " + e.getMessage());
        }
    }
}
