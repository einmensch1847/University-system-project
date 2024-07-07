package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class professors_name_for_course_page extends VBox{
    public professors_name_for_course_page(){
        VBox vBox = new VBox();
        vBox.setPrefSize(538, 740);
        vBox.setSpacing(25);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setPrefSize(538, 740);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM professor");

            int row = 0;
            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                String NAME = resultSet.getString("name");
                String LASTNAME = resultSet.getString("lastname");
                String SUBJECT = resultSet.getString("subject");
                int number_of_students = resultSet.getInt("number_of_students");
                String email = resultSet.getString("email") ;

                Label label = new Label(ID + " : " + NAME + " " + LASTNAME + " subject : " + SUBJECT + " (Students: " + number_of_students + ")"+" email : "+email);
                label.setStyle("-fx-text-fill: rgba(0,0,0,0.93); -fx-font-size: 12px");



                gridPane.add(label, 0, row);
                row++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        scrollPane.setContent(gridPane);

        Button exitButton = new Button();
        exitButton.setText("EXIT");
        exitButton.setPrefSize(50, 20);
        exitButton.setStyle("-fx-font-size: 8px; -fx-font-family: Arial; -fx-background-color: rgba(183,107,107,0.93); -fx-background-radius: 10px;");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            }
        });

        HBox buttonBox = new HBox(exitButton);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.setLayoutX(330);
        buttonBox.setLayoutY(750);

        this.setPrefSize(538, 780);
        this.setSpacing(20);
        Pane pane = new Pane();
        pane.getChildren().addAll(scrollPane, buttonBox);
        this.getChildren().add(pane);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
