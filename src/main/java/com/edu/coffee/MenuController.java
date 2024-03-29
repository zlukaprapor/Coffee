package com.edu.coffee;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
    private void initialize() {
        // Встановлюємо текст кнопок
        menuButton.setText("Меню");
        ordersButton.setText("Замовлення");
        queueButton.setText("Черга");
        optionsButton.setText("Опції");
    }
}

