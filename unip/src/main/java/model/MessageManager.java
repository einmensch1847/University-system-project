//package model;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MessageManager {
//    public void addMessage(Message message) {
//        String query = "INSERT INTO messages (sender, content, timestamp) VALUES (?, ?, ?)";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, message.getSender());
//            statement.setString(2, message.getContent());
//            statement.setTimestamp(3, Timestamp.valueOf(message.getTimestamp()));
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Message> getMessages() {
//        List<Message> messages = new ArrayList<>();
//        String query = "SELECT sender, content, timestamp FROM messages";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(query);
//             ResultSet resultSet = statement.executeQuery()) {
//            while (resultSet.next()) {
//                String sender = resultSet.getString("sender");
//                String content = resultSet.getString("content");
//                Timestamp timestamp = resultSet.getTimestamp("timestamp");
//                Message message = new Message(sender, content);
//                message.setTimestamp(timestamp.toLocalDateTime());
//                messages.add(message);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return messages;
//    }
//}