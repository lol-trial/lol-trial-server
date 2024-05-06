package org.lol.loltrial.repository;

import org.lol.loltrial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByName(String username);
    Optional<User> findByName(String username);
    Optional<User> findByEmail(String email);
}
