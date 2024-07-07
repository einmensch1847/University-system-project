package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.print.attribute.standard.Media;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static javafx.geometry.Pos.CENTER;

public class Main_page extends VBox {

    private static Button Reservation_of_electrical_faculty_workshops , Reservation_of_workshops_of_the_Faculty_of_Mathematics , Reservation_of_physics_faculty_workshops , Reservation_of_workshops_of_the_Faculty_of_Chemistry ;
    private static Button language_btn1 ;
    private static Button language_btn2 ;

    private static Label Announcements , text ;
    private static Button comment_btn , admission_request_btn , login_btn , signup_btn , apply_for_a_student_loan_btn , about_the_university_btn , news_btn , enter_of_international_stubents_btn , communication_with_the_university , public_chat ;

    private String[] imagePaths = {
            "11 (1).jpg" ,
            "11 (2).jpg" ,
            "11 (3).jpg" ,
            "11 (4).jpg" ,
            "11 (5).jpg" ,
            "6.jpg",
//            "1.jpg",
//            "2.jpg",
//            "3.jpg",
            "4.jpg",
            "5.jpg"
    };

    private int currentImageIndex = 0;

    public Main_page() throws FileNotFoundException {

        ImageView imageView = new ImageView();
        updateImage(imageView);

        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        root.setPrefSize(370 , 340);
        root.setLayoutX(17);
        root.setLayoutY(0);
        root.setStyle("-fx-background-radius: 10px");
        root.setStyle("-fx-font-weight: bold; -fx-font-style: italic;");

        //pictus : 300 , 169 *******

//        Scene scene = new Scene(root, 800, 600);


        // Add event handler to change image when clicked
        imageView.setOnMouseClicked(event -> {
            currentImageIndex = (currentImageIndex + 1) % imagePaths.length;
            updateImage(imageView);
        });

        //************************

        Label timeLabel = new Label();
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalTime currentTime = LocalTime.now();
            timeLabel.setText(currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }));

        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();
        timeLabel.setFont(Font.font("Arial",30));
//        timeLabel.setLayoutX(700);
//        timeLabel.setLayoutY(100);

        HBox hbox = new HBox(root);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPrefSize(500 , 300);
        hbox.setStyle("-fx-background-color: rgba(96,96,91,0.53) ; -fx-background-radius: 20px");
        hbox.setLayoutX(100);
        hbox.setLayoutY(100);


        comment_btn = new Button("critics and suggestions") ;
        comment_btn.setPrefSize(200 , 80);
        comment_btn.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(19,74,12,0.62) ;-fx-background-radius: 10px;-fx-text-alignment: center ; -fx-text-fill: rgb(255,255,255) ; -fx-font-weight: bold; -fx-font-style: italic;");
        comment_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CriticsAndSuggestionsPage criticsAndSuggestionsPage = null;
                try {
                    criticsAndSuggestionsPage = new CriticsAndSuggestionsPage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(criticsAndSuggestionsPage));
                stage1.show();

