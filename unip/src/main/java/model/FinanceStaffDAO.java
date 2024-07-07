package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class FinanceStaffDAO {
    public static void addFinanceStaff(String name, String lastname, String username, String password, String phoneNumber, String email, int salary) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
        PreparedStatement statement = connection.prepareStatement("INSERT INTO finance_staff (name, lastname, username, password, phone_number, email, salary, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, name);
        statement.setString(2, lastname);
        statement.setString(3, username);
        statement.setString(4, password);
        statement.setString(5, phoneNumber);
        statement.setString(6, email);
        statement.setInt(7, salary);

        java.util.Date date = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String x = simpleDateFormat.format(date);
        statement.setString(8, x);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
        String y = simpleDateFormat1.format(date);
        statement.setString(9, y);

        statement.executeUpdate();
    }
}