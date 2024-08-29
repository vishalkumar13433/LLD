package org.example.services;

public interface INotifficationService {
    public void notifyForAlert(int priority, String label, String message) throws Exception;
}
