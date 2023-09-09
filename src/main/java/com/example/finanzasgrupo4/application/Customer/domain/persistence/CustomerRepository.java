package com.example.finanzasgrupo4.application.Customer.domain.persistence;

import com.example.finanzasgrupo4.application.Customer.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAll();
    Customer findByUsername(String username);
    Customer findByEmail(String email);
    Customer findByIdentityDoc(Long identityDoc);
    //This help us with log in instead of jwt method :(
    Customer findByEmailAndPassword(String username, String password);


}
