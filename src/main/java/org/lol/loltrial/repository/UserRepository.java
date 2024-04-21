package org.lol.loltrial.repository;

import org.lol.loltrial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByName(String username);
    User findByName(String username);
}
