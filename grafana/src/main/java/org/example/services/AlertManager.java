package org.example.services;

import org.example.dao.Alert;

import java.util.ArrayList;
import java.util.List;

public class AlertManager {
    public List<Alert> alerts;

    public AlertManager() {
        alerts = new ArrayList<>();
    }

    public List<Alert> getActiveAlerts() {
        return alerts;
    }

    public void addAlert(Alert alert) {
        alert.setAlertId(alerts.size() + 1);
        alerts.add(alert);
    }

    public void updateAlert(int alertId, Alert updatedAlert) {
        for (Alert alert : alerts) {
            if (alert.alertId == alertId) {
                alert.threshold = updatedAlert.threshold;
                alert.range = updatedAlert.range;
            }
        }
    }

}
