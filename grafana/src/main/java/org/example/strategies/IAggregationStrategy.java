package org.example.strategies;

import org.example.dao.Metric;

import java.util.List;

public interface IAggregationStrategy {
    long aggregate(List<Metric> metrics);
}
