module pairprogramming.restaurant2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens pairprogramming.restaurant2 to javafx.fxml;
    exports pairprogramming.restaurant2;
}