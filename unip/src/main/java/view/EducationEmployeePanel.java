package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EducationEmployeePanel extends VBox{
    Button Show_Chosing_Course_Unit , professors_dormitory_button , students_dormitory_button , edit_main_page_text , memberhip_requests , edit_about_us , edit_news , edit_contact_us , loans_requests , Critics_and_suggestions , students , set_a_new_student , set_a_new_Admin , set_a_new_professor , set_a_new_education_employee , set_a_new_management_employee , set_a_new_finance_staff , Edit_students_info , Edit_Admins_info , Edit_professors_info , Edit_education_employees_info , Edit_management_employees_info , Edit_finance_staff_info , Approval_of_international_students , edir_employes_page_text , edir_professors_page_text , edir_students_page_text , chnge_professors_student_limit;
    public EducationEmployeePanel() throws FileNotFoundException {
        Label timeLabel = new Label();
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalTime currentTime = LocalTime.now();
            timeLabel.setText(currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }));

        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();
        timeLabel.setFont(Font.font("Arial",70));
        timeLabel.setLayoutX(1000);
        timeLabel.setLayoutY(210);

        Button public_chat = new Button("➤");
        public_chat.setPrefSize(30 , 30);
        public_chat.setStyle("-fx-font-size: 10px;-fx-background-color: rgba(255,255,255,0) ;");
        public_chat.setLayoutX(0);
        public_chat.setLayoutY(0);
        public_chat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AdminsPublicChatPage PublicChatPage = null;
                try {
                    PublicChatPage = new AdminsPublicChatPage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(PublicChatPage));
                stage1.show();
            }
        });

        Show_Chosing_Course_Unit = new Button("Show Chosing Course Unit") ;
        Show_Chosing_Course_Unit.setPrefSize(150 , 30);
        Show_Chosing_Course_Unit.setStyle("-fx-font-size: 10px ; -fx-font-family: Arial ;-fx-background-color: rgba(140,132,132,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        Show_Chosing_Course_Unit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ShowChosingCourseUnitPage ShowChosingCourseUnitPage = null;
                ShowChosingCourseUnitPage = new ShowChosingCourseUnitPage();
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(ShowChosingCourseUnitPage));
                stage1.show();
            }
        });

        students_dormitory_button = new Button("student dormitory") ;
        students_dormitory_button.setPrefSize(150 , 30);
        students_dormitory_button.setStyle("-fx-font-size: 10px ; -fx-font-family: Arial ;-fx-background-color: rgba(140,132,132,0.81);-fx-background-radius: 10px;-fx-text-alignment: center");
        students_dormitory_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Show_students_dormitory_page Show_students_dormitory_page = null;
                Show_students_dormitory_page = new Show_students_dormitory_page();
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(Show_students_dormitory_page));
                stage1.show();
            }
        });

        professors_dormitory_button = new Button("professor dormitory") ;
        professors_dormitory_button.setPrefSize(150 , 30);
        professors_dormitory_button.setStyle("-fx-font-size: 10px ; -fx-font-family: Arial ;-fx-background-color: rgba(140,132,132,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        professors_dormitory_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Show_professors_dormitory_page Show_professors_dormitory_page = null;
                Show_professors_dormitory_page = new Show_professors_dormitory_page();
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(Show_professors_dormitory_page));
                stage1.show();
            }
        });

        chnge_professors_student_limit = new Button("change professors student limit") ;
        chnge_professors_student_limit.setPrefSize(150 , 30);
        chnge_professors_student_limit.setStyle("-fx-font-size: 10px ; -fx-font-family: Arial ;-fx-background-color: rgba(140,132,132,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        chnge_professors_student_limit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                change_professors_student_limit changeProfessorsStudentLimit = null;
                try {
                    changeProfessorsStudentLimit = new change_professors_student_limit();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(changeProfessorsStudentLimit));
                stage1.show();
            }
        });


        edir_students_page_text = new Button("edit students page text") ;
        edir_students_page_text.setPrefSize(150 , 30);
        edir_students_page_text.setStyle("-fx-font-size: 10px ; -fx-font-family: Arial ;-fx-background-color:rgba(140,132,132,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        edir_students_page_text.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                edir_students_page_text_page edirStudentsPageTextPage = null;
                try {
                    edirStudentsPageTextPage = new edir_students_page_text_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(edirStudentsPageTextPage));
                stage1.show();
            }
        });

        edir_professors_page_text = new Button("edit professors page text") ;
        edir_professors_page_text.setPrefSize(150 , 30);
        edir_professors_page_text.setStyle("-fx-font-size: 10px ; -fx-font-family: Arial ;-fx-background-color: rgba(140,132,132,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        edir_professors_page_text.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                edir_professors_page_text_page edir_professors_page_text_page = null;
                try {
                    edir_professors_page_text_page = new edir_professors_page_text_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(edir_professors_page_text_page));
                stage1.show();
            }
        });

        edir_employes_page_text = new Button("edit employes page text") ;
        edir_employes_page_text.setPrefSize(150 , 30);
        edir_employes_page_text.setStyle("-fx-font-size: 10px ; -fx-font-family: Arial ;-fx-background-color: rgba(140,132,132,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center");
        edir_employes_page_text.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Edit_employes_page_text_page editMainPageText = null;
                try {
                    editMainPageText = new Edit_employes_page_text_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();

            }
        });

        edit_main_page_text = new Button("Edit the text of the Mainpage") ;
        edit_main_page_text.setPrefSize(240 , 80);
        edit_main_page_text.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(51,68,94,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        edit_main_page_text.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Edit_main_page_text editMainPageText = null;
                try {
                    editMainPageText = new Edit_main_page_text();
                } catch (FileNotFoundException | SQLException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();

//                Stage stage = (Stage) edit_main_page_text.getScene().getWindow() ;
//                stage.close();
            }
        });
        memberhip_requests = new Button("employes") ;
        memberhip_requests.setPrefSize(240 , 80);
        memberhip_requests.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(51,68,94,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        memberhip_requests.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show_employes_page editMainPageText = null;
                try {
                    editMainPageText = new show_employes_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();

//                Stage stage = (Stage) memberhip_requests.getScene().getWindow() ;
//                stage.close();
            }
        });
        Edit_students_info = new Button("Edit students info") ;
        Edit_students_info.setPrefSize(240 , 80);
        Edit_students_info.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(104,134,100,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        Edit_students_info.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Edit_students_info editMainPageText = null;
                try {
                    editMainPageText = new Edit_students_info();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();
            }
        });

        HBox hBox1 = new HBox(edit_main_page_text , memberhip_requests , Edit_students_info) ;
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(30);

        edit_about_us = new Button("edit about us") ;
        edit_about_us.setPrefSize(240 , 80);
        edit_about_us.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color:rgba(51,68,94,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        edit_about_us.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EditAboutUsPage editAboutUsPage = null;
                try {
                    editAboutUsPage = new EditAboutUsPage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editAboutUsPage));
                stage1.show();

