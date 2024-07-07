package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.EducationEmployeeHandler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class SetNewEducationEmployeePage extends VBox {
    private TextField name_TextField;
    private TextField lastname_TextField;
    private TextField username_TextField;
    private TextField password_TextField;
    private TextField phone_number_TextField;
    private TextField Email_textfield;
    private TextField salary_textfield;

    public SetNewEducationEmployeePage() throws FileNotFoundException {
        setupUI();
    }

    private void setupUI() throws FileNotFoundException {
        Label name_label = new Label("name : ");
        name_label.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");
        Label lastname_label = new Label("lastname : ");
        lastname_label.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");
        Label username_label = new Label("username : ");
        username_label.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");
        Label password_label = new Label("password : ");
        password_label.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");
        Label phone_number_label = new Label("phone number : ");
        phone_number_label.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");
        Label Email_label = new Label("Email : ");
        Email_label.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");
        Label salary_label = new Label("salary : ");
        salary_label.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");

        name_TextField = new TextField();
        name_TextField.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill: rgb(18,30,73);");
        lastname_TextField = new TextField();
        lastname_TextField.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill: rgb(18,30,73);");
        username_TextField = new TextField();
        username_TextField.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill: rgb(18,30,73);");
        password_TextField = new TextField();
        password_TextField.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill: rgb(18,30,73);");
        phone_number_TextField = new TextField();
        phone_number_TextField.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill: rgb(18,30,73);");
        Email_textfield = new TextField();
        Email_textfield.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill: rgb(18,30,73);");
        salary_textfield = new TextField();
        salary_textfield.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill: rgb(18,30,73);");

        VBox vBox1 = new VBox(name_label, lastname_label, username_label, password_label, phone_number_label, Email_label, salary_label);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(22);

        VBox vBox2 = new VBox(name_TextField, lastname_TextField, username_TextField, password_TextField, phone_number_TextField, Email_textfield, salary_textfield);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(16);

        Button send_button = new Button("registration");
        send_button.setPrefSize(90, 25);
        send_button.setStyle("-fx-font-size: 13px; -fx-font-family: Arial; -fx-background-color: rgba(32,48,97,0.75); -fx-background-radius: 10px; -fx-text-fill: rgba(170,193,227,0.84);");
        send_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleRegistration();
            }
        });
        HBox hBox = new HBox(vBox1, vBox2);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        Label registration_label = new Label("");

        VBox vBox3 = new VBox(hBox, registration_label, send_button);
        vBox3.setAlignment(Pos.CENTER);
        vBox3.setSpacing(10);
        vBox3.setLayoutY(100);
        vBox3.setLayoutX(100);

        Button Exit_button = new Button();
        Exit_button.setText("EXIT");
        Exit_button.setPrefSize(50, 20);
        Exit_button.setStyle("-fx-font-size: 8px; -fx-font-family: Arial; -fx-background-color: rgba(183,107,107,0.93); -fx-background-radius: 10px;");
        Exit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) Exit_button.getScene().getWindow();
                stage.close();
            }
        });
        Exit_button.setLayoutX(445);
        Exit_button.setLayoutY(750);

        Image image = new Image(new FileInputStream("c:/test/unip/admin_panel.jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(538, 780);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(vBox3, Exit_button);
        this.getChildren().add(pane);
    }

    private void handleRegistration() {
        String name = name_TextField.getText();
        String lastname = lastname_TextField.getText();
        String username = username_TextField.getText();
        String password = password_TextField.getText();
        String phoneNumber = phone_number_TextField.getText();
        String email = Email_textfield.getText();
        int salary = Integer.parseInt(salary_textfield.getText());
        LocalDate date = LocalDate.now();

        EducationEmployeeHandler.registerEducationEmployee(name, lastname, username, password, phoneNumber, email, salary, date);
    }
}