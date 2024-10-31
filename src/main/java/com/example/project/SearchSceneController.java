package com.example.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.project.calculation_classes.BTree;
import com.example.project.calculation_classes.MyNode;
import com.example.project.calculation_classes.TaskProcessor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SearchSceneController extends AbstractController {
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
    private Button generateButton;

    @FXML
    private TextField ketField;

    @FXML
    private Button lookButton;

    @FXML
    private Button searchButton;

    @FXML
    private AnchorPane searchSceneAhchorPane;

    @FXML
    void addButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(searchSceneAhchorPane, "first_scene.fxml");
    }

    @FXML
    void applyButtonClick(ActionEvent event) {
        // Зчитуємо значення з текстових полів
        String keyValue = ketField.getText();
        String resultOfValidation = taskProcessor.validateDeletingKey(keyValue);
        ketField.clear();
        if (!resultOfValidation.equals(TaskProcessor.DATA_IS_OK)) {
            loadResultValidatePopUp(event, "/com/example/project/pop_ups/result_validate_popup.fxml", "Результат пошуку", "/images/popUpStyles/result_validate_popup_style.css", resultOfValidation);
        } else {
            MyNode foundNode = TaskProcessor.bTree.get(new MyNode(Integer.parseInt(keyValue), ""));
            loadResultSearchResultPopUp(event, "/com/example/project/pop_ups/search_result_popup.fxml", "Результат пошуку", "/images/popUpStyles/search)result-popup_style.css", foundNode.getValue(), BTree.comparisonCount + "");
        }
    }

    @FXML
    void deleteButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(searchSceneAhchorPane, "delete_scene.fxml");
    }

    @FXML
    void editButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(searchSceneAhchorPane, "edit_scene.fxml");
    }

//    @FXML
//    void generateButtonClick(ActionEvent event) {
//        loadResultValidatePopUp(event, "/com/example/project/pop_ups/result_validate_popup.fxml", "Результат генерації", "/images/popUpStyles/result_validate_popup_style.css", "База даних була заповнена до 10_000 вузлів");
//    }

    @FXML
    void lookButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(searchSceneAhchorPane, "look_scene.fxml");
    }

    @FXML
    void initialize() {

    }

}
