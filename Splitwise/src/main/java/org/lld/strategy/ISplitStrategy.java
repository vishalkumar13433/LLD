package org.lld.strategy;

import org.lld.enums.SplitType;
import org.lld.models.Balance;
import org.lld.models.User;

import java.util.List;
import java.util.Map;

public interface ISplitStrategy {
    List<Balance> split(User paidBy, double amount, List<User> participants, Map<User, Double> shares);

    SplitType getSplitType();
}