//                Stage stage = (Stage) comment_btn.getScene().getWindow() ;
//                stage.close();
            }
        });

        public_chat = new Button("➤");
        public_chat.setPrefSize(50 , 50);
        public_chat.setStyle("-fx-font-size: 20px;-fx-background-color: rgba(255,255,255,0) ;");
        public_chat.setLayoutX(1490);
        public_chat.setLayoutY(130);
        public_chat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PublicChatPage PublicChatPage = null;
                try {
                    PublicChatPage = new PublicChatPage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(PublicChatPage));
                stage1.show();
            }
        });

        admission_request_btn = new Button("admission request") ;
        admission_request_btn.setPrefSize(200 , 80);
        admission_request_btn.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(19,74,12,0.62) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ; -fx-font-weight: bold; -fx-font-style: italic;");
        admission_request_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AdmissionRequestPage admissionRequestPage = null;
                try {
                    admissionRequestPage = new AdmissionRequestPage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(admissionRequestPage));
                stage1.show();

                Stage stage = (Stage) admission_request_btn.getScene().getWindow() ;
                stage.close();
            }
        });

        apply_for_a_student_loan_btn = new Button("apply for a student loan") ;
        apply_for_a_student_loan_btn.setPrefSize(200 , 80);
        apply_for_a_student_loan_btn.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(19,74,12,0.62) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ; -fx-font-weight: bold; -fx-font-style: italic;");
        apply_for_a_student_loan_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ApplyForStudentLoanPage applyForAStudentLoanPage = null;
                try {
                    applyForAStudentLoanPage = new ApplyForStudentLoanPage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(applyForAStudentLoanPage));
                stage1.show();
            }
        });

        VBox vBoxx1 = new VBox(comment_btn , admission_request_btn , apply_for_a_student_loan_btn) ;
        vBoxx1.setSpacing(20);

        enter_of_international_stubents_btn = new Button("entry of international\nstubents") ;
        enter_of_international_stubents_btn.setPrefSize(200 , 80);
        enter_of_international_stubents_btn.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(19,74,12,0.62) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ; -fx-font-weight: bold; -fx-font-style: italic;");
        enter_of_international_stubents_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Entry_of_stubents_page entryOfStubentsPage = null;
                try {
                    entryOfStubentsPage = new Entry_of_stubents_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(entryOfStubentsPage));
                stage1.show();

                Stage stage = (Stage) login_btn.getScene().getWindow() ;
                stage.close();
            }
        }) ;

        login_btn = new Button("entry of stubents") ;
        login_btn.setPrefSize(200 , 80);
        login_btn.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(19,74,12,0.62) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ; -fx-font-weight: bold; -fx-font-style: italic;");
        login_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Entry_of_stubents_page entryOfStubentsPage = null;
                try {
                    entryOfStubentsPage = new Entry_of_stubents_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(entryOfStubentsPage));
                stage1.show();

                Stage stage = (Stage) login_btn.getScene().getWindow() ;
                stage.close();
            }
        });

        signup_btn = new Button("entry of employess") ;
        signup_btn.setPrefSize(200 , 80);
        signup_btn.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(19,74,12,0.62) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ; -fx-font-weight: bold; -fx-font-style: italic;");
        signup_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Entry_of_employees_page entryOfStubentsPage = null;
                try {
                    entryOfStubentsPage = new Entry_of_employees_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(entryOfStubentsPage));
                stage1.show();

                Stage stage = (Stage) signup_btn.getScene().getWindow() ;
                stage.close();
            }
        });

        VBox vBoxx2 = new VBox(enter_of_international_stubents_btn , login_btn , signup_btn) ;
        vBoxx2.setSpacing(20);

        about_the_university_btn =new Button("about us") ;
        about_the_university_btn.setPrefSize(200 , 80);
        about_the_university_btn.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(19,74,12,0.62) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ; -fx-font-weight: bold; -fx-font-style: italic;");
        about_the_university_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AboutTheUniPage aboutTheUniPage = null;
                try {
                    aboutTheUniPage = new AboutTheUniPage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(aboutTheUniPage));
                stage1.show();

                Stage stage = (Stage) about_the_university_btn.getScene().getWindow() ;
                stage.close();
            }
        });

        news_btn = new Button("news") ;
        news_btn.setPrefSize(200 , 80);
        news_btn.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(19,74,12,0.62) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ; -fx-font-weight: bold; -fx-font-style: italic;");
        news_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                News_page newsPage = null;
                try {
                    newsPage = new News_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(newsPage));
                stage1.show();

                Stage stage = (Stage) news_btn.getScene().getWindow() ;
                stage.close();
            }
        });

        communication_with_the_university = new Button("contact us") ;
        communication_with_the_university.setPrefSize(200 , 80);
        communication_with_the_university.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(19,74,12,0.62) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ; -fx-font-weight: bold; -fx-font-style: italic;");
        communication_with_the_university.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Communication_with_the_university_page communicationWithTheUniversityPage = null;
                try {
                    communicationWithTheUniversityPage = new Communication_with_the_university_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(communicationWithTheUniversityPage));
                stage1.show();

                Stage stage = (Stage) communication_with_the_university.getScene().getWindow() ;
                stage.close();
            }
        });

        VBox vBoxx3 = new VBox(about_the_university_btn , news_btn , communication_with_the_university) ;
        vBoxx3.setSpacing(20);

        HBox hBox = new HBox(vBoxx1 , vBoxx2 , vBoxx3) ;
        hBox.setSpacing(50);
        hBox.setLayoutX(62);
        hBox.setLayoutY(430);


        language_btn1 = new Button("DE") ;
        language_btn1.setPrefSize(30 , 20);
        language_btn1.setStyle("-fx-font-size: 10px ; -fx-font-family: Arial ;-fx-background-color: rgba(255,255,255,0) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-font-weight: bold; -fx-font-style: italic;");

        language_btn2 = new Button("EN") ;
        language_btn2.setPrefSize(30 , 20);
        language_btn2.setStyle("-fx-font-size:10px ; -fx-font-family: Arial ;-fx-background-color: rgba(255,255,255,0) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-font-weight: bold; -fx-font-style: italic;");

        VBox vBox2 = new VBox(language_btn1 , language_btn2) ;
        vBox2.setLayoutX(1500);
        vBox2.setLayoutY(80);

        Announcements = new Label("Announcements : ") ;
        Announcements.setStyle("-fx-font-family: 'Agent Orange' ");
        text = new Label() ;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
            Statement statement = connection.createStatement() ;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM main_page_tabel") ;
            while (resultSet.next()){
                text.setText(resultSet.getString("text"));
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        VBox vBox3 = new VBox(Announcements , text) ;
        vBox3.setSpacing(10);
        vBox3.setAlignment(CENTER);
        vBox3.setPrefSize(630 , 50);
        vBox3.setStyle("-fx-background-color: rgba(151,151,151,0.68) ;-fx-background-radius: 10px;");

        VBox vBox4 = new VBox(timeLabel , vBox3) ;
        vBox4.setSpacing(15);
        vBox4.setAlignment(CENTER);
        vBox4.setLayoutX(780);
        vBox4.setLayoutY(200);



        Reservation_of_electrical_faculty_workshops = new Button() ;
        Reservation_of_electrical_faculty_workshops.setText("Reservation of electrica faculty workshops");
        Reservation_of_electrical_faculty_workshops.setPrefSize(375 , 50);
        Reservation_of_electrical_faculty_workshops.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(46,46,44,0.62) ;-fx-background-radius: 10px;-fx-text-alignment: center ; -fx-text-fill: rgb(255,255,255) ;-fx-font-weight: bold; -fx-font-style: italic;");
        Reservation_of_electrical_faculty_workshops.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Reservation_of_electrical_faculty_workshops_page reservationOfElectricalFacultyWorkshopsPage = null;
                try {
                    reservationOfElectricalFacultyWorkshopsPage = new Reservation_of_electrical_faculty_workshops_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(reservationOfElectricalFacultyWorkshopsPage));
                stage1.show();

//                Stage stage = (Stage) Reservation_of_electrical_faculty_workshops.getScene().getWindow() ;
//                stage.close();
            }
        });

        Reservation_of_workshops_of_the_Faculty_of_Mathematics = new Button() ;
        Reservation_of_workshops_of_the_Faculty_of_Mathematics.setText("Reservation of workshops of the Faculty of Mathematics");
        Reservation_of_workshops_of_the_Faculty_of_Mathematics.setPrefSize(375 , 50);
        Reservation_of_workshops_of_the_Faculty_of_Mathematics.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(46,46,44,0.62) ;-fx-background-radius: 10px;-fx-text-alignment: center ; -fx-text-fill: rgb(255,255,255) ;-fx-font-weight: bold; -fx-font-style: italic;");
        Reservation_of_workshops_of_the_Faculty_of_Mathematics.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Reservation_of_workshops_of_the_Faculty_of_Mathematics_page reservationOfWorkshopsOfTheFacultyOfMathematicsPage = null;
                try {
                    reservationOfWorkshopsOfTheFacultyOfMathematicsPage = new Reservation_of_workshops_of_the_Faculty_of_Mathematics_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(reservationOfWorkshopsOfTheFacultyOfMathematicsPage));
                stage1.show();

