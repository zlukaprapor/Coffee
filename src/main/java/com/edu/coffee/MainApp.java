package com.edu.coffee;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Клас MainApp є точкою входу до додатка.
 * Він ініціалізує додаток JavaFX та завантажує головний макет FXML.
 */
public class MainApp extends Application {

    /**
     * Метод start ініціалізує додаток JavaFX та налаштовує головний етап.
     * Він завантажує головний макет FXML, встановлює назву етапу, розмір та сцену.
     *
     * @param primaryStage Головний етап додатку JavaFX.
     * @throws Exception Якщо виникає помилка під час завантаження макета FXML.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Завантажуємо головний макет FXML
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));

        // Налаштовуємо головний етап
        primaryStage.setTitle("Соffee"); // Встановлюємо назву
        primaryStage.setResizable(false); // Вимикаємо можливість зміни розміру
        primaryStage.setWidth(1280); // Встановлюємо ширину
        primaryStage.setHeight(720); // Встановлюємо висоту
        primaryStage.setScene(new Scene(root)); // Встановлюємо сцену
        primaryStage.show(); // Показуємо головний етап
    }

    /**
     * Метод main є точкою входу до додатка.
     * Він запускає додаток JavaFX.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        launch(args); // Запускаємо додаток JavaFX
    }
}
