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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class final_change_professors_student_limit extends VBox{
    public final_change_professors_student_limit(int id , int limit , int number_of_students) throws FileNotFoundException {


        Label numberr_of_students = new Label("number of students : "+number_of_students);


        Label username = new Label("LIMIT : ") ;

        TextField textField = new TextField(String.valueOf(limit)) ;
        textField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        Button button = new Button("APPLY") ;
        button.setPrefSize(100 , 40);
        button.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(162,187,227,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");

        VBox vBox = new VBox(username , textField , numberr_of_students ,  button) ;
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(12);
        vBox.setPrefSize(200 , 290);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = Connection.prepareStatement("UPDATE professor SET student_limit =? WHERE id =?");
                    statement.setInt(1 , Integer.parseInt(textField.getText()));
                    statement.setInt(2 , id ) ;
                    statement.executeUpdate() ;
                    statement.close();
                    Connection.close();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMATION");
                    alert.setHeaderText(null);
                    alert.setContentText("APPLED");
                    alert.showAndWait();

                } catch (SQLException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText(null);
                    alert.setContentText("ERROR");
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
        this.setPrefSize(200, 290);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        Pane pane = new Pane();
        pane.getChildren().addAll(vBox);
        this.getChildren().add(pane);
    }
}
