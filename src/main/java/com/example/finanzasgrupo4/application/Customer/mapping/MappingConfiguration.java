package com.example.finanzasgrupo4.application.Customer.mapping;

import org.springframework.context.annotation.Bean;

public class MappingConfiguration {
    @Bean
    public CustomerMapper productMapper(){
        return new CustomerMapper();
    }

}
