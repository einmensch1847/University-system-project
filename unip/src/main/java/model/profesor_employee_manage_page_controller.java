package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class profesor_employee_manage_page_controller {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/uni_project";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    public void updateprofessor(int basic_salary , int id, String name, String lastName, String username, String password, String phoneNumber, String email , String address, int salary) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        String query = "UPDATE professor SET name = ? , lastname = ? , username = ? , password = ? , phone_number =? , email = ? , address = ? , basic_salary = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1 , name);
        statement.setString(2, lastName);
        statement.setString(3 , username);
        statement.setString(4 , password);
        statement.setString(5 , phoneNumber);
        statement.setString(6 , email);
        statement.setString(7 , address);
        statement.setInt(8 , salary);
        statement.setInt(9 , id);
        statement.executeUpdate() ;
    }
}
