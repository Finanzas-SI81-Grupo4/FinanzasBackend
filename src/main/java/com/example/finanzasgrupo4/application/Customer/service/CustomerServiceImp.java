package com.example.finanzasgrupo4.application.Customer.service;

import com.example.finanzasgrupo4.application.Customer.domain.model.Customer;
import com.example.finanzasgrupo4.application.Customer.domain.persistence.CustomerRepository;
import com.example.finanzasgrupo4.application.Customer.domain.service.CustomerService;
import com.example.finanzasgrupo4.shared.exception.ResourceNotFoundException;
import com.example.finanzasgrupo4.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImp implements CustomerService {
    private static final String ENTITY="Reward";
    private final CustomerRepository customerRepository;
    private final Validator validator;

    public CustomerServiceImp(CustomerRepository customerRepository, Validator validator){
        this.customerRepository=customerRepository;
        this.validator =validator;
    }
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getByEmailAndPassword(String email, String password) {
        return customerRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Customer getByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public Customer getByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Customer getById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(()->
                new ResourceNotFoundException(ENTITY,customerId));
    }

    @Override
    public Customer create(Customer customer) {
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Customer customerWithUsername = customerRepository.findByUsername(customer.getEmail());

        if (customerWithUsername != null)
            throw new ResourceValidationException(ENTITY,
                    "A customer with the same username already exists.");

        Customer customerWithEmail = customerRepository.findByEmail(customer.getEmail());

        if (customerWithEmail != null)
            throw new ResourceValidationException(ENTITY,
                    "A customer with the same email already exists.");

        Customer customerWithIdentityDoc = customerRepository.findByIdentityDoc(customer.getIdentityDoc());

        if (customerWithIdentityDoc != null)
            throw new ResourceValidationException(ENTITY,
                    "A customer with the same identity document number already exists.");

        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Long customerId, Customer request) {
        Set<ConstraintViolation<Customer>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return customerRepository.findById(customerId).map(customer ->
                        customerRepository.save(customer.withFirstName(request.getFirstName())
                                .withLastName(request.getLastName())
                                .withEmail(request.getEmail())
                                .withIdentityDoc(request.getIdentityDoc())
                                .withUsername(request.getUsername())
                                .withPassword(request.getPassword())
                                ))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, customerId));
    }

    @Override
    public ResponseEntity<?> delete(Long customerId) {
        return customerRepository.findById(customerId).map(
                customer -> {
                    customerRepository.delete(customer);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()->new ResourceNotFoundException(ENTITY,customerId));
    }
}
