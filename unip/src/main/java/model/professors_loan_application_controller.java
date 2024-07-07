package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class professors_loan_application_controller {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/uni_project";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public void professors_loan_application_controllerr(String name, String lastname, String email, String phoneNumber, int requestedAmount, int id, int age, String otherExplanations, String reason)throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO professors_loan_application (name, lastname, email, phon_number, requested_amount, professor_id, age, other_explanations, reason, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        statement.setString(1, name);
        statement.setString(2, lastname);
        statement.setString(3, email);
        statement.setString(4, phoneNumber);
        statement.setInt(5, requestedAmount);
        statement.setInt(6, id);
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
