package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.StudentLoanApplication;
import model.professors_loan_application_controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class professors_loan_application extends VBox {
    public professors_loan_application(int id) throws FileNotFoundException {
        Label nameLabel = new Label("name : ");
        nameLabel.setStyle("-fx-font-size: 15; -fx-text-fill: rgba(11,28,107,0.75)");
        Label lastnameLabel = new Label("last name : ");
        lastnameLabel.setStyle("-fx-font-size: 15; -fx-text-fill: rgba(11,28,107,0.75)");
        Label emailLabel = new Label("Email : ");
        emailLabel.setStyle("-fx-font-size: 15; -fx-text-fill: rgba(11,28,107,0.75)");
        Label phoneNumberLabel = new Label("phone number : ");
        phoneNumberLabel.setStyle("-fx-font-size: 15; -fx-text-fill: rgba(11,28,107,0.75)");
        Label requestedLoanAmountLabel = new Label("requested loan amount : ");
        requestedLoanAmountLabel.setStyle("-fx-font-size: 15; -fx-text-fill: rgba(11,28,107,0.75)");
        Label idLabel = new Label("id : ");
        idLabel.setStyle("-fx-font-size: 15; -fx-text-fill: rgba(11,28,107,0.75)");
        Label ageLabel = new Label("age : ");
        ageLabel.setStyle("-fx-font-size: 15; -fx-text-fill: rgba(11,28,107,0.75)");
        Label otherExplanationsLabel = new Label("other explanations : ");
        otherExplanationsLabel.setStyle("-fx-font-size: 15; -fx-text-fill: rgba(11,28,107,0.75)");
        Label theReasonForTheRequestLabel = new Label("the reason for the request : ");
        theReasonForTheRequestLabel.setStyle("-fx-font-size: 15; -fx-text-fill: rgba(11,28,107,0.75)");

        VBox vBox1 = new VBox(nameLabel, lastnameLabel, emailLabel, phoneNumberLabel, requestedLoanAmountLabel, idLabel, ageLabel);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(16);

        VBox vBox11 = new VBox(otherExplanationsLabel, theReasonForTheRequestLabel);
        vBox11.setAlignment(Pos.CENTER);
        vBox11.setSpacing(30);

        TextField nameTextField = new TextField();
        nameTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45); -fx-background-radius: 10px;");
        TextField lastNameTextField = new TextField();
        lastNameTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45); -fx-background-radius: 10px;");
        TextField emailTextField = new TextField();
        emailTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45); -fx-background-radius: 10px;");
        TextField phoneNumberTextField = new TextField();
        phoneNumberTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45); -fx-background-radius: 10px;");
        TextField requestedLoanAmountTextField = new TextField();
        requestedLoanAmountTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45); -fx-background-radius: 10px;");
        TextField idTextField = new TextField(String.valueOf(id));
        idTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45); -fx-background-radius: 10px;");
        TextField ageTextField = new TextField();
        ageTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45); -fx-background-radius: 10px;");
        TextArea otherExplanationsTextArea = new TextArea();
        otherExplanationsTextArea.setPrefSize(150, 50);
        otherExplanationsTextArea.setStyle("-fx-background-color: rgba(226,226,229,0.45); -fx-background-radius: 10px;");
        TextArea theReasonForTheRequestTextArea = new TextArea();
        theReasonForTheRequestTextArea.setPrefSize(150, 50);
        theReasonForTheRequestTextArea.setStyle("-fx-background-color: rgba(226,226,229,0.45); -fx-background-radius: 10px;");
        VBox vBox2 = new VBox(nameTextField, lastNameTextField, emailTextField, phoneNumberTextField, requestedLoanAmountTextField, idTextField, ageTextField);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(10);

        VBox vBox22 = new VBox(otherExplanationsTextArea, theReasonForTheRequestTextArea);
        vBox22.setAlignment(Pos.CENTER);
        vBox22.setSpacing(10);

        HBox hBox11 = new HBox(vBox11, vBox22);
        hBox11.setAlignment(Pos.CENTER);
        hBox11.setSpacing(6);

        Button sendBtn = new Button("\" SEND \"");
        sendBtn.setPrefSize(100, 50);
        sendBtn.setStyle("-fx-font-size: 16px; -fx-font-family: Arial; -fx-background-color: rgba(80,93,155,0.62); -fx-background-radius: 10px; -fx-text-fill: rgb(255,255,255)");

        HBox hBox1 = new HBox(vBox1, vBox2);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(6);

        VBox vBox3 = new VBox(hBox1, hBox11, sendBtn);
        vBox3.setSpacing(20);
        vBox3.setPrefSize(390, 530);
        vBox3.setAlignment(Pos.CENTER);
        vBox3.setStyle("-fx-background-color:rgba(255,255,255,0.45); -fx-background-radius: 10px;");
        vBox3.setLayoutX(106);
        vBox3.setLayoutY(140);

        Label label = new Label("\" APPLY FOR LOAN \"");
        label.setStyle("-fx-font-size: 30; -fx-text-fill: rgba(255,255,255,0.75); -fx-font-family: BordeauxHeavy");
        label.setLayoutX(155);
        label.setLayoutY(90);

        Button exitButton = new Button();
        exitButton.setText("\" EXIT \"");
        exitButton.setPrefSize(50, 20);
        exitButton.setStyle("-fx-font-size: 8px; -fx-font-family: Arial; -fx-background-color: rgba(183,107,107,0.93); -fx-background-radius: 10px;");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                Main_page mainPage = null;
//                try {
//                    mainPage = new Main_page();
//                } catch (FileNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//                Stage stage1 = new Stage();
//                stage1.setScene(new Scene(mainPage));
//                stage1.show();

                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            }
        });
        exitButton.setLayoutX(1450);
        exitButton.setLayoutY(750);

        sendBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    professors_loan_application_controller Professors_loan_application_controller = new professors_loan_application_controller();
                    Professors_loan_application_controller.professors_loan_application_controllerr(
                            nameTextField.getText(),
                            lastNameTextField.getText(),
                            emailTextField.getText(),
                            phoneNumberTextField.getText(),
                            Integer.parseInt(requestedLoanAmountTextField.getText()),
                            Integer.parseInt(idTextField.getText()),
                            Integer.parseInt(ageTextField.getText()),
                            otherExplanationsTextArea.getText(),
                            theReasonForTheRequestTextArea.getText()
                    );

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("APPLY FOR A STUDENT LOAN");
                    alert.setHeaderText(null);
                    alert.setContentText("SENT");
                    alert.showAndWait();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Image image = new Image(new FileInputStream("blogging-guide-xYaMK5p3vCA-unsplash (1).jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(1540, 785);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(label, vBox3, exitButton);
        this.getChildren().add(pane);
    }
}
