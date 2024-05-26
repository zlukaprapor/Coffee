package com.edu.coffee;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
        // Отримання тексту замовлених елементів з OrdersScene
        String orderedItemsText = OrdersScene.getOrderedItemsText();
        // Встановлення тексту у відповідний лейбл
        messageLabelLeft.setText(orderedItemsText);
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
        messageLabelLeft.setText("Привіт! Це Черга. messageLabelLeft");
        messageLabelRight.setText("Привіт! Це Черга. messageLabelRight");
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
        messageLabelLeft.setText("Привіт! Це Опції. messageLabelLeft");
        messageLabelRight.setText("Привіт! Це Опції. messageLabelRight");
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
