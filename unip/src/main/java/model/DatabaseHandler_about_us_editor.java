package model;

import java.sql.*;

public class DatabaseHandler_about_us_editor {
    private static final String URL = "jdbc:mysql://localhost:3306/uni_project";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public String loadAboutUsText() {
        String query = "SELECT * FROM about_the_university";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return resultSet.getString("text");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateAboutUs(String text) {
        String query = "UPDATE about_the_university SET text = ? WHERE id = 0";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, text);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}