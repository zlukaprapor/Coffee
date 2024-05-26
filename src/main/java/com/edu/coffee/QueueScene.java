package com.edu.coffee;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueScene {

    private static final int MAX_COMPLETED_ORDERS = 10;
    private static VBox ordersBox;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static VBox completedOrdersBox;
    private static Queue<Order> completedOrdersQueue = new LinkedList<>();
    private static List<Order> currentOrders;

    public static void setupQueueScene(VBox leftBox, VBox rightBox) {
        ordersBox = leftBox;
        completedOrdersBox = rightBox;

        currentOrders = Order.readOrder();

        for (Order order : currentOrders) {
            HBox orderItem = createOrderItem(order);
            ordersBox.getChildren().add(orderItem);
        }

        updateCompletedOrdersBox();
    }

    private static HBox createOrderItem(Order order) {
        HBox orderItem = new HBox();
        String time = formatter.format(order.getOrderTime());
        Label orderLabel = new Label(order.getName() + " - " + order.getNumber() + " столик " + time);
        orderLabel.getStyleClass().add("meal-name-queue");
        Button completeButton = new Button("Виконано");
        completeButton.getStyleClass().add("completeButton");

        completeButton.setOnAction(event -> {
            ordersBox.getChildren().remove(orderItem);
            currentOrders.remove(order);
            addToCompletedOrders(order);
            Order.writeItemsToFile(currentOrders);
        });

        orderItem.getChildren().addAll(orderLabel, completeButton);
        return orderItem;
    }

    private static void addToCompletedOrders(Order order) {
        if (completedOrdersQueue.size() == MAX_COMPLETED_ORDERS) {
            completedOrdersQueue.poll(); // Remove the oldest order
        }
        completedOrdersQueue.offer(order);
        updateCompletedOrdersBox();
    }

    private static void updateCompletedOrdersBox() {
        completedOrdersBox.getChildren().clear();
        Label header = new Label("Виконано:");
        header.getStyleClass().add("view-label");
        completedOrdersBox.getChildren().add(header);

        for (Order order : completedOrdersQueue) {
            LocalTime currentTime = LocalTime.now();
            Label orderLabel = new Label(order.getName() + " - " + order.getNumber() + " столик, виконано: " + formatter.format(currentTime));
            orderLabel.getStyleClass().add("meal-name");
            completedOrdersBox.getChildren().add(orderLabel);
        }
    }
}
