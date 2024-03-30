package com.edu.coffee;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Item {
    private static final String FILE_PATH = "/com/edu/coffee/complex_lunches.json";

    private String name;
    private long price;
    private String dishes;

    // Конструктор за замовчуванням
    public Item() {
        this.name = "";
        this.price = 0;
        this.dishes = "";
    }

    // Конструктор з параметрами
    public Item(String name, long price, String dishes) {
        this.name = name;
        this.price = price;
        this.dishes = dishes;
    }

    // Геттери та сеттери для атрибутів

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    // Метод для зчитування обідів з файлу
    public static List<Item> readMeals() {
        return readItems("meals");
    }

    // Метод для зчитування напоїв з файлу
    public static List<Item> readDrinks() {
        return readItems("drinks");
    }

    // Метод для зчитування обідів з файлу
    public static List<Item> readItems(String category) {
        List<Item> items = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            // Отримання потоку вводу до ресурсу JSON
            InputStream inputStream = Item.class.getResourceAsStream(FILE_PATH);

            // Перевірка, чи потік вводу не є нульовим
            if (inputStream != null) {
                // Зчитування JSON-файлу
                JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream));

                // Отримання масиву обідів з JSON-об'єкту
                JSONArray itemsArray = (JSONArray) jsonObject.get(category);

                // Перебір кожного об'єкту у масиві
                for (Object obj : itemsArray) {
                    JSONObject mealObject = (JSONObject) obj;
                    String name = (String) mealObject.get("name");
                    long price = (long) mealObject.get("price");
                    String dishes = (String) mealObject.get("dishes");
                    items.add(new Item(name, price, dishes));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    // Метод для запису нового обіду до файлу
    public static void writeItem(String name, long price, String dishes) {
        // Так само, останні три методи я залишив з минулого коду, але вони можуть бути реалізовані інакше
    }
}

