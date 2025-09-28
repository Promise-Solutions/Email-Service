package studiozero.service.email.infrastructure.configs.usecases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import studiozero.service.email.application.usecases.GetTasksUseCase;
import studiozero.service.email.infrastructure.gateways.TaskGateway;

@Configuration
public class GetTasksUseCaseConfig {

    @Bean
    public GetTasksUseCase getTasksUseCase(TaskGateway gateway) {
        return new GetTasksUseCase(gateway);
    }
}
