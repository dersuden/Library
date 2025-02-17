package org.example.library;

import java.sql.*;

public class GetInfoAboutBook {
    public void getInfo() {
        String url = "jdbc:postgresql://localhost:5432/Library";
        String user = "Arthur";
        String password = "123";
        String sql = "SELECT * FROM Library";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String bookName = resultSet.getString("book_name");
                String bookAuthor = resultSet.getString("book_author");
                String info = "Данные: " + "\n" + "id = " + id + "\n" + "Название книги: " + bookName + "\n" + "Автор книги: " + bookAuthor;
                System.out.println(info);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
