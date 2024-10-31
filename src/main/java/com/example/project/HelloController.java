package com.example.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button mainButton;

    @FXML
    private Label mainLable;

    @FXML
    void buttonClick(ActionEvent event) {
        mainLable.setText(mainButton.getText());
    }

    @FXML
    void initialize() {

    }

}
