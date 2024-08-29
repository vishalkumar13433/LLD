package org.example.dao;

import org.example.enums.StatusCode;

public class Metric {
    public String source;
    public float timeTaken;
    public long time;

    public StatusCode statusCode;

    public Metric(String source, long time, float timeTaken, StatusCode statusCode) {
        this.source = source;
        this.timeTaken = timeTaken;
        this.time = time;
        this.statusCode = statusCode;
    }
}
