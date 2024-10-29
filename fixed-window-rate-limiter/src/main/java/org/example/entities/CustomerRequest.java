package org.example.entities;
public class CustomerRequest {
    private int requests;
    private long windowStart;

    public CustomerRequest(int requests, long windowStart) {
        this.requests = requests;
        this.windowStart = windowStart;
    }

    public int getRequests() {
        return requests;
    }

    public void setRequests(int requests) {
        this.requests = requests;
    }

    public long getWindowStart() {
        return windowStart;
    }

    public void setWindowStart(long windowStart) {
        this.windowStart = windowStart;
    }
}