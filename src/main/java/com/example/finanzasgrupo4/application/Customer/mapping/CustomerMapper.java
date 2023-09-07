package com.example.finanzasgrupo4.application.Customer.mapping;

import com.example.finanzasgrupo4.application.Customer.domain.model.Customer;
import com.example.finanzasgrupo4.application.Customer.resource.CreateCustomerResource;
import com.example.finanzasgrupo4.application.Customer.resource.CustomerResource;
import com.example.finanzasgrupo4.application.Customer.resource.UpdateCustomerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import com.example.finanzasgrupo4.shared.mapping.*;

import java.io.Serializable;
import java.util.List;

public class CustomerMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public CustomerResource toResource(Customer model) { return mapper.map(model, CustomerResource.class); }

    public Customer toModel(CreateCustomerResource resource) { return mapper.map(resource, Customer.class); }

    public Customer toModel(UpdateCustomerResource resource) { return mapper.map(resource, Customer.class); }

    public Page<CustomerResource> modelListPage(List<Customer> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, CustomerResource.class), pageable, modelList.size());
    }

}
