package org.lld.dto;

import org.lld.enums.Status;

import java.util.List;
import java.util.Map;

public class Order {
    String restaurantId;
    String customerId;
    Map<String, Integer> dishToQuantityMap;
    Status status;

    public Order(String restaurantId, String customerId, Map<String, Integer> dishToQuantityMap, Status status) {
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.dishToQuantityMap = dishToQuantityMap;
        this.status = status;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Map<String, Integer> getDishToQuantityMap() {
        return dishToQuantityMap;
    }

    public void setDishToQuantityMap(Map<String, Integer> dishToQuantityMap) {
        this.dishToQuantityMap = dishToQuantityMap;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
