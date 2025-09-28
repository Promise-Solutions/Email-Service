package studiozero.service.email.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import studiozero.service.email.infrastructure.entities.EmployeeEntity;

import java.util.List;
import java.util.UUID;

public interface EmailJpa extends JpaRepository<EmployeeEntity, UUID> {
    @Query("SELECT e.email FROM EmployeeEntity e WHERE e.active = true")
    List<String> findAllActiveEmails();
}
