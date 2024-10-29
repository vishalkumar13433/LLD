package org.example.entites;

import org.example.enumerations.PlanType;

public class Subscription {
    String productId;
    PlanType planType;
    String startDate;

    public Subscription(String productId, PlanType planType, String startDate) {
        this.productId = productId;
        this.planType = planType;
        this.startDate = startDate;
    }

    public Subscription() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public void setPlanType(PlanType planType) {
        this.planType = planType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
