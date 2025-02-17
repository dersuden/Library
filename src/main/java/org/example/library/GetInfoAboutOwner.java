package org.example.library;

import java.sql.*;

public class GetInfoAboutOwner {
    public void getInfoAboutOwner() {
        String url = "jdbc:postgresql://localhost:5432/Library";
        String user = "Arthur";
        String password = "123";
        String sql = "SELECT * FROM owner";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String ownerName = resultSet.getString("owner_name");
                String email = resultSet.getString("email");
                String number = resultSet.getString("number");
                String info = "Данные: " + "\n" + "id: " + id + "\n" + "ФИО читателя: " + ownerName + "\n" + "Почта читателя: " + email + "\n" + "Телефон читателя: " + number + "\n";
                System.out.println(info);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
