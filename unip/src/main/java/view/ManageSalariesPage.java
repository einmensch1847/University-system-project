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
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ManageSalariesPage extends VBox{


    public ManageSalariesPage() throws FileNotFoundException {

        Button student = new Button("Student Manager");
        student.setStyle("-fx-background-color: rgba(94,94,90,0.53) ; -fx-text-fill: #ffff ; -fx-font-size: 20px ; -fx-font-weight: bold ; -fx-background-radius: 10px");
        student.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Student_Manage studentManagePage = null;
                try {
                    studentManagePage = new Student_Manage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(studentManagePage));
                stage1.show();
            }
        });
        student.setPrefSize(240 , 100);
        Button Admin = new Button("Admin Manager");
        Admin.setStyle("-fx-background-color: rgba(94,94,90,0.53) ; -fx-text-fill: #ffff ; -fx-font-size: 20px ; -fx-font-weight: bold ; -fx-background-radius: 10px");
        Admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Admin_Manage adminManage = null;
                try {
                    adminManage = new Admin_Manage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(adminManage));
                stage1.show();
            }
        });
        Admin.setPrefSize(240 , 100);
        Button managment_employee = new Button("managment Manager");
        managment_employee.setStyle("-fx-background-color: rgba(94,94,90,0.53) ; -fx-text-fill: #ffff ; -fx-font-size: 20px ; -fx-font-weight: bold ; -fx-background-radius: 10px");
        managment_employee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Managment_Employee_manage managmentEmployeeManage = null;
                try {
                    managmentEmployeeManage = new Managment_Employee_manage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(managmentEmployeeManage));
                stage1.show();
            }
        });
        managment_employee.setPrefSize(240 , 100);
        Button finance_employee = new Button("Finance Manager");
        finance_employee.setStyle("-fx-background-color: rgba(94,94,90,0.53) ; -fx-text-fill: #ffff ; -fx-font-size: 20px ; -fx-font-weight: bold ; -fx-background-radius: 10px");
        finance_employee.setPrefSize(240 , 100);
        Button education_employee = new Button("Education Manager");
        education_employee.setStyle("-fx-background-color: rgba(94,94,90,0.53) ; -fx-text-fill: #ffff ; -fx-font-size: 20px ; -fx-font-weight: bold ; -fx-background-radius: 10px");
        education_employee.setPrefSize(240 , 100);
        Button profesor_employee = new Button("Professor Manager");
        profesor_employee.setStyle("-fx-background-color: rgba(94,94,90,0.53) ; -fx-text-fill: #ffff ; -fx-font-size: 20px ; -fx-font-weight: bold ; -fx-background-radius: 10px");
        profesor_employee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                profesor_employee_manage profesorEmployeeManage = null;
                try {
                    profesorEmployeeManage = new profesor_employee_manage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(profesorEmployeeManage));
                stage1.show();
            }
        });
        profesor_employee.setPrefSize(240 , 100);

        HBox hbox = new HBox(student , Admin , managment_employee , finance_employee , education_employee , profesor_employee );
        hbox.setLayoutY(20);
        hbox.setLayoutX(20);
        hbox.setSpacing(10);



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

        Image image = new Image(new FileInputStream("jason-leung-3rq6DqLKakc-unsplash (1).jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(1540, 785);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(hbox , Exit_button);
        this.getChildren().add(pane);
    }
}
