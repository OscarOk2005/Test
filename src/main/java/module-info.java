module org.example.database2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.database2 to javafx.fxml;
    exports org.example.database2;
}