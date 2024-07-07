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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class Entry_of_employees_page extends VBox{
    public Object getUsers_username;
    public Object getUsers_id ;

    public Entry_of_employees_page() throws FileNotFoundException {
        Label label = new Label("\" WLCOME TO RWTH AACHEN \"") ;
        label.setStyle("-fx-font-size: 45 ; -fx-text-fill: rgb(198,136,95) ; -fx-font-family: BordeauxHeavy ");
        label.setLayoutX(850);
        label.setLayoutY(360);

        Button Exit_button = new Button() ;
        Exit_button.setText("\" EXIT \"");
        Exit_button.setPrefSize(50 , 20);
        Exit_button.setStyle("-fx-font-size: 8px ; -fx-font-family: Arial ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
        Exit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main_page mainPage = null;
                try {
                    mainPage = new Main_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(mainPage));
                stage1.show();

                Stage stage = (Stage) Exit_button.getScene().getWindow() ;
                stage.close();
            }
        });
        Exit_button.setLayoutX(1450);
        Exit_button.setLayoutY(750);

        Label username_label = new Label(" username : ") ;
        username_label.setStyle("-fx-font-size: 16px ; -fx-font-family: Arial ;-fx-text-fill: rgb(220,198,161) ;");
        Label passwoaed_label = new Label(" password : ") ;
        passwoaed_label.setStyle("-fx-font-size: 16px ; -fx-font-family: Arial ;-fx-text-fill:rgb(220,198,161) ;");

        TextField username_textfield = new TextField() ;
        username_textfield.setStyle("-fx-background-color: rgba(91,84,84,0.76) ;-fx-background-radius: 10px; -fx-text-fill:rgb(255,255,255) ");
        TextField password_textField = new TextField() ;
        password_textField.setStyle("-fx-background-color: rgba(91,84,84,0.76) ;-fx-background-radius: 10px; -fx-text-fill:rgb(255,255,255) ");

        VBox vBox1 = new VBox(username_label , passwoaed_label) ;
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(13);

        VBox vBox2 = new VBox(username_textfield , password_textField) ;
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(4);

        Button login_button = new Button("LOGIN") ;
        login_button.setPrefSize(120 , 45);
        login_button.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(67,39,17,0.68) ;-fx-background-radius: 10px;-fx-text-fill:rgb(220,198,161)");

        HBox hBox = new HBox(vBox1 , vBox2 , login_button) ;
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPrefSize(500 , 300);
        hBox.setStyle("-fx-background-radius: 10px ; -fx-background-color:  rgba(136,65,7,0.59)");
        hBox.setLayoutX(70);
        hBox.setLayoutY(300);

        login_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String Name1 = username_textfield.getText() ;
                String Password1 = password_textField.getText() ;

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM education_employee WHERE username = ? AND password = ?") ;
                    statement.setString(1 , Name1);
                    statement.setString(2 , Password1);

                    ResultSet resultSet = statement.executeQuery() ;
                    if (resultSet.next()){
                        EducationEmployeePanel educationEmployeePanel = null;
                        try {
                            educationEmployeePanel = new EducationEmployeePanel();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        Stage stage1 = new Stage() ;
                        stage1.setScene(new Scene(educationEmployeePanel));
                        stage1.show();

                        Stage stage = (Stage) login_button.getScene().getWindow() ;
                        stage.close();

                        getUsers_username = resultSet.getString("username") ;

                        getUsers_id = resultSet.getInt("id") ;

                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String name = username_textfield.getText() ;
                String password = password_textField.getText() ;

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM management_employee WHERE username = ? AND password = ?") ;
                    statement.setString(1 , name);
                    statement.setString(2 , password);

                    ResultSet resultSet = statement.executeQuery() ;
                    if (resultSet.next()){
                        management_employees_page adminPanel = null;
                        try {
                            adminPanel = new management_employees_page();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        Stage stage1 = new Stage() ;
                        stage1.setScene(new Scene(adminPanel));
                        stage1.show();

                        Stage stage = (Stage) login_button.getScene().getWindow() ;
                        stage.close();

                        getUsers_username = resultSet.getString("username") ;

                        getUsers_id = resultSet.getInt("id") ;

                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String adminname = username_textfield.getText() ;
                String adminpassword = password_textField.getText() ;

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?") ;
                    statement.setString(1 , adminname);
                    statement.setString(2 , adminpassword);

                    ResultSet resultSet = statement.executeQuery() ;
                    if (resultSet.next()){
                        Admin_panel adminPanel = null;
                        try {
                            adminPanel = new Admin_panel();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        Stage stage1 = new Stage() ;
                        stage1.setScene(new Scene(adminPanel));
                        stage1.show();

                        Stage stage = (Stage) login_button.getScene().getWindow() ;
                        stage.close();


                    }

                } catch (SQLException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setHeaderText(null);
                    alert.setContentText("username or password is wrong");
                    alert.showAndWait();
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM finance_staff WHERE username = ? AND password = ?") ;
                    statement.setString(1 , adminname);
                    statement.setString(2 , adminpassword);

                    ResultSet resultSet = statement.executeQuery() ;
                    if (resultSet.next()){
                        int id = resultSet.getInt("id") ;
                        String Name = resultSet.getString("name") ;
                        String lastname = resultSet.getString("lastname") ;
                        String username = resultSet.getString("username") ;
                        String Password = resultSet.getString("password") ;
                        String phone = resultSet.getString("phone_number") ;
                        String email = resultSet.getString("email") ;
                        int salary = resultSet.getInt("salary") ;
                        Finance_Staff_Panel financeStaffPanel = null;
                        try {
                            financeStaffPanel = new Finance_Staff_Panel(id , Name , lastname , username , Password , phone , email , salary) ;
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        Stage stage1 = new Stage() ;
                        stage1.setScene(new Scene(financeStaffPanel));
                        stage1.show();

                        Stage stage = (Stage) login_button.getScene().getWindow() ;
                        stage.close();


                    }

                } catch (SQLException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setHeaderText(null);
                    alert.setContentText("username or password is wrong");
                    alert.showAndWait();
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM professor WHERE username = ? AND password = ?") ;
                    statement.setString(1 , adminname);
                    statement.setString(2 , adminpassword);

                    ResultSet resultSet = statement.executeQuery() ;
                    if (resultSet.next()){
                        Professors_panel professorsPanel = null;
                        int id = resultSet.getInt("id") ;
                        try {
                            professorsPanel = new Professors_panel(id);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        Stage stage1 = new Stage() ;
                        stage1.setScene(new Scene(professorsPanel));
                        stage1.show();

                        Stage stage = (Stage) login_button.getScene().getWindow() ;
                        stage.close();
                    }

                } catch (SQLException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setHeaderText(null);
                    alert.setContentText("username or password is wrong");
                    alert.showAndWait();
                }
            }
        });

        username_textfield.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() == KeyCode.DOWN){
                password_textField.requestFocus();
                event.consume();
            }
        });

        password_textField.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() == KeyCode.UP){
                username_textfield.requestFocus();
                event.consume();
            }
        });

        password_textField.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() == KeyCode.ENTER){
                login_button.fire();
                event.consume();
            }
        });

        Image image = new Image(new FileInputStream("wander-fleur-NboyPdtHqFc-unsplash (1).jpg")) ;
        BackgroundSize backgroundSize = new BackgroundSize(100 , 100 , true , true , true , false) ;
        BackgroundImage backgroundImage = new BackgroundImage(image , BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT , BackgroundPosition.CENTER , backgroundSize) ;
        Background background = new Background(backgroundImage) ;
        this.setBackground(background);
        this.setPrefSize(1540 , 785);
        this.setSpacing(20);
        Pane pane = new Pane() ;
        pane.getChildren().addAll(label , Exit_button , hBox) ;
        this.getChildren().add(pane) ;
    }
}
