package com.example.project.popup.controlers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SearchResultPopUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextArea bottom_text_area;

    @FXML
    private Button ok_button;

    @FXML
    private TextArea top_text_area;

    @FXML
    void okButtonClick(ActionEvent event) {
        Stage stage = (Stage) ok_button.getScene().getWindow();
        // Закриваємо це вікно
        stage.close();
    }

    @FXML
    void initialize() {

    }
    public void setLabels(String topText, String bottomText) {
        top_text_area.setText(topText);
        bottom_text_area.setText(bottomText);
    }

}
