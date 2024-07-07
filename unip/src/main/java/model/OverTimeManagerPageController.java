package model;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OverTimeManagerPageController {
    public void handeler(int base_salary , int salary, int time, int id) throws SQLException {
        try {
            int base_salary2 = base_salary + (time * salary) ;

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
            PreparedStatement statement = connection.prepareStatement("UPDATE professor SET OverTimeSalary = ? , overtime = ? , basic_salary = ? WHERE id = ?");
            statement.setInt(1, salary);
            statement.setInt(2, time);
            statement.setInt(3 , base_salary2);
            statement.setInt(4, id);
            statement.executeUpdate();


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("APPLY");
            alert.setHeaderText(null);
            alert.setContentText("APPLIED");
            alert.showAndWait();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("APPLY");
            alert.setHeaderText(null);
            alert.setContentText("ERROR");
            alert.showAndWait();
            e.printStackTrace();
        }
    }
}
