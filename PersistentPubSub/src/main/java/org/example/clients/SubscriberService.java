package org.example.clients;

import org.example.entity.Message;

import java.util.List;

public interface SubscriberService {

    void connectToBroker() throws Exception;
    List<Message> pollMessages(String topicName, String subscriptionName, int messages) throws Exception;
    List<Message> pollMessages(String topicName, String subscriptionName) throws Exception;

}
