package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class edit_professors_student_limit_page extends VBox {
    int limit = 0 ;
    public edit_professors_student_limit_page(int id) throws FileNotFoundException {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM professor WHERE id = ?") ;
            statement.setInt(1 , id);
            ResultSet resultSet = statement.executeQuery() ;
            while (resultSet.next()){
                limit = resultSet.getInt("student_limit") ;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Label limit_label = new Label("LIMIT : ") ;
        TextField limit_text_field = new TextField(String.valueOf(limit)) ;
        limit_text_field.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        Button button = new Button("APPLY") ;
        button.setPrefSize(100 , 40);
        button.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(162,187,227,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        VBox vBox = new VBox(limit_label , limit_text_field , button) ;
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(12);
        vBox.setPrefSize(200 , 290);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Connection connection = null;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "");
                    PreparedStatement statement = connection.prepareStatement("UPDATE professor SET student_limit = ?  WHERE id = ?") ;
                    statement.setInt(1 , Integer.parseInt(limit_text_field.getText()));
                    statement.setInt(2 , id);
                    statement.executeUpdate() ;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("APPLY");
                    alert.setHeaderText(null);
                    alert.setContentText("APPLD");
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
        this.setPrefSize(200, 290);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        Pane pane = new Pane();
        pane.getChildren().addAll(vBox);
        this.getChildren().add(pane);
    }
}
