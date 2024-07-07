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
import model.Managment_Employee_manage_page_controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Managment_Employee_manage_page extends VBox {
    private static String final_name = null;
    private static String final_last_name = null;
    private static String final_phone_number = null;
    private static String final_email = null;
    private static String final_username = null;
    private static String final_password = null;
    private static int final_id = 0;

    public Managment_Employee_manage_page(int salary, String name, String last_name, String phone_number, String email, String username, String password, int id) throws FileNotFoundException {
        final_id = id;
        final_name = name;
        final_last_name = last_name;
        final_phone_number = phone_number;
        final_email = email;
        final_username = username;
        final_password = password;

        Label Salary = new Label("salary: ");
        TextField textField = new TextField(String.valueOf(salary));
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
                    int updatedSalary = Integer.parseInt(textField.getText());
                    Managment_Employee_manage_page_controller controller = new Managment_Employee_manage_page_controller();
                    controller.updateEmployee(final_id, final_name, final_last_name, final_username, final_password, final_phone_number, final_email, updatedSalary);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("APPLY");
                    alert.setHeaderText(null);
                    alert.setContentText("Information updated successfully");
                    alert.showAndWait();
                } catch (SQLException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("APPLY");
                    alert.setHeaderText(null);
                    alert.setContentText("Error updating information");
                    alert.showAndWait();
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Input Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid salary format");
                    alert.showAndWait();
                }
            }
        });

        Image image = new Image(new FileInputStream("c:/test/unip/admin_panel.jpg"));
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
