package com.example.finanzasgrupo4.shared.domain;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.util.Date;

public class AuditModel implements Serializable {
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updated_At",nullable = false,updatable = true)
    private Date updatedAt;
}
