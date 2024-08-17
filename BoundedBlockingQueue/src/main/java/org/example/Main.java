package org.example;

import org.example.pubsub.Consumer;
import org.example.pubsub.Publisher;
import org.example.queue.BoundedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BoundedBlockingQueue queue = new BoundedBlockingQueue(5);

        Thread producerThread = new Thread(new Publisher(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

//        FOLLOW UPS:
//        1. Use semaphore
//        2. Add multiple consumer
//        3. add shutdown mechanism: Create a ShutdownSignal Class;
//        4. can we use executor service
//
//        1. Thread Safety and Synchronization
//          How does the use of Semaphore and ReentrantLock ensure thread safety in the BoundedBlockingQueue?
//          Why might we prefer using Semaphore over other synchronization mechanisms, such as synchronized blocks, in the queue implementation?
//          What are the potential pitfalls of not using proper synchronization in a producer-consumer scenario?
//        2. Queue Behavior During Shutdown
//          What happens to the items in the queue when the shutdown signal is received? How does the queue ensure that all items are processed before consumers exit?
//          How would the queue behave if one or more consumers are interrupted during shutdown? What steps should be taken to ensure that no items are lost or left unprocessed?
//          In what scenarios might you need to drain the queue before shutting down, and how would you implement that?
//        3. Extending the Queue Implementation
//          How would you modify the BoundedBlockingQueue to support priorities (e.g., a priority queue) while still maintaining thread safety?
//          What modifications would be necessary to support multiple producers in addition to multiple consumers, and how would that affect the queue's performance and synchronization?
//          If you wanted to implement a timeout mechanism for both producers (when enqueuing) and consumers (when dequeuing), how would you integrate that into the current implementation?
//        4. Performance Considerations
//          How might the performance of the BoundedBlockingQueue be affected as the number of consumers increases? What factors could lead to contention, and how might you address them?
//          What is the impact of the queue size (capacity) on the overall performance of the producer-consumer system? How would you determine an optimal capacity?
//           How would you measure and optimize the throughput of the queue under different workloads, such as bursty traffic or constant load?
//        5. Advanced Topics
//          How would you implement a mechanism to dynamically resize the queue capacity at runtime? What challenges would this introduce?
//          How would the introduction of backpressure mechanisms (where the producer slows down if the queue is full) affect the design and implementation of the queue?
//          What are the trade-offs between implementing a bounded blocking queue using an array-based approach versus a linked-list-based approach? How would this affect synchronization and performance?
//        6. Error Handling
//          How would you handle exceptions thrown by the producer or consumers during enqueueing or dequeueing? Should these exceptions trigger a shutdown, and if so, how would you implement that?
//          What strategies would you use to handle situations where a consumer is unable to process an item successfully? How would you retry, skip, or log such cases?
//          In a system where producers and consumers are distributed across different nodes or services, how would you handle network partitions or failures while maintaining the integrity of the queue?
        }
}