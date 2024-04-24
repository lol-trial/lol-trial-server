package org.lol.loltrial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    private String oauth_id;
    private String name;
    private String status;
    private String role;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime last_login;
}
