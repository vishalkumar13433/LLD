package org.example.services;

import org.example.actors.Restaurant;
import org.example.entities.FoodItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestaurantService {
    private final Map<String, Restaurant> restaurants;

    public RestaurantService() {
        restaurants = new HashMap<>();
    }

    public String onboardRestaurant(String name, String address) {
        Restaurant restaurant = new Restaurant(name, address);
        restaurants.put(restaurant.getId(),restaurant);
        return restaurant.getId();
    }

    public void deboardRestaurant(String id) throws Exception{
        if (restaurants.get(id) == null) {
            throw new Exception("no restaurant found");
        }

        restaurants.remove(id);
    }

    public void addItemToMenu(String restaurantId, FoodItem item, int qty) throws Exception {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant == null) {
            throw new Exception("no restaurant found");
        }

        restaurant.addItemToMenu(item, qty);
    }

    public void reserveItems(String restaurantId, Map<FoodItem, Integer> items) throws Exception {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant == null) {
            throw new Exception("no restaurant found");
        }
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            restaurant.reserveItem(entry.getKey(), entry.getValue());
        }
    }

    public List<Restaurant> findRestaurantNearMe(String haralur) {
        List<Restaurant> res = new ArrayList<>();
        res.add(restaurants.entrySet().iterator().next().getValue());
        return res;
    }
}
