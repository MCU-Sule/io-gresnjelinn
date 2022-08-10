module com.example.pt09fileio2072028 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.pt09fileio2072028 to javafx.fxml;
    opens com.example.pt09fileio2072028.model to javafx.fxml;
    exports com.example.pt09fileio2072028;
    exports com.example.pt09fileio2072028.model;
}