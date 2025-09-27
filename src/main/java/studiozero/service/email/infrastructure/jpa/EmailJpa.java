package studiozero.service.email.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailJpa extends JpaRepository<String, Long> {
}
