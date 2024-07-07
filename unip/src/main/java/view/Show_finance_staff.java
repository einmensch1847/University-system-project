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

public class Show_finance_staff extends VBox {
    public Show_finance_staff() throws FileNotFoundException {
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

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
            Statement statement = connection.createStatement() ;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM finance_staff") ;
            int row = 0;
            while (resultSet.next()){

                int ID = resultSet.getInt("id") ;
                String name = resultSet.getString("name") ;
                String lastname = resultSet.getString("lastname") ;
                String username = resultSet.getString("username") ;
                String password = resultSet.getString("password") ;
                String phone_number = resultSet.getString("phone_number") ;
                String email = resultSet.getString("email") ;
                int salary = resultSet.getInt("salary") ;
                String date = resultSet.getString("date") ;
                String time = resultSet.getString("time") ;


                Label label = new Label(ID+" : "+name+" "+lastname+" email : "+email+"\n"+"username : "+username+"   password : "+password +" salary : "+salary+"\n"+"phone number : "+phone_number+" date and time :"+date +"  "+time) ;
                label.setStyle("-fx-text-fill: rgba(0,0,0,0.93)  ; -fx-text-fill: rgb(34,92,47); -fx-font-size: 12px ; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-family: Arial ");

                HBox hBox = new HBox(label);
                hBox.setStyle("-fx-background-radius: 8px ; -fx-background-color: rgba(26,68,201,0.4) ;-fx-text-alignment: center ;");

                Button Dbutton = new Button("DELETE");
                Dbutton.setTextFill(Color.WHITE);
                Dbutton.setPrefSize(70 , 18);
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
                            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM finance_staff WHERE id = ?");
                            preparedStatement.setInt(1, finalId);
                            preparedStatement.executeUpdate();

                            vBox.getChildren().remove(label);


                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });


                gridPane.add(hBox, 0, row);
                gridPane.add(Dbutton, 2, row);
                row++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        scrollPane.setContent(gridPane);

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

        this.setPrefSize(538, 780);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(scrollPane , Exit_button);
        this.getChildren().add(pane);
    }
}
