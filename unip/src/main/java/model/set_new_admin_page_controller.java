package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class set_new_admin_page_controller {

    public boolean registerAdmin(String name, String lastname, String username, String password, String dateOfBirth, String fatherName, String phoneNumber, String postalCode, String address, int age) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO admin (name, lastname, username, password, date_of_dirth, father_name, phone_number, postal_code, address, age, date, time, salary) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, name);
            statement.setString(2, lastname);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.setString(5, dateOfBirth);
            statement.setString(6, fatherName);
            statement.setString(7, phoneNumber);
            statement.setString(8, postalCode);
            statement.setString(9, address);
            statement.setInt(10, age);

            java.util.Date date = new java.util.Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            statement.setString(11, simpleDateFormat.format(date));
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
            statement.setString(12, simpleDateFormat1.format(date));
            statement.setInt(13 , 0);

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}