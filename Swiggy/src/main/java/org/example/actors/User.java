package org.example.actors;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String Address; // can be converted to Address object
    private float avgRating;

    public User(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        avgRating = 0;
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
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }


}
