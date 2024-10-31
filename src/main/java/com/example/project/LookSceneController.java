package com.example.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.example.project.calculation_classes.TaskProcessor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LookSceneController extends AbstractController {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private Button generateButton;

    @FXML
    private Button lookButton;

    @FXML
    private AnchorPane lookSceneAnchorPane;

    @FXML
    private Button searchButton;

    @FXML
    private TextArea textArea;


    @FXML
    void addButtonClick() throws IOException {
        new SceneSwitch(lookSceneAnchorPane,"first_scene.fxml");
    }

    @FXML
    void deleteButtonClick(ActionEvent event) throws IOException {
        new SceneSwitch(lookSceneAnchorPane,"delete_scene.fxml");
    }

    @FXML
    void editButtonClick(ActionEvent event) throws IOException{
        new SceneSwitch(lookSceneAnchorPane,"edit_scene.fxml");
    }

//    @FXML
//    void generateButtonClick(ActionEvent event) {
//
//    }

    @FXML
    void searchButtonClick(ActionEvent event) throws IOException{
        new SceneSwitch(lookSceneAnchorPane,"search_scene.fxml");
    }

    @FXML
    void initialize() {
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(TaskProcessor.FILE_NAME))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();       // Зчитуємо число
                    String text = scanner.nextLine(); // Зчитуємо залишок рядка
                    stringBuilder.append(number).append(" ").append(text).append("\n");
                } else {
                    scanner.nextLine(); // Пропускаємо рядок, якщо він не починається з числа
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        textArea.setText(stringBuilder.toString());
    }

}
