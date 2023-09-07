package com.example.finanzasgrupo4.application.Customer.domain.service;

import com.example.finanzasgrupo4.application.Customer.domain.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getByUsernameAndPassword(String username, String password);
    Customer getByUsername(String username);
}
