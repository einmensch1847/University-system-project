package model;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class EducationEmployeeHandler {

    public static void registerEducationEmployee(String name, String lastname, String username, String password, String phoneNumber, String email, int salary, LocalDate date) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO education_employee (name, lastname, username, password, phone_number, email, salary, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, name);
            statement.setString(2, lastname);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.setString(5, phoneNumber);
            statement.setString(6, email);
            statement.setInt(7, salary);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(Date.from(date.atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant()));
            statement.setString(8, formattedDate);

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            String currentTime = timeFormat.format(new Date());
            statement.setString(9, currentTime);

            statement.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registration");
            alert.setHeaderText(null);
            alert.setContentText("User successfully registered");
            alert.showAndWait();

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Registration");
            alert.setHeaderText(null);
            alert.setContentText("User registration failed\nPlease try a different username");
            alert.showAndWait();
        }
    }
}