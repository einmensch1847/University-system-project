package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/uni_project";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public boolean insertCriticsAndSuggestions(String text) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Critics_and_suggestions (Critics_and_suggestions, date, time) VALUES (?, ?, ?)");
            statement.setString(1, text);
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
            String formattedDate = dateFormat.format(date);
            statement.setString(2, formattedDate);
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            String formattedTime = timeFormat.format(date);
            statement.setString(3, formattedTime);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}