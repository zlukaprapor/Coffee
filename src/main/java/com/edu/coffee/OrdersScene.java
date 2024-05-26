package com.edu.coffee;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class OrdersScene {
    private static List<Item> orderedItems = new ArrayList<>();

    public static void addItemToOrder(Item item) {
        orderedItems.add(item);
    }

    public static List<Item> getOrderedItems() {
        return orderedItems;
    }

    public static void removeItemFromOrder(Item item) {
        orderedItems.remove(item);
    }

    public static void setupOrdersScene(VBox ordersBox) {
        ordersBox.getChildren().clear();

        long total = calculateTotal();
        Label totalLabel = new Label("Загальна сума: " + total + " грн");
        totalLabel.getStyleClass().add("total-label");
        ordersBox.getChildren().add(totalLabel);

        Label itemsLabel = new Label("Замовлені страви:");
        itemsLabel.getStyleClass().add("items-label");
        ordersBox.getChildren().add(itemsLabel);

        for (Item item : orderedItems) {
            Label itemLabel = new Label(item.getName());
            itemLabel.getStyleClass().add("item-label");
            Button removeButton = new Button("Видалити");
            removeButton.setOnAction(event -> {
                removeItemFromOrder(item);
                setupOrdersScene(ordersBox); // Refresh the scene after removal
            });
            ordersBox.getChildren().addAll(itemLabel, removeButton);
        }
    }

    public static void setup2OrdersScene(VBox ordersBox) {
        ordersBox.getChildren().clear();

        Label addOrderLabel = new Label("Додати нове замовлення:");
        TextField waiterNameField = new TextField();
        waiterNameField.setPromptText("Офіціант:");
        TextField tableNumberField = new TextField();
        tableNumberField.setPromptText("Стіл:");
        TextField paymentTypeField = new TextField();
        paymentTypeField.setPromptText("Спосіб оплати:");

        Button addOrderButton = new Button("Додати замовлення");
        addOrderButton.setOnAction(event -> {
            String name = waiterNameField.getText();
            String number = tableNumberField.getText();
            String type = paymentTypeField.getText();
            LocalTime currentTime = LocalTime.now();
            Order newOrder = new Order(currentTime, name, number, type);
            Order.addOrder(newOrder);
            System.out.println("Додано нове замовлення");
        });

        ordersBox.getChildren().addAll(
                addOrderLabel, waiterNameField, tableNumberField, paymentTypeField, addOrderButton
        );
    }

    private static long calculateTotal() {
        long total = 0;
        for (Item item : orderedItems) {
            total += item.getPrice();
        }
        return total;
    }
}
