package studiozero.service.email.infrastructure.configs.usecases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import studiozero.service.email.application.usecases.GetSubJobsUseCase;
import studiozero.service.email.infrastructure.gateways.SubJobGateway;

@Configuration
public class GetSubJobsUseCaseConfig {

    @Bean
    public GetSubJobsUseCase getSubJobsUseCase(SubJobGateway gateway) {
        return new GetSubJobsUseCase(gateway);
    }
}
