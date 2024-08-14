package org.example.orders;

import org.example.enums.OrderStatus;

import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private String userId;
    private String restaurantId;
    private float amount;
    private OrderStatus status;

    private List<OrderItem> items;
    private String paymentId;

    public Order(String userId, String restaurantId, List<OrderItem> items) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.status = OrderStatus.PENDING;
        this.items = items;

        float amount = 0f;
        for (OrderItem item : items) {
            amount += item.getAmount() * item.getQuantity();
        }
        this.amount = amount;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
}
