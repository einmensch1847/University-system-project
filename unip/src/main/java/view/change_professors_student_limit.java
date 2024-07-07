package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class change_professors_student_limit extends VBox{
    public change_professors_student_limit() throws FileNotFoundException {
        Label username = new Label("ID : ") ;

        TextField textField = new TextField() ;
        textField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        Button button = new Button("search") ;
        button.setPrefSize(100 , 40);
        button.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(162,187,227,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");

        VBox vBox = new VBox(username , textField , button) ;
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(12);
        vBox.setPrefSize(200 , 290);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("select * from professor where id = ?");
                    statement.setString(1, textField.getText());
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id") ;
                        int Limit = resultSet.getInt("student_limit") ;
                        int number_of_students = resultSet.getInt("number_of_students") ;
                        final_change_professors_student_limit finalchange_professors_student_limit = null;
                        try {
                            finalchange_professors_student_limit = new final_change_professors_student_limit(id , Limit , number_of_students);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        Stage stage1 = new Stage() ;
                        stage1.setScene(new Scene(finalchange_professors_student_limit));
                        stage1.show();

                        Stage stage = (Stage) button.getScene().getWindow() ;
                        stage.close();
                    }
                    connection.close();
                    statement.close();
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
