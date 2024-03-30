package com.edu.coffee;

import javafx.scene.control.Label;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;

public class MenuScene {

    public static void setMenuLabelText(Label messageLabelLeft) {
        try {
            // Отримання потоку вводу до ресурсу JSON
            InputStream inputStream = MenuScene.class.getResourceAsStream("/com/edu/coffee/complex_lunches.json");

            // Перевірка, чи потік вводу не є нульовим
            if (inputStream != null) {
                // Парсер JSON
                JSONParser parser = new JSONParser();

                // Зчитування JSON-файлу
                JSONObject menuObject = (JSONObject) parser.parse(new InputStreamReader(inputStream));

                // Створення рядка для зберігання тексту для messageLabel
                StringBuilder message = new StringBuilder();

                // Отримання масиву об'єктів із JSON-об'єкту
                JSONArray menuArray = (JSONArray) menuObject.get("meals");

                // Перебір кожного об'єкту у масиві
                for (Object obj : menuArray) {
                    JSONObject menu = (JSONObject) obj;
                    String name = (String) menu.get("name");
                    String dishes = (String) menu.get("dishes");
                    long price = (long) menu.get("price");
                    message.append(name).append(": ").append(dishes).append(" - ").append(price).append(" грн\n");
                }

                // Встановлення тексту для messageLabel
                messageLabelLeft.setText(message.toString());
            } else {
                // Обробка ситуації, коли ресурс не знайдено
                System.err.println("Ресурс complex_lunches.json не знайдено.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
