package view;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import model.CriticsAndSuggestionsDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class ShowCriticsAndSuggestionsPage extends VBox {
    public ShowCriticsAndSuggestionsPage() throws FileNotFoundException {
        CriticsAndSuggestionsDAO dao = new CriticsAndSuggestionsDAO();
        List<String> criticsAndSuggestionsList = dao.getAllCriticsAndSuggestions();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setStyle("-fx-background-color: rgba(32,48,97,0.75); -fx-spacing: 25;");
        scrollPane.setPrefSize(538, 740);

        VBox contentBox = new VBox();
        contentBox.setPrefWidth(538);

        for (String criticsAndSuggestions : criticsAndSuggestionsList) {
            Label commentLabel = new Label(criticsAndSuggestions);
            commentLabel.setStyle("-fx-text-fill: rgba(0,0,0,0.93); -fx-font-size: 10px;");
            contentBox.getChildren().add(commentLabel);

            Label spacerLabel = new Label();
            spacerLabel.setPrefHeight(10);
            contentBox.getChildren().add(spacerLabel);
        }

        scrollPane.setContent(contentBox);

        Button exitButton = new Button("EXIT");
        exitButton.setPrefSize(50, 20);
        exitButton.setStyle("-fx-font-size: 8px; -fx-font-family: Arial; -fx-background-color: rgba(183,107,107,0.93); -fx-background-radius: 10px;");
        exitButton.setOnAction(event -> {
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
        });
        exitButton.setLayoutX(445);
        exitButton.setLayoutY(750);

        Image image = new Image(new FileInputStream("c:/test/unip/admin_panel.jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        scrollPane.setBackground(background);
        this.setBackground(background);
        this.setPrefSize(538, 780);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(scrollPane , exitButton);
        this.getChildren().add(pane);
    }
}