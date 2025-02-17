package org.example.library;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBook {
    public void addBook(int id, String bookName, String bookAuthor) {
        String url = "jdbc:postgresql://localhost:5432/Library";
        String user = "Arthur";
        String password = "123";
        String sql = "INSERT INTO library VALUES (?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, bookName);
            statement.setString(3, bookAuthor);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}