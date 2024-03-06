package org.lld.service;

import org.lld.models.Balance;
import org.lld.models.Expense;
import org.lld.models.User;

import java.util.List;

public interface IBalanceService {
    void showBalances();
    void showBalance(User user);

    void updateBalances(List<Balance> balances);
}
