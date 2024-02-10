package org.lld.services;

public interface LoggerInterface {
    void start(int processId);

    void end(int processId);

    void poll();
}