//                Stage stage = (Stage) edit_about_us.getScene().getWindow() ;
//                stage.close();
            }
        });
        edit_news = new Button("edit news") ;
        edit_news.setPrefSize(240 , 80);
        edit_news.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(51,68,94,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        edit_news.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Edit_news_page editMainPageText = null;
                try {
                    editMainPageText = new Edit_news_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();

//                Stage stage = (Stage) edit_news.getScene().getWindow() ;
//                stage.close();
            }
        });
        Edit_Admins_info = new Button("Edit Admins info") ;
        Edit_Admins_info.setPrefSize(240 , 80);
        Edit_Admins_info.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(104,134,100,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        Edit_Admins_info.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Edit_admins_info editMainPageText = null;
                try {
                    editMainPageText = new Edit_admins_info();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();
            }
        });


        HBox hBox2 = new HBox(edit_about_us , edit_news , Edit_Admins_info) ;
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(30);

        edit_contact_us = new Button("edit contact us") ;
        edit_contact_us.setPrefSize(240 , 80);
        edit_contact_us.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(51,68,94,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        edit_contact_us.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Edit_contact_us_page editMainPageText = null;
                try {
                    editMainPageText = new Edit_contact_us_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();

//                Stage stage = (Stage) edit_contact_us.getScene().getWindow() ;
//                stage.close();
            }
        });
        loans_requests = new Button("loans requests") ;
        loans_requests.setPrefSize(240 , 80);
        loans_requests.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(51,68,94,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        loans_requests.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Show_loan_requests_page editMainPageText = null;
                try {
                    editMainPageText = new Show_loan_requests_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();

//                Stage stage = (Stage) loans_requests.getScene().getWindow() ;
//                stage.close();
            }
        });
        Edit_professors_info = new Button("Edit professors info") ;
        Edit_professors_info.setPrefSize(240 , 80);
        Edit_professors_info.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(104,134,100,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        Edit_professors_info.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Edit_professors_info editMainPageText = null;
                try {
                    editMainPageText = new Edit_professors_info();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();
            }
        });


        HBox hBox3 = new HBox(edit_contact_us , loans_requests , Edit_professors_info) ;
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setSpacing(30);

        Critics_and_suggestions = new Button("Critics and suggestions") ;
        Critics_and_suggestions.setPrefSize(240 , 80);
        Critics_and_suggestions.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(51,68,94,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        Critics_and_suggestions.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ShowCriticsAndSuggestionsPage showCriticsAndSuggestionsPage = null;
                try {
                    showCriticsAndSuggestionsPage = new ShowCriticsAndSuggestionsPage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(showCriticsAndSuggestionsPage));
                stage1.show();

//                Stage stage = (Stage) Critics_and_suggestions.getScene().getWindow() ;
//                stage.close();
            }
        });
        students = new Button("students") ;
        students.setPrefSize(240 , 80);
        students.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(51,68,94,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        students.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ShowStudentsPage showStudentsPage = null;
                showStudentsPage = new ShowStudentsPage();
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(showStudentsPage));
                stage1.show();

