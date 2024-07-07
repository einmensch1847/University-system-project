package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdmissionRequest {
    private Connection connection;

    public AdmissionRequest() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
    }

    public void insertAdmissionRequest(String name, String lastname, String phoneNumber, String email, String fatherName,
                                       int age, String nationality, String country, String reason, String otherExplanations) throws SQLException {
        String query = "INSERT INTO admission_request(name, lastname, phone_number, Email, father_name, age, nationality, country, reason, other_explanations, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, lastname);
        statement.setString(3, phoneNumber);
        statement.setString(4, email);
        statement.setString(5, fatherName);
        statement.setInt(6, age);
        statement.setString(7, nationality);
        statement.setString(8, country);
        statement.setString(9, reason);
        statement.setString(10, otherExplanations);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date);
        statement.setString(11, formattedDate);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = timeFormat.format(date);
        statement.setString(12, formattedTime);

        statement.executeUpdate();
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}