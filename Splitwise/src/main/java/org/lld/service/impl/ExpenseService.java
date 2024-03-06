package org.lld.service.impl;

import org.lld.factory.SplitStrategyFactory;
import org.lld.models.Expense;
import org.lld.models.User;
import org.lld.service.IBalanceService;
import org.lld.service.IExpenseService;
import org.lld.strategy.ISplitStrategy;

import java.util.List;
import java.util.Map;

public class ExpenseService implements IExpenseService {

    SplitStrategyFactory splitStrategyFactory = new SplitStrategyFactory();
    IBalanceService balanceService = new BalanceService();

    @Override
    public void addExpense(User paidBy, double amount, List<User> participants, Map<User, Double> shares, String splitStrategy) {
        ISplitStrategy strategy = splitStrategyFactory.getStrategyByName(splitStrategy);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown Split Type");
        }
        Expense expense = new Expense(paidBy, amount, participants, shares, strategy);
        balanceService.updateBalances(expense.getBalances());
    }
}
