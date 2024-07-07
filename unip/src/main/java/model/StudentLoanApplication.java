package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentLoanApplication {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/uni_project";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public void insertStudentLoanApplication(String name, String lastname, String email, String phoneNumber, int requestedAmount, String studentNumber, int age, String otherExplanations, String reason) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO apply_for_a_student_loan (name, lastname, email, phon_number, requested_amount, student_number, age, other_explanations, reason, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        statement.setString(1, name);
        statement.setString(2, lastname);
        statement.setString(3, email);
        statement.setString(4, phoneNumber);
        statement.setInt(5, requestedAmount);
        statement.setString(6, studentNumber);
        statement.setInt(7, age);
        statement.setString(8, otherExplanations);
        statement.setString(9, reason);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        String formattedDate = dateFormat.format(date);
        statement.setString(10, formattedDate);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = timeFormat.format(date);
        statement.setString(11, formattedTime);

        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}