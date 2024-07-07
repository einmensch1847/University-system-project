package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class Reservation_of_electrical_faculty_workshops_page extends VBox {
    private static Label acc_lbl ;
    private static TextField name_textField;
    private static TextField number_of_persons_textField;
    private static TextField time_reservation_textField;
    private static TextField student_number_textField;
    private static TextField student_level_textField ;
    private static TextArea reason_textField ;
    public Reservation_of_electrical_faculty_workshops_page() throws FileNotFoundException {

        Button language_btn1 = new Button("DE") ;
        language_btn1.setPrefSize(30 , 20);
        language_btn1.setStyle("-fx-font-size: 10px ; -fx-font-family: Arial ;-fx-background-color: rgba(255,255,255,0) ;-fx-background-radius: 10px;");

        Button language_btn2 = new Button("EN") ;
        language_btn2.setPrefSize(30 , 20);
        language_btn2.setStyle("-fx-font-size:10px ; -fx-font-family: Arial ;-fx-background-color: rgba(255,255,255,0) ;-fx-background-radius: 10px;");

        VBox vBox22 = new VBox(language_btn1 , language_btn2) ;
        vBox22.setLayoutX(10);
        vBox22.setLayoutY(30);

        Button send_button = new Button("SEND") ;
        send_button.setStyle("-fx-font-size: 16px ; -fx-font-family: Arial ;-fx-background-color: rgba(56,175,116,0.51) ;-fx-background-radius: 10px;-fx-text-fill: rgba(241,242,245,0.93) ;");

        Button Exit_button = new Button() ;
        Exit_button.setText("\" EXIT \"");
        Exit_button.setPrefSize(50 , 20);
        Exit_button.setStyle("-fx-font-size: 8px ; -fx-font-family: Arial ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
        Exit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                Main_page mainPage = null;
//                try {
//                    mainPage = new Main_page();
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

        acc_lbl = new Label("");
        acc_lbl.setStyle("-fx-font-size: 20 ;");

        Label label = new Label("Reservation of electrical lboratories") ;
        label.setStyle("-fx-font-size: 10px ;-fx-text-fill: rgba(255,255,255,0.93) ;-fx-font-family: 'Agent Orange'");
        label.setLayoutY(230);
        label.setLayoutX(120);

        Label name_label = new Label("name and lastname : ") ;
        name_label.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-text-fill: rgba(255,255,255,0.93) ;");

        Label number_of_persons_label = new Label("number of members of your research group : ") ;
        number_of_persons_label.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-text-fill: rgba(255,255,255,0.93) ;");

        Label time_reservation_label = new Label("your requested time : ") ;
        time_reservation_label.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-text-fill: rgba(255,255,255,0.93) ;");

        Label student_number_label = new Label("your student number : ") ;
        student_number_label.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-text-fill: rgba(255,255,255,0.93) ;");

        Label student_level_label = new Label("your student level : ") ;
        student_level_label.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-text-fill: rgba(255,255,255,0.93) ;");

        Label reason_label = new Label("description : ") ;
        reason_label.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-text-fill: rgba(255,255,255,0.93) ;");



        name_textField = new TextField();
        name_textField.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");

        number_of_persons_textField = new TextField();
        number_of_persons_textField.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");

        time_reservation_textField = new TextField();
        time_reservation_textField.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");

        student_number_textField = new TextField();
        student_number_textField.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");

        student_level_textField = new TextField();
        student_level_textField.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");

        reason_textField = new TextArea();
        reason_textField.setPrefSize(30 , 80);
        reason_textField.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");

        VBox vBox3 = new VBox(reason_label , reason_textField, acc_lbl , send_button , Exit_button) ;
        vBox3.setSpacing(7);
        vBox3.setAlignment(Pos.CENTER);

        VBox vBox1 = new VBox(name_label , number_of_persons_label , time_reservation_label , student_number_label , student_level_label );
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(30);

        VBox vBox2 = new VBox(name_textField, number_of_persons_textField, time_reservation_textField, student_number_textField, student_level_textField) ;
//        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(20);

        HBox hBox = new HBox(vBox1 , vBox2) ;
        VBox vBox4 = new VBox(hBox , vBox3) ;
        vBox4.setSpacing(20);
        vBox4.setLayoutX(65);
        vBox4.setLayoutY(300);


        send_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int number_of_persons = parseInt(number_of_persons_textField.getText()) ;
                    int time_reservation = parseInt(time_reservation_textField.getText()) ;
                    int student_number = parseInt(student_number_textField.getText()) ;

                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO electrical_lab (reason , student_leval , name , number_of_persons , time_reservation , student_number) values (? , ? , ? , ? , ? , ?)") ;
                    statement.setString(1 , reason_textField.getText());
                    statement.setString(2 , student_level_textField.getText());
                    statement.setString(3 , name_textField.getText());
                    statement.setInt(4 , number_of_persons);
                    statement.setInt(5 , time_reservation);
                    statement.setInt(6 , student_number);
                    statement.executeUpdate() ;

                    acc_lbl.setText("SENT");
                    acc_lbl.setStyle("-fx-text-fill:rgb(141,241,128) ; -fx-font-size: 20 ;");

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        

        Image image = new Image(new FileInputStream("faculty_page.jpg")) ;
        BackgroundSize backgroundSize = new BackgroundSize(100 , 100 , true , true , true , false) ;
        BackgroundImage backgroundImage = new BackgroundImage(image , BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT , BackgroundPosition.CENTER , backgroundSize) ;
        Background background = new Background(backgroundImage) ;
        this.setBackground(background);
        this.setPrefSize(538 , 780);
        this.setSpacing(20);
        Pane pane = new Pane() ;
        pane.getChildren().addAll(label , vBox4 , vBox22) ;
        this.getChildren().add(pane) ;
    }
}
