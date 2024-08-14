package org.lld.dto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Menu {
    List<Dish> dishes;
    Double avgPrice;

    public Menu(List<Dish> dishes) {
        this.dishes = dishes;
        avgPrice = 0d;
    }

    void removeDish(String dishId) {
        Optional<Dish> toBeRemovedDish = dishes.stream().filter(dish -> dish.getId().equals(dishId)).findAny();
        if (toBeRemovedDish.isPresent()) {
            dishes.remove(toBeRemovedDish.get());
            if (dishes.isEmpty()) {
                avgPrice = 0d;
            } else {
                avgPrice = (avgPrice * (dishes.size() + 1) + toBeRemovedDish.get().getPrice()) / dishes.size();
            }
        } else {
            throw new IllegalArgumentException("dish does not exist");
        }
    }

    String addDish(String dishName, double price) {
        String uuid = UUID.randomUUID().toString();
        Dish dish = new Dish(uuid, dishName, price);
        dishes.add(dish);
        if (dishes.size() == 1) {
            avgPrice = dish.price;
        } else {
            avgPrice = (avgPrice * (dishes.size() - 1) + dish.price) / dishes.size();
        }
        return uuid;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
