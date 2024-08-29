package org.example.services;

import org.example.dao.Alert;
import org.example.dao.Metric;
import org.example.enums.AggregationRange;
import org.example.enums.AggregationType;
import org.example.metrics.MetricCollector;
import org.example.strategies.IAggregationStrategy;
import org.example.strategies.P50LatencyAggregation;
import org.example.strategies.P99LatencyAggregation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlertingEngine {
    private final long coolOffPeriod;
    MetricCollector metricCollector;
    NotificationService notificationService;
    AlertManager alertManager;

    static AlertingEngine engineInstance;

    Map<AggregationType, IAggregationStrategy> typeToAggregationStrategy;

    public static synchronized AlertingEngine getInstance(long coolOffPeriod, MetricCollector metricCollector, NotificationService notificationService, AlertManager alertManager) {
        if (engineInstance == null) {
            engineInstance = new AlertingEngine(coolOffPeriod);
            engineInstance.metricCollector = metricCollector;
            engineInstance.notificationService = notificationService;
            engineInstance.alertManager = alertManager;

        }
        return engineInstance;
    }

    public AlertingEngine(long coolOffPeriod) {
        this.coolOffPeriod = coolOffPeriod;
        typeToAggregationStrategy = new HashMap<>();
        P99LatencyAggregation p99latencyAggregation = new P99LatencyAggregation();
        P50LatencyAggregation p50latencyAggregation = new P50LatencyAggregation();
        typeToAggregationStrategy.put(AggregationType.P99, p99latencyAggregation);
        typeToAggregationStrategy.put(AggregationType.P50, p50latencyAggregation);
        // can add other strategies also
    }

    private long fetchRangeFromType(AggregationRange range) {
        switch (range) {
            case M5: return 5 * 60;
            case H1: return 60 * 60;
            case D1: return 24 * 60 * 60;
        }
        return 0;
    }

    public void runAlerting() throws Exception {
        while (true) {
            List<Alert> alerts = alertManager.getActiveAlerts();
            for (Alert alert: alerts) {
                List<Metric> metrics = metricCollector.fetchMetricsWithTimeRange(alert.source, fetchRangeFromType(alert.range));
                long aggregate = getCurrentAggregation(metrics, alert.metricType);
                if (aggregate > alert.threshold) {
                    notificationService.notifyForAlert(alert.priority, alert.label, alert.message);
                }
            }
            Thread.currentThread().wait(coolOffPeriod);
        }
    }

    private long getCurrentAggregation(List<Metric> metrics, AggregationType metricType) throws Exception {
        IAggregationStrategy strategy =  typeToAggregationStrategy.get(metricType);
        if (strategy == null) {
            throw new Exception("invalid config");
        }
        return strategy.aggregate(metrics);
    }

}
