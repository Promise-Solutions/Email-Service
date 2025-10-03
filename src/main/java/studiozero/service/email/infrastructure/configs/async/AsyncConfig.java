package studiozero.service.email.infrastructure.configs.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {

    // ======= Config para eventos assíncronos de envio de emails
    @Bean("emailSenderTaskExecutor")
    public Executor emailSenderTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(35);
        executor.setThreadNamePrefix("email-");
        executor.initialize();
        return executor;
    }
}
