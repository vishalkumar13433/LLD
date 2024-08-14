package org.lld.dto;

public class Dish {
    String id;
    String dishName;
    Double price;
    Double rating;

    public Dish(String id, String dishName, Double price) {
        this.id = id;
        this.dishName = dishName;
        this.price = price;
        this.rating = 0d; //TODO:: implement rating logic in future
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
