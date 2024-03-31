package com.edu.coffee;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Клас MenuScene відповідає за налаштування сцени з відображенням меню з обідами та напоями.
 */
public class MenuScene {

    /**
     * Метод setupMenuScene налаштовує сцену з відображенням обідів та напоїв.
     *
     * @param messageLabelLeft  мітка, в яку вставляється відображення обідів
     * @param messageLabelRight мітка, в яку вставляється відображення напоїв
     */
    public static void setupMenuScene(Label messageLabelLeft, Label messageLabelRight) {
        // Створення VBox для відображення обідів
        VBox mealBox = new VBox();
        // Додавання мітки для відображення заголовка "Обіди:"
        Label viewLabel = new Label("Обіди:\n");
        viewLabel.getStyleClass().add("view-label");
        mealBox.getChildren().add(viewLabel);
        // Отримання списку обідів з класу Item
        List<Item> meals = Item.readMeals();
        // Додавання інформації про обіди до VBox
        for (Item meal : meals) {
            Label nameLabel = new Label("Назва: " + meal.getName());
            nameLabel.getStyleClass().add("meal-name");
            Label priceLabel = new Label("Ціна: " + meal.getPrice());
            priceLabel.getStyleClass().add("meal-price");
            Label dishesLabel = new Label("Страви: " + meal.getDishes());
            dishesLabel.getStyleClass().add("meal-description");
            VBox mealInfo = new VBox(nameLabel, priceLabel, dishesLabel);
            mealInfo.getStyleClass().add("meal-info");
            mealBox.getChildren().add(mealInfo);
        }
        // Встановлення графічного зображення VBox з обідами у мітку messageLabelLeft
        messageLabelLeft.setGraphic(mealBox);

        // Створення VBox для відображення напоїв
        VBox drinkBox = new VBox();
        // Додавання мітки для відображення заголовка "Напої:"
        Label viewLabelDrinks = new Label("Напої:\n");
        viewLabelDrinks.getStyleClass().add("view-label");
        drinkBox.getChildren().add(viewLabelDrinks);
        // Отримання списку напоїв з класу Item
        List<Item> drinks = Item.readDrinks();
        // Додавання інформації про напої до VBox
        for (Item drink : drinks) {
            Label nameLabel = new Label("Назва: " + drink.getName());
            nameLabel.getStyleClass().add("drink-name");
            Label priceLabel = new Label("Ціна: " + drink.getPrice());
            priceLabel.getStyleClass().add("drink-price");
            Label dishesLabel = new Label("Напої: " + drink.getDishes());
            dishesLabel.getStyleClass().add("drink-description");
            VBox drinkInfo = new VBox(nameLabel, priceLabel, dishesLabel);
            drinkInfo.getStyleClass().add("drink-info");
            drinkBox.getChildren().add(drinkInfo);
        }
        // Встановлення графічного зображення VBox з напоями у мітку messageLabelRight
        messageLabelRight.setGraphic(drinkBox);
    }
}
