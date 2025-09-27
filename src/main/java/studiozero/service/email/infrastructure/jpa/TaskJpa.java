package studiozero.service.email.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import studiozero.service.email.domain.dtos.Task;

public interface TaskJpa extends JpaRepository<Task, Long> {
}
