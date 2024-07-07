package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Insert_comment_for_professors extends VBox{
    public Insert_comment_for_professors(int id) throws FileNotFoundException {

        Label label = new Label("report failure to admin");
        label.setStyle("-fx-font-size: 30; -fx-text-fill: rgba(255,255,255,0.75); -fx-font-family: BordeauxHeavy");
        label.setLayoutX(650);
        label.setLayoutY(300);

        Label label1 = new Label("The desired text:");
        label1.setStyle("-fx-font-family: Georgia; -fx-font-size: 20; -fx-text-fill: rgb(255,255,255)");

        TextArea textArea = new TextArea();
        textArea.setPrefSize(434, 300);
        textArea.setStyle("-fx-background-color: rgba(110,37,71,0); -fx-font-family: Tahoma");

        Button sendButton = new Button("SEND");
        sendButton.setPrefSize(100 , 50);
        sendButton.setStyle("-fx-background-color: rgba(47,74,202,0.62); -fx-background-radius: 10px;-fx-text-fill: rgba(255,255,255,0.62) ; -fx-font-size: 15px");
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = null ;
                String lastname = null ;
                String username = null ;
                String password = null ;
                String phone_number = null ;
                String email = null ;
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM professor WHERE id = ?") ;
                    statement.setInt(1 , id);
                    ResultSet resultSet = statement.executeQuery() ;
                    while (resultSet.next()){
                        name = resultSet.getString("name") ;
                        lastname = resultSet.getString("lastname") ;
                        username = resultSet.getString("username") ;
                        password = resultSet.getString("password") ;
                        phone_number = resultSet.getString("phone_number") ;
                        email = resultSet.getString("email") ;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO professors_comments (professor_id , name , lastname , username , password , phone_number , email , text, date, time) VALUES (? , ? , ? , ? , ?, ? , ? ,? , ? , ?)");
                    statement.setInt(1 , id);
                    statement.setString(2 , name);
                    statement.setString(3 , lastname);
                    statement.setString(4 , username);
                    statement.setString(5 , password);
                    statement.setString(6 , phone_number);
                    statement.setString(7 , email);
                    statement.setString(8 , textArea.getText());
                    java.util.Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
                    String formattedDate = dateFormat.format(date);
                    statement.setString(9, formattedDate);
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    String formattedTime = timeFormat.format(date);
                    statement.setString(10, formattedTime);
                    statement.executeUpdate();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Critics and suggestions");
                    alert.setHeaderText(null);
                    alert.setContentText("SENT");
                    alert.showAndWait();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


            }
        });

        VBox vBox = new VBox(label1, textArea , sendButton);
        vBox.setSpacing(15);
        vBox.setLayoutY(200);
        vBox.setLayoutX(50);

        Button Exit_button = new Button() ;
        Exit_button.setText("\" EXIT \"");
        Exit_button.setPrefSize(50 , 20);
        Exit_button.setStyle("-fx-font-size: 8px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
        Exit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) Exit_button.getScene().getWindow() ;
                stage.close();
            }
        });
        Exit_button.setLayoutX(1450);
        Exit_button.setLayoutY(750);

        Image image = new Image(new FileInputStream("annie-spratt-hCb3lIB8L8E-unsplash (1) (1).jpg")) ;
        BackgroundSize backgroundSize = new BackgroundSize(100 , 100 , true , true , true , false) ;
        BackgroundImage backgroundImage = new BackgroundImage(image , BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT , BackgroundPosition.CENTER , backgroundSize) ;
        Background background = new Background(backgroundImage) ;
        this.setBackground(background);
        this.setPrefSize(1540 , 785);
        this.setSpacing(20);
        Pane pane = new Pane() ;
        pane.getChildren().addAll(label , vBox , Exit_button) ;
        this.getChildren().add(pane) ;
    }
}
