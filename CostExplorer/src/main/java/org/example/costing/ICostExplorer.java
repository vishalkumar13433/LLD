package org.example.costing;

import org.example.users.Customer;

import java.util.List;

public interface ICostExplorer {
    float[] getMonthlyCostList(Customer customer);
    Float getAnnualCostList(Customer customer);

}
