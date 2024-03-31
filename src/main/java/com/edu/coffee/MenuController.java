package com.edu.coffee;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
        MenuScene.setupMenuScene(messageLabelLeft, messageLabelRight);
    }

    /**
     * Обробник події натискання кнопки "Замовлення".
     * Встановлює текст у messageLabelRight на "Привіт! Це Замовлення."
     */
    @FXML
    private void ordersButtonClicked() {
        messageLabelRight.setText("Привіт! Це Замовлення.");
    }

    /**
     * Обробник події натискання кнопки "Черга".
     * Встановлює текст у messageLabelRight на "Привіт! Це Черга."
     */
    @FXML
    private void queueButtonClicked() {
        messageLabelRight.setText("Привіт! Це Черга.");
    }

    /**
     * Обробник події натискання кнопки "Опції".
     * Встановлює текст у messageLabelRight на "Привіт! Це Опції."
     */
    @FXML
    private void optionsButtonClicked() {
        messageLabelRight.setText("Привіт! Це Опції.");
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
