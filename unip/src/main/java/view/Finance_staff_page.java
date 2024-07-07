//package view;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.layout.*;
//import javafx.stage.Stage;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//
//public class Finance_staff_page extends VBox{
//    public Finance_staff_page() throws FileNotFoundException {
//
//        Button Exit_button = new Button() ;
//        Exit_button.setText("\" EXIT \"");
//        Exit_button.setPrefSize(50 , 20);
//        Exit_button.setStyle("-fx-font-size: 8px ; -fx-font-family: 'Times New Roman' ;-fx-background-color: rgba(183,107,107,0.93) ;-fx-background-radius: 10px;");
//        Exit_button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Main_page mainPage = null;
//                try {
//                    mainPage = new Main_page();
//                } catch (FileNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//                Stage stage1 = new Stage() ;
//                stage1.setScene(new Scene(mainPage));
//                stage1.show();
//
//                Stage stage = (Stage) Exit_button.getScene().getWindow() ;
//                stage.close();
//            }
//        });
//        Exit_button.setLayoutX(445);
//        Exit_button.setLayoutY(750);
//
//
//        Image image = new Image(new FileInputStream("c:/test/unip/student_panel.jpg")) ;
//        BackgroundSize backgroundSize = new BackgroundSize(100 , 100 , true , true , true , false) ;
//        BackgroundImage backgroundImage = new BackgroundImage(image , BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT , BackgroundPosition.CENTER , backgroundSize) ;
//        Background background = new Background(backgroundImage) ;
//        this.setBackground(background);
//        this.setPrefSize(538 , 780);
//        this.setSpacing(20);
//        Pane pane = new Pane() ;
//        pane.getChildren().addAll(Exit_button) ;
//        this.getChildren().add(pane) ;
//    }
//}
