package studiozero.service.email.infrastructure.gateways;

import org.springframework.stereotype.Repository;
import studiozero.service.email.domain.dtos.Task;
import studiozero.service.email.domain.repositories.TaskRepository;
import studiozero.service.email.infrastructure.jpa.TaskJpa;

import java.util.List;

@Repository
public class TaskGateway implements TaskRepository {

    private final TaskJpa taskJpa;

    public TaskGateway(TaskJpa taskJpa) {
        this.taskJpa = taskJpa;
    }

    @Override
    public List<Task> getTaskList() {
        return null;
    }
}
