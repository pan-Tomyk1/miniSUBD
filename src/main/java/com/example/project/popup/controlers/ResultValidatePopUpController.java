package com.example.project.popup.controlers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ResultValidatePopUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button ok_button;

    @FXML
    private Label top_label;

    @FXML
    void okButtonClick(ActionEvent event) {
        Stage stage = (Stage) ok_button.getScene().getWindow();
        // Закриваємо це вікно
        stage.close();
    }

    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'result_validate_popup.fxml'.";
        assert ok_button != null : "fx:id=\"ok_button\" was not injected: check your FXML file 'result_validate_popup.fxml'.";
        assert top_label != null : "fx:id=\"top_label\" was not injected: check your FXML file 'result_validate_popup.fxml'.";

    }
    public void setLabels(String topText) {
        top_label.setText(topText);
    }

}
