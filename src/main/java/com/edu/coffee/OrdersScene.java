package com.edu.coffee;

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
    public static String getOrderedItemsText() {
        StringBuilder orderedItemsText = new StringBuilder();
        for (Item item : orderedItems) {
            orderedItemsText.append(item.getName()).append("\n");
        }
        return orderedItemsText.toString();
    }
}

