package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student_manage_page_controller {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/uni_project";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public void updateStudent(int id, String name, String lastname, String username, String password, String phone_number, String postal_code, String address, int debt) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "UPDATE student SET name = ?, lastname = ?, username = ?, password = ?, phone_number = ?, postal_code = ?, address = ?, debt = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, lastname);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.setString(5, phone_number);
            statement.setString(6, postal_code);
            statement.setString(7, address);
            statement.setInt(8, debt);
            statement.setInt(9, id);
            statement.executeUpdate();

            connection.close();
            statement.close();

        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
