package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.ManagementEmployeeDAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SetANewManagementEmployeePage extends VBox {
    public SetANewManagementEmployeePage() throws FileNotFoundException {
        Label nameLabel = new Label("name : ");
        nameLabel.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");
        Label lastnameLabel = new Label("lastname : ");
        lastnameLabel.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");
        Label usernameLabel = new Label("username : ");
        usernameLabel.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");
        Label passwordLabel = new Label("password : ");
        passwordLabel.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");
        Label phoneNumberLabel = new Label("phone number : ");
        phoneNumberLabel.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");
        Label emailLabel = new Label("Email : ");
        emailLabel.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");
        Label salaryLabel = new Label("salary : ");
        salaryLabel.setStyle("-fx-text-fill: rgb(18,30,73); -fx-font-size: 13px;");

        TextField nameTextField = new TextField();
        nameTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73);");
        TextField lastnameTextField = new TextField();
        lastnameTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73);");
        TextField usernameTextField = new TextField();
        usernameTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73);");
        TextField passwordTextField = new TextField();
        passwordTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73);");
        TextField phoneNumberTextField = new TextField();
        phoneNumberTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73);");
        TextField emailTextField = new TextField();
        emailTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73);");
        TextField salaryTextField = new TextField();
        salaryTextField.setStyle("-fx-background-color: rgba(82,129,203,0.73); -fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73);");

        VBox vBox1 = new VBox(nameLabel, lastnameLabel, usernameLabel, passwordLabel, phoneNumberLabel, emailLabel, salaryLabel);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(22);

        VBox vBox2 = new VBox(nameTextField, lastnameTextField, usernameTextField, passwordTextField, phoneNumberTextField, emailTextField, salaryTextField);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(16);

        Button sendButton = new Button("registration");
        sendButton.setPrefSize(90, 25);
        sendButton.setStyle("-fx-font-size: 13px; -fx-font-family: Arial; -fx-background-color: rgba(32,48,97,0.75); -fx-background-radius: 10px; -fx-text-fill:rgba(170,193,227,0.84)");

        HBox hBox = new HBox(vBox1, vBox2);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        Label registrationLabel = new Label("");

        VBox vBox3 = new VBox(hBox, registrationLabel, sendButton);
        vBox3.setAlignment(Pos.CENTER);
        vBox3.setSpacing(10);
        vBox3.setLayoutY(100);
        vBox3.setLayoutX(100);
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
        exitButton.setLayoutX(445);
        exitButton.setLayoutY(750);

        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ManagementEmployeeDAO.addManagementEmployee(
                            nameTextField.getText(),
                            lastnameTextField.getText(),
                            usernameTextField.getText(),
                            passwordTextField.getText(),
                            phoneNumberTextField.getText(),
                            emailTextField.getText(),
                            Integer.parseInt(salaryTextField.getText())
                    );

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("registration");
                    alert.setHeaderText(null);
                    alert.setContentText("user successfully logged in");
                    alert.showAndWait();

                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("registration");
                    alert.setHeaderText(null);
                    alert.setContentText("user failed to login successfully \n set a other username");
                    alert.showAndWait();
                }
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