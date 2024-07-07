package model;

import java.sql.*;

public class CommunicationService {
    private Connection connection;

    public CommunicationService() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
    }

    public String getCommunicationText() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Communication_with_the_university");

        StringBuilder communicationText = new StringBuilder();
        while (resultSet.next()) {
            communicationText.append(resultSet.getString("text")).append("\n");
        }
        return communicationText.toString();
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}