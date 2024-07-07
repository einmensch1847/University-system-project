package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class ShowChosingCourseUnitPage extends VBox {
    public ShowChosingCourseUnitPage() {
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            int row = 0;
            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                String NAME = resultSet.getString("name");
                String LASTNAME = resultSet.getString("lastname");
                String student_number = resultSet.getString("student_number");
                String L1 = resultSet.getString("L1");
                String L2 = resultSet.getString("L2");
                String L3 = resultSet.getString("L3");
                String L4 = resultSet.getString("L4");
                String L5 = resultSet.getString("L5");
                String L6 = resultSet.getString("L6");
                String L7 = resultSet.getString("L7");
                String L8 = resultSet.getString("L8");
                String L9 = resultSet.getString("L9");
                String L10 = resultSet.getString("L10");

                Label id_label = new Label(String.valueOf(ID));
                HBox hBox1 = new HBox(id_label);
                hBox1.setStyle("-fx-background-radius: 8px ; -fx-background-color: rgba(255,68,0,0.47) ;-fx-text-alignment: center ;");

                Label name_Lastname_label = new Label(NAME+" "+LASTNAME);
                name_Lastname_label.setStyle("-fx-text-fill: rgba(0,0,0,0.93); -fx-font-size: 12px");
                HBox hBox = new HBox(name_Lastname_label);
                hBox.setStyle("-fx-background-radius: 8px ; -fx-background-color: rgba(26,68,201,0.4) ;-fx-text-alignment: center ;");
                Label student_number_label = new Label(student_number);
                Label L1_label = new Label(L1);
                Label L2_label = new Label(L2);
                Label L3_label = new Label(L3);
                Label L4_label = new Label(L4);
                Label L5_label = new Label(L5);
                Label L6_label = new Label(L6);
                Label L7_label = new Label(L7);
                Label L8_label = new Label(L8);
                Label L9_label = new Label(L9);
                Label L10_label = new Label(L10);



                gridPane.add(hBox1, 0, row);
                gridPane.add(hBox , 1, row);
                gridPane.add(student_number_label, 2, row);
                gridPane.add(L1_label, 3, row);
                gridPane.add(L2_label, 4, row);
                gridPane.add(L3_label, 5, row);
                gridPane.add(L4_label, 6, row);
                gridPane.add(L5_label, 7, row);
                gridPane.add(L6_label, 8, row);
                gridPane.add(L7_label, 9, row);
                gridPane.add(L8_label, 10, row);
                gridPane.add(L9_label, 11, row);
                gridPane.add(L10_label, 12, row);
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
