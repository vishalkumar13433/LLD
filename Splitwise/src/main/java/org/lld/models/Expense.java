package org.lld.models;

import org.lld.strategy.ISplitStrategy;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Expense {
    private String id;
    private String desc;
    private Double amount;
    private User paidBy;

    private long createdAt;

    private List<Balance> balances;

    public Expense(User paidBy, double amount, List<User> participants, Map<User, Double> shares, ISplitStrategy splitStrategy) {
        this.amount = amount;
        this.paidBy = paidBy;
        balances = splitStrategy.split(paidBy, amount, participants, shares);
        this.createdAt = System.currentTimeMillis();
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }
}
