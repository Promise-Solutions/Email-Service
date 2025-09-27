package studiozero.service.email.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import studiozero.service.email.domain.dtos.Subjob;

public interface SubJobJpa extends JpaRepository<Subjob, Long> {
}
