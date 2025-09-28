package studiozero.service.email.application.usecases;

import studiozero.service.email.domain.dtos.Task;
import studiozero.service.email.domain.repositories.TaskRepository;

import java.util.List;

public class GetTasksUseCase {

    private TaskRepository taskRepository;

    public GetTasksUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> execute() {
        List<Task> taskList = taskRepository.getTaskList();

        if (taskList.isEmpty()){
            throw new RuntimeException("No tasks found");
        };

        return taskList;
    };
}
