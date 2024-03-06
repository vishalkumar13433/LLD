package org.lld.service;

import org.lld.models.User;

import java.util.List;
import java.util.Map;

public interface IExpenseService {
    void addExpense(User paidBy, double amount, List<User> participants, Map<User, Double> shares, String splitStrategy);
}
