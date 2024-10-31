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

public class EditSceneController extends AbstractController {
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
    private Button editButton;

    @FXML
    private AnchorPane editSceneAnchorPane;

    @FXML
    private Button generateButton;

    @FXML
    private TextField ketField;

    @FXML
    private Button lookButton;

    @FXML
    private Button searchButton;

    @FXML
    void addButtonClick() throws IOException {
        new SceneSwitch(editSceneAnchorPane, "first_scene.fxml");
    }

    @FXML
    void applyButtonClick(ActionEvent event) {
        // Зчитуємо значення з текстових полів
        String keyValue = ketField.getText();
        String resultOfValidation = taskProcessor.validateDeletingKey(keyValue);
        ketField.clear();
        if (!resultOfValidation.equals(TaskProcessor.DATA_IS_OK)) {
            loadResultValidatePopUp(event, "/com/example/project/pop_ups/result_validate_popup.fxml", "Результат редагування", "/images/popUpStyles/result_validate_popup_style.css", resultOfValidation);
        } else {
            loadResultAreYouSurePopUp(event, "/com/example/project/pop_ups/are_u_sure_popup.fxml", "Редагування", "/images/popUpStyles/are_u_sure_popup_style.css", "Введіть нове значення ключа");
            String dataValue = AbstractController.areYouSurePopUpLabelText;
            if (dataValue != null) {
                System.out.println("dataValue =" + dataValue);
                if (dataValue.length() > 50) {
                    loadResultValidatePopUp(event, "/com/example/project/pop_ups/result_validate_popup.fxml", "Результат редагування", "/images/popUpStyles/result_validate_popup_style.css", "Значення даних задовге");
                }
                TaskProcessor.editNode(Integer.parseInt(keyValue), dataValue);
            }
        }
    }

    @FXML
    void deleteButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(editSceneAnchorPane, "delete_scene.fxml");
    }

//    @FXML
//    void generateButtonClick(ActionEvent event) {
//
//    }

    @FXML
    void lookButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(editSceneAnchorPane, "look_scene.fxml");
    }

    @FXML
    void searchButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(editSceneAnchorPane, "search_scene.fxml");
    }

    @FXML
    void initialize() {

    }

}
