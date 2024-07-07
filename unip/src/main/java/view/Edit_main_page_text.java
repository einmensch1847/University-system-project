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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class Edit_main_page_text extends VBox {
    public Edit_main_page_text() throws SQLException, FileNotFoundException {

        Label current_text = new Label("current text : ") ;
        current_text.setStyle("-fx-font-family: 'Agent Orange' ");

        Label text = new Label() ;
        text.setStyle("-fx-font-size: 13px");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
            Statement statement = connection.createStatement() ;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM main_page_tabel") ;
            while (resultSet.next()){
                text.setText(resultSet.getString("text"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        TextField textField = new TextField() ;
        textField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(0,0,0) ");

        Button button = new Button("APPLY") ;
        button.setPrefSize(90 , 25);
        button.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(32,48,97,0.75) ;-fx-background-radius: 10px;-fx-text-fill:rgba(170,193,227,0.84)");

        VBox vBox = new VBox(current_text , text , textField , button) ;
        vBox.setSpacing(15);
        vBox.setAlignment(Pos.CENTER);
        vBox.setLayoutX(80);
        vBox.setLayoutY(400);

        Button Exit_button = new Button() ;
        Exit_button.setText("\" EXIT \"");
        Exit_button.setPrefSize(50 , 20);
        Exit_button.setStyle("-fx-font-size: 8px ; -fx-font-family: Arial ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
        Exit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage stage = (Stage) Exit_button.getScene().getWindow() ;
                stage.close();
            }
        });
        Exit_button.setLayoutX(445);
        Exit_button.setLayoutY(750);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("UPDATE main_page_tabel set text = ? WHERE text = ?") ;
                    statement.setString(1 , textField.getText());
                    statement.setString(2 , text.getText());
                    statement.executeUpdate() ;

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("EDIT MAIN PAGE TABEL");
                    alert.setHeaderText(null);
                    alert.setContentText("APPLIED");
                    alert.showAndWait();
                } catch (SQLException e) {
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
        Pane pane = new Pane(vBox , Exit_button);
        pane.getChildren().addAll();
        this.getChildren().add(pane);
    }
}
