package org.example.library;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddOwner {
    public void addOwner(int id, String ownerName, String email, String number) {
        String url = "jdbc:postgresql://localhost:5432/Library";
        String user = "Arthur";
        String password = "123";
        String sql = "INSERT INTO owner VALUES (?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, ownerName);
            statement.setString(3, email);
            statement.setString(4, number);
            statement.executeUpdate();
            System.out.println("Новый пользователь библиотеки зарегитрирован!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}