package studiozero.service.email.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import studiozero.service.email.domain.dtos.Subjob;
import studiozero.service.email.infrastructure.entities.SubJobEntity;

import java.util.List;
import java.util.UUID;

public interface SubJobJpa extends JpaRepository<SubJobEntity, UUID> {

    @Query("SELECT sj.job.client.name AS clientName, sj.job.title AS jobName, sj.date AS date FROM SubJobEntity sj")
    List<Subjob> findAllSubJobSummaries();

    @Query("SELECT sj.job.client.name AS clientName, sj.job.title AS jobName, sj.date AS date FROM SubJobEntity sj WHERE sj.date = :date")
    List<Subjob> findSubJobsByDate(java.time.LocalDate date);
}