//                Stage stage = (Stage) Reservation_of_workshops_of_the_Faculty_of_Mathematics.getScene().getWindow() ;
//                stage.close();
            }
        });

        Reservation_of_physics_faculty_workshops = new Button() ;
        Reservation_of_physics_faculty_workshops.setText("Reservation of physics faculty workshops");
        Reservation_of_physics_faculty_workshops.setPrefSize(375 , 50);
        Reservation_of_physics_faculty_workshops.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(46,46,44,0.62) ;-fx-background-radius: 10px;-fx-text-alignment: center ; -fx-text-fill: rgb(255,255,255) ;-fx-font-weight: bold; -fx-font-style: italic;");
        Reservation_of_physics_faculty_workshops.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Reservation_of_physics_faculty_workshops_page reservationOfPhysicsFacultyWorkshopsPage = null;
                try {
                    reservationOfPhysicsFacultyWorkshopsPage = new Reservation_of_physics_faculty_workshops_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(reservationOfPhysicsFacultyWorkshopsPage));
                stage1.show();

//                Stage stage = (Stage) Reservation_of_physics_faculty_workshops.getScene().getWindow() ;
//                stage.close();
            }
        });

        Reservation_of_workshops_of_the_Faculty_of_Chemistry = new Button() ;
        Reservation_of_workshops_of_the_Faculty_of_Chemistry.setText("Reservation of workshops of the Faculty of Chemistry");
        Reservation_of_workshops_of_the_Faculty_of_Chemistry.setPrefSize(375 , 50);
        Reservation_of_workshops_of_the_Faculty_of_Chemistry.setStyle("-fx-font-size: 13px ; -fx-font-family: Arial ;-fx-background-color: rgba(46,46,44,0.62) ;-fx-background-radius: 10px;-fx-text-alignment: center ; -fx-text-fill: rgb(255,255,255) ;-fx-font-weight: bold; -fx-font-style: italic;");
        Reservation_of_workshops_of_the_Faculty_of_Chemistry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Reservation_of_workshops_of_the_Faculty_of_Chemistry_page reservationOfWorkshopsOfTheFacultyOfChemistryPage = null;
                try {
                    reservationOfWorkshopsOfTheFacultyOfChemistryPage = new Reservation_of_workshops_of_the_Faculty_of_Chemistry_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(reservationOfWorkshopsOfTheFacultyOfChemistryPage));
                stage1.show();

