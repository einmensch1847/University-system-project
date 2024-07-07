module org.example.unip {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires java.desktop;


    opens org.example.unip to javafx.fxml;
    exports org.example.unip;
}