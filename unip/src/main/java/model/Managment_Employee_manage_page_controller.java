package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Managment_Employee_manage_page_controller {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/uni_project";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public void updateEmployee(int id, String name, String lastName, String username, String password, String phoneNumber, String email, int salary) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        String query = "UPDATE management_employee SET name = ?, lastname = ?, username = ?, password = ?, phone_number = ?, email = ?, salary = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, lastName);
        statement.setString(3, username);
        statement.setString(4, password);
        statement.setString(5, phoneNumber);
        statement.setString(6, email);
        statement.setInt(7, salary);
        statement.setInt(8, id);
        statement.executeUpdate();
    }
}
