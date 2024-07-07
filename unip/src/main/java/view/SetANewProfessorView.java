package view;

import model.SetANewProfessorController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class SetANewProfessorView extends VBox {
    public SetANewProfessorView() throws FileNotFoundException {
        SetANewProfessorController professorDatabase = new SetANewProfessorController();

        Label nameLabel = new Label("name : ");
        nameLabel.setStyle("-fx-text-fill: rgb(18,30,73) ; -fx-font-size: 13px ; ");
        Label lastnameLabel = new Label("lastname : ");
        lastnameLabel.setStyle("-fx-text-fill: rgb(18,30,73) ; -fx-font-size: 13px ; ");
        Label usernameLabel = new Label("username : ");
        usernameLabel.setStyle("-fx-text-fill: rgb(18,30,73) ;-fx-font-size: 13px ; ");
        Label passwordLabel = new Label("password : ");
        passwordLabel.setStyle("-fx-text-fill: rgb(18,30,73) ; -fx-font-size: 13px ; ");
        Label dateOfBirthLabel = new Label("date of birth : ");
        dateOfBirthLabel.setStyle("-fx-text-fill: rgb(18,30,73) ; -fx-font-size: 13px ; ");
        Label ageLabel = new Label("age : ");
        ageLabel.setStyle("-fx-text-fill: rgb(18,30,73) ; -fx-font-size: 13px ; ");
        Label phoneNumberLabel = new Label("phone number : ");
        phoneNumberLabel.setStyle("-fx-text-fill: rgb(18,30,73) ; -fx-font-size: 13px ; ");
        Label emailLabel = new Label("Email : ");
        emailLabel.setStyle("-fx-text-fill: rgb(18,30,73) ; -fx-font-size: 13px ; ");
        Label addressLabel = new Label("address : ");
        addressLabel.setStyle("-fx-text-fill: rgb(18,30,73) ; -fx-font-size: 13px ; ");
        Label degreeOfEducationLabel = new Label("degree of education : ");
        degreeOfEducationLabel.setStyle("-fx-text-fill: rgb(18,30,73) ; -fx-font-size: 13px ; ");
        Label topicLabel = new Label("topic : ");
        topicLabel.setStyle("-fx-text-fill: rgb(18,30,73) ; -fx-font-size: 13px ; ");
        Label unitLabel = new Label("unit : ");
        unitLabel.setStyle("-fx-text-fill: rgb(18,30,73) ; -fx-font-size: 13px ; ");
        Label basicSalaryLabel = new Label("basic salary : ");
        basicSalaryLabel.setStyle("-fx-text-fill: rgb(18,30,73) ; -fx-font-size: 13px ; ");

        TextField nameTextField = new TextField();
        nameTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        TextField lastnameTextField = new TextField();
        lastnameTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        TextField usernameTextField = new TextField();
        usernameTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        TextField passwordTextField = new TextField();
        passwordTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        TextField dateOfBirthTextField = new TextField();
        TextField ageTextField = new TextField();
        ageTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        TextField phoneNumberTextField = new TextField();
        phoneNumberTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        TextField emailTextField = new TextField();
        emailTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        TextField addressTextField = new TextField();
        addressTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        TextField degreeOfEducationTextField = new TextField();
        degreeOfEducationTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        TextField topicTextField = new TextField();
        topicTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        TextField unitTextField = new TextField();
        unitTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        TextField basicSalaryTextField = new TextField();
        basicSalaryTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");

        DatePicker dateOfBirthPicker = new DatePicker();
        dateOfBirthPicker.setValue(LocalDate.now());
        dateOfBirthPicker.valueProperty().addListener(((observable, oldValue, newValue) -> {
            dateOfBirthTextField.setText(String.valueOf(newValue));
        }));

        VBox vBox1 = new VBox(nameLabel, lastnameLabel, usernameLabel, passwordLabel, dateOfBirthLabel, ageLabel, phoneNumberLabel, emailLabel, addressLabel, degreeOfEducationLabel, topicLabel, unitLabel, basicSalaryLabel);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(22);

        HBox hBoxDateOfBirth = new HBox(dateOfBirthTextField, dateOfBirthPicker);

        VBox vBox2 = new VBox(nameTextField, lastnameTextField, usernameTextField, passwordTextField, hBoxDateOfBirth, ageTextField, phoneNumberTextField, emailTextField, addressTextField, degreeOfEducationTextField, topicTextField, unitTextField, basicSalaryTextField);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(16);

        Button sendButton = new Button("registration");
        sendButton.setPrefSize(90, 25);
        sendButton.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(32,48,97,0.75) ;-fx-background-radius: 10px;-fx-text-fill:rgba(170,193,227,0.84)");

        HBox hBox = new HBox(vBox1, vBox2);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        Label registrationLabel = new Label("");

        VBox vBox3 = new VBox(hBox, registrationLabel, sendButton);
        vBox3.setAlignment(Pos.CENTER);
        vBox3.setSpacing(10);
        vBox3.setLayoutY(40);
        vBox3.setLayoutX(40);

        Button exitButton = new Button();
        exitButton.setText("EXIT");
        exitButton.setPrefSize(50, 20);
        exitButton.setStyle("-fx-font-size: 8px ; -fx-font-family: Arial ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            }
        });
        exitButton.setLayoutX(445);
        exitButton.setLayoutY(750);

        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean success = professorDatabase.registerProfessor(
                        nameTextField.getText(),
                        lastnameTextField.getText(),
                        usernameTextField.getText(),
                        passwordTextField.getText(),
                        dateOfBirthTextField.getText(),
                        Integer.parseInt(ageTextField.getText()),
                        phoneNumberTextField.getText(),
                        emailTextField.getText(),
                        addressTextField.getText(),
                        degreeOfEducationTextField.getText(),
                        topicTextField.getText(),
                        Integer.parseInt(unitTextField.getText()),
                        Integer.parseInt(basicSalaryTextField.getText())
                );

                Alert alert;
                if (success) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("User successfully registered");
                } else {
                    alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("User registration failed. Please try another username.");
                }
                alert.showAndWait();
            }
        });

        Image image = new Image(new FileInputStream("c:/test/unip/admin_panel.jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(538, 780);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(vBox3, exitButton);
        this.getChildren().add(pane);

    }
}