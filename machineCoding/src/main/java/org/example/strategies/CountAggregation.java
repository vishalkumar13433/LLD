package org.example.strategies;

import org.example.dao.Metric;

import java.util.List;

public class CountAggregation implements IAggregationStrategy{
    @Override
    public long aggregate(List<Metric> metrics) {
        return 0;
    }
}
