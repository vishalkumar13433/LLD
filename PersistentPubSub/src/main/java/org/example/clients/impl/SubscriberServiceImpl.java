package org.example.clients.impl;

import org.example.adminConsole.Broker;
import org.example.clients.SubscriberService;
import org.example.entity.Message;

import java.util.List;

public class SubscriberServiceImpl implements SubscriberService {

    private Integer defaultPollSize = 1;
    private Broker broker;
    @Override
    public void connectToBroker() throws Exception {
        if (broker != null) {
            System.out.println("Already connceted to broker");
            return;
        }
        broker = new Broker();
    }

    @Override
    public List<Message> pollMessages(String topicName, String subscriptionName, int count) throws Exception {
        return broker.poll(topicName, subscriptionName, count);
    }

    @Override
    public List<Message> pollMessages(String topicName, String subscriptionName) throws Exception{
        return broker.poll(topicName, subscriptionName, defaultPollSize);
    }
}
