package com.example.finanzasgrupo4.application.Customer.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerResource {
    //va lo que se va a poder manipular

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