//                Stage stage = (Stage) students.getScene().getWindow() ;
//                stage.close();
            }
        });
        Edit_education_employees_info = new Button("Edit education employees info") ;
        Edit_education_employees_info.setPrefSize(240 , 80);
        Edit_education_employees_info.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(104,134,100,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        Edit_education_employees_info.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Edit_education_employees_info editMainPageText = null;
                try {
                    editMainPageText = new Edit_education_employees_info();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();
            }
        });


        HBox hBox4 = new HBox(Critics_and_suggestions , students , Edit_education_employees_info) ;
        hBox4.setAlignment(Pos.CENTER);
        hBox4.setSpacing(30);

        set_a_new_student = new Button("set a new student") ;
        set_a_new_student.setPrefSize(240 , 80);
        set_a_new_student.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(74,59,41,0.81);-fx-background-radius: 10px;-fx-text-alignment: center ; -fx-text-fill: rgb(255,255,255) ;");
        set_a_new_student.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                set_new_student_page editMainPageText = null;
                try {
                    editMainPageText = new set_new_student_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();

//                Stage stage = (Stage) set_a_new_student.getScene().getWindow() ;
//                stage.close();
            }
        });
        set_a_new_Admin = new Button("set a new Admin") ;
        set_a_new_Admin.setPrefSize(240 , 80);
        set_a_new_Admin.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(74,59,41,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        set_a_new_Admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Set_new_Admin_page editMainPageText = null;
                try {
                    editMainPageText = new Set_new_Admin_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();

//                Stage stage = (Stage) set_a_new_Admin.getScene().getWindow() ;
//                stage.close();
            }
        });
        Edit_management_employees_info = new Button("Edit management employees\ninfo");
        Edit_management_employees_info.setPrefSize(240 , 80);
        Edit_management_employees_info.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(104,134,100,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        Edit_management_employees_info.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Edit_management_employees_info editMainPageText = null;
                try {
                    editMainPageText = new Edit_management_employees_info();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();
            }
        });


        HBox hBox5 = new HBox(set_a_new_student , set_a_new_Admin , Edit_management_employees_info) ;
        hBox5.setAlignment(Pos.CENTER);
        hBox5.setSpacing(30);

        set_a_new_professor = new Button("set a new professor") ;
        set_a_new_professor.setPrefSize(240 , 80);
        set_a_new_professor.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(74,59,41,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        set_a_new_professor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SetANewProfessorView setANewProfessorView = null;
                try {
                    setANewProfessorView = new SetANewProfessorView();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(setANewProfessorView));
                stage1.show();

//                Stage stage = (Stage) set_a_new_professor.getScene().getWindow() ;
//                stage.close();
            }
        });
        set_a_new_education_employee = new Button("set a new education\nemployee") ;
        set_a_new_education_employee.setPrefSize(240 , 80);
        set_a_new_education_employee.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(74,59,41,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        set_a_new_education_employee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SetNewEducationEmployeePage setNewEducationEmployeePage = null;
                try {
                    setNewEducationEmployeePage = new SetNewEducationEmployeePage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(setNewEducationEmployeePage));
                stage1.show();

//                Stage stage = (Stage) set_a_new_education_employee.getScene().getWindow() ;
//                stage.close();
            }
        });
        Edit_finance_staff_info = new Button("Edit finance staff info") ;
        Edit_finance_staff_info.setPrefSize(240 , 80);
        Edit_finance_staff_info.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(104,134,100,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        Edit_finance_staff_info.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Edit_finance_staff_info editMainPageText = null;
                try {
                    editMainPageText = new Edit_finance_staff_info();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(editMainPageText));
                stage1.show();
            }
        });


        HBox hBox6 = new HBox(set_a_new_professor , set_a_new_education_employee , Edit_finance_staff_info);
        hBox6.setAlignment(Pos.CENTER);
        hBox6.setSpacing(30);

        set_a_new_management_employee = new Button("set a new management\nemployee") ;
        set_a_new_management_employee.setPrefSize(240 , 80);
        set_a_new_management_employee.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(74,59,41,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        set_a_new_management_employee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SetANewManagementEmployeePage setANewManagementEmployeePage = null;
                try {
                    setANewManagementEmployeePage = new SetANewManagementEmployeePage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(setANewManagementEmployeePage));
                stage1.show();

//                Stage stage = (Stage) set_a_new_management_employee.getScene().getWindow() ;
//                stage.close();
            }
        });
        set_a_new_finance_staff = new Button("set a new finance staff") ;
        set_a_new_finance_staff.setPrefSize(240 , 80);
        set_a_new_finance_staff.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(74,59,41,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        set_a_new_finance_staff.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SetANewFinanceStaffPage setANewFinanceStaffPage = null;
                try {
                    setANewFinanceStaffPage = new SetANewFinanceStaffPage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(setANewFinanceStaffPage));
                stage1.show();

//                Stage stage = (Stage) set_a_new_finance_staff.getScene().getWindow() ;
//                stage.close();
            }
        });
        Approval_of_international_students = new Button("Approval of international\nstudents") ;
        Approval_of_international_students.setPrefSize(240 , 80);
        Approval_of_international_students.setStyle("-fx-font-size: 15px ; -fx-font-family: Arial ;-fx-background-color: rgba(81,73,39,0.81) ;-fx-background-radius: 10px;-fx-text-alignment: center; -fx-text-fill: rgb(255,255,255) ;");
        Approval_of_international_students.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                set_new_international_student_page set_new_international_student_page = null;
                try {
                    set_new_international_student_page = new set_new_international_student_page();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
                Stage stage1 = new Stage() ;
                stage1.setScene(new Scene(set_new_international_student_page));
                stage1.show();
            }
        });


        HBox hBox7 = new HBox(set_a_new_management_employee , set_a_new_finance_staff , Approval_of_international_students) ;
        hBox7.setAlignment(Pos.CENTER);
        hBox7.setSpacing(30);

        VBox vBox1 = new VBox(hBox7 , hBox6 , hBox5 , hBox1 , hBox2 , hBox3 , hBox4 ) ;
        vBox1.setSpacing(10);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setLayoutX(40);
        vBox1.setLayoutY(20);

        Button Exit_button = new Button() ;
        Exit_button.setText("\" EXIT \"");
        Exit_button.setPrefSize(150 , 30);
        Exit_button.setStyle("-fx-font-size: 10px ; -fx-font-family: Arial ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
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
//        Exit_button.setLayoutX(445);
//        Exit_button.setLayoutY(750);

        HBox hBox= new HBox(students_dormitory_button , professors_dormitory_button , chnge_professors_student_limit , edir_professors_page_text , edir_students_page_text , edir_employes_page_text , Exit_button ) ;
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);
        hBox.setStyle("-fx-background-radius: 15px ; -fx-background-color: rgba(94,94,30,0.8)");
        hBox.setPrefSize(1532 , 50);
        hBox.setLayoutX(4);
        hBox.setLayoutY(715);

        HBox hBoxx= new HBox(Show_Chosing_Course_Unit) ;
        hBoxx.setAlignment(Pos.CENTER);
        hBoxx.setSpacing(5);
        hBoxx.setStyle("-fx-background-radius: 15px ; -fx-background-color: rgba(94,94,30,0.8)");
        hBoxx.setPrefSize(1532 , 50);
        hBoxx.setLayoutX(4);
        hBoxx.setLayoutY(660);

        Image image = new Image(new FileInputStream("jason-leung-3rq6DqLKakc-unsplash (1).jpg"));
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefSize(1540, 785);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(timeLabel , hBox , hBoxx , vBox1 , public_chat);
        this.getChildren().add(pane);
    }
}
