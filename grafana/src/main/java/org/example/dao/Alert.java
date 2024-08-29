package org.example.dao;

import org.example.enums.AggregationRange;
import org.example.enums.AggregationType;

public class Alert {

    public int alertId;
    public AggregationType metricType;
    public String source;
    public AggregationRange range;
    public float threshold;

    public int priority; //can be enum
    public String label;
    public String message;

    public void setAlertId(int i) {
        this.alertId = i;
    }

    public Alert(AggregationType metricType, String source, AggregationRange range, float threshold, int priority, String label) {
        this.metricType = metricType;
        this.source = source;
        this.range = range;
        this.threshold = threshold;
        this.priority = priority;
        this.label = label;
        this.message = message;
    }
}
