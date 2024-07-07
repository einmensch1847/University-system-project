package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class enter_the_subject_mater extends VBox{
    public enter_the_subject_mater(int id) throws FileNotFoundException {
        Label subject_matter = new Label("subject matter : ") ;

        TextField textField = new TextField() ;
        textField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");

        Button button = new Button("SEND") ;
        button.setPrefSize(100 , 40);
        button.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(162,187,227,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");

        VBox vBox = new VBox(subject_matter , textField , button) ;
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(12);
        vBox.setPrefSize(200 , 290);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = textField.getText() ;

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("UPDATE professor SET subject = ? WHERE id = ? ") ;
                    statement.setString(1 , textField.getText());
                    statement.setInt(2 , id);
                    statement.executeUpdate() ;

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("subject matter");
                    alert.setHeaderText(null);
                    alert.setContentText("SENT \n Reload panel pleas ");
                    alert.showAndWait();
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
