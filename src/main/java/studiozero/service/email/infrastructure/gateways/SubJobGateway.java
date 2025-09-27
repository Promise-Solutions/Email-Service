package studiozero.service.email.infrastructure.gateways;

import studiozero.service.email.domain.dtos.Subjob;
import studiozero.service.email.domain.repositories.SubJobRepository;
import studiozero.service.email.infrastructure.jpa.SubJobJpa;

import java.util.List;

public class SubJobGateway implements SubJobRepository {

    private final SubJobJpa subJobJpa;

    public SubJobGateway(SubJobJpa subJobJpa) {
        this.subJobJpa = subJobJpa;
    }

    @Override
    public List<Subjob> getSubjobList() {
        return null;
    }
}
