package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ManagementEmployeeDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/uni_project";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void addManagementEmployee(String name, String lastname, String username, String password, String phoneNumber, String email, int salary) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.prepareStatement(
                    "INSERT INTO management_employee (name, lastname, username, password, phone_number, email, salary, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            statement.setString(1, name);
            statement.setString(2, lastname);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.setString(5, phoneNumber);
            statement.setString(6, email);
            statement.setInt(7, salary);

            java.util.Date date = new java.util.Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = simpleDateFormat.format(date);
            statement.setString(8, dateString);

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            String timeString = timeFormat.format(date);
            statement.setString(9, timeString);

            statement.executeUpdate();
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