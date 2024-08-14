package org.example.services;

import org.example.adapter.IPaymentAdapter;
import org.example.enums.PaymentStatus;
import org.example.orders.Order;
import org.example.payments.Payment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class PaymentService {
    Map<String, Payment> payments;
    Map<String, IPaymentAdapter> upstreams;

    public PaymentService() {
        payments = new HashMap<>();
        upstreams = new HashMap<>();
    }

    public String initiatePayment(String orderId, float amount, IPaymentAdapter caller) {
        Payment newPayment = new Payment(orderId, amount);
        payments.put(newPayment.getId(), newPayment);
        upstreams.put(newPayment.getId(), caller);

        // mock async payment flow
        CompletableFuture.runAsync(() -> {
            try {
                Thread.currentThread().wait(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            paymentCompletion(newPayment.getId());
        });
        return newPayment.getId();
    }

    public void paymentCompletion(String paymentId) {
       Payment payment =  payments.get(paymentId);
       IPaymentAdapter upstream = upstreams.get(paymentId);
       upstream.onPaymentCompletion(payment.getOrderId(), payment.getId(), PaymentStatus.SUCCESS);
    }


    public Map<String, Payment> getPayments() {
        return payments;
    }

    public void setPayments(Map<String, Payment> payments) {
        this.payments = payments;
    }
}
