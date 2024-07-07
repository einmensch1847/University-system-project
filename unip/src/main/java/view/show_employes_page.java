package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class show_employes_page extends VBox {

    Button Admin , professor , education_employee , management_employee , finance_staff ;

    public show_employes_page() throws FileNotFoundException {
        Admin = new Button("\" Admin \"") ;
        Admin.setPrefSize(240 , 85);
        Admin.setStyle("-fx-font-size: 16px ; -fx-font-family: Arial ;-fx-background-color: rgba(210,165,119,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        Admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Show_admins editMainPageText = null;
                try {
                    editMainPageText = new Show_admins();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();

                Stage stage = (Stage) Admin.getScene().getWindow() ;
                stage.close();
            }
        });
        professor = new Button("\" Professor \"") ;
        professor.setPrefSize(240 , 85);
        professor.setStyle("-fx-font-size: 16px ; -fx-font-family: Arial ;-fx-background-color: rgba(160,187,107,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        professor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Show_professors editMainPageText = null;
                try {
                    editMainPageText = new Show_professors();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();

                Stage stage = (Stage) professor.getScene().getWindow() ;
                stage.close();
            }
        });
        education_employee = new Button("\" Education Employee \"") ;
        education_employee.setPrefSize(240 , 85);
        education_employee.setStyle("-fx-font-size: 16px ; -fx-font-family: Arial ;-fx-background-color: rgba(105,176,170,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        education_employee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Show_education_employee editMainPageText = null;
                try {
                    editMainPageText = new Show_education_employee();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();

                Stage stage = (Stage) education_employee.getScene().getWindow() ;
                stage.close();
            }
        });
        management_employee = new Button("\" Management Employee \"") ;
        management_employee.setPrefSize(240 , 85);
        management_employee.setStyle("-fx-font-size: 16px ; -fx-font-family: Arial ;-fx-background-color: rgba(162,187,227,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        management_employee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Show_management_employee editMainPageText = null;
                try {
                    editMainPageText = new Show_management_employee();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();

                Stage stage = (Stage) management_employee.getScene().getWindow() ;
                stage.close();
            }
        });
        finance_staff = new Button("\" Finance Staff \"") ;
        finance_staff.setPrefSize(240 , 85);
        finance_staff.setStyle("-fx-font-size: 16px ; -fx-font-family: Arial ;-fx-background-color: rgba(184,162,227,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        finance_staff.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Show_finance_staff editMainPageText = null;
                try {
                    editMainPageText = new Show_finance_staff();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();

                Stage stage = (Stage) finance_staff.getScene().getWindow() ;
                stage.close();
            }
        });

        HBox hBox2 = new HBox(Admin , professor , education_employee ) ;
        hBox2.setSpacing(15);
        hBox2.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox( management_employee , finance_staff) ;
        hBox1.setSpacing(15);
        hBox1.setAlignment(Pos.CENTER);

        VBox hBox = new VBox(hBox2 , hBox1) ;
        hBox.setSpacing(15);
        hBox.setAlignment(Pos.CENTER);

        hBox.setLayoutY(250);
        hBox.setLayoutX(380);

        Button Exit_button = new Button() ;
        Exit_button.setText("\" EXIT \"");
        Exit_button.setPrefSize(50 , 20);
        Exit_button.setStyle("-fx-font-size: 8px ; -fx-font-family: Arial ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
        Exit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                Admin_panel mainPage = null;
//                try {
//                    mainPage = new Admin_panel();
//                } catch (FileNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//                Stage stage1 = new Stage() ;
//                stage1.setScene(new Scene(mainPage));
//                stage1.show();

                Stage stage = (Stage) Exit_button.getScene().getWindow() ;
                stage.close();
            }
        });
        Exit_button.setLayoutX(1450);
        Exit_button.setLayoutY(750);

        Image image = new Image(new FileInputStream("annie-spratt-QckxruozjRg-unsplash (1) (2).jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(1540, 785);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(hBox , Exit_button);
        this.getChildren().add(pane);

    }
}
