package com.edu.coffee;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.json.simple.JSONArray;

import java.util.List;


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


    private List<Item> items;

    @FXML
    private void menuButtonClicked() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Обіди:\n");
        List<Item> meals = Item.readMeals();
        for (Item meal : meals) {
            stringBuilder.append("Назва: ").append(meal.getName()).append(", ");
            stringBuilder.append("Ціна: ").append(meal.getPrice()).append(", ");
            stringBuilder.append("Страви: ").append(meal.getDishes()).append("\n");
        }
        messageLabelLeft.setText(stringBuilder.toString());

        StringBuilder drinkBuilder = new StringBuilder();
        drinkBuilder.append("Напої:\n");
        List<Item> drinks = Item.readDrinks();
        for (Item drink : drinks) {
            drinkBuilder.append("Назва: ").append(drink.getName()).append(", ");
            drinkBuilder.append("Ціна: ").append(drink.getPrice()).append(", ");
            drinkBuilder.append("Напої: ").append(drink.getDishes()).append("\n");
        }
        messageLabelRight.setText(drinkBuilder.toString());
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

