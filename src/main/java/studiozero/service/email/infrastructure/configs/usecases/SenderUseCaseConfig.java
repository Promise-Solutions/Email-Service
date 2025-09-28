package studiozero.service.email.infrastructure.configs.usecases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import studiozero.service.email.application.usecases.SendUseCase;
import studiozero.service.email.infrastructure.gateways.SenderGateway;

@Configuration
public class SenderUseCaseConfig {

    @Bean
    public SendUseCase senderUseCase(SenderGateway gateway) {
        return new SendUseCase(gateway);
    }
}
