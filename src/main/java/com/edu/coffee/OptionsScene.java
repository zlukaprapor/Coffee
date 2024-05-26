package com.edu.coffee;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

import static com.edu.coffee.Item.addMeal;
import static com.edu.coffee.Item.addDrink;
import static com.edu.coffee.Item.removeMeal;
import static com.edu.coffee.Item.removeDrink;

public class OptionsScene {

    public static void setupOptionsScene(VBox optionsBox) {
        Label addMealLabel = new Label("Додати нову страву:");
        TextField mealNameField = new TextField();
        mealNameField.setPromptText("Назва страви");
        TextField mealPriceField = new TextField();
        mealPriceField.setPromptText("Ціна страви");
        TextField mealDishesField = new TextField();
        mealDishesField.setPromptText("Список страв (через кому)");

        Button addMealButton = new Button("Додати страву");
        addMealButton.setOnAction(event -> {
            String name = mealNameField.getText();
            long price = Long.parseLong(mealPriceField.getText());
            String dishes = mealDishesField.getText();
            Item newMeal = new Item(name, price, dishes);
            addMeal(newMeal);
            System.out.println("Додано нову страву: " + name);
            updateDeleteOptions(optionsBox);
        });

        Label addDrinkLabel = new Label("Додати новий напій:");
        TextField drinkNameField = new TextField();
        drinkNameField.setPromptText("Назва напою");
        TextField drinkPriceField = new TextField();
        drinkPriceField.setPromptText("Ціна напою");
        TextField drinkDishesField = new TextField();
        drinkDishesField.setPromptText("Список страв (через кому)");

        Button addDrinkButton = new Button("Додати напій");
        addDrinkButton.setOnAction(event -> {
            String name = drinkNameField.getText();
            long price = Long.parseLong(drinkPriceField.getText());
            String dishes = drinkDishesField.getText();
            Item newDrink = new Item(name, price, dishes);
            addDrink(newDrink);
            System.out.println("Додано новий напій: " + name);
            updateDeleteOptions(optionsBox);
        });

        VBox addOptionsBox = new VBox();
        addOptionsBox.getChildren().addAll(
                addMealLabel, mealNameField, mealPriceField, mealDishesField, addMealButton,
                addDrinkLabel, drinkNameField, drinkPriceField, drinkDishesField, addDrinkButton
        );

        optionsBox.getChildren().add(addOptionsBox);
    }

    public static void updateDeleteOptions(VBox optionsBox) {
        optionsBox.getChildren().removeIf(node -> node instanceof VBox && ((VBox) node).getChildren().size() > 0 && ((VBox) node).getChildren().get(0) instanceof Label && (
                ((Label) ((VBox) node).getChildren().get(0)).getText().equals("Видалити страву:") ||
                        ((Label) ((VBox) node).getChildren().get(0)).getText().equals("Видалити напій:")
        ));

        VBox deleteOptionsBox = new VBox();
        Label deleteMealLabel = new Label("Видалити страву:");
        deleteOptionsBox.getChildren().add(deleteMealLabel);
        List<Item> meals = Item.readMeals();
        for (Item meal : meals) {
            HBox mealItem = new HBox();
            Label mealLabel = new Label(meal.getName() + " - " + meal.getPrice() + " грн");
            Button deleteMealButton = new Button("Видалити");
            deleteMealButton.setOnAction(event -> {
                removeMeal(meal);
                System.out.println("Видалено страву: " + meal.getName());
                updateDeleteOptions(optionsBox);
            });
            mealItem.getChildren().addAll(mealLabel, deleteMealButton);
            deleteOptionsBox.getChildren().add(mealItem);
        }

        Label deleteDrinkLabel = new Label("Видалити напій:");
        deleteOptionsBox.getChildren().add(deleteDrinkLabel);
        List<Item> drinks = Item.readDrinks();
        for (Item drink : drinks) {
            HBox drinkItem = new HBox();
            Label drinkLabel = new Label(drink.getName() + " - " + drink.getPrice() + " грн");
            Button deleteDrinkButton = new Button("Видалити");
            deleteDrinkButton.setOnAction(event -> {
                removeDrink(drink);
                System.out.println("Видалено напій: " + drink.getName());
                updateDeleteOptions(optionsBox);
            });
            drinkItem.getChildren().addAll(drinkLabel, deleteDrinkButton);
            deleteOptionsBox.getChildren().add(drinkItem);
        }

        optionsBox.getChildren().add(deleteOptionsBox);
    }
}
