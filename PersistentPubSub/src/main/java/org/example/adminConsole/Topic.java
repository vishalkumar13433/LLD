package org.example.adminConsole;

import org.example.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private String name;
    private List<Subscription> subscriptions;
    private List<Message> msgs; // in order to restore the topic

    public Topic(String name) {
        this.name = name;
        subscriptions = new ArrayList<>();
        msgs = new ArrayList<>();
    }

    public void publishMessage(Message msg) {
        this.msgs.add(msg);
        for (Subscription subscription: this.subscriptions) {
            subscription.onMessage(msg);
        }
    }

    public void removeSubscriber(Subscription subscriber) {
        subscriptions.remove(subscriber);
    }

    public void addSubscriber(Subscription subscriber) {
        subscriptions.add(subscriber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<Message> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Message> msgs) {
        this.msgs = msgs;
    }
}
