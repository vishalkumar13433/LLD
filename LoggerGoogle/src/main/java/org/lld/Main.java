package org.lld;

import org.lld.services.LoggerInterface;
import org.lld.services.impl.LoggerImplementation;

public class Main {
    public static void main(String[] args) {
        LoggerInterface logger = new LoggerImplementation();
//        logger.start(1);
//        logger.poll();
//        logger.end(2);
//        logger.poll();
//        logger.end(1);
//        logger.poll();
//        logger.start(2);
//        logger.start(3);
//        logger.poll();
//        logger.end(3);
//        logger.poll();
//        logger.end(2);
//        logger.poll();

        logger.start(1);
        logger.poll();
        logger.start(3);
        logger.poll();
        logger.end(1);
        logger.poll();
        logger.start(2);
        logger.poll();
        logger.end(2);
        logger.poll();
        logger.end(3);
        logger.poll();
        logger.poll();
        logger.poll();
    }
}