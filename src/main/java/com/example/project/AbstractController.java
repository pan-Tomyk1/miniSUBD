package com.example.project;

import com.example.project.calculation_classes.MyNode;
import com.example.project.calculation_classes.StringGenerator;
import com.example.project.calculation_classes.TaskProcessor;
import com.example.project.popup.controlers.AreUSurePopUpController;
import com.example.project.popup.controlers.ResultValidatePopUpController;
import com.example.project.popup.controlers.SearchResultPopUpController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class AbstractController {


    static String areYouSurePopUpLabelText;

    public void loadResultValidatePopUp(ActionEvent event, String pathFXML, String stageTitle, String styleFile, String labelText) {
        try {
            // Завантажуємо FXML-файл для спливаючого вікна
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pathFXML));
            Parent popupContent = fxmlLoader.load();

            // Отримуємо контролер
            ResultValidatePopUpController controller = fxmlLoader.getController();
            // Передаємо дані

            controller.setLabels(labelText);

            // Створюємо нове вікно
            Stage popupStage = new Stage();
            popupStage.setTitle(stageTitle);


            // Встановлюємо сцену з вашим FXML-інтерфейсом
            Scene popupScene = new Scene(popupContent);
            popupStage.setScene(popupScene);


            // Підключаємо CSS-файл (за потреби)
            popupScene.getStylesheets().add(getClass().getResource(styleFile).toExternalForm());


            // Встановлюємо тип вікна як модальне
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.initOwner(((Node) event.getSource()).getScene().getWindow());

            // Відображаємо вікно і блокуємо основне
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadResultAreYouSurePopUp(ActionEvent event, String pathFXML, String stageTitle, String styleFile, String labelText) {
        try {
            // Завантажуємо FXML-файл для спливаючого вікна
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pathFXML));
            Parent popupContent = fxmlLoader.load();

            // Отримуємо контролер
            AreUSurePopUpController controller = fxmlLoader.getController();
            // Передаємо дані

            controller.setLabel(labelText);

            // Створюємо нове вікно
            Stage popupStage = new Stage();
            popupStage.setTitle(stageTitle);


            // Встановлюємо сцену з вашим FXML-інтерфейсом
            Scene popupScene = new Scene(popupContent);
            popupStage.setScene(popupScene);


            // Підключаємо CSS-файл (за потреби)
            popupScene.getStylesheets().add(getClass().getResource(styleFile).toExternalForm());


            // Встановлюємо тип вікна як модальне
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.initOwner(((Node) event.getSource()).getScene().getWindow());

            // Відображаємо вікно і блокуємо основне
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadResultSearchResultPopUp(ActionEvent event, String pathFXML, String stageTitle, String styleFile, String firstTextAreaText, String secondTextAreaText) {
        try {
            // Завантажуємо FXML-файл для спливаючого вікна
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pathFXML));
            Parent popupContent = fxmlLoader.load();

            // Отримуємо контролер
            SearchResultPopUpController controller = fxmlLoader.getController();
            // Передаємо дані

            controller.setLabels(firstTextAreaText,secondTextAreaText);

            // Створюємо нове вікно
            Stage popupStage = new Stage();
            popupStage.setTitle(stageTitle);


            // Встановлюємо сцену з вашим FXML-інтерфейсом
            Scene popupScene = new Scene(popupContent);
            popupStage.setScene(popupScene);


            // Підключаємо CSS-файл (за потреби)
            popupScene.getStylesheets().add(getClass().getResource(styleFile).toExternalForm());


            // Встановлюємо тип вікна як модальне
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.initOwner(((Node) event.getSource()).getScene().getWindow());

            // Відображаємо вікно і блокуємо основне
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setAreYouSurePopUpLabelText(String _areYouSurePopUpLabelText) {
        areYouSurePopUpLabelText = _areYouSurePopUpLabelText;
    }
    @FXML
    public void generateButtonClick(ActionEvent event) {
        Random random = new Random();
        int size=TaskProcessor.hashSet.size();
        if(size>10_000){
            loadResultValidatePopUp(event, "/com/example/project/pop_ups/result_validate_popup.fxml", "Результат генерації", "/images/popUpStyles/result_validate_popup_style.css", "В базі даних більше ніж 10_000 вузлів");
        }
        for (int i = size; i <10_000 ; i++) {
            boolean isDoubling=true;
            int key=0;
            while (isDoubling){
                key=random.nextInt(Integer.MAX_VALUE);
                isDoubling=TaskProcessor.hashSet.contains(key);
            }
            TaskProcessor.hashSet.add(key);
            String value=StringGenerator.generateRandomString(30);
            TaskProcessor.bTree.add(new MyNode(key, value));
        }
        TaskProcessor.bTreeToFile();
        loadResultValidatePopUp(event, "/com/example/project/pop_ups/result_validate_popup.fxml", "Результат генерації", "/images/popUpStyles/result_validate_popup_style.css", "База даних була заповнена до 10_000 вузлів");
    }
}
