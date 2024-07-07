package view;

import com.mysql.cj.jdbc.ConnectionWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.OverTimeManagerPageController;
import model.profesor_employee_manage_page_controller;

import java.io.FileInputStream;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class OverTimeManagerPage extends VBox{
    public int salary = 0 ;
    public int time = 0 ;
    public OverTimeManagerPage(int OverTimeSalary , int id , int OverTime , int base_salary) throws FileNotFoundException {

        Label over_time_salary = new Label("salary : "+OverTimeSalary+"\ntime : "+OverTime+"\nOVER TIME SALARY : ");
        over_time_salary.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 12px ; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-family: Arial ; -fx-text-alignment: center");
        over_time_salary.setAlignment(Pos.CENTER);

        TextField textField = new TextField();
        textField.setPromptText("Over Salary") ;
        textField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        TextField textField2 = new TextField();
        textField2.setPromptText("Over Time") ;
        textField2.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        Button button = new Button("APPLY") ;
        button.setPrefSize(100 , 40);
        button.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(162,187,227,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                time = Integer.parseInt(textField2.getText()) ;
                salary = Integer.parseInt(textField.getText()) ;
                OverTimeManagerPageController overTimeManagerPageController = new OverTimeManagerPageController() ;
                try {
                    overTimeManagerPageController.handeler(base_salary , salary , time , id);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        VBox vbox = new VBox(over_time_salary, textField , textField2 , button);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);


        Image image = new Image(new FileInputStream("admin_panel.jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(200, 290);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        Pane pane = new Pane();
        pane.getChildren().addAll(vbox);
        this.getChildren().add(pane);
    }
}
