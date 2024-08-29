package org.example.metrics;

import org.example.dao.Metric;

import java.util.*;

public class MetricCollector {
    public Map<String, List<Metric>> sourceMetrics;

    public MetricCollector() {
        sourceMetrics = new HashMap<>();
    }

    public List<Metric> fetchMetricsWithTimeRange(String source, long seconds) {
        List<Metric> q = sourceMetrics.get(source);
        long currentTime = System.currentTimeMillis();
        long prevTime = currentTime - (seconds * 1000L);
        List<Metric> rangeMetrics = new ArrayList<>();
        for (Metric m : q) {
            if (m.time >= prevTime) {
                rangeMetrics.add(m);
            }
        }
        return rangeMetrics;
    }

    public void insertMetrics(String source, List<Metric> metrics) {
        List<Metric> q = sourceMetrics.get(source);
        if (q == null) {
            q = new ArrayList<>();
        }
        q.addAll(metrics);
        sourceMetrics.put(source, q);
    }
}
