package com.edu.coffee;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Клас-контролер для управління віджетами і обробки подій у GUI меню.
 */
public class MenuController {

    @FXML
    private Button menuButton;

    @FXML
    private Button ordersButton;

    @FXML
    private Button queueButton;

    @FXML
    private Button optionsButton;

    @FXML
    private Label messageLabelLeft;

    @FXML
    private Label messageLabelRight;

    /**
     * Обробник події натискання кнопки "Меню".
     * Викликає метод setupMenuScene з класу MenuScene, передаючи необхідні елементи Label.
     */
    @FXML
    private void menuButtonClicked() {
        messageLabelLeft.setText("");
        messageLabelRight.setText("");
        messageLabelLeft.setGraphic(null);
        messageLabelRight.setGraphic(null);
        MenuScene.setupMenuScene(messageLabelLeft, messageLabelRight);
    }

    /**
     * Обробник події натискання кнопки "Замовлення".
     * Встановлює текст у messageLabelRight на "Привіт! Це Замовлення."
     */
    @FXML
    private void ordersButtonClicked() {
        messageLabelLeft.setText("");
        messageLabelRight.setText("");
        messageLabelLeft.setGraphic(null);
        messageLabelRight.setGraphic(null);

        VBox ordersBox = new VBox();
        VBox ordersBox2 = new VBox();


        // Встановлення інформації про замовлення
        OrdersScene.setupOrdersScene(ordersBox);

        OrdersScene.setup2OrdersScene(ordersBox2);

        // Відображення даних на GUI
        messageLabelLeft.setGraphic(ordersBox);
        messageLabelRight.setGraphic(ordersBox2);
    }

    /**
     * Обробник події натискання кнопки "Черга".
     * Встановлює текст у messageLabelRight на "Привіт! Це Черга."
     */
    @FXML
    private void queueButtonClicked() {
        messageLabelLeft.setText("");
        messageLabelRight.setText("");
        messageLabelLeft.setGraphic(null);
        messageLabelRight.setGraphic(null);

        VBox ordersBox = new VBox();
        VBox completedOrdersBox = new VBox();
        QueueScene.setupQueueScene(ordersBox, completedOrdersBox);

        messageLabelLeft.setGraphic(ordersBox);
        messageLabelRight.setGraphic(completedOrdersBox);
    }

    /**
     * Обробник події натискання кнопки "Опції".
     * Встановлює текст у messageLabelRight на "Привіт! Це Опції."
     */
    @FXML
    private void optionsButtonClicked() {

        messageLabelLeft.setText("");
        messageLabelRight.setText("");
        messageLabelLeft.setGraphic(null);
        messageLabelRight.setGraphic(null);
        VBox optionsBox = new VBox();
        VBox optionsBox2 = new VBox();
        OptionsScene.setupOptionsScene(optionsBox);
        OptionsScene.updateDeleteOptions(optionsBox2);

        messageLabelLeft.setGraphic(optionsBox);
        messageLabelRight.setGraphic(optionsBox2);
    }

    /**
     * Метод, що викликається під час ініціалізації контролера.
     * Встановлює текст для кнопок у вікні.
     */
    @FXML
    private void initialize() {
        menuButton.setText("Меню");
        ordersButton.setText("Замовлення");
        queueButton.setText("Черга");
        optionsButton.setText("Опції");
    }

}
