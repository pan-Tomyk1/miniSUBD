package com.example.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.project.calculation_classes.TaskProcessor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DeleteSceneController extends AbstractController {
    TaskProcessor taskProcessor = new TaskProcessor();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button applyButton;

    @FXML
    private Button deleteButton;

    @FXML
    private AnchorPane deleteSceneAnchorPane;

    @FXML
    private Button editButton;

    @FXML
    private Button generateButton;

    @FXML
    private TextField ketField;

    @FXML
    private Button lookButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button deleteDatabaseButton;

    @FXML
    void deleteDatabaseButtonClick(ActionEvent event) {
        taskProcessor.deleteDatabase();
        loadResultValidatePopUp(event, "/com/example/project/pop_ups/result_validate_popup.fxml", "Результат видалення", "/images/popUpStyles/result_validate_popup_style.css", "Всі дані із бази даних були успішно видалені");
    }

    @FXML
    void addButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(deleteSceneAnchorPane, "first_scene.fxml");
    }

    @FXML
    void applyButtonClick(ActionEvent event) {
        // Зчитуємо значення з текстових полів
        String keyValue = ketField.getText();
        String resultOfValidation = taskProcessor.validateDeletingKey(keyValue);
        ketField.clear();
        if (!resultOfValidation.equals(TaskProcessor.DATA_IS_OK)) {
            loadResultValidatePopUp(event, "/com/example/project/pop_ups/result_validate_popup.fxml", "Результат видалення", "/images/popUpStyles/result_validate_popup_style.css", resultOfValidation);
        } else {
            TaskProcessor.deleteNode(Integer.parseInt(keyValue));
            loadResultValidatePopUp(event, "/com/example/project/pop_ups/result_validate_popup.fxml", "Результат видалення", "/images/popUpStyles/result_validate_popup_style.css", "Дані успішно видалені");
        }
    }

    @FXML
    void editButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(deleteSceneAnchorPane, "edit_scene.fxml");
    }

//    @FXML
//    void generateButtonClick(ActionEvent event)  {
//
//    }

    @FXML
    void lookButtonCLick(ActionEvent event) throws IOException {
        new SceneSwitch(deleteSceneAnchorPane, "look_scene.fxml");
    }

    @FXML
    void searchButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(deleteSceneAnchorPane, "search_scene.fxml");
    }

    @FXML
    void initialize() {
    }

}
