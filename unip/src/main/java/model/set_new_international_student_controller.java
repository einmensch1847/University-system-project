package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class set_new_international_student_controller {
    public boolean registerStudent(String name, String lastname, String username, String password, String field,
                                   String studentNumber, String dateOfBirth, String fatherName, String phoneNumber,
                                   String postalCode, String address, String tuition, int age, int debt , String nationality) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO international_students (name, lastname, username, password, field, student_number, date_of_dirth, " +
                            "father_name, phone_number, postal_code, address, tuition, age, debt, date, time , unit , L1 , L2 , L3 , L4 , L5 , L6 , L7 , L8 , L9 , L10 , nationality) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0 , ?,?,?,?,?,?,?,?,?,? , ? )");

            statement.setString(1, name);
            statement.setString(2, lastname);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.setString(5, field);
            statement.setString(6, studentNumber);
            statement.setString(7, dateOfBirth);
            statement.setString(8, fatherName);
            statement.setString(9, phoneNumber);
            statement.setString(10, postalCode);
            statement.setString(11, address);
            statement.setString(12, tuition);
            statement.setInt(13, age);
            statement.setInt(14, debt);

            java.util.Date date = new java.util.Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            statement.setString(15, simpleDateFormat.format(date));
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
            statement.setString(16, simpleDateFormat1.format(date));
            statement.setString(17, "...");
            statement.setString(18, "...");
            statement.setString(19, "...");
            statement.setString(20, "...");
            statement.setString(21, "...");
            statement.setString(22, "...");
            statement.setString(23, "...");
            statement.setString(24, "...");
            statement.setString(25, "...");
            statement.setString(26, "...");
            statement.setString(27, nationality);


            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
