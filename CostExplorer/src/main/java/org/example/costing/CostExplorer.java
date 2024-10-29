package org.example.costing;

import org.example.entites.Product;
import org.example.entites.Subscription;
import org.example.users.Customer;

import java.util.List;
import java.util.Map;

public class CostExplorer implements ICostExplorer{
    Map<String, Product> productMap;

    public CostExplorer(Map<String, Product> productMap) {
        this.productMap = productMap;
    }

    @Override
    public float[] getMonthlyCostList(Customer customer) {
        float[] costs = new float[12];
        List<Subscription> subscriptions = customer.getSubscriptions();
        if (subscriptions.isEmpty()) {
            return costs;
        }
        for (Subscription subscription: subscriptions) {
            String startDate = subscription.getStartDate();
            String[] dateComponents = startDate.split("-");
            int month = Integer.parseInt(dateComponents[1]);
            for (int i=month; i<13;i++) {
                Product product = productMap.get(subscription.getProductId());
                costs[i-1] += product.getPricing().get(subscription.getPlanType());
            }
        }

        return costs;
    }

    @Override
    public Float getAnnualCostList(Customer customer) {
        float[] monthlyCosts = getMonthlyCostList(customer);
        float yearlyCost = 0f;
        for (float monthCost : monthlyCosts) {
            yearlyCost+=monthCost;
        }
        return yearlyCost;
    }
}
