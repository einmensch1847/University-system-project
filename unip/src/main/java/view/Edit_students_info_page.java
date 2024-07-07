package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class Edit_students_info_page extends VBox {
    private static String final_name = null;
    private static String final_last_name = null;
    private static String final_username = null;
    private static String final_password = null ;
    private static String final_phone_number = null;
    private static String final_postal_code = null;
    private static String final_address = null ;
    private static int final_id = 0 ;
    public Edit_students_info_page(int id , String name , String lastname , String username , String password , String phone_number , String postal_code , String address) throws FileNotFoundException {

        final_id = id ;
        final_name = name ;
        final_last_name = lastname ;
        final_phone_number = phone_number ;
        final_postal_code = postal_code ;
        final_username = username ;
        final_password = password ;
        final_address = address ;

        Label ID = new Label("\" "+id+" \"") ;
        ID.setStyle("-fx-text-fill: rgb(255,255,255) ;");
        Label name_label = new Label("name : ") ;
        name_label.setStyle("-fx-text-fill: rgb(255,255,255) ; -fx-font-size: 13px ; ");
        Label lastname_label = new Label("lastname : ") ;
        lastname_label.setStyle("-fx-text-fill: rgb(255,255,255) ; -fx-font-size: 13px ; ");
        Label username_label = new Label("username : ") ;
        username_label.setStyle("-fx-text-fill: rgb(255,255,255) ;-fx-font-size: 13px ; ");
        Label password_label = new Label("password : ") ;
        password_label.setStyle("-fx-text-fill: rgb(255,255,255) ; -fx-font-size: 13px ; ");
        Label phone_number_label = new Label("phone number : ") ;
        phone_number_label.setStyle("-fx-text-fill: rgb(255,255,255) ; -fx-font-size: 13px ; ");
        Label postal_code_label = new Label("postal code : ") ;
        postal_code_label.setStyle("-fx-text-fill: rgb(255,255,255) ; -fx-font-size: 13px ; ");
        Label address_label = new Label("Address : ") ;
        address_label.setStyle("-fx-text-fill: rgb(255,255,255) ; -fx-font-size: 13px ; ");

        TextField name_TextField = new TextField() ;
        name_TextField.setText(name);
        name_TextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(255,255,255) ");
        TextField lastname_TextField = new TextField() ;
        lastname_TextField.setText(lastname);
        lastname_TextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(255,255,255) ");
        TextField username_TextField = new TextField() ;
        username_TextField.setText(username);
        username_TextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(255,255,255) ");
        TextField password_TextField = new TextField() ;
        password_TextField.setText(password);
        password_TextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(255,255,255) ");
        TextField phone_number_TextField = new TextField() ;
        phone_number_TextField.setText(phone_number);
        phone_number_TextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(255,255,255) ");
        TextField postal_code_textfield = new TextField() ;
        postal_code_textfield.setText(postal_code);
        postal_code_textfield.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(255,255,255) ");
        TextField address_textfield = new TextField() ;
        address_textfield.setText(address);
        address_textfield.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(255,255,255) ");


        VBox vBox1 = new VBox(name_label , lastname_label , username_label , password_label , phone_number_label , postal_code_label , address_label ) ;
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(22);

        VBox vBox2 = new VBox(name_TextField , lastname_TextField , username_TextField , password_TextField , phone_number_TextField , postal_code_textfield , address_textfield ) ;
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(16);

        Button send_button = new Button("registration") ;
        send_button.setPrefSize(90 , 25);
        send_button.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(117,135,197,0.75) ;-fx-background-radius: 10px;-fx-text-fill:rgba(255,255,255,0.84)");

        HBox hBox = new HBox(vBox1 , vBox2) ;
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        Label registration_label = new Label("") ;

        VBox vBox3 = new VBox(ID , hBox , registration_label , send_button) ;
        vBox3.setAlignment(Pos.CENTER);
        vBox3.setSpacing(10);
        vBox3.setLayoutY(100);
        vBox3.setLayoutX(130);

        Button Exit_button = new Button() ;
        Exit_button.setText("\" EXIT \"");
        Exit_button.setPrefSize(50 , 20);
        Exit_button.setStyle("-fx-font-size: 8px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
        Exit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) Exit_button.getScene().getWindow() ;
                stage.close();
            }
        });
        Exit_button.setLayoutX(445);
        Exit_button.setLayoutY(750);

        send_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("UPDATE student SET name = ? , lastname = ? , username = ? , password = ? , phone_number =? , postal_code = ? , address = ? WHERE id = ?");
                    statement.setString(1 , name_TextField.getText());
                    statement.setString(2, lastname_TextField.getText());
                    statement.setString(3 , username_TextField.getText());
                    statement.setString(4 , password_TextField.getText());
                    statement.setString(5 , phone_number_TextField.getText());
                    statement.setString(6 , postal_code_textfield.getText());
                    statement.setString(7 , address_textfield.getText());
                    statement.setInt(8 , final_id);
                    statement.executeUpdate() ;

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("APPLY");
                    alert.setHeaderText(null);
                    alert.setContentText("APPLD");
                    alert.showAndWait();
                } catch (SQLException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("APPLY");
                    alert.setHeaderText(null);
                    alert.setContentText("ERROR");
                    alert.showAndWait();
                    e.printStackTrace();

                }
            }
        });

        Image image = new Image(new FileInputStream("c:/test/unip/student_panel.jpg")) ;
        BackgroundSize backgroundSize = new BackgroundSize(100 , 100 , true , true , true , false) ;
        BackgroundImage backgroundImage = new BackgroundImage(image , BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT , BackgroundPosition.CENTER , backgroundSize) ;
        Background background = new Background(backgroundImage) ;
        this.setBackground(background);
        this.setPrefSize(538 , 780);
        this.setSpacing(20);
        Pane pane = new Pane() ;
        pane.getChildren().addAll(vBox3 , Exit_button) ;
        this.getChildren().add(pane) ;
    }
}
