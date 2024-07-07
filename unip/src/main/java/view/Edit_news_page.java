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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class Edit_news_page extends VBox {
    public Edit_news_page() throws FileNotFoundException {

        TextArea textArea = new TextArea() ;
        textArea.setWrapText(true);
        textArea.setStyle("-fx-background-color: rgba(33,49,131,0.78) ; -fx-font-family: 'Times New Roman'");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
            Statement statement = connection.createStatement() ;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM news") ;
            while (resultSet.next()){
                textArea.setText(resultSet.getString("text"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        textArea.setPrefSize(434 , 700);

        Button apply_butto = new Button("APPLY") ;
        apply_butto.setPrefSize(80 , 30);
        apply_butto.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(170,193,227,0.84);-fx-background-radius: 10px;-fx-text-fill:rgba(32,48,97,0.75)");

        VBox vBox = new VBox(textArea , apply_butto) ;
        vBox.setSpacing(13);
        vBox.setAlignment(Pos.CENTER);
        vBox.setLayoutX(53);
        vBox.setLayoutY(20);
        
        Button Exit_button = new Button() ;
        Exit_button.setText("\" EXIT \"");
        Exit_button.setPrefSize(50 , 20);
        Exit_button.setStyle("-fx-font-size: 8px ; -fx-font-family: Arial ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
        Exit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                Admin_panel mainPage = null;
//                try {
//                    mainPage = new Admin_panel();
//                } catch (FileNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//                Stage stage1 = new Stage() ;
//                stage1.setScene(new Scene(mainPage));
//                stage1.show();

                Stage stage = (Stage) Exit_button.getScene().getWindow() ;
                stage.close();
            }
        });
        Exit_button.setLayoutX(445);
        Exit_button.setLayoutY(750);

        apply_butto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("UPDATE news SET text = ? WHERE id = 0 ") ;
                    statement.setString(1 , textArea.getText());
                    statement.executeUpdate() ;

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("registration");
                    alert.setHeaderText(null);
                    alert.setContentText("successfully");
                    alert.showAndWait();

                } catch (SQLException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("registration");
                    alert.setHeaderText(null);
                    alert.setContentText("failed");
                    alert.showAndWait();
                    throw new RuntimeException(e);
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
        pane.getChildren().addAll(vBox , Exit_button);
        this.getChildren().add(pane);
    }
}
