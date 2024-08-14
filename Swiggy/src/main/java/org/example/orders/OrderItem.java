package org.example.orders;

import java.util.UUID;

public class OrderItem {
    private String id;
    private String menuItemId;
    private int quantity;

    private float amount;

    public OrderItem(String menuItemId, int quantity, float amount) {
        this.menuItemId = menuItemId;
        this.quantity = quantity;
        this.amount = amount;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(String menuItemId) {
        this.menuItemId = menuItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
