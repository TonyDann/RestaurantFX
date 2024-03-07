module com.example.pair {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pair to javafx.fxml;
    exports com.example.pair;
}