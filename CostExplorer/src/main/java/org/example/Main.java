package org.example;

import org.example.costing.CostExplorer;
import org.example.costing.ICostExplorer;
import org.example.entites.Product;
import org.example.entites.Subscription;
import org.example.enumerations.PlanType;
import org.example.users.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Product product = new Product("Jira");
        Map<PlanType, Float> pricing = new HashMap<>();
        pricing.put(PlanType.BASIC, 9.99f);
        pricing.put(PlanType.STANDARD, 49.99f);
        pricing.put(PlanType.PREMIUM, 249.99f);
        product.setPricing(pricing);

        Product product2 = new Product("Opsgenie");
        Map<PlanType, Float> opsPricing = new HashMap<>();
        opsPricing.put(PlanType.BASIC, 19.99f);
        opsPricing.put(PlanType.STANDARD, 79.99f);
        opsPricing.put(PlanType.PREMIUM, 349.99f);
        product2.setPricing(opsPricing);

        List<Subscription> subscriptions = new ArrayList<>();
        subscriptions.add(new Subscription(product.getProductName(), PlanType.STANDARD, "2021-03-01"));
        subscriptions.add(new Subscription(product2.getProductName(), PlanType.BASIC, "2021-07-01"));
        Customer sharechat = new Customer(subscriptions);

        Map<String , Product> productMap = new HashMap<>();
        productMap.put(product.getProductName(), product);
        productMap.put(product2.getProductName(), product2);
        ICostExplorer costExplorer = new CostExplorer(productMap);
        float[] costs = costExplorer.getMonthlyCostList(sharechat);
        for (float cost : costs) {
            System.out.println(cost + ",");
        }
        System.out.println(costExplorer.getAnnualCostList(sharechat));
    }
}