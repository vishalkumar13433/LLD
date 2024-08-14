package org.example.actors;

import org.example.entities.FoodItem;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Restaurant {
    String id;
    String name;
    String address;
    Map<FoodItem, Integer> items;
    float avgRating;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.id = UUID.randomUUID().toString();
        this.avgRating = 0f;
        this.items = new HashMap<>();
    }

    public Map<FoodItem, Float> getMenu() {
        Map<FoodItem, Float> menu = new HashMap<>();
        for (FoodItem item : items.keySet()) {
            menu.put(item, item.getPrice());
        }

        return menu;
    }

    public void addItemToMenu(FoodItem item, int quantity){
        Integer currentQty = this.items.get(item);
        if (currentQty == null) {
            currentQty = 0;
        }
        this.items.put(item, currentQty + quantity);
    }

    public void reserveItem(FoodItem item, int qty) throws Exception{
        Integer quantity = this.items.get(item);
        if (quantity == null) {
            throw new Exception("Item not found");
        }
        if (qty > quantity) {
            throw new Exception("cannot fulfil order quantity");
        }

        items.put(item, quantity - qty);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }
}
