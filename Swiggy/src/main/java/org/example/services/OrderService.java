package org.example.services;

import org.example.actors.Restaurant;
import org.example.adapter.IPaymentAdapter;
import org.example.entities.FoodItem;
import org.example.enums.OrderStatus;
import org.example.enums.PaymentStatus;
import org.example.orders.Order;
import org.example.orders.OrderItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService implements IPaymentAdapter {
    Map<String, Order> orders;
    RestaurantService restaurantService;
    PaymentService paymentService;

    public OrderService(RestaurantService restaurantService, PaymentService paymentService) {
        this.restaurantService = restaurantService;
        this.paymentService = paymentService;
        this.orders = new HashMap<>();
    }

    @Override
    public void onPaymentCompletion(String orderId, String paymentId, PaymentStatus status) {
        Order order = orders.get(orderId);
        if (order == null) {
            return;
        }
        if (paymentId == null || !paymentId.equals(order.getPaymentId())){
            return;
        }

        if (status.equals(PaymentStatus.FAILED)) {
            order.setStatus(OrderStatus.CANCELLED);
        } else if (status.equals(PaymentStatus.SUCCESS)) {
            System.out.println("payment completed for order:" + orderId);
            // in case of delayed webhook delivery
            if (order.getStatus().equals(OrderStatus.PENDING)) {
                order.setStatus(OrderStatus.CONFIRMED);
            }
        }
        // Attach assign Partner Logic here
    }

    public String createOrder(String restaurantId, String userId, Map<FoodItem, Integer> items) {
        Order newOrder = new Order(userId, restaurantId, convertItemsToOrderItems(items));
        orders.put(newOrder.getId(), newOrder);
        try {
            restaurantService.reserveItems(restaurantId, items);
        } catch (Exception e) {
            newOrder.setStatus(OrderStatus.CANCELLED);
        }

        String paymentId = paymentService.initiatePayment(newOrder.getId(), newOrder.getAmount(), this); // passing this to mock the webhook behaviour
        newOrder.setPaymentId(paymentId);
        return newOrder.getId();
    }

    private List<OrderItem>  convertItemsToOrderItems(Map<FoodItem, Integer> items) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (FoodItem item : items.keySet()){
            orderItems.add(new OrderItem(item.getItemId(), items.get(item), item.getPrice()));
        }
        return orderItems;
    }
}
