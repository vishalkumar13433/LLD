package org.lld.dto;

import java.util.Objects;

public class Process {
    private int processId;
    private long startTime;
    private long endTime;

    public Process(int processId, long startTime) {
        this.processId = processId;
        this.startTime = startTime;
        this.endTime = -1;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Process process = (Process) o;
        return processId == process.processId && startTime == process.startTime && endTime == process.endTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(processId, startTime, endTime);
    }
}
