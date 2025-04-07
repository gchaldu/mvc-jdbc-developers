package org.example.developer.persistence;

import org.example.connection.DatabaseConnection;
import org.example.developer.model.Developer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeveloperDAO {

    public void saveDeveloper(Developer developer){
        String sql = "Insert into developers (id, name, age) value ( ?, ?, ?) ";

        try(
                Connection connection = DatabaseConnection.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ){
                connection.setAutoCommit(false);

                statement.setString(1, developer.getId());
                statement.setString(2, developer.getName());
                statement.setInt(3, developer.getAge());

                statement.executeUpdate();

                connection.commit();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
