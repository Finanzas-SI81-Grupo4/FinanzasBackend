package com.example.finanzasgrupo4.application.Customer.domain.persistence;

import com.example.finanzasgrupo4.application.Customer.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAll();
    Customer findCustomerByUsername(String username);
    //This help us with log in instead of jwt method :(
    Customer findCustomerByUsernameAndPassword(String username, String password);


}