//                Stage stage = (Stage) Reservation_of_workshops_of_the_Faculty_of_Chemistry.getScene().getWindow() ;
//                stage.close();
            }
        });

        HBox vBox1 = new HBox(Reservation_of_electrical_faculty_workshops , Reservation_of_workshops_of_the_Faculty_of_Mathematics , Reservation_of_physics_faculty_workshops , Reservation_of_workshops_of_the_Faculty_of_Chemistry) ;
        vBox1.setSpacing(9);
        vBox1.setLayoutX(7);
        vBox1.setLayoutY(5);

        language_btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comment_btn.setText("Kritiken und Anregungen");
                admission_request_btn.setText("Aufnahmeantrag");
                apply_for_a_student_loan_btn.setText("einen Studienkredit\nbeantragen");
                enter_of_international_stubents_btn.setText("Eintritt internationaler\nStudierender");
                login_btn.setText("entry of stubents");
                signup_btn.setText("entry of employess");
                about_the_university_btn.setText("über die Universität");
                news_btn.setText("Nachricht");
                communication_with_the_university.setText("Kommunikation mit der\nUniversität");
                Reservation_of_electrical_faculty_workshops.setText("Reservierung von Workshops für\nElektrofakultäten");
                Reservation_of_workshops_of_the_Faculty_of_Mathematics.setText("Reservierung von Workshops der Fakultät\nfür Mathematik");
                Reservation_of_physics_faculty_workshops.setText("Reservierung von Workshops der\nFakultät für Physik");
                Reservation_of_workshops_of_the_Faculty_of_Chemistry.setText("Reservierung von Workshops der Fakultät\nfür Chemie");
                Announcements.setText("Ankündigungen : ");
            }
        });
        language_btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comment_btn.setText("critics and suggestions");
                admission_request_btn.setText("admission request");
                apply_for_a_student_loan_btn.setText("apply for a student loan");
                enter_of_international_stubents_btn.setText("enter of international\nstubents");
                login_btn.setText("entry of stubents");
                signup_btn.setText("entry of employess");
                about_the_university_btn.setText("about us");
                news_btn.setText("news");
                communication_with_the_university.setText("contact us");
                Reservation_of_electrical_faculty_workshops.setText("Reservation of electrica faculty workshops");
                Reservation_of_workshops_of_the_Faculty_of_Mathematics.setText("Reservation of workshops of the Faculty of Mathematics");
                Reservation_of_physics_faculty_workshops.setText("Reservation of physics faculty workshops");
                Reservation_of_workshops_of_the_Faculty_of_Chemistry.setText("Reservation of workshops of the Faculty of Chemistry");
                Announcements.setText("Announcements : ");
            }
        });



        Image image = new Image(new FileInputStream("filip-bunkens-MfA21vhkVLg-unsplash (3).jpg")) ;
        BackgroundSize backgroundSize = new BackgroundSize(100 , 100 , true , true , true , false) ;
        BackgroundImage backgroundImage = new BackgroundImage(image , BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT , BackgroundPosition.CENTER , backgroundSize) ;
        Background background = new Background(backgroundImage) ;
        this.setBackground(background);
        this.setPrefSize(1540 , 785);
        this.setSpacing(20);
        Pane pane = new Pane() ;
        pane.getChildren().addAll(hbox , vBox1 , vBox2 , hBox , vBox4 , public_chat) ;
        this.getChildren().add(pane) ;
    }

    private void updateImage(ImageView imageView) {
        String imagePath = imagePaths[currentImageIndex];
        Image image = new Image(new File(imagePath).toURI().toString());
        imageView.setImage(image);
    }
}
