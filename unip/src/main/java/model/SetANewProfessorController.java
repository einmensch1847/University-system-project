package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetANewProfessorController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/uni_project";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public boolean registerProfessor(String name, String lastname, String username, String password, String dateOfBirth, int age, String phoneNumber, String email, String address, String degreeOfEducation, String topic, int unit, int basicSalary) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO professor (name, lastname, username, password, date_of_dirth, age, phone_number, email, address, degree_of_education, topic, unit, basic_salary, date, time, number_of_students, overtime , subject , student_limit, OverTimeSalary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,40)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, lastname);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.setString(5, dateOfBirth);
            statement.setInt(6, age);
            statement.setString(7, phoneNumber);
            statement.setString(8, email);
            statement.setString(9, address);
            statement.setString(10, degreeOfEducation);
            statement.setString(11, topic);
            statement.setInt(12, unit);
            statement.setInt(13, basicSalary);

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

            statement.setString(14, dateFormat.format(date));
            statement.setString(15, timeFormat.format(date));
            statement.setInt(16, 0);
            statement.setInt(17, 0);
            statement.setString(18 , ".....");
            statement.setInt(19, 0);

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}