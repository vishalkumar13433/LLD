package org.lld.services.impl;

import org.lld.dto.Process;
import org.lld.services.LoggerInterface;

import java.util.*;

public class LoggerImplementation implements LoggerInterface {
    private Map<Integer, Process> processMap;
    private Queue<Process> processQueue;

    public LoggerImplementation() {
        processMap = new HashMap<>();
        processQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getStartTime() == o2.getStartTime()) {
                if (o1.getProcessId() < o2.getProcessId()) {
                    return -1;
                } else if (o1.getProcessId() == o2.getProcessId()) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (o1.getStartTime() < o2.getStartTime()) {
                return -1;
            } else {
                return 1;
            }
        });
    }

    @Override
    public void start(int processId) {
        Process process = processMap.get(processId);
        if (process == null) {
            process = new Process(processId, System.nanoTime());
            processMap.put(processId, process);
            processQueue.add(process);
        } else {
            process.setStartTime(System.currentTimeMillis());
        }
    }

    @Override
    public void end(int processId) {
        Process process = processMap.get(processId);
        if (process == null) {
            System.out.println("No such process exist:" + processId);
            return;
        }
        process.setEndTime(System.nanoTime());
    }

    @Override
    public void poll() {
        if (processQueue.isEmpty()) {
            System.out.println("No Active Process!!");
            return;
        }
        Process process = processQueue.peek();
        if (process.getEndTime() == -1) {
            System.out.println("No Active Process!!");
            return;
        }
        process = processQueue.poll();
        System.out.println(process.getProcessId() + "-> started at:" + process.getStartTime() + " and ended at :" + process.getEndTime());
    }
}
