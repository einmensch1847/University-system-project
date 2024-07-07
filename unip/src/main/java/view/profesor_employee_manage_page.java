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
import model.Admin_manage_page_controller;
import model.profesor_employee_manage_page_controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class profesor_employee_manage_page extends VBox{
    private static String final_name = null;
    private static String final_last_name = null;
    private static String final_username = null;
    private static String final_password = null ;
    private static String final_phone_number = null;
    private static String final_email = null;
    private static String final_address = null ;
    private static int final_id = 0 ;
    public profesor_employee_manage_page(int base_salary , int id , String name , String lastname , String username , String password , String phone_number , String email , String address) throws FileNotFoundException {
        final_id = id ;
        final_name = name ;
        final_last_name = lastname ;
        final_phone_number = phone_number ;
        final_email = email ;
        final_username = username ;
        final_password = password ;
        final_address = address ;

        Label Salary = new Label("salary: ");
        TextField textField = new TextField(String.valueOf(base_salary));
        textField.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73)");
        Button send_button = new Button("registration");
        send_button.setPrefSize(90, 25);
        send_button.setStyle("-fx-font-size: 13px; -fx-font-family: Arial; -fx-background-color: rgba(117,135,197,0.75); -fx-background-radius: 10px; -fx-text-fill:rgba(255,255,255,0.84)");

        VBox vbox = new VBox(Salary, textField, send_button);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);
        send_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    profesor_employee_manage_page_controller dbHandler = new profesor_employee_manage_page_controller();
                    dbHandler.updateprofessor(base_salary , final_id, final_name, final_last_name, final_username, final_password, final_phone_number, final_email , final_address, Integer.parseInt(textField.getText()));

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("APPLY");
                    alert.setHeaderText(null);
                    alert.setContentText("APPLIED");
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
