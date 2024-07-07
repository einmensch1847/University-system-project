package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CriticsAndSuggestionsDAO {
    private Connection connection;

    public CriticsAndSuggestionsDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getAllCriticsAndSuggestions() {
        List<String> criticsAndSuggestionsList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Critics_and_suggestions");
            while (resultSet.next()) {
                String criticsAndSuggestions = resultSet.getString("Critics_and_suggestions");
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                criticsAndSuggestionsList.add(criticsAndSuggestions + " date and time :" + date + "  " + time);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return criticsAndSuggestionsList;
    }
}