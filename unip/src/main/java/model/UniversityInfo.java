package model;

import java.sql.*;

public class UniversityInfo {
    private Connection connection;

    public UniversityInfo() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
    }

    public String getAboutUniversityText() throws SQLException {
        StringBuilder text = new StringBuilder();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM about_the_university");
        while (resultSet.next()) {
            text.append(resultSet.getString("text"));
        }
        return text.toString();
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}