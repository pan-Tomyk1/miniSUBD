module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.project.popup.controlers to javafx.fxml;

    opens com.example.project to javafx.fxml;
    exports com.example.project;
}