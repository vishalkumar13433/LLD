Pub/Sub Queues
Implement a persistent pub-sub queue mechanism with guaranteed delivery of every published message for all the subscribed consumers in that subscribed topic in the same order.
Features:
    1. API to expose topics
    2. API for publisher to push messages against a topic
    3. API to subscribe and unsubscribe from topic
    4. API for subscriber to consume from topic
    5. Maintain the state of consumption of each message in each topic for each consumer.
    6. Maintain order of message consumption for each consumer.
    7. Handle cases of consumers not being available. What to do with those messages?
      (Write to disk and restore?)
    8. Filtered message consumption in a topic by the consumer
   
Plus Points:
   1. Separate service or component that is responsible for topics, including creation and
      exposing topics
   2. Writing messages to disk and restoring them back when the queue is full, due to
      consumer unavailability.
   3. Maintaining copies of messages for serving data faster.

SDE1 → Features #1-#4
SDE2 → SDE1 + Features #5-#6 SDE3 → SDE2 + Featyres #7-#8
Note: This problem will be good for SDE2 and SDE3 but very complex for SDE1. So, parking it for now