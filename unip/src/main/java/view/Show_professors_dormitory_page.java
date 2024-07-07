package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class Show_professors_dormitory_page extends VBox{
    public Show_professors_dormitory_page() {
        VBox vBox = new VBox();
        vBox.setPrefSize(538, 740);
        vBox.setSpacing(25);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setPrefSize(538, 740);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM professors_dormitory_reqest");

            int row = 0;
            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                String NAME = resultSet.getString("name");
                String LASTNAME = resultSet.getString("lastname");
                String phone_number = resultSet.getString("phone_number");
                String email = resultSet.getString("Email");
                String father_name = resultSet.getString("father_name");
                int age = resultSet.getInt("age");
                String reason = resultSet.getString("reason");
                String other_explanations = resultSet.getString("other_explanations");
                String date  = resultSet.getString("date");
                String time  = resultSet.getString("time");

                Label id_label = new Label(String.valueOf(ID));
                HBox hBox1 = new HBox(id_label);
                hBox1.setStyle("-fx-background-radius: 8px ; -fx-background-color: rgba(255,68,0,0.47) ;-fx-text-alignment: center ;");

                Label name_Lastname_label = new Label(NAME+" "+LASTNAME);
                name_Lastname_label.setStyle("-fx-text-fill: rgba(0,0,0,0.93); -fx-font-size: 12px");
                HBox hBox = new HBox(name_Lastname_label);
                hBox.setStyle("-fx-background-radius: 8px ; -fx-background-color: rgba(26,68,201,0.4) ;-fx-text-alignment: center ;");
                Label phone_number_label = new Label(phone_number);
                Label email_label = new Label(email);
                Label father_name_label = new Label(father_name);
                Label age_label = new Label(String.valueOf(age));
                Label reason_label = new Label(reason);
                Label other_explanations_label = new Label(other_explanations);
                Label date_label = new Label(date);
                Label time_label = new Label(time);


                gridPane.add(hBox1, 0, row);
                gridPane.add(hBox , 1, row);
                gridPane.add(phone_number_label, 2, row);
                gridPane.add(email_label, 3, row);
                gridPane.add(father_name_label, 4, row);
                gridPane.add(age_label, 5, row);
                gridPane.add(reason_label, 6, row);
                gridPane.add(other_explanations_label, 7, row);
                gridPane.add(date_label, 8, row);
                gridPane.add(time_label, 9, row);
                row++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        scrollPane.setContent(gridPane);

        Button exitButton = new Button();
        exitButton.setText("EXIT");
        exitButton.setPrefSize(50, 20);
        exitButton.setStyle("-fx-font-size: 8px; -fx-font-family: Arial; -fx-background-color: rgba(183,107,107,0.93); -fx-background-radius: 10px;");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            }
        });

        HBox buttonBox = new HBox(exitButton);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.setLayoutX(330);
        buttonBox.setLayoutY(750);

        this.setPrefSize(538, 780);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(scrollPane, buttonBox);
        this.getChildren().add(pane);
    }
}
