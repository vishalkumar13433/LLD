package org.example.adminConsole;

import javafx.util.Pair;
import org.example.entity.Message;
import org.example.entity.MessageDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Broker {
    private Map<String, Topic> topics;

    public Broker(Map<String, Topic> topics) {
        this.topics = topics;
    }

    public Broker() {
    }

    public Map<String, Topic> getTopics() {
        return topics;
    }

    public void setTopics(Map<String, Topic> topics) {
        this.topics = topics;
    }

    public void addTopic(String topicName) throws Exception{
        if (topics.containsKey(topicName)) {
            throw new Exception("topic with the given name already exists!!");
        }
        Topic topic = new Topic(topicName);
        topics.put(topicName, topic);
    }

    public void deleteTopic(String topicName) throws Exception {
        if (!topics.containsKey(topicName)) {
            throw new Exception("topic does not exist!!");
        }
        topics.remove(topicName);
    }

    public String createSubscription(String topicName, String subscription, Pair<String, String> filter) throws Exception{
        if (!topics.containsKey(topicName)) {
            throw new Exception("topic does not exist!!");
        }
        Topic topic = topics.get(topicName);
        List<Subscription> subscriptions =  topic.getSubscriptions();
        Optional<Subscription> sub = subscriptions.stream().filter(subscription1 -> subscription1.getName().equals(subscription)).findFirst();
        if(sub.isPresent()){
            throw new Exception("subscription with this name already exists!!");
        }

        Subscription newSub = new Subscription(subscription);
        if (filter != null) {
            newSub.setFilter(filter);
        }
        return newSub.getName();
    }

    public void removeSubscription(String topicName, String subscription) throws Exception{
        if (!topics.containsKey(topicName)) {
            throw new Exception("topic does not exist!!");
        }
        Topic topic = topics.get(topicName);
        List<Subscription> subscriptions =  topic.getSubscriptions();
        Optional<Subscription> sub = subscriptions.stream().filter(subscription1 -> subscription1.getName().equals(subscription)).findFirst();
        if(!sub.isPresent()){
            throw new Exception("subscription with this name does not exists!!");
        }
        topic.removeSubscriber(sub.get());
    }

    public void publishToTopic(String topicName, MessageDTO message) throws Exception{
        if (!topics.containsKey(topicName)) {
            throw new Exception("topic does not exist!!");
        }
        Topic topic = topics.get(topicName);
        Message msg = new Message(message);
        topic.publishMessage(msg);
    }

    public List<Message> poll(String topicName, String subscriptionName, int pollCount) throws Exception{
        if (pollCount <= 0) {
            throw new Exception("pollCount should be positive integer");
        }
        if (!topics.containsKey(topicName)) {
            throw new Exception("topic does not exist!!");
        }
        Topic topic = topics.get(topicName);
        List<Subscription> subscriptions =  topic.getSubscriptions();
        Optional<Subscription> sub = subscriptions.stream().filter(subscription1 -> subscription1.getName().equals(subscriptionName)).findFirst();
        if(!sub.isPresent()){
            throw new Exception("subscription with this name does not exists!!");
        }

        return sub.get().pollMessages(pollCount);
    }
}
