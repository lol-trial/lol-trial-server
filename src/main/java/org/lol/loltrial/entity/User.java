package org.lol.loltrial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String auth_id;
    private String name;
    private String status;
    private String role;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime last_login;
}
