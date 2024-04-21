package org.lol.loltrial.repository;

import org.lol.loltrial.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Repository interface 예시 */
@Repository
public interface ExampleRepository extends JpaRepository<Example, Long> {
}
