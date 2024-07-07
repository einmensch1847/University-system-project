package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.set_new_international_student_controller;
import model.set_new_student_controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class set_new_international_student_page extends VBox{
    private TextField name_TextField, lastname_TextField, username_TextField, password_TextField, field_TextField;
    private TextField student_number_TextField, date_of_birth_TextField, father_name_TextField, phone_number_TextField;
    private TextField postal_code_TextField, address_TextField, tuition_TextField, age_TextField, debt_TextField , nationality;
    private DatePicker date_of_birth;
    private Label registration_label;
    private Button send_button, Exit_button;
    public set_new_international_student_page() throws FileNotFoundException {
        setupUI();
        setupActions();
    }
    private void setupUI() throws FileNotFoundException {
        Label name_label = createLabel("name : ");
        Label lastname_label = createLabel("lastname : ");
        Label username_label = createLabel("username : ");
        Label password_label = createLabel("password : ");
        Label field_label = createLabel("field : ");
        Label student_number_label = createLabel("student number : ");
        Label date_of_birth_label = createLabel("date of birth : ");
        Label father_name_label = createLabel("father name : ");
        Label phone_number_label = createLabel("phone number : ");
        Label postal_code_label = createLabel("postal code : ");
        Label address_label = createLabel("address : ");
        Label tuition_label = createLabel("tuition (true , false) : ");
        Label age_label = createLabel("age : ");
        Label debt_label = createLabel("debt : ");
        Label nationality_label = createLabel("nationality : ");

        name_TextField = createTextField();
        lastname_TextField = createTextField();
        username_TextField = createTextField();
        password_TextField = createTextField();
        field_TextField = createTextField();
        student_number_TextField = createTextField();
        date_of_birth_TextField = createTextField();
        father_name_TextField = createTextField();
        phone_number_TextField = createTextField();
        postal_code_TextField = createTextField();
        address_TextField = createTextField();
        tuition_TextField = createTextField();
        age_TextField = createTextField();
        debt_TextField = createTextField();
        nationality = createTextField();

        date_of_birth = new DatePicker();
        date_of_birth.setValue(LocalDate.now());
        date_of_birth.valueProperty().addListener(((observable, oldValue, newValue) -> {
            date_of_birth_TextField.setText(String.valueOf(newValue));
        }));

        VBox vBox1 = new VBox(name_label, lastname_label, username_label, password_label, field_label, student_number_label,
                date_of_birth_label, father_name_label, phone_number_label, postal_code_label, address_label,
                tuition_label, age_label, debt_label , nationality_label);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(22);

        HBox dateBox = new HBox(date_of_birth_TextField, date_of_birth);

        VBox vBox2 = new VBox(name_TextField, lastname_TextField, username_TextField, password_TextField, field_TextField,
                student_number_TextField, dateBox, father_name_TextField, phone_number_TextField, postal_code_TextField,
                address_TextField, tuition_TextField, age_TextField, debt_TextField , nationality);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(16);

        send_button = new Button("registration");
        send_button.setPrefSize(90, 25);
        send_button.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(32,48,97,0.75) ;-fx-background-radius: 10px;-fx-text-fill:rgba(170,193,227,0.84)");

        HBox hBox = new HBox(vBox1, vBox2);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        registration_label = new Label("");

        VBox vBox3 = new VBox(hBox, registration_label, send_button);
        vBox3.setAlignment(Pos.CENTER);
        vBox3.setSpacing(10);
        vBox3.setLayoutY(40);
        vBox3.setLayoutX(40);

        Exit_button = new Button("\" EXIT \"");
        Exit_button.setPrefSize(50, 20);
        Exit_button.setStyle("-fx-font-size: 8px ; -fx-font-family: Arial ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
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

    private Label createLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-text-fill: rgb(18,30,73) ; -fx-font-size: 13px ; ");
        return label;
    }

    private TextField createTextField() {
        TextField textField = new TextField();
        textField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73)");
        return textField;
    }

    private void setupActions() {
        Exit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) Exit_button.getScene().getWindow();
                stage.close();
            }
        });

        send_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleRegistration();
            }
        });
    }

    private void handleRegistration() {
        set_new_international_student_controller backend = new set_new_international_student_controller();
        boolean success = false;
        try {
            success = backend.registerStudent(name_TextField.getText(), lastname_TextField.getText(), username_TextField.getText(),
                    password_TextField.getText(), field_TextField.getText(), student_number_TextField.getText(),
                    date_of_birth_TextField.getText(), father_name_TextField.getText(), phone_number_TextField.getText(),
                    postal_code_TextField.getText(), address_TextField.getText(), tuition_TextField.getText(),
                    Integer.parseInt(age_TextField.getText()), Integer.parseInt(debt_TextField.getText()) , nationality.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.WARNING, "Registration", "Please enter valid numeric values for age and debt.");
            return;
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Registration", "An unexpected error occurred: " + e.getMessage());
            return;
        }

        if (success) {
            showAlert(Alert.AlertType.INFORMATION, "Registration", "User successfully registered");
        } else {
            showAlert(Alert.AlertType.WARNING, "Registration", "User registration failed. Try another username");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
