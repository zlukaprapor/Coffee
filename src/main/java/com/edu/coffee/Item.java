package com.edu.coffee;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас Item представляє об'єкт меню, який містить інформацію про назву, ціну та склад обіду або напою.
 */
public class Item {
    // Шлях до JSON-файлу, що містить інформацію про обіди та напої
    private static final String FILE_PATH = "/com/edu/coffee/complex_lunches.json";

    // Атрибути класу
    private String name;    // Назва об'єкту меню
    private long price;     // Ціна об'єкту меню
    private String dishes;  // Склад об'єкту меню

    // Конструктори класу

    /**
     * Конструктор за замовчуванням.
     */
    public Item() {
        this.name = "";
        this.price = 0;
        this.dishes = "";
    }

    /**
     * Конструктор з параметрами.
     *
     * @param name   назва об'єкту меню
     * @param price  ціна об'єкту меню
     * @param dishes склад об'єкту меню
     */
    public Item(String name, long price, String dishes) {
        this.name = name;
        this.price = price;
        this.dishes = dishes;
    }

    // Геттери та сеттери для атрибутів

    // Методи доступу до атрибутів

    /**
     * Метод для отримання назви об'єкту меню.
     *
     * @return назва об'єкту меню
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для встановлення назви об'єкту меню.
     *
     * @param name назва об'єкту меню
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод для отримання ціни об'єкту меню.
     *
     * @return ціна об'єкту меню
     */
    public long getPrice() {
        return price;
    }

    /**
     * Метод для встановлення ціни об'єкту меню.
     *
     * @param price ціна об'єкту меню
     */
    public void setPrice(long price) {
        this.price = price;
    }

    /**
     * Метод для отримання складу об'єкту меню.
     *
     * @return склад об'єкту меню
     */
    public String getDishes() {
        return dishes;
    }

    /**
     * Метод для встановлення складу об'єкту меню.
     *
     * @param dishes склад об'єкту меню
     */
    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    // Методи роботи з файлом JSON

    // Методи для зчитування об'єктів меню з файлу JSON

    /**
     * Метод для зчитування обідів з файлу JSON.
     *
     * @return список об'єктів меню - обіди
     */
    public static List<Item> readMeals() {
        return readItems("meals");
    }

    /**
     * Метод для зчитування напоїв з файлу JSON.
     *
     * @return список об'єктів меню - напої
     */
    public static List<Item> readDrinks() {
        return readItems("drinks");
    }

    // Приватні внутрішні методи

    // Метод для зчитування об'єктів меню з файлу JSON

    /**
     * Метод для зчитування об'єктів меню з файлу JSON за заданою категорією.
     *
     * @param category категорія об'єктів меню (наприклад, "meals" або "drinks")
     * @return список об'єктів меню заданої категорії
     */
    private static List<Item> readItems(String category) {
        List<Item> items = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            // Отримання потоку вводу до ресурсу JSON
            InputStream inputStream = Item.class.getResourceAsStream(FILE_PATH);

            // Перевірка, чи потік вводу не є нульовим
            if (inputStream != null) {
                // Зчитування JSON-файлу
                JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream));

                // Отримання масиву об'єктів меню з JSON-об'єкту за вказаною категорією
                JSONArray itemsArray = (JSONArray) jsonObject.get(category);

                // Перебір кожного об'єкту у масиві
                for (Object obj : itemsArray) {
                    JSONObject itemObject = (JSONObject) obj;
                    String name = (String) itemObject.get("name");
                    long price = (long) itemObject.get("price");
                    String dishes = (String) itemObject.get("dishes");
                    items.add(new Item(name, price, dishes));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    // Методи для запису нових об'єктів меню до файлу JSON

    // Тут можуть бути методи для запису нових об'єктів меню до файлу JSON,
    // але їх реалізація залежить від конкретних вимог і може бути виконана окремо.
}
