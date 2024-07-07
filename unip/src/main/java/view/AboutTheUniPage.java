package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.UniversityInfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class AboutTheUniPage extends VBox {
    public AboutTheUniPage() throws FileNotFoundException {

        Label label = new Label("\" ABOUT US \"") ;
        label.setStyle("-fx-font-size: 45 ; -fx-text-fill: rgb(83,80,80) ; -fx-font-family: BordeauxHeavy ");
        label.setLayoutX(800);
        label.setLayoutY(80);

        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.setStyle("-fx-background-color: rgba(255,255,255,0.82); -fx-font-family: 'Times New Roman' ");
        try {
            UniversityInfo universityInfo = new UniversityInfo();
            textArea.setText(universityInfo.getAboutUniversityText());
            universityInfo.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        textArea.setPrefSize(434, 720);
        textArea.setLayoutX(140);
        textArea.setLayoutY(20);

        Button exitButton = new Button();
        exitButton.setText("\" EXIT \"");
        exitButton.setPrefSize(50, 20);
        exitButton.setStyle("-fx-font-size: 8px; -fx-font-family: Arial; -fx-background-color: rgba(183,107,107,0.93); -fx-background-radius: 10px;");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main_page mainPage = null;
                try {
                    mainPage = new Main_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(mainPage));
                stage1.show();

                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            }
        });
        exitButton.setLayoutX(1450);
        exitButton.setLayoutY(750);

        Image image = new Image(new FileInputStream("jason-goodman-Oalh2MojUuk-unsplash (1).jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(1540 , 785);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(textArea, exitButton , label);
        this.getChildren().add(pane);
    }
}