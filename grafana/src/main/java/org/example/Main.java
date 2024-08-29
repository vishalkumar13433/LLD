package org.example;

import org.example.dao.Alert;
import org.example.dao.Metric;
import org.example.enums.AggregationRange;
import org.example.enums.AggregationType;
import org.example.enums.StatusCode;
import org.example.metrics.MetricCollector;
import org.example.services.AlertManager;
import org.example.services.AlertingEngine;
import org.example.services.NotificationService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MetricCollector metricCollector = new MetricCollector();
        NotificationService notificationService = new NotificationService();
        AlertManager alertManager = new AlertManager();
        Alert alert = new Alert(AggregationType.P50, "/health", AggregationRange.M5, 100, 0, "service is unavailable");

        alertManager.addAlert(alert);

        List<Metric> metrics = new ArrayList<>();
        metrics.add(new Metric("/health", System.currentTimeMillis(), 101, StatusCode.SUCCESS));
        metrics.add(new Metric("/health", System.currentTimeMillis(), 201, StatusCode.SUCCESS));
        metrics.add(new Metric("/health", System.currentTimeMillis(), 91, StatusCode.SUCCESS));

        metricCollector.insertMetrics("/health", metrics);


        AlertingEngine alertingEngine = AlertingEngine.getInstance(2 * 60 * 1000, metricCollector, notificationService, alertManager);
        try {
            alertingEngine.runAlerting();
        } catch (Exception e) {
            System.out.println("error while running alert engine" +e.getMessage());
        }
    }
}