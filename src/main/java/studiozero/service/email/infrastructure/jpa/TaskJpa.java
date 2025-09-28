package studiozero.service.email.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import studiozero.service.email.domain.dtos.Task;
import studiozero.service.email.infrastructure.entities.TaskEntity;

import java.util.List;
import java.util.UUID;

public interface TaskJpa extends JpaRepository<TaskEntity, UUID> {

    @Query("SELECT t.title AS title, t.limitDate AS limitDate FROM TaskEntity t")
    List<Task> findAllTaskSummaries();

    @Query("SELECT t.title AS title, t.limitDate AS limitDate FROM TaskEntity t WHERE t.limitDate = :date")
    List<Task> findTasksByDate(java.time.LocalDate date);
}
