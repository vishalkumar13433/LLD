package org.example.strategies;

import org.example.dao.Metric;

import java.util.List;

public class P50LatencyAggregation implements IAggregationStrategy{
    @Override
    public long aggregate(List<Metric> metrics) {
        long sum = 0l;
        for (Metric metric:  metrics) {
            sum += (long) metric.timeTaken;
        }

        return sum / metrics.size();
    }
}
