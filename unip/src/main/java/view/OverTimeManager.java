package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.profesor_employee_manage_page_controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class OverTimeManager extends VBox {
    public OverTimeManager() {

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setPrefSize(1540, 740);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM professor");

            int row = 0;
            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                String NAME = resultSet.getString("name");
                String LASTNAME = resultSet.getString("lastname");
                String SUBJECT = resultSet.getString("subject");
                int number_of_students = resultSet.getInt("number_of_students");
                int basic_salary = resultSet.getInt("basic_salary");
                int overtime = resultSet.getInt("overtime");
                int OverTimeSalary = resultSet.getInt("OverTimeSalary");

                Label label = new Label(ID + " : " + NAME + " " + LASTNAME + " subject : " + SUBJECT + " (Students: " + number_of_students + ") , basic salary : "+basic_salary+" , overtime : "+overtime+" , OverTimeSalary : "+OverTimeSalary);
                label.setStyle("-fx-text-fill: rgb(34,92,47); -fx-font-size: 12px ; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-family: Arial ");
                HBox hBox = new HBox(label);
                hBox.setStyle("-fx-background-radius: 8px ; -fx-background-color: rgba(26,68,201,0.4) ;-fx-text-alignment: center ;");

                Button edit_button = new Button("Edit");
                edit_button.setStyle("-fx-text-fill: rgb(34,92,47); -fx-font-size: 12px ; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-family: Arial ; -fx-background-radius: 10px ; -fx-text-alignment: center ;-fx-background-color: #29a395");
                edit_button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        OverTimeManagerPage overTimeManagerPage = null;
                        try {
                            overTimeManagerPage = new OverTimeManagerPage(OverTimeSalary , ID , overtime , basic_salary);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        Stage stage1 = new Stage() ;
                        stage1.setScene(new Scene(overTimeManagerPage));
                        stage1.show();
                    }
                });


                gridPane.add(hBox, 0, row);
                gridPane.add(edit_button, 1, row);
                row++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        scrollPane.setContent(gridPane);

        Button Exit_button = new Button() ;
        Exit_button.setText("\" EXIT \"");
        Exit_button.setPrefSize(50 , 20);
        Exit_button.setStyle("-fx-font-size: 8px ; -fx-font-family: Arial ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
        Exit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) Exit_button.getScene().getWindow() ;
                stage.close();
            }
        });
        Exit_button.setLayoutX(1450);
        Exit_button.setLayoutY(750);

        this.setPrefSize(1540, 785);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(scrollPane , Exit_button);
        this.getChildren().add(pane);
    }
}
