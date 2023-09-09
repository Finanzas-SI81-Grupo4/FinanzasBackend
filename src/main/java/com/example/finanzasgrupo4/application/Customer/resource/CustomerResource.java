package com.example.finanzasgrupo4.application.Customer.resource;

import lombok.*;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResource {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long identityDoc;
    private String username;
    private String password;
}
