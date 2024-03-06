package org.lld.strategy;

import org.lld.enums.SplitType;
import org.lld.models.Balance;
import org.lld.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements ISplitStrategy{
    private final SplitType splitType = SplitType.EQUAL;
    @Override
    public List<Balance> split(User paidBy, double amount, List<User> participants, Map<User, Double> shares) {
        int divideAmong = participants.size();
        double eachShare = amount / divideAmong;
        List<Balance> balances = new ArrayList<>();
        for (int i=0;i<participants.size();i++) {
            User user = participants.get(i);
            if (user == paidBy) {
                continue;
            }
            Balance balance = new Balance(paidBy, user, eachShare);
            balances.add(balance);
        }
        return balances;
    }

    public SplitType getSplitType() {
        return splitType;
    }
}
