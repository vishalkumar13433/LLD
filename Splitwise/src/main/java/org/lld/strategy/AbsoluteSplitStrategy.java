package org.lld.strategy;

import org.lld.enums.SplitType;
import org.lld.models.Balance;
import org.lld.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AbsoluteSplitStrategy implements ISplitStrategy{

    private final SplitType splitType = SplitType.ABSOLUTE;
    @Override
    public List<Balance> split(User paidBy, double amount, List<User> participants, Map<User, Double> shares) {
        List<Balance> balances = new ArrayList<>();
        for (User user :  shares.keySet()) {
            if (user == paidBy) {
                continue;
            }
            Double eachShare = shares.get(user);
            Balance balance = new Balance(paidBy, user, eachShare);
            balances.add(balance);
        }
        return balances;
    }

    public SplitType getSplitType() {
        return splitType;
    }
}
