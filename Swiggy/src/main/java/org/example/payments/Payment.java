package org.example.payments;

import org.example.enums.PaymentStatus;

import java.util.UUID;

public class Payment {
    private String id;
    private String orderId;
    private float amount;
    private PaymentStatus status;

    public Payment(String orderId, float amount) {
        this.orderId = orderId;
        this.amount = amount;
        this.id = UUID.randomUUID().toString();
        this.status = PaymentStatus.INITIATED;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
