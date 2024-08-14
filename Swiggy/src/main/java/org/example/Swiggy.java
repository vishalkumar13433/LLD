package org.example;

import org.example.actors.Restaurant;
import org.example.actors.User;
import org.example.entities.FoodItem;
import org.example.services.OrderService;
import org.example.services.PaymentService;
import org.example.services.RestaurantService;
import org.example.services.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Swiggy {
    public static void main(String[] args) {
        UserService userService = new UserService();
        RestaurantService restaurantService = new RestaurantService();
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(restaurantService,paymentService);

        User user1 = userService.onboardUser("Vishal", "RBD");
        User user2 = userService.onboardUser("Tanuj", "RBD");

        String restaurant1 = restaurantService.onboardRestaurant("Punjabi Nukkad", "Haralur");
        String restaurant2 = restaurantService.onboardRestaurant("Singh da Pind", "Haralur");

        try {
            restaurantService.addItemToMenu(restaurant1, new FoodItem("Chicken Biryani" , 200), 2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            restaurantService.addItemToMenu(restaurant1, new FoodItem("Paneer Biryani" , 180), 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            restaurantService.addItemToMenu(restaurant2, new FoodItem("Chicken Biryani" , 100), 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            restaurantService.addItemToMenu(restaurant1, new FoodItem("Paneer Biryani" , 80), 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        List<Restaurant> restaurants = restaurantService.findRestaurantNearMe("haralur");

        Restaurant restaurant = restaurants.get(0);

        Map<FoodItem, Float> menu = restaurant.getMenu();
        FoodItem item =  menu.keySet().iterator().next();

        Map<FoodItem, Integer> orderMap = new HashMap<>();
        orderMap.put(item, 1);
        orderService.createOrder(restaurant.getId(), user1.getId(), orderMap);

    }
}