package org.example.entites;

import org.example.enumerations.PlanType;

import java.util.Map;

public class Product {
    String productName;
    Map<PlanType, Float> pricing;

    public Product() {
    }
    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public Map<PlanType, Float> getPricing() {
        return pricing;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPricing(Map<PlanType, Float> pricing) {
        this.pricing = pricing;
    }
}
