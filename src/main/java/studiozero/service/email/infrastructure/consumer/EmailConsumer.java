package studiozero.service.email.infrastructure.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import studiozero.service.email.application.usecases.SendDailyEmailUseCase;

@Component
public class EmailConsumer {
    private final Logger log = LoggerFactory.getLogger(EmailConsumer.class);
    private SendDailyEmailUseCase sendDailyEmailUseCase;

    public EmailConsumer(SendDailyEmailUseCase sendDailyEmailUseCase) {
        this.sendDailyEmailUseCase = sendDailyEmailUseCase;
    }

    @RabbitListener(queues = "${broker.daily-email-queue}")
    public void consumeEvent(ConsumeEmailEventDto eventDto) {
        log.info("Evento recebido da fila");
        sendDailyEmailUseCase.execute(eventDto);
    }
}
