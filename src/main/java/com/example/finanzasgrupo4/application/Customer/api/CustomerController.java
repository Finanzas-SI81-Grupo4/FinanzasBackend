package com.example.finanzasgrupo4.application.Customer.api;

import com.example.finanzasgrupo4.application.Customer.domain.service.CustomerService;
import com.example.finanzasgrupo4.application.Customer.mapping.CustomerMapper;
import com.example.finanzasgrupo4.application.Customer.resource.CreateCustomerResource;
import com.example.finanzasgrupo4.application.Customer.resource.CustomerResource;
import com.example.finanzasgrupo4.application.Customer.resource.UpdateCustomerResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper mapper;

    public CustomerController(CustomerService customerService, CustomerMapper mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }

    //funciona GET ALL

    @GetMapping
    public List<CustomerResource> getAllCustomers()
    {
        return mapper.modelList(customerService.getAll());
    }

    //funciona GET BY ID
    @GetMapping("{customerId}")
    public CustomerResource getCustomerById(@PathVariable Long customerId) {
        return mapper.toResource(customerService.getById(customerId));
    }
    //funciona GET BY USERNAME

    @GetMapping("username/{username}")
    public CustomerResource getCustomerByUserName(@PathVariable("username") String username) {
        return mapper.toResource(customerService.getByUsername(username));
    }

    // funciona GET BY EMAIL
    @GetMapping("email/{customerEmail}")
    public CustomerResource getInfoCustomerByEmail(@PathVariable("customerEmail") String customerEmail) {
        return mapper.toResource(customerService.getByEmail(customerEmail));
    }

    // funciona GET BY PASSWORD AND EMAIL
    @GetMapping("email&password/{customerEmail}/{customerPassword}")
    public CustomerResource getInfoCustomerByEmailAndPassword(@PathVariable("customerEmail") String customerEmail, @PathVariable("customerPassword") String customerPassword) {
        return mapper.toResource(customerService.getByEmailAndPassword(customerEmail,customerPassword));
    }

    //funciona POST
    @PostMapping
    public CustomerResource createCustomer(@RequestBody CreateCustomerResource resource){
        return mapper.toResource(customerService.create(mapper.toModel(resource)));
    }

    //funciona UPDATE
    @PutMapping("/{customerId}")
    public CustomerResource updateCustomer(@PathVariable Long customerId, @RequestBody UpdateCustomerResource resource) {
        return mapper.toResource(customerService.update(customerId, mapper.toModel(resource)));
    }

    //funciona DELETE
    @DeleteMapping("{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        return customerService.delete(customerId);
    }































}
