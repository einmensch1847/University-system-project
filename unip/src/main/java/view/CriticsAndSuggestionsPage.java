package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.DatabaseHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CriticsAndSuggestionsPage extends VBox {
    private TextArea textArea;

    public CriticsAndSuggestionsPage() throws FileNotFoundException {
        Label label = new Label("CRITICS AND SUGGESTIONS");
        label.setStyle("-fx-font-size: 35; -fx-text-fill: rgba(14,76,86,0.75); -fx-font-family: BordeauxHeavy");
        label.setLayoutX(148);
        label.setLayoutY(90);

        Label label1 = new Label("The desired text:");
        label1.setStyle("-fx-font-family: Georgia; -fx-font-size: 20; -fx-text-fill: rgb(255,255,255)");

        textArea = new TextArea();
        textArea.setPrefSize(434, 500);
        textArea.setStyle("-fx-background-color: rgba(110,37,71,0); -fx-font-family: Tahoma");

        Button exitButton = createExitButton();
        Button sendButton = createSendButton();

        VBox vBox1 = new VBox(sendButton);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(10);

        VBox vBox = new VBox(label1, textArea, vBox1);
        vBox.setSpacing(15);
        vBox.setLayoutY(90);
        vBox.setLayoutX(1000);

        Image image = new Image(new FileInputStream("image (2).jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(1540, 785);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(label, vBox , exitButton);
        this.getChildren().add(pane);
    }

    private Button createExitButton() {
        Button exitButton = new Button("EXIT");
        exitButton.setPrefSize(50, 20);
        exitButton.setStyle("-fx-font-size: 8px; -fx-font-family: Arial; -fx-background-color: rgba(183,107,107,0.93); -fx-background-radius: 10px;");
        exitButton.setLayoutX(1450);
        exitButton.setLayoutY(750);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //                    Main_page mainPage = new Main_page();
//                    Stage stage1 = new Stage();
//                    stage1.setScene(new Scene(mainPage));
//                    stage1.show();
                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            }
        });
        return exitButton;
    }

    private Button createSendButton() {
        Button sendButton = new Button("SEND");
        sendButton.setPrefSize(100, 35);
        sendButton.setStyle("-fx-background-color: rgba(80,93,155,0.62); -fx-background-radius: 10px;-fx-font-size: 14px;");
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = textArea.getText();
                DatabaseHandler dbHandler = new DatabaseHandler();
                boolean success = dbHandler.insertCriticsAndSuggestions(text);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Critics and suggestions");
                alert.setHeaderText(null);
                alert.setContentText(success ? "SENT" : "FAILED");
                alert.showAndWait();
            }
        });
        return sendButton;
    }
}