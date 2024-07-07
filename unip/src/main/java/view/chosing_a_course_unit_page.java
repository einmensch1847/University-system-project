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

public class chosing_a_course_unit_page extends VBox {
    public chosing_a_course_unit_page(int id , String name , String lastname , String student_number , String username) throws FileNotFoundException {

        Button chosing_a_course_unit_button = new Button("chosing a course\nunit") ;
        chosing_a_course_unit_button.setPrefSize(170 , 80);
        chosing_a_course_unit_button.setStyle("-fx-font-size: 14px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(255,255,255,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
        chosing_a_course_unit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final_chosing_a_course_unit_page finalChosingACourseUnitPage = null;
                finalChosingACourseUnitPage = new final_chosing_a_course_unit_page(id , name , lastname , student_number , username);
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(finalChosingACourseUnitPage));
                stage1.show();

                Stage stage = (Stage) chosing_a_course_unit_button.getScene().getWindow() ;
                stage.close();
            }
        });

        Button professors_name_for_course = new Button("professors name\nfor course") ;
        professors_name_for_course.setPrefSize(170 , 80);
        professors_name_for_course.setStyle("-fx-font-size: 14px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(255,255,255,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
        professors_name_for_course.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                professors_name_for_course_page finalChosingACourseUnitPage = null;
                finalChosingACourseUnitPage = new professors_name_for_course_page();
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(finalChosingACourseUnitPage));
                stage1.show();

                Stage stage = (Stage) chosing_a_course_unit_button.getScene().getWindow() ;
                stage.close();
            }
        });

        VBox vBox = new VBox(chosing_a_course_unit_button , professors_name_for_course) ;
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);
        vBox.setLayoutX(185);
        vBox.setLayoutY(200);



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


        Image image = new Image(new FileInputStream("hanyang-zhang-r54LEA2_6AE-unsplash (1).jpg")) ;
        BackgroundSize backgroundSize = new BackgroundSize(100 , 100 , true , true , true , false) ;
        BackgroundImage backgroundImage = new BackgroundImage(image , BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT , BackgroundPosition.CENTER , backgroundSize) ;
        Background background = new Background(backgroundImage) ;
        this.setBackground(background);
        this.setPrefSize(1540 , 785);
        this.setSpacing(20);
        Pane pane = new Pane() ;
        pane.getChildren().addAll(vBox , Exit_button) ;
        this.getChildren().add(pane) ;

    }

}
