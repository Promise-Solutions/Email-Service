package studiozero.service.email.infrastructure.configs.usecases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import studiozero.service.email.application.usecases.SendDailyEmailUseCase;
import studiozero.service.email.infrastructure.gateways.SendEmailGateway;

@Configuration
public class SendDailyEmailUseCaseConfig {

    @Bean
    public SendDailyEmailUseCase sendUseCase(SendEmailGateway senderGateway) {
        return new SendDailyEmailUseCase(senderGateway);
    }
}
