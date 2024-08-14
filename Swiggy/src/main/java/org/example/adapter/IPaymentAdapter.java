package org.example.adapter;

import org.example.enums.PaymentStatus;

public interface IPaymentAdapter {
    void onPaymentCompletion(String orderId,String paymentId, PaymentStatus status);
}
