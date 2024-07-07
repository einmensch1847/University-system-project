package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class student_dormitory_page_controller {
    private static Connection connection;

    public student_dormitory_page_controller() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
    }
    public void student_dormitory_page_controllerr(String name, String lastname, String phoneNumber, String email, String fatherName,
                                                      int age, String reason, String otherExplanations) throws SQLException {
        String query = "INSERT INTO student_dormitory_request (name, lastname, phone_number, Email, father_name, age, reason, other_explanations, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, lastname);
        statement.setString(3, phoneNumber);
        statement.setString(4, email);
        statement.setString(5, fatherName);
        statement.setInt(6, age);
        statement.setString(7, reason);
        statement.setString(8, otherExplanations);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date);
        statement.setString(9, formattedDate);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = timeFormat.format(date);
        statement.setString(10, formattedTime);

        statement.executeUpdate();
    }

    public static void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
