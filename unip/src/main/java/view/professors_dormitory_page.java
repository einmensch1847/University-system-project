package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.professors_dormitory_page_controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class professors_dormitory_page extends VBox {
    public professors_dormitory_page() throws FileNotFoundException {
        Label nameLabel = new Label("name : ");
        nameLabel.setStyle("-fx-font-size: 14 ; -fx-text-fill: rgb(255,255,255)");
        Label lastnameLabel = new Label("lastname : ");
        lastnameLabel.setStyle("-fx-font-size: 14 ; -fx-text-fill: rgb(255,255,255)");
        Label phoneNumberLabel = new Label("phone number : ");
        phoneNumberLabel.setStyle("-fx-font-size: 14 ; -fx-text-fill: rgb(255,255,255)");
        Label emailLabel = new Label("Email : ");
        emailLabel.setStyle("-fx-font-size: 14 ; -fx-text-fill: rgb(255,255,255)");
        Label fatherNameLabel = new Label("father name : ");
        fatherNameLabel.setStyle("-fx-font-size: 13 ; -fx-text-fill: rgb(255,255,255)");
        Label ageLabel = new Label("age : ");
        ageLabel.setStyle("-fx-font-size: 14 ; -fx-text-fill: rgb(255,255,255)");
        Label reasonLabel = new Label("the reason for the request : ");
        reasonLabel.setStyle("-fx-font-size: 14 ; -fx-text-fill: rgb(255,255,255)");
        Label otherExplanationsLabel = new Label("other explanations : ");
        otherExplanationsLabel.setStyle("-fx-font-size: 14 ; -fx-text-fill: rgb(255,255,255)");

        VBox labelBox1 = new VBox(nameLabel, lastnameLabel, phoneNumberLabel, emailLabel, fatherNameLabel, ageLabel);
        labelBox1.setAlignment(Pos.CENTER);
        labelBox1.setSpacing(15);

        VBox labelBox2 = new VBox(reasonLabel, otherExplanationsLabel);
        labelBox2.setAlignment(Pos.CENTER);
        labelBox2.setSpacing(30);

        TextField nameTextField = new TextField();
        nameTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");
        TextField lastnameTextField = new TextField();
        lastnameTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");
        TextField phoneNumberTextField = new TextField();
        phoneNumberTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");
        TextField emailTextField = new TextField();
        emailTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");
        TextField fatherNameTextField = new TextField();
        fatherNameTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");
        TextField ageTextField = new TextField();
        ageTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");
        TextArea reasonTextArea = new TextArea();
        reasonTextArea.setPrefSize(150, 50);
        reasonTextArea.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");
        TextArea otherExplanationsTextArea = new TextArea();
        otherExplanationsTextArea.setPrefSize(150, 50);
        otherExplanationsTextArea.setStyle("-fx-background-color: rgba(226,226,229,0.45) ;-fx-background-radius: 10px;");

        VBox textFieldBox1 = new VBox(nameTextField, lastnameTextField, phoneNumberTextField, emailTextField, fatherNameTextField, ageTextField);
        textFieldBox1.setAlignment(Pos.CENTER);
        textFieldBox1.setSpacing(10);

        VBox textFieldBox2 = new VBox(reasonTextArea, otherExplanationsTextArea);
        textFieldBox2.setAlignment(Pos.CENTER);
        textFieldBox2.setSpacing(10);

        HBox hbox2 = new HBox(labelBox2, textFieldBox2);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.setSpacing(6);

        Button sendButton = new Button("\" SEND \"");
        sendButton.setPrefSize(140, 70);
        sendButton.setStyle("-fx-font-size: 16px; -fx-font-family: Arial; -fx-background-color: rgba(80,93,155,0.62); -fx-background-radius: 10px; -fx-text-fill: rgb(255,255,255)");

        HBox hbox1 = new HBox(labelBox1, textFieldBox1);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setSpacing(6);

        VBox mainBox = new VBox(hbox1, hbox2, sendButton);
        mainBox.setSpacing(20);
        mainBox.setPrefSize(370, 530);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setStyle("-fx-background-color:rgba(11,28,107,0.75); -fx-background-radius: 10px;");
        mainBox.setLayoutX(106);
        mainBox.setLayoutY(100);

        Label headerLabel = new Label("\" professors dormitory \"");
        headerLabel.setStyle("-fx-font-size: 30; -fx-text-fill: rgba(255,255,255,0.75); -fx-font-family: BordeauxHeavy ");
        headerLabel.setLayoutX(160);
        headerLabel.setLayoutY(45);

        Button exitButton = new Button();
        exitButton.setText("\" EXIT \"");
        exitButton.setPrefSize(50, 20);
        exitButton.setStyle("-fx-font-size: 8px; -fx-font-family: Arial; -fx-background-color: rgba(183,107,107,0.93); -fx-background-radius: 10px;");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            }
        });
        exitButton.setLayoutX(1450);
        exitButton.setLayoutY(750);

        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    professors_dormitory_page_controller professorsDormitoryPageController = new professors_dormitory_page_controller();
                    professorsDormitoryPageController.professors_dormitory_page_controllerr(
                            nameTextField.getText(),
                            lastnameTextField.getText(),
                            phoneNumberTextField.getText(),
                            emailTextField.getText(),
                            fatherNameTextField.getText(),
                            Integer.parseInt(ageTextField.getText()),
                            reasonTextArea.getText(),
                            otherExplanationsTextArea.getText()
                    );
                    professors_dormitory_page_controller.close();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ADMISSION REQUEST");
                    alert.setHeaderText(null);
                    alert.setContentText("SENT");
                    alert.showAndWait();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Image image = new Image(new FileInputStream("marcus-loke-WQJvWU_HZFo-unsplash (1).jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(1540, 785);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(headerLabel, mainBox, exitButton);
        this.getChildren().add(pane);
    }
}
