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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class ApplyForStudentLoanPage extends VBox {
    public ApplyForStudentLoanPage() throws FileNotFoundException {
        Label nameLabel = new Label("name : ");
        nameLabel.setStyle("-fx-font-size: 13; -fx-text-fill: rgb(255,255,255)");
        Label lastnameLabel = new Label("last name : ");
        lastnameLabel.setStyle("-fx-font-size: 13; -fx-text-fill: rgb(255,255,255)");
        Label emailLabel = new Label("Email : ");
        emailLabel.setStyle("-fx-font-size: 13; -fx-text-fill: rgb(255,255,255)");
        Label phoneNumberLabel = new Label("phone number : ");
        phoneNumberLabel.setStyle("-fx-font-size: 13; -fx-text-fill: rgb(255,255,255)");
        Label requestedLoanAmountLabel = new Label("requested loan amount : ");
        requestedLoanAmountLabel.setStyle("-fx-font-size: 13; -fx-text-fill: rgb(255,255,255)");
        Label studentNumberLabel = new Label("student number : ");
        studentNumberLabel.setStyle("-fx-font-size: 13; -fx-text-fill: rgb(255,255,255)");
        Label ageLabel = new Label("age : ");
        ageLabel.setStyle("-fx-font-size: 13; -fx-text-fill: rgb(255,255,255)");
        Label otherExplanationsLabel = new Label("other explanations : ");
        otherExplanationsLabel.setStyle("-fx-font-size: 13; -fx-text-fill: rgb(255,255,255)");
        Label theReasonForTheRequestLabel = new Label("the reason for the request : ");
        theReasonForTheRequestLabel.setStyle("-fx-font-size: 13; -fx-text-fill: rgb(255,255,255)");

        VBox vBox1 = new VBox(nameLabel, lastnameLabel, emailLabel, phoneNumberLabel, requestedLoanAmountLabel, studentNumberLabel, ageLabel);
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
        TextField studentNumberTextField = new TextField();
        studentNumberTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45); -fx-background-radius: 10px;");
        TextField ageTextField = new TextField();
        ageTextField.setStyle("-fx-background-color: rgba(226,226,229,0.45); -fx-background-radius: 10px;");
        TextArea otherExplanationsTextArea = new TextArea();
        otherExplanationsTextArea.setPrefSize(150, 50);
        otherExplanationsTextArea.setStyle("-fx-background-color: rgba(226,226,229,0.45); -fx-background-radius: 10px;");
        TextArea theReasonForTheRequestTextArea = new TextArea();
        theReasonForTheRequestTextArea.setPrefSize(150, 50);
        theReasonForTheRequestTextArea.setStyle("-fx-background-color: rgba(226,226,229,0.45); -fx-background-radius: 10px;");
        VBox vBox2 = new VBox(nameTextField, lastNameTextField, emailTextField, phoneNumberTextField, requestedLoanAmountTextField, studentNumberTextField, ageTextField);
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
        vBox3.setPrefSize(330, 500);
        vBox3.setAlignment(Pos.CENTER);
        vBox3.setStyle("-fx-background-color:rgba(67,65,65,0.45); -fx-background-radius: 10px;");
//        vBox3.setLayoutX(106);
//        vBox3.setLayoutY(240);

        Label label = new Label("\" APPLY FOR A STUDENT LOAN \"");
        label.setStyle("-fx-font-size: 20; -fx-text-fill: rgba(14,76,86,0.75); -fx-font-family: BordeauxHeavy");
//        label.setLayoutX(130);
//        label.setLayoutY(90);

        VBox vBox = new VBox(label , vBox3) ;
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setLayoutX(1000);
        vBox.setLayoutY(100);

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

        sendBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    StudentLoanApplication application = new StudentLoanApplication();
                    application.insertStudentLoanApplication(
                            nameTextField.getText(),
                            lastNameTextField.getText(),
                            emailTextField.getText(),
                            phoneNumberTextField.getText(),
                            Integer.parseInt(requestedLoanAmountTextField.getText()),
                            studentNumberTextField.getText(),
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

        Image image = new Image(new FileInputStream("image (3).jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(1540, 785);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(vBox , exitButton);
        this.getChildren().add(pane);
    }
}