package org.lld.service.impl;

import org.lld.models.Balance;
import org.lld.models.User;
import org.lld.service.IBalanceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceService implements IBalanceService {

    Map<User, Map<User, Double>> balances;

    public BalanceService() {
        this.balances = new HashMap<>();
    }

    public Map<User, Map<User, Double>> getBalances() {
        return balances;
    }

    public void setBalances(Map<User, Map<User, Double>> balances) {
        this.balances = balances;
    }

    @Override
    public void showBalances() {
        Map<User, Map<User, Double>> balances = this.getBalances();
        for (User user : balances.keySet()) {
            System.out.println("--------------------");
            showBalance(user);
            System.out.println("--------------------");
        }
    }

    @Override
    public void showBalance(User user) {
        String user1Name = user.getName();
        System.out.println("Balance sheet of " + user1Name);
        Map<User, Double> userBalances= balances.get(user);
        for (User u : userBalances.keySet()) {
            String user2Name = u.getName();
            double amount = userBalances.get(u);
            if (amount < 0) {
                System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
            } else if (amount > 0) {
                System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
            }
        }
        if (userBalances.keySet().isEmpty()) {
            System.out.println("ALL Settled Up");
        }
    }

    public void updateBalances(List<Balance> balances) {
        for (Balance balance : balances) {
            double amount = balance.getAmount();
            User user1 = balance.getFromUser();
            User user2 = balance.getToUserId();
            updateBalance( user1,  user2 ,  amount);
            updateBalance( user2,  user1 ,  -1 * amount);
        }
    }

    private void updateBalance(User user1, User user2 , double amount) {
        Map<User, Double> userBalances = this.getBalances().get(user1);
        if (userBalances.isEmpty()) {
            userBalances = new HashMap<>();
            userBalances.put(user2, amount);
            this.getBalances().put(user1, userBalances);
        }
        for (User user : userBalances.keySet()) {
            if (user == user2) {
                double settlementAmt = userBalances.get(user);
                userBalances.put(user, settlementAmt + amount);
            }
        }
    }
}
