package studiozero.service.email.domain.repositories;

import studiozero.service.email.domain.dtos.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> getTaskList();

}
