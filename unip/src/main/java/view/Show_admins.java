package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class Show_admins extends VBox {
    public Show_admins() throws FileNotFoundException {

        VBox vBox = new VBox() ;
        vBox.setPrefSize(538 , 740);
        vBox.setSpacing(25);
        vBox.setAlignment(Pos.CENTER);
//        vBox.setLayoutX(53);
//        vBox.setLayoutY(20);

        ScrollPane scrollPane = new ScrollPane() ;
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        vBox.setStyle("-fx-background-color: rgba(32,48,97,0.75) ;");
        scrollPane.setStyle("-fx-background-color: rgba(32,48,97,0.75) ;-fx-spacing: 25");
        scrollPane.setPrefSize(538, 740);

//        scrollPane.setLayoutX(53);
//        scrollPane.setLayoutY(20);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
            Statement statement = ((Connection) connection).createStatement() ;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM admin") ;
            while (resultSet.next()){

                int ID = resultSet.getInt("id") ;
                String name = resultSet.getString("name") ;
                String lastname = resultSet.getString("lastname") ;
                String username = resultSet.getString("username") ;
                String password = resultSet.getString("password") ;
                String date_of_birth = resultSet.getString("date_of_dirth") ;
                String father_name = resultSet.getString("father_name") ;
                String phone_number = resultSet.getString("phone_number") ;
                String postal_code = resultSet.getString("postal_code") ;
                String adddress = resultSet.getString("address") ;
                int age = resultSet.getInt("age") ;
                String date = resultSet.getString("date") ;
                String time = resultSet.getString("time") ;


                Label label = new Label(ID+" : "+name+" "+lastname+"\n"+"username : "+username+"   password : "+password +" adddress : "+adddress+"\n"+"date of birth : "+date_of_birth+"   father name : "+father_name+"   age : "+age+"\n"+"phone number : "+phone_number+"    postal code : "+postal_code+" date and time :"+date +"  "+time) ;
                label.setStyle("-fx-text-fill: rgba(0,0,0,0.93) ;-fx-font-size: 9px");

                Button Dbutton = new Button("DELETE");
                Dbutton.setTextFill(Color.WHITE);
                Dbutton.setPrefSize(60 , 25);
                Dbutton.setStyle("-fx-font-size: 10px ; -fx-font-family: Arial ;-fx-background-color: rgba(189,64,64,0.85) ;-fx-background-radius: 10px;");

                Dbutton.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                Dbutton.setTextFill(Color.WHITE);

                final int finalId = ID;

                Dbutton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("deleted");
                        alert.setHeaderText(null);
                        alert.setContentText("deleted");
                        alert.showAndWait();
                        try {
                            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM admin WHERE id = ?");
                            preparedStatement.setInt(1, finalId);
                            preparedStatement.executeUpdate();

                            vBox.getChildren().remove(label);


                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });

                VBox hBox = new VBox(label , Dbutton ) ;
                vBox.setAlignment(Pos.CENTER);

                vBox.getChildren().add(hBox) ;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        scrollPane.setContent(vBox);

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

        Image image = new Image(new FileInputStream("c:/test/unip/admin_panel.jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(538, 780);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(scrollPane , Exit_button);
        this.getChildren().add(pane);
    }
}
