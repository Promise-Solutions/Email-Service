package studiozero.service.email.application.usecases;

import studiozero.service.email.domain.dtos.Subjob;
import studiozero.service.email.domain.repositories.SubJobRepository;

import java.util.List;

public class GetSubJobsUseCase {

    private SubJobRepository subJobRepository;

    public GetSubJobsUseCase(SubJobRepository subJobRepository) {
        this.subJobRepository = subJobRepository;
    }

    public List<Subjob> execute() {
        List<Subjob> subJobList = subJobRepository.getSubjobList();

        if (subJobList.isEmpty()) {
            throw new RuntimeException("No sub jobs found");
        }

        return subJobList;
    };
}
