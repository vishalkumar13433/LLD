package org.example.clients.impl;

import org.example.adminConsole.Broker;
import org.example.clients.PublisherService;
import org.example.entity.MessageDTO;

public class PublisherServiceImpl implements PublisherService {

    private Broker broker;

    @Override
    public void publish(String topicName, MessageDTO message) throws Exception {
        if (broker == null) {
            throw new IllegalStateException("need to connect to broker first");
        }
        broker.publishToTopic(topicName, message);
    }

    @Override
    public void connectToBroker() throws Exception {
        if (broker != null) {
            return;
        }
        broker = new Broker();
        System.out.println("connected successfully to broker");
    }
}
