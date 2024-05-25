package com.edu.coffee;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
            Label nameLabel = new Label(meal.getName());
            nameLabel.getStyleClass().add("meal-name");
            // Розділення та форматування страв
            String dishes = meal.getDishes();
            String[] dishesArray = dishes.split(", ");
            StringBuilder formattedDishes = new StringBuilder();
            for (String dish : dishesArray) {
                formattedDishes.append(dish).append("\n");
            }
            Label dishesLabel = new Label(formattedDishes.toString());
            dishesLabel.getStyleClass().add("meal-description");
            Label priceLabel = new Label("Ціна: " + meal.getPrice());
            priceLabel.getStyleClass().add("meal-price");
            // Створення кнопки з зображенням для купівлі
            Button buyButton = new Button();
            buyButton.getStyleClass().clear();// Видаляє всі класи стилів, що застосовуються до кнопки
            Image buyImage = new Image(MenuScene.class.getResource("/com/edu/coffee/img/buy.png").toExternalForm()); // шлях до  зображення
            ImageView buyImageView = new ImageView(buyImage);
            buyImageView.setFitWidth(42);  // встановлення ширини зображення
            buyImageView.setFitHeight(42); // встановлення висоти зображення
            buyButton.setGraphic(buyImageView);
            buyButton.getStyleClass().add("buy-button");// Додавання стилів до кнопки з зображенням

            // Додавання дій для кнопки
            buyButton.setOnAction(event -> {
                // Дії при натисканні кнопки купівлі
                System.out.println("Куплено: " + meal.getName());
            });

            VBox mealInfo = new VBox(nameLabel, dishesLabel, priceLabel, buyButton);
            mealInfo.getStyleClass().add("meal-info");
            mealBox.getChildren().add(mealInfo);
        }

        // Встановлення графічного зображення VBox з напоїв у мітку messageLabelLeft
        messageLabelLeft.setGraphic(mealBox);
        // Створення VBox для відображення напоїв
        VBox drinkBox = new VBox();
        // Додавання мітки для відображення заголовка "Напої:"
        Label viewLabelDrinks = new Label("Напої:\n");
        viewLabelDrinks.getStyleClass().add("view-label");
        drinkBox.getChildren().add(viewLabelDrinks);
        // Отримання списку напоїв з класу Item
        List<Item> drinks = Item.readDrinks();
        // Додавання інформації про напоїв до VBox
        for (Item drink : drinks) {
            Label nameLabel = new Label(drink.getName());
            nameLabel.getStyleClass().add("drink-name");
            // Розділення та форматування напоїв
            String dishes = drink.getDishes();
            String[] dishesArray = dishes.split(", ");
            StringBuilder formattedDishes = new StringBuilder();
            for (String dish : dishesArray) {
                formattedDishes.append(dish).append("\n");
            }
            Label dishesLabel = new Label(formattedDishes.toString());
            dishesLabel.getStyleClass().add("drink-description");
            Label priceLabel = new Label("Ціна: " + drink.getPrice());
            priceLabel.getStyleClass().add("drink-price");
            // Створення кнопки з зображенням для купівлі
            Button buyButton = new Button();
            buyButton.getStyleClass().clear();// Видаляє всі класи стилів, що застосовуються до кнопки
            Image buyImage = new Image(MenuScene.class.getResource("/com/edu/coffee/img/buy.png").toExternalForm()); // шлях до  зображення
            ImageView buyImageView = new ImageView(buyImage);
            buyImageView.setFitWidth(42);  // встановлення ширини зображення
            buyImageView.setFitHeight(42); // встановлення висоти зображення
            buyButton.setGraphic(buyImageView);
            buyButton.getStyleClass().add("buy-button");// Додавання стилів до кнопки з зображенням

            // Додавання дій для кнопки
            buyButton.setOnAction(event -> {
                // Дії при натисканні кнопки купівлі
                System.out.println("Куплено: " + drink.getName());
            });

            VBox drinkInfo = new VBox(nameLabel, dishesLabel, priceLabel, buyButton);
            drinkInfo.getStyleClass().add("drink-info");
            drinkBox.getChildren().add(drinkInfo);
        }
        // Встановлення графічного зображення VBox з напоями у мітку messageLabelRight
        messageLabelRight.setGraphic(drinkBox);
    }
}
