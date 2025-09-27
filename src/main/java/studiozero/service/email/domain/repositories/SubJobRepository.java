package studiozero.service.email.domain.repositories;

import studiozero.service.email.domain.dtos.Subjob;

import java.util.List;

public interface SubJobRepository {
    List<Subjob> getSubjobList();

}
