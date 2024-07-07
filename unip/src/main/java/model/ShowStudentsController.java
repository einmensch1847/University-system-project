package model;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.sql.*;

public class ShowStudentsController {
    public static void loadStudentsInfo(VBox vBox) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String field = resultSet.getString("field");
                String studentNumber = resultSet.getString("student_number");
                String dateOfBirth = resultSet.getString("date_of_dirth");
                String fatherName = resultSet.getString("father_name");
                String phoneNumber = resultSet.getString("phone_number");
                String postalCode = resultSet.getString("postal_code");
                String address = resultSet.getString("address");
                String tuition = resultSet.getString("tuition");
                int age = resultSet.getInt("age");
                int debt = resultSet.getInt("debt");
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");

                Label label = new Label(id + " : " + name + " " + lastname + " username: " + username + " password: " + password + " field: " + field +
                        "student number: " + studentNumber + " date of birth: " + dateOfBirth + "\n" + " fathername :" + fatherName + " phone num: " + phoneNumber +
                        "postal code: " + postalCode + " address: " + address + " tuition: " + tuition +
                        "age: " + age + " debt: " + debt + " Membership time: " + date + "  " + time);
                label.setStyle("-fx-text-fill: rgba(0,0,0,0.93); -fx-font-size: 8px");
                vBox.getChildren().add(label);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}