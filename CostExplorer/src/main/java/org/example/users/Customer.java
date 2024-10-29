package org.example.users;

import org.example.entites.Subscription;

import java.util.List;

public class Customer {
    List<Subscription> subscriptions;

    public Customer(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
