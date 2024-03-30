package com.edu.coffee;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


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


    @FXML
    private void menuButtonClicked() {
        MenuScene.setMenuLabelText(messageLabelLeft);
    }

    @FXML
    private void ordersButtonClicked() {
        messageLabelRight.setText("Привіт! Це Замовлення.");
    }

    @FXML
    private void queueButtonClicked() {
        messageLabelRight.setText("Привіт! Це Черга.");
    }

    @FXML
    private void optionsButtonClicked() {
        messageLabelRight.setText("Привіт! Це Опції.");
    }
    @FXML
    private void initialize() {
        // Встановлюємо текст кнопок
        menuButton.setText("Меню");
        ordersButton.setText("Замовлення");
        queueButton.setText("Черга");
        optionsButton.setText("Опції");
    }

}

