package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.ShowStudentsController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ShowStudentsPage extends VBox {
    public ShowStudentsPage() {
        VBox vBox = new VBox();
        vBox.setPrefSize(538, 740);
        vBox.setSpacing(25);
        vBox.setAlignment(Pos.CENTER);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        vBox.setStyle("-fx-background-color: rgba(32,48,97,0.75);");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        scrollPane.setStyle("-fx-background-color: rgba(255,255,255,0.75); -fx-spacing: 25");
        scrollPane.setPrefSize(538, 740);

        ShowStudentsController.loadStudentsInfo(vBox);

        scrollPane.setContent(vBox);

        Button exitButton = createExitButton();
        exitButton.setLayoutX(445);
        exitButton.setLayoutY(750);

        Image image = null;
        try {
            image = new Image(new FileInputStream("admin_panel.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(538, 780);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(scrollPane, exitButton);
        this.getChildren().add(pane);
    }

    private Button createExitButton() {
        Button exitButton = new Button("EXIT");
        exitButton.setPrefSize(50, 20);
        exitButton.setStyle("-fx-font-size: 8px; -fx-font-family: Arial; -fx-background-color: rgba(183,107,107,0.93); -fx-background-radius: 10px;");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            }
        });
        return exitButton;
    }
}