package org.example.adminConsole;

import javafx.util.Pair;
import org.example.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class Subscription implements ISubscription {
    private String name;
    private Integer consumerOffset;
    private List<Message> messages;
    private Pair<String, String> filter;

    public Subscription(String name) {
        this.name = name;
        this.filter = null;
        this.consumerOffset = 0;
        this.messages = new ArrayList<>();
    }

    public Subscription(String name, Pair<String, String> filter) {
        this.name = name;
        this.filter = filter;
        this.consumerOffset = 0;
        this.messages = new ArrayList<>();
    }

    @Override
    public void onMessage(Message message) {
        if (this.filter != null) {
            if ("source".equals(this.filter.getKey()) && message.getSource().contains(this.filter.getValue())) {
                this.messages.add(message);
            }
        } else {
            this.messages.add(message);
        }
    }

    @Override

    public List<Message> pollMessages(int msgCount) {
        List<Message> msgs =  messages.subList(consumerOffset, Integer.max(consumerOffset+msgCount, messages.size() - 1));
        consumerOffset += msgs.size();
        return msgs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getConsumerOffset() {
        return consumerOffset;
    }

    public void setConsumerOffset(Integer consumerOffset) {
        this.consumerOffset = consumerOffset;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Pair<String, String> getFilter() {
        return filter;
    }

    public void setFilter(Pair<String, String> filter) {
        this.filter = filter;
    }
}
