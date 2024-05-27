package com.edu.coffee;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class QueueScene {



    private static final int MAX_COMPLETED_ORDERS = 10;
    private static VBox ordersBox;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static VBox completedOrdersBox;
    private static Queue<Order> completedOrdersQueue = new LinkedList<>();
    private static List<Order> currentOrders;
    private static final String CHECK_FILE_PATH = "/com/edu/coffee/check.txt";




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
        Label orderLabel = new Label(order.getName() + " - " + order.getNumber() + " столик " + formatter.format(order.getOrderTime()));
        orderLabel.getStyleClass().add("meal-name-queue");
        Button completeButton = new Button("Виконано");
        completeButton.getStyleClass().add("completeButton");

        completeButton.setOnAction(event -> {
            LocalTime currentTime = LocalTime.now();
            order.setCompletionTime(currentTime);
            ordersBox.getChildren().remove(orderItem);
            currentOrders.remove(order);
            addToCompletedOrders(order);
            printCheck(order);
            showCheckDialog(order);
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
            Label orderLabel = new Label(order.getName() + " - " + order.getNumber() + " столик, виконано: " + formatter.format(order.getCompletionTime()));
            orderLabel.getStyleClass().add("meal-name");
            completedOrdersBox.getChildren().add(orderLabel);
        }
    }

    private static void printCheck(Order order) {

        String checkData = "Офіціант: " +  order.getName() +"\n" +
                "Столик: " + order.getNumber() + "\n" +
                "Час прийняття замовлення: " + formatter.format(order.getOrderTime()) + "\n" +
                "Час видачі замовлення: " + formatter.format(order.getCompletionTime()) + "\n" +
                "Оплата: " + order.getType()  + "\n" +
                "Сума: " + order.getTotal()  + "\n" +
                "Замовлення:\n" + order.getList()  + "\n" +
                "---------------------------------------------\n";

        try (FileWriter writer = new FileWriter(Order.class.getResource(CHECK_FILE_PATH).getPath(), true)) {
            writer.write(checkData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showCheckDialog(Order order) {
        LocalTime currentTime = LocalTime.now();
        String checkDetails = "Офіціант: " +  order.getName() +"\n" +
                "Столик: " + order.getNumber() + "\n" +
                "Час прийняття замовлення: " + formatter.format(order.getOrderTime()) + "\n" +
                "Час видачі замовлення: " + formatter.format(currentTime) + "\n" +
                "Оплата: " + order.getType() + "\n" +
                "Сума: " + order.getTotal() + "\n" +
                "Замовлення:\n" + order.getList();

        // Створення нового вікна для повідомлення
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle("Чек");

        // Додавання мітки з повідомленням
        Label messageLabel = new Label(checkDetails);
        StackPane layout = new StackPane(messageLabel);
        Scene scene = new Scene(layout, 300, 200);
        dialogStage.setScene(scene);

        // Показуємо спливаюче вікно
        dialogStage.show();

        // Створення таймера для закриття вікна через 2 секунди
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(dialogStage::close);
            }
        }, 2000);
    }
}
