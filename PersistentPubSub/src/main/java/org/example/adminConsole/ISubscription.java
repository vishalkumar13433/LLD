package org.example.adminConsole;

import org.example.entity.Message;

import java.util.List;

public interface ISubscription {
    void onMessage(Message message);
    List<Message> pollMessages(int msgCount);
}
