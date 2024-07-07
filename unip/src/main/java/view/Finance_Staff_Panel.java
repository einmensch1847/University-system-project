package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

public class Finance_Staff_Panel extends VBox {
    public Finance_Staff_Panel(int id , String name , String lastname , String username , String password , String phone_number , String email , int salary) throws FileNotFoundException {

        Label timeLabel = new Label();
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalTime currentTime = LocalTime.now();
            timeLabel.setText(currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }));

        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();
        timeLabel.setFont(Font.font("Arial",70));
        timeLabel.setLayoutX(1000);
        timeLabel.setLayoutY(210);

        Button showAdminsButton = new Button("Show Admins");
        showAdminsButton.setStyle("-fx-background-color: rgba(94,94,90,0.53) ; -fx-text-fill: #ffff ; -fx-font-size: 20px ; -fx-font-weight: bold ; -fx-background-radius: 10px");
        showAdminsButton.setPrefSize(260 , 120);
        showAdminsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Show_admins showAdmins = null;
                try {
                    showAdmins = new Show_admins();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(showAdmins));
                stage1.show();
            }
        });
        Button ShowEducationButton = new Button("Show Education");
        ShowEducationButton.setStyle("-fx-background-color: rgba(94,94,90,0.53) ; -fx-text-fill: #ffff ; -fx-font-size: 20px ; -fx-font-weight: bold ; -fx-background-radius: 10px");
        ShowEducationButton.setPrefSize(260 , 120);
        ShowEducationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Show_education_employee showEducationEmployee = null;
                try {
                    showEducationEmployee = new Show_education_employee();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(showEducationEmployee));
                stage1.show();
            }
        });
        Button showStudentsButton = new Button("Show Students");
        showStudentsButton.setStyle("-fx-background-color: rgba(94,94,90,0.5) ; -fx-text-fill: #ffff ; -fx-font-size: 20px ; -fx-font-weight: bold ;-fx-background-radius: 10px");
        showStudentsButton.setPrefSize(260 , 120);
        showStudentsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ShowStudentsPage showStudentsPage = null;
                showStudentsPage = new ShowStudentsPage();
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(showStudentsPage));
                stage1.show();
            }
        });
        Button showStaffButton = new Button("Show Staff");
        showStaffButton.setStyle("-fx-background-color: rgba(94,94,90,0.5) ; -fx-text-fill: #ffff ; -fx-font-size: 20px ; -fx-font-weight: bold ; -fx-background-radius: 10px");
        showStaffButton.setPrefSize(260 , 120);
        showStaffButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Show_finance_staff showFinanceStaff = null;
                try {
                    showFinanceStaff = new Show_finance_staff();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(showFinanceStaff));
                stage1.show();
            }
        });
        Button manageSalariesButton = new Button("Manage Salaries");
        manageSalariesButton.setStyle("-fx-background-color: rgba(94,94,90,0.5) ; -fx-text-fill: #ffff ; -fx-font-size: 20px ; -fx-font-weight: bold ; -fx-background-radius: 10px");
        manageSalariesButton.setPrefSize(260 , 120);
        manageSalariesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ManageSalariesPage manageSalariesPage = null;
                try {
                    manageSalariesPage = new ManageSalariesPage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(manageSalariesPage));
                stage1.show();
            }
        });
        Button manageOvertimeButton = new Button("Manage Overtime");
        manageOvertimeButton.setStyle("-fx-background-color: rgba(94,94,90,0.5) ; -fx-text-fill: #ffff ; -fx-font-size: 20px ; -fx-font-weight: bold ; -fx-background-radius: 10px");
        manageOvertimeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                OverTimeManager overTimeManager = null;
                overTimeManager = new OverTimeManager();
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(overTimeManager));
                stage1.show();
            }
        });
        manageOvertimeButton.setPrefSize(260 , 120);

        VBox vBox1 = new VBox(showAdminsButton , ShowEducationButton , showStudentsButton) ;
        vBox1.setSpacing(20);

        VBox vBox2 = new VBox(showStaffButton , manageSalariesButton , manageOvertimeButton) ;
        vBox2.setSpacing(20);

        HBox hBox = new HBox(vBox1 , vBox2) ;
        hBox.setSpacing(35);
        hBox.setLayoutX(80);
        hBox.setLayoutY(80);

        Button Exit_button = new Button() ;
        Exit_button.setText("\" EXIT \"");
        Exit_button.setPrefSize(50 , 20);
        Exit_button.setStyle("-fx-font-size: 8px ; -fx-font-family: Arial ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
        Exit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main_page mainPage = null;
                try {
                    mainPage = new Main_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(mainPage));
                stage1.show();

                Stage stage = (Stage) Exit_button.getScene().getWindow() ;
                stage.close();
            }
        });
        Exit_button.setLayoutX(1450);
        Exit_button.setLayoutY(750);

        Image image = new Image(new FileInputStream("image (5).jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(1540, 785);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(hBox , Exit_button , timeLabel);
        this.getChildren().add(pane);
    }

}
