package org.example.unip;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.*;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Main_page mainPage = new Main_page() ;
        Admin_panel adminPanel = new Admin_panel() ;
        management_employees_page management_employees_page = new management_employees_page() ;
        PublicChatPage public_chat_page = new PublicChatPage() ;
        Show_professors_dormitory_page Show_professors_dormitory_page = new Show_professors_dormitory_page() ;
        Show_students_dormitory_page Show_students_dormitory_page = new Show_students_dormitory_page() ;
        ShowChosingCourseUnitPage ShowChosingCourseUnitPage = new ShowChosingCourseUnitPage() ;
        Scene scene = new Scene(mainPage);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



