package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class Edit_admins_info extends VBox{
    public Edit_admins_info() throws FileNotFoundException {

        Label username = new Label("username : ") ;

        PasswordField passwordField = new PasswordField() ;
        passwordField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73)");

        TextField textField = new TextField() ;
        textField.setStyle("-fx-background-color: rgba(82,129,203,0.73) ;-fx-background-radius: 10px; -fx-text-fill:rgb(18,30,73) ");
        Button button = new Button("search") ;
        button.setPrefSize(100 , 40);
        button.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(162,187,227,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");

        VBox vBox = new VBox(username , textField , passwordField , button) ;
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(12);
        vBox.setPrefSize(200 , 290);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = textField.getText() ;
                String password = passwordField.getText() ;

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?") ;
                    statement.setString(1 , username);
                    statement.setString(2 , password);

                    ResultSet resultSet = statement.executeQuery() ;
                    if (resultSet.next()){
                        String name = resultSet.getString("name") ;
                        String last_name = resultSet.getString("lastname") ;
                        String phone_number = resultSet.getString("phone_number") ;
                        String postal_code = resultSet.getString("postal_code") ;
                        String address = resultSet.getString("address") ;
                        int id = resultSet.getInt("id") ;

                        Edit_admins_info_page adminPanel = null;
                        try {
                            adminPanel = new Edit_admins_info_page(id , name , last_name , username , password , phone_number , postal_code , address);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        Stage stage1 = new Stage() ;
                        stage1.setScene(new Scene(adminPanel));
                        stage1.show();

                        Stage stage = (Stage) button.getScene().getWindow() ;
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
