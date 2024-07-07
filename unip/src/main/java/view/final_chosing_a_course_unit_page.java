package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class final_chosing_a_course_unit_page extends VBox {
    int num = 0;
    private Set<Integer> selectedProfessors = new HashSet<>();
    private static final int MAX_SELECTION = 10;

    public final_chosing_a_course_unit_page(int id, String name, String lastname, String student_number, String username) {

        VBox vBox = new VBox();
        vBox.setPrefSize(538, 740);
        vBox.setSpacing(25);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setPrefSize(1540, 740);

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
                int students_number_limit = resultSet.getInt("student_limit");

                Label label = new Label(ID + " : " + NAME + " " + LASTNAME + " subject : " + SUBJECT + " (Students: " + number_of_students + ")");
                label.setStyle("-fx-text-fill: rgba(0,0,0,0.93); -fx-font-size: 12px");
                HBox hBox = new HBox(label);
                hBox.setStyle("-fx-background-radius: 8px ; -fx-background-color: rgba(26,68,201,0.4) ;-fx-text-alignment: center ;");

                Button selectButton = new Button("Select");
                selectButton.setPrefSize(60, 40);
                selectButton.setStyle("-fx-font-size: 10px; -fx-font-family: Arial; -fx-background-color: rgba(0,90,255,0.77); -fx-background-radius: 10px;-fx-text-fill:rgba(255,255,255,0.93);");
                selectButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (selectedProfessors.size() < MAX_SELECTION && number_of_students < students_number_limit) {
                            if (!selectedProfessors.contains(ID)) {
                                num++;
                                selectedProfessors.add(ID);

                                try {
                                    PreparedStatement updateStudentsStatement = connection.prepareStatement("UPDATE professor SET number_of_students = number_of_students + 1 WHERE id = ?");
                                    updateStudentsStatement.setInt(1, ID);
                                    updateStudentsStatement.executeUpdate();
                                    showAlert(Alert.AlertType.INFORMATION, "Success", "Professor selected successfully.");
                                } catch (SQLException e) {
                                    showAlert(Alert.AlertType.ERROR, "Error", "Failed to update professor's student count.");
                                }

                            } else {
                                showAlert(Alert.AlertType.WARNING, "Warning", "Professor already selected.");
                            }
                        } else {
                            showAlert(Alert.AlertType.WARNING, "Warning", "Maximum number of professors selected or student limit reached.\nreport to admin ");
                        }
                    }
                });

                Button removeButton = new Button("Remove");
                removeButton.setPrefSize(60, 40);
                removeButton.setStyle("-fx-font-size: 10px; -fx-font-family: Arial; -fx-background-color: rgba(0,255,210,0.76); -fx-background-radius: 10px;-fx-text-fill:rgba(255,255,255,0.93);");
                removeButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (selectedProfessors.contains(ID)) {
                            selectedProfessors.remove(ID);

                            try {
                                PreparedStatement updateStudentsStatement = connection.prepareStatement("UPDATE professor SET number_of_students = number_of_students - 1 WHERE id = ?");
                                updateStudentsStatement.setInt(1, ID);
                                updateStudentsStatement.executeUpdate();
                                showAlert(Alert.AlertType.INFORMATION, "Success", "Professor removed successfully.");
                            } catch (SQLException e) {
                                showAlert(Alert.AlertType.ERROR, "Error", "Failed to update professor's student count.");
                            }

                        } else {
                            showAlert(Alert.AlertType.WARNING, "Warning", "Professor not selected.");
                        }
                    }
                });

                gridPane.add(hBox, 0, row);
                gridPane.add(selectButton, 1, row);
                gridPane.add(removeButton, 2, row);
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

        Button finalizeButton = new Button();
        finalizeButton.setText("Finalize");
        finalizeButton.setPrefSize(50, 20);
        finalizeButton.setStyle("-fx-font-size: 8px; -fx-font-family: Arial; -fx-background-color: rgba(107,183,107,0.93); -fx-background-radius: 10px;");
        finalizeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_project", "root", "");
                    int count = 1;
                    for (Integer professorId : selectedProfessors) {
                        PreparedStatement professorInfoStatement = connection.prepareStatement("SELECT name , lastname , subject FROM professor WHERE id = ?");
                        professorInfoStatement.setInt(1, professorId);
                        ResultSet rs = professorInfoStatement.executeQuery();
                        String professorName = "";
                        String professorSubject = "";
                        String professorLastname = "" ;
                        if (rs.next()) {
                            professorName = rs.getString("name");
                            professorLastname = rs.getString("lastname") ;
                            professorSubject = rs.getString("subject");
                        }

                        String columnName = "L" + count;
                        PreparedStatement statement1 = connection.prepareStatement("UPDATE student SET " + columnName + " = ? WHERE id = ?");
                        statement1.setString(1, professorId + " : Selected \n"+professorName+"  "+professorLastname+" \\\\\\ "+ professorSubject);
                        statement1.setInt(2, id);
                        statement1.executeUpdate();

                        PreparedStatement updateStudentsStatement = connection.prepareStatement("UPDATE professor SET number_of_students = number_of_students + 1 WHERE id = ?");
                        updateStudentsStatement.setInt(1, professorId);
                        updateStudentsStatement.executeUpdate();

                        count++;
                    }

                    showAlert(Alert.AlertType.INFORMATION, "Success", "Selections finalized successfully.");
                } catch (SQLException e) {
                    showAlert(Alert.AlertType.ERROR, "Error", "Error finalizing selections.");
                    throw new RuntimeException(e);
                }
            }
        });

        HBox buttonBox = new HBox(finalizeButton, exitButton);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.setLayoutX(1410);
        buttonBox.setLayoutY(750);

        this.setPrefSize(1540, 785);
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