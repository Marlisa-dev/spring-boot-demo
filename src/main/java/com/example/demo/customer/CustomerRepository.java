package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "TODO. Implement real db", "todo", "email@gmail.com")

        );
    }
}
