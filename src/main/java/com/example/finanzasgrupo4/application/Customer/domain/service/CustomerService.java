package com.example.finanzasgrupo4.application.Customer.domain.service;

import com.example.finanzasgrupo4.application.Customer.domain.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getByEmailAndPassword(String username, String password);
    Customer getByUsername(String username);
    Customer getByEmail(String email);
    Customer getById(Long customerId);
    Customer create(Customer customer);
    Customer update(Long customerId, Customer request);
    ResponseEntity<?> delete(Long customerId);
}
