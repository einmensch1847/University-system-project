package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Professors_panel extends VBox{
    String name = null ;
    String email = null ;
    private String[] imagePaths = {
            "6.jpg",
//            "1.jpg",
//            "2.jpg",
//            "3.jpg",
            "4.jpg",
            "5.jpg"
    };
    private int currentImageIndex = 0;
    public Professors_panel(int id) throws FileNotFoundException {

        TextArea textArea = new TextArea() ;
        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.setStyle("-fx-background-color: rgba(255,255,255,0.78) ; -fx-font-family: 'Times New Roman' ;");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
            Statement statement = connection.createStatement() ;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM professors_page_text") ;
            while (resultSet.next()){
                textArea.setText(resultSet.getString("text"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        textArea.setPrefSize(300 , 169);
        textArea.setLayoutY(229);
        textArea.setLayoutX(60);

        ImageView imageView = new ImageView();
        updateImage(imageView);

        StackPane root = new StackPane();
        root.getChildren().add(imageView);
//        root.setPrefSize(370 , 340);
        root.setLayoutX(60);
        root.setLayoutY(60);

        //pictus : 300 , 169 ******

        imageView.setOnMouseClicked(event -> {
            currentImageIndex = (currentImageIndex + 1) % imagePaths.length;
            updateImage(imageView);
        });
        root.setStyle("-fx-background-radius: 19px ;");

        //**********

        Label info11_lbl = new Label("name : ") ;
        info11_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info11_lbl.setLayoutX(163);
        info11_lbl.setLayoutY(90);
        Label info22_lbl = new Label("lastname : ") ;
        info22_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info22_lbl.setLayoutX(163);
        info22_lbl.setLayoutY(90);
        Label info33_lbl = new Label("username : ") ;
        info33_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info33_lbl.setLayoutX(163);
        info33_lbl.setLayoutY(90);
        Label info44_lbl = new Label("password : ") ;
        info44_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info44_lbl.setLayoutX(163);
        info44_lbl.setLayoutY(90);
        Label info55_lbl = new Label("topic : ") ;
        info55_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info55_lbl.setLayoutX(163);
        info55_lbl.setLayoutY(90);
        Label info66_lbl = new Label("unit : ") ;
        info66_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info66_lbl.setLayoutX(163);
        info66_lbl.setLayoutY(90);
        Label info77_lbl = new Label("overtime : ") ;
        info77_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info77_lbl.setLayoutX(163);
        info77_lbl.setLayoutY(90);
        Label info88_lbl = new Label("number of students : ") ;
        info88_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info88_lbl.setLayoutX(163);
        info88_lbl.setLayoutY(90);
        Label info99_lbl = new Label("basic salary : ") ;
        info99_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info99_lbl.setLayoutX(163);
        info99_lbl.setLayoutY(90);
        Label info100_lbl = new Label("id : ") ;
        info100_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info100_lbl.setLayoutX(163);
        info100_lbl.setLayoutY(90);
        Label info110_lbl = new Label("subject matter : ") ;
        info110_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info110_lbl.setLayoutX(163);
        info110_lbl.setLayoutY(90);

        Label info1_lbl = new Label() ;
        info1_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info1_lbl.setLayoutX(163);
        info1_lbl.setLayoutY(90);
        Label info2_lbl = new Label() ;
        info2_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info2_lbl.setLayoutX(163);
        info2_lbl.setLayoutY(90);
        Label info3_lbl = new Label() ;
        info3_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info3_lbl.setLayoutX(163);
        info3_lbl.setLayoutY(90);
        Label info4_lbl = new Label() ;
        info4_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info4_lbl.setLayoutX(163);
        info4_lbl.setLayoutY(90);
        Label info5_lbl = new Label() ;
        info5_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info5_lbl.setLayoutX(163);
        info5_lbl.setLayoutY(90);
        Label info6_lbl = new Label() ;
        info6_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info6_lbl.setLayoutX(163);
        info6_lbl.setLayoutY(90);
        Label info7_lbl = new Label() ;
        info7_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info7_lbl.setLayoutX(163);
        info7_lbl.setLayoutY(90);
        Label info8_lbl = new Label() ;
        info8_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info8_lbl.setLayoutX(163);
        info8_lbl.setLayoutY(90);
        Label info9_lbl = new Label() ;
        info9_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info9_lbl.setLayoutX(163);
        info9_lbl.setLayoutY(90);
        Label info10_lbl = new Label() ;
        info10_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info10_lbl.setLayoutX(163);
        info10_lbl.setLayoutY(90);
        Label info111_lbl = new Label() ;
        info111_lbl.setStyle("-fx-font-size: 14px ; -fx-text-fill: rgba(11,28,107,0.75); -fx-font-family: Arial ");
        info111_lbl.setLayoutX(163);
        info111_lbl.setLayoutY(90);


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM professor WHERE id = ?") ;
            statement.setInt(1 , id);
            ResultSet resultSet = statement.executeQuery() ;
            while (resultSet.next()){
                name = resultSet.getString("name") ;
                email = resultSet.getString("email") ;
                info1_lbl.setText(resultSet.getString("name")) ;
                info2_lbl.setText(resultSet.getString("lastname")) ;
                info3_lbl.setText(resultSet.getString("username")) ;
                info4_lbl.setText(resultSet.getString("password")) ;
                info5_lbl.setText(resultSet.getString("topic")) ;
                info6_lbl.setText(String.valueOf(resultSet.getInt("unit"))) ;
                info7_lbl.setText(String.valueOf(resultSet.getInt("overtime"))) ;
                info8_lbl.setText(String.valueOf(resultSet.getInt("number_of_students"))) ;
                info9_lbl.setText(String.valueOf(resultSet.getInt("basic_salary"))) ;
                info10_lbl.setText(String.valueOf(resultSet.getInt("id"))) ;
                info111_lbl.setText(resultSet.getString("subject"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        VBox vBox1 = new VBox(info1_lbl , info2_lbl , info3_lbl , info4_lbl , info5_lbl , info6_lbl , info7_lbl , info8_lbl , info9_lbl , info10_lbl , info111_lbl) ;
        vBox1.setSpacing(13);
        vBox1.setAlignment(Pos.CENTER);

        VBox vBox2 = new VBox(info11_lbl , info22_lbl , info33_lbl , info44_lbl , info55_lbl , info66_lbl , info77_lbl , info88_lbl , info99_lbl , info100_lbl , info110_lbl) ;
        vBox2.setSpacing(13);
        vBox2.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox(vBox2 , vBox1) ;
        hBox1.setSpacing(2);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setStyle("-fx-background-color: rgba(255,255,255,0.8) ;-fx-background-radius: 13px ;-fx-text-alignment: center ;");
        hBox1.setLayoutX(600);
        hBox1.setLayoutY(60);
        hBox1.setPrefSize(300 , 350);


        Button public_chat = new Button("➤");
        public_chat.setPrefSize(50 , 50);
        public_chat.setStyle("-fx-font-size: 20px;-fx-background-color: rgba(255,255,255,0) ;");
        public_chat.setLayoutX(0);
        public_chat.setLayoutY(0);
        public_chat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ProfessorsPublicChatPage PublicChatPage = null;
                try {
                    PublicChatPage = new ProfessorsPublicChatPage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(PublicChatPage));
                stage1.show();
            }
        });


//        Button pay_slip_button = new Button("pay slip") ;
//        pay_slip_button.setPrefSize(270 , 75);
//        pay_slip_button.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(255,255,255,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
//        pay_slip_button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//
//            }
//        });
        Button enter_the_subject_button = new Button("enter the subject mater") ;
        enter_the_subject_button.setPrefSize(270 , 75);
        enter_the_subject_button.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(255,255,255,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
        enter_the_subject_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                enter_the_subject_mater enterTheSubjectMater = null;
                try {
                    enterTheSubjectMater = new enter_the_subject_mater(id);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(enterTheSubjectMater));
                stage1.show();
            }
        });
        Button report_failure_to_admin_button = new Button("report failure to admin") ;
        report_failure_to_admin_button.setPrefSize(270 , 75);
        report_failure_to_admin_button.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(255,255,255,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
        report_failure_to_admin_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Insert_comment_for_professors insertCommentForProfessors = null;
                try {
                    insertCommentForProfessors = new Insert_comment_for_professors(id);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(insertCommentForProfessors));
                stage1.show();
            }
        });
//        Button enter_grades_button = new Button("enter grades") ;
//        enter_grades_button.setPrefSize(270 , 75);
//        enter_grades_button.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(255,255,255,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
//        enter_grades_button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//
//            }
//        });
        Button loan_application_button = new Button("loan application") ;
        loan_application_button.setPrefSize(270 , 75);
        loan_application_button.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(255,255,255,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
        loan_application_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                professors_loan_application professors_loan_application = null;
                try {
                    professors_loan_application = new professors_loan_application(id);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(professors_loan_application));
                stage1.show();
            }
        });
        Button edit_info_button = new Button("edit info ⚙") ;
        edit_info_button.setPrefSize(270 , 75);
        edit_info_button.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(255,255,255,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
        edit_info_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Edit_professors_info editProfessorsInfo = null;
                try {
                    editProfessorsInfo = new Edit_professors_info();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editProfessorsInfo));
                stage1.show();
            }
        });
        Button insert_your_articles_button = new Button("insert your articles");
        insert_your_articles_button.setPrefSize(270, 75);
        insert_your_articles_button.setStyle("-fx-font-size: 15px; -fx-font-family: 'Times New Roman'; -fx-background-color: rgba(255,255,255,0.65); -fx-background-radius: 10px; -fx-text-alignment: center; -fx-font-size: 15px;");

        insert_your_articles_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
                File selectedFile = fileChooser.showOpenDialog(insert_your_articles_button.getScene().getWindow());
                if (selectedFile != null) {
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
                        PreparedStatement statement = connection.prepareStatement("INSERT INTO fille (name, email, file, date, time) VALUES (?, ?, ?, ?, ?)");
                        FileInputStream inputStream = new FileInputStream(selectedFile);
                        byte[] fileBytes = inputStream.readAllBytes();
                        inputStream.close();

                        statement.setString(1, name);
                        statement.setString(2, email);
                        statement.setBytes(3, fileBytes); // استفاده از setBytes به جای setBlob
                        LocalDate currentDate = LocalDate.now();
                        LocalTime currentTime = LocalTime.now();
                        statement.setDate(4, java.sql.Date.valueOf(currentDate));
                        statement.setTime(5, java.sql.Time.valueOf(currentTime));

                        statement.executeUpdate();

                        statement.close();
                        connection.close();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText(null);
                        alert.setContentText("File uploaded successfully!");
                        alert.showAndWait();

                        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    } catch (SQLException | IOException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("File upload failed: " + e.getMessage());
                        alert.showAndWait();

                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Button professors_dormitory_button = new Button("professors dormitory") ;
        professors_dormitory_button.setPrefSize(270 , 75);
        professors_dormitory_button.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(255,255,255,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
        professors_dormitory_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                professors_dormitory_page professorsDormitoryPage = null;
                try {
                    professorsDormitoryPage = new professors_dormitory_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(professorsDormitoryPage));
                stage1.show();
            }
        });

        VBox vBox = new VBox(enter_the_subject_button , report_failure_to_admin_button , loan_application_button , edit_info_button , insert_your_articles_button , professors_dormitory_button) ;
        vBox.setSpacing(17);
        vBox.setLayoutX(1230);
        vBox.setLayoutY(20);

        Button Exit_button = new Button() ;
        Exit_button.setText("\" EXIT \"");
        Exit_button.setPrefSize(50 , 20);
        Exit_button.setStyle("-fx-font-size: 8px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
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


        Image image = new Image(new FileInputStream("shapelined-_JBKdviweXI-unsplash (1).jpg")) ;
        BackgroundSize backgroundSize = new BackgroundSize(100 , 100 , true , true , true , false) ;
        BackgroundImage backgroundImage = new BackgroundImage(image , BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT , BackgroundPosition.CENTER , backgroundSize) ;
        Background background = new Background(backgroundImage) ;
        this.setBackground(background);
        this.setPrefSize(1540 , 785);
        this.setSpacing(20);
        Pane pane = new Pane() ;
        pane.getChildren().addAll(vBox , hBox1 , root , textArea , Exit_button , public_chat) ;
        this.getChildren().add(pane) ;

    }
    private void updateImage(ImageView imageView) {
        String imagePath = imagePaths[currentImageIndex];
        Image image = new Image(new File(imagePath).toURI().toString());
        imageView.setImage(image);
    }
}
