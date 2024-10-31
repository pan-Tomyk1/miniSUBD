package com.example.project.popup.controlers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.project.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AreUSurePopUpController extends AbstractController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane areYouSureAnchorPane;

    @FXML
    private Label label;

    @FXML
    private Button no_button;

    @FXML
    private Button ok_button;

    @FXML
    private TextArea text_area;

    @FXML
    void noButtonClick(ActionEvent event) {
        AbstractController.setAreYouSurePopUpLabelText(null);
        Stage stage = (Stage) ok_button.getScene().getWindow();
        // Закриваємо це вікно
        stage.close();
    }

    @FXML
    void okButtonClick(ActionEvent event) {
        AbstractController.setAreYouSurePopUpLabelText(text_area.getText());
        Stage stage = (Stage) ok_button.getScene().getWindow();
        // Закриваємо це вікно
        stage.close();
    }

    @FXML
    void initialize() {
        assert areYouSureAnchorPane != null : "fx:id=\"areYouSureAnchorPane\" was not injected: check your FXML file 'are_u_sure_popup.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'are_u_sure_popup.fxml'.";
        assert no_button != null : "fx:id=\"no_button\" was not injected: check your FXML file 'are_u_sure_popup.fxml'.";
        assert ok_button != null : "fx:id=\"ok_button\" was not injected: check your FXML file 'are_u_sure_popup.fxml'.";
        assert text_area != null : "fx:id=\"text_area\" was not injected: check your FXML file 'are_u_sure_popup.fxml'.";

    }
    public void setLabel(String topText) {
        label.setText(topText);
    }
}
