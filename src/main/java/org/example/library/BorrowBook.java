package org.example.library;

import java.sql.*;
import java.util.ResourceBundle;

public class BorrowBook {
    public void borrowBook() {
        String url = "jdbc:postgresql://localhost:5432/Library";
        String user = "Arthur";
        String password = "123";
        String sql = "SELECT owner.owner_name, owner.email, owner.number, owner.borrowed_book FROM owner JOIN library ON owner.borrowed_book = library.book_name";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ownerName = resultSet.getString("owner_name");
                String email = resultSet.getString("email");
                String number = resultSet.getString("number");
                String borrowedBook = resultSet.getString("borrowed_book");
                String info = "Информация о должнике: " + "\n" + "ФИО: " + ownerName + "\n" + "Электронная почта: " + email + "\n" + "Телефон: " + number + "\n" + "Список книг: " + borrowedBook;
                System.out.println(info);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
