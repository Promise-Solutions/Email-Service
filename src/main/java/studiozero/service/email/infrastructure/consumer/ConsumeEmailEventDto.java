package studiozero.service.email.infrastructure.consumer;

import studiozero.service.email.domain.dtos.SubJob;
import studiozero.service.email.domain.dtos.Task;

import java.util.List;

public record ConsumeEmailEventDto(
        List<String> to,
        List<SubJob> subJobs,
        List<Task> tasks
) {
}
