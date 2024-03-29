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
    private Label messageLabel;

    @FXML
    private void menuButtonClicked() {
        messageLabel.setText("Привіт! Це Меню.");
    }

    @FXML
    private void ordersButtonClicked() {
        messageLabel.setText("Привіт! Це Замовлення.");
    }

    @FXML
    private void queueButtonClicked() {
        messageLabel.setText("Привіт! Це Черга.");
    }

    @FXML
    private void optionsButtonClicked() {
        messageLabel.setText("Привіт! Це Опції.");
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

