package org.lld.models;

public class Balance {
    private User fromUser;
    private User toUser;

    private Double amount;

    public Balance(User fromUser, User toUser, Double amount) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUserId(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUserId() {
        return toUser;
    }

    public void setToUserId(User toUser) {
        this.toUser = toUser;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
