package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class edit_professors_student_limit extends VBox{
    public edit_professors_student_limit() throws FileNotFoundException {
        Label id_label = new Label("ID : ") ;

        TextField id_text_field = new TextField() ;
        id_text_field.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");

        Button button = new Button("search") ;
        button.setPrefSize(100 , 40);
        button.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(162,187,227,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        VBox vBox = new VBox(id_label , id_text_field , button) ;
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(12);
        vBox.setPrefSize(200 , 290);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Connection connection = null;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "");
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM professor WHERE id = ?") ;
                    statement.setInt(1 , Integer.parseInt(id_text_field.getText()));
                    ResultSet resultSet = statement.executeQuery() ;
                    if (resultSet.next()) {
                        edit_professors_student_limit_page edit_professors_student_limit_page;
                        try {
                            edit_professors_student_limit_page = new edit_professors_student_limit_page(Integer.parseInt(id_text_field.getText()));
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        Stage stage1 = new Stage();
                        stage1.setScene(new Scene(edit_professors_student_limit_page));
                        stage1.show();

                        Stage stage = (Stage) button.getScene().getWindow();
                        stage.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
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
