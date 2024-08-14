package org.example.clients;

import org.example.entity.MessageDTO;

public interface PublisherService {
    void publish(String topicName, MessageDTO message) throws Exception;

    void connectToBroker() throws Exception;
}
