package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.text.SimpleDateFormat;

public class PublicChatPage extends VBox {

    private GridPane gridPane;
    private int row;

    public PublicChatPage() throws FileNotFoundException {

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setStyle("-fx-background-color: rgba(32,48,97,0.75); -fx-spacing: 25");
        scrollPane.setPrefSize(538, 740);

        row = 0;
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        scrollPane.setContent(gridPane);
        loadMessages();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> loadMessages()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        TextField messageField = new TextField();
        messageField.setPromptText("Type your message...");
        messageField.setPrefSize(493, 40);


        Button sendButton = new Button("➤");
        sendButton.setStyle("-fx-background-color: #204097; -fx-text-fill: white; -fx-font-size: 18px;");
        sendButton.setPrefSize(45, 40);
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO public_chat(text, date, time , color) VALUES(? , ? , ? , ?)");
                    statement.setString(1, messageField.getText());
                    java.util.Date date = new java.util.Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    statement.setString(2, simpleDateFormat.format(date));
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
                    statement.setString(3, simpleDateFormat1.format(date));
                    statement.setString(4 , "RED");
                    statement.executeUpdate();
                    connection.close();

                    addMessageToGrid(row++, messageField.getText(), simpleDateFormat1.format(date) , "RED");
                    messageField.clear();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        messageField.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() == KeyCode.ENTER){
                sendButton.fire();
                event.consume();
            }
        });

        Image image = new Image(new FileInputStream("c:/test/unip/admin_panel.jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(538, 780);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(scrollPane);
        this.getChildren().add(pane);
        hBox.getChildren().addAll(messageField, sendButton);
        this.getChildren().add(hBox);
    }

    private void loadMessages() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public_chat");

            gridPane.getChildren().clear();
            row = 0;

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String text = resultSet.getString("text");
                String time = resultSet.getString("time");
                String color = resultSet.getString("color");

                addMessageToGrid(row++, id + " : " + text, time , color);

            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addMessageToGrid(int row, String text, String time , String color) {
        Shape shape = new Circle(10, 10, 10);
//        shape.setFill(Color.RED);
        shape.setStyle("-fx-fill: " + color + ";");


        Label l = new Label(text);
        l.setWrapText(true);
        l.setMaxWidth(200);
        l.setStyle("-fx-text-fill: rgba(0,0,0,0.93); -fx-font-size: 12px");
        Label l2 = new Label(time);

        gridPane.add(shape, 0, row);
        gridPane.add(l, 1, row);
        gridPane.add(l2, 2, row);
    }
}