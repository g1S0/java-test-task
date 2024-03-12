package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "audit_log")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "action_time")
    private LocalDateTime actionTime;

    @Column(name = "username")
    private String username;

    @Column(name = "has_access")
    private Boolean hasAccess;

    @Column(name = "request_params")
    private String requestParams;
}
