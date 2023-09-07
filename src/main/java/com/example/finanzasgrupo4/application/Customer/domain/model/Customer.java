package com.example.finanzasgrupo4.application.Customer.domain.model;

import com.example.finanzasgrupo4.shared.domain.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
