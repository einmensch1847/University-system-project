package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class management_employees_page extends VBox {

    Button memberhip_requests , loans_requests , Critics_and_suggestions , students , set_a_new_student , set_a_new_Admin , set_a_new_professor , set_a_new_education_employee , set_a_new_finance_staff , Edit_students_info , Edit_professors_info , Edit_education_employees_info , Edit_management_employees_info , Edit_finance_staff_info , Approval_of_international_students  ;


    private String[] imagePaths = {
            "6.jpg",
//            "1.jpg",
//            "2.jpg",
//            "3.jpg",
            "4.jpg",
            "5.jpg"
    };
    private int currentImageIndex = 0;
    public management_employees_page() throws FileNotFoundException {

        TextArea textArea = new TextArea() ;
        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.setStyle("-fx-background-color: rgba(255,255,255,0.78) ; -fx-font-family: 'Times New Roman' ;");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project","root" , "") ;
            Statement statement = connection.createStatement() ;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM management_employees_page_text") ;
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

        //**************************************

        memberhip_requests = new Button("employes") ;
        memberhip_requests.setPrefSize(270 , 75);
        memberhip_requests.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(190,213,86,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
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
        Edit_students_info.setPrefSize(270 , 75);
        Edit_students_info.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(190,213,86,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
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

        loans_requests = new Button("loans requests") ;
        loans_requests.setPrefSize(270 , 75);
        loans_requests.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(190,213,86,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
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
        Edit_professors_info.setPrefSize(270 , 75);
        Edit_professors_info.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(190,213,86,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
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

        Critics_and_suggestions = new Button("Critics and suggestions") ;
        Critics_and_suggestions.setPrefSize(270 , 75);
        Critics_and_suggestions.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(86,126,213,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ; -fx-text-fill: rgba(255,255,255,0.65) ;-fx-font-size: 15px ;");
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
        students.setPrefSize(270 , 75);
        students.setStyle("-fx-text-fill: rgba(255,255,255,0.65) ; -fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(86,126,213,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
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
        Edit_education_employees_info.setPrefSize(270 , 75);
        Edit_education_employees_info.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(190,213,86,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
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

        set_a_new_student = new Button("set a new student") ;
        set_a_new_student.setPrefSize(270 , 75);
        set_a_new_student.setStyle("-fx-text-fill: rgba(255,255,255,0.65) ; -fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(86,126,213,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
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
        set_a_new_Admin.setPrefSize(270 , 75);
        set_a_new_Admin.setStyle("-fx-text-fill: rgba(255,255,255,0.65) ; -fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(86,126,213,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
        set_a_new_Admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setHeaderText(null);
                alert.setContentText("This section is inactive for you");
                alert.showAndWait();
            }
        });

        Edit_management_employees_info = new Button("Edit your info");
        Edit_management_employees_info.setPrefSize(270 , 75);
        Edit_management_employees_info.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(190,213,86,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
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

//                Stage stage = (Stage) set_a_new_finance_staff.getScene().getWindow() ;
//                stage.close();
            }
        });

        set_a_new_professor = new Button("set a new professor") ;
        set_a_new_professor.setPrefSize(270 , 75);
        set_a_new_professor.setStyle("-fx-text-fill: rgba(255,255,255,0.65) ; -fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(86,126,213,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
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

        set_a_new_education_employee = new Button("set a new education employee") ;
        set_a_new_education_employee.setPrefSize(270 , 75);
        set_a_new_education_employee.setStyle("-fx-text-fill: rgba(255,255,255,0.65) ; -fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(86,126,213,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-text-alignment: center ;-fx-font-size: 15px ;");
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
        Edit_finance_staff_info.setPrefSize(270 , 75);
        Edit_finance_staff_info.setStyle("-fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(190,213,86,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
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

        set_a_new_finance_staff = new Button("set a new finance staff") ;
        set_a_new_finance_staff.setPrefSize(270 , 75);
        set_a_new_finance_staff.setStyle("-fx-text-fill: rgba(255,255,255,0.65) ; -fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(86,126,213,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ;-fx-font-size: 15px ;");
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
        Approval_of_international_students = new Button("Approval of\ninternational students") ;
        Approval_of_international_students.setPrefSize(270 , 75);
        Approval_of_international_students.setStyle("-fx-text-fill: rgba(255,255,255,0.65) ; -fx-font-size: 15px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(86,126,213,0.65) ;-fx-background-radius: 10px;-fx-text-alignment: center ; -fx-font-size: 15px ;");
        Approval_of_international_students.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });


        VBox vBox2 = new VBox(Edit_students_info , Edit_professors_info , Edit_education_employees_info , Edit_management_employees_info , Edit_finance_staff_info , memberhip_requests , loans_requests) ;
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(20);
        vBox2.setLayoutY(20);
        vBox2.setLayoutX(1230);

        VBox vBox3 = new VBox(Critics_and_suggestions , students , Approval_of_international_students , set_a_new_student) ;
        vBox3.setAlignment(Pos.CENTER);
        vBox3.setSpacing(24);

        VBox vBox4 = new VBox(set_a_new_Admin , set_a_new_professor , set_a_new_education_employee , set_a_new_finance_staff) ;
        vBox4.setAlignment(Pos.CENTER);
        vBox4.setSpacing(24);

        HBox hBox = new HBox(vBox3 , vBox4) ;
        hBox.setLayoutY(60);
        hBox.setSpacing(17);
        hBox.setLayoutX(500);

        Button Show_Chosing_Course_Unit = new Button("Show Chosing Course Unit");
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

        Button students_dormitory_button = new Button("student dormitory");
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

        Button professors_dormitory_button = new Button("professor dormitory");
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

        Button chnge_professors_student_limit = new Button("change professors student limit");
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


        Button edir_students_page_text = new Button("edit students page text");
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

        Button edir_professors_page_text = new Button("edit professors page text");
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

        Button edir_employes_page_text = new Button("edit employes page text");
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

        Button Exit_button = new Button() ;
        Exit_button.setText("\" EXIT \"");
        Exit_button.setPrefSize(150 , 30);
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
//        Exit_button.setLayoutX(1450);
//        Exit_button.setLayoutY(750);

        HBox hBox1= new HBox(students_dormitory_button , professors_dormitory_button , chnge_professors_student_limit , edir_professors_page_text , edir_students_page_text , edir_employes_page_text , Exit_button ) ;
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(5);
        hBox1.setStyle("-fx-background-radius: 15px ; -fx-background-color: rgba(65,67,71,0.8)");
        hBox1.setPrefSize(1532 , 50);
        hBox1.setLayoutX(4);
        hBox1.setLayoutY(730);

        HBox hBoxx= new HBox(Show_Chosing_Course_Unit) ;
        hBoxx.setAlignment(Pos.CENTER);
        hBoxx.setSpacing(5);
        hBoxx.setStyle("-fx-background-radius: 15px ; -fx-background-color: rgba(65,67,71,0.8)");
        hBoxx.setPrefSize(1532 , 50);
        hBoxx.setLayoutX(4);
        hBoxx.setLayoutY(675);


        Image image = new Image(new FileInputStream("jj-ying-7JX0-bfiuxQ-unsplash (1).jpg")) ;
        BackgroundSize backgroundSize = new BackgroundSize(100 , 100 , true , true , true , false) ;
        BackgroundImage backgroundImage = new BackgroundImage(image , BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT , BackgroundPosition.CENTER , backgroundSize) ;
        Background background = new Background(backgroundImage) ;
        this.setBackground(background);
        this.setPrefSize(1540 , 785);
        this.setSpacing(20);
        Pane pane = new Pane() ;
        pane.getChildren().addAll(vBox2 , hBox , root , textArea , hBoxx , hBox1) ;
        this.getChildren().add(pane) ;
    }

    private void updateImage(ImageView imageView) {
        String imagePath = imagePaths[currentImageIndex];
        Image image = new Image(new File(imagePath).toURI().toString());
        imageView.setImage(image);
    }
}
