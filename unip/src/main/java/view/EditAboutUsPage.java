package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.DatabaseHandler_about_us_editor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EditAboutUsPage extends VBox {
    private TextArea textArea;

    public EditAboutUsPage() throws FileNotFoundException {
        textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setStyle("-fx-background-color: rgba(33,49,131,0.78); -fx-font-family: 'Times New Roman'");
        textArea.setPrefSize(434, 700);

        Button applyButton = createApplyButton();
        VBox vBox = new VBox(textArea, applyButton);
        vBox.setSpacing(13);
        vBox.setAlignment(Pos.CENTER);
        vBox.setLayoutX(53);
        vBox.setLayoutY(20);

        Button exitButton = createExitButton();
        exitButton.setLayoutX(445);
        exitButton.setLayoutY(750);

        Image image = new Image(new FileInputStream("c:/test/unip/admin_panel.jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(538, 780);
        this.setSpacing(20);

        Pane pane = new Pane();
        pane.getChildren().addAll(vBox, exitButton);
        this.getChildren().add(pane);

        loadText();
    }

    private Button createExitButton() {
        Button exitButton = new Button("EXIT");
        exitButton.setPrefSize(50, 20);
        exitButton.setStyle("-fx-font-size: 8px; -fx-font-family: Arial; -fx-background-color: rgba(183,107,107,0.93); -fx-background-radius: 10px;");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //                    Admin_panel mainPage = new Admin_panel();
//                    Stage stage1 = new Stage();
//                    stage1.setScene(new Scene(mainPage));
//                    stage1.show();
                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            }
        });
        return exitButton;
    }

    private Button createApplyButton() {
        Button applyButton = new Button("APPLY");
        applyButton.setPrefSize(80, 30);
        applyButton.setStyle("-fx-font-size: 13px; -fx-font-family: Arial; -fx-background-color: rgba(170,193,227,0.84); -fx-background-radius: 10px; -fx-text-fill: rgba(32,48,97,0.75)");
        applyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseHandler_about_us_editor dbHandler = new DatabaseHandler_about_us_editor();
                boolean success = dbHandler.updateAboutUs(textArea.getText());
                Alert alert = new Alert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.WARNING);
                alert.setTitle("Update Status");
                alert.setHeaderText(null);
                alert.setContentText(success ? "Update successful" : "Update failed");
                alert.showAndWait();
            }
        });
        return applyButton;
    }

    private void loadText() {
        DatabaseHandler_about_us_editor dbHandler = new DatabaseHandler_about_us_editor();
        String text = dbHandler.loadAboutUsText();
        if (text != null) {
            textArea.setText(text);
        }
    }
}