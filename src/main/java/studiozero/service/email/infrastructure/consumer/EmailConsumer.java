package studiozero.service.email.infrastructure.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import studiozero.service.email.application.usecases.SendDailyEmailUseCase;

@Component
public class EmailConsumer {
    private SendDailyEmailUseCase sendDailyEmailUseCase;

    public EmailConsumer(SendDailyEmailUseCase sendDailyEmailUseCase) {
        this.sendDailyEmailUseCase = sendDailyEmailUseCase;
    }

    @RabbitListener(queues = "${broker.daily-email-queue}")
    public void consumeEvent(ConsumeEmailEventDto eventDto) {
        sendDailyEmailUseCase.execute(eventDto);
    }
}
