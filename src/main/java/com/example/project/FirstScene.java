package com.example.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.example.project.calculation_classes.TaskProcessor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FirstScene extends AbstractController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button applyButton;

    @FXML
    private TextField dataField;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private AnchorPane firstSceneAnchorPane;

    @FXML
    private Button generateButton;

    @FXML
    private TextField ketField;

    @FXML
    private Button lookButton;

    @FXML
    private Button searchButton;

    @FXML
    void addButtonClick(ActionEvent event) {

    }

    @FXML
    void applyButtonClick(ActionEvent event) {
        // Зчитуємо значення з текстових полів
        String keyValue = ketField.getText();
        String dataValue = dataField.getText();
        String resultOfValidation = TaskProcessor.validateAddingKey(keyValue);
        dataField.clear();
        ketField.clear();
        if(dataValue.length()>50){
            loadResultValidatePopUp(event, "/com/example/project/pop_ups/result_validate_popup.fxml", "Результат додавання", "/images/popUpStyles/result_validate_popup_style.css", "Значення ключа задовге");
            return;
        }
        if (!resultOfValidation.equals(TaskProcessor.DATA_IS_OK)) {
            loadResultValidatePopUp(event, "/com/example/project/pop_ups/result_validate_popup.fxml", "Результат додавання", "/images/popUpStyles/result_validate_popup_style.css", resultOfValidation);

        } else {
            TaskProcessor.addNode(Integer.parseInt(keyValue), dataValue);
            loadResultValidatePopUp(event, "/com/example/project/pop_ups/result_validate_popup.fxml", "Результат додавання", "/images/popUpStyles/result_validate_popup_style.css", "Дані успішно додані");
        }
    }

    @FXML
    void deleteButtonClick() throws IOException {
        new SceneSwitch(firstSceneAnchorPane, "delete_scene.fxml");
    }

    @FXML
    void editButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(firstSceneAnchorPane, "edit_scene.fxml");
    }

//    @FXML
//    void generateButtonClick(ActionEvent event) {
//
//    }

    @FXML
    void lookButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(firstSceneAnchorPane, "look_scene.fxml");
    }

    @FXML
    void searchButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(firstSceneAnchorPane, "search_scene.fxml");
    }

    @FXML
    void initialize() {

    }

}
