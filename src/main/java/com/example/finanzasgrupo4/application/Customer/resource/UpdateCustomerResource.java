package com.example.finanzasgrupo4.application.Customer.resource;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCustomerResource {
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotNull
    private Long identityDoc;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
