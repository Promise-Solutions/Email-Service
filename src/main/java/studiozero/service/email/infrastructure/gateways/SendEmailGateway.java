package studiozero.service.email.infrastructure.gateways;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import studiozero.service.email.domain.repositories.SendEmailRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class SendEmailGateway implements SendEmailRepository {
    private final JavaMailSender mailSender;

    public SendEmailGateway(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async("emailSenderTaskExecutor")
    @Override
    public void sendEmail(List<String> to, String subject, String body) {
        to.parallelStream()
            .forEach(employee -> CompletableFuture.runAsync(() -> {
                try {
                    SimpleMailMessage message = new SimpleMailMessage();
                    message.setTo(employee);
                    message.setSubject(subject);
                    message.setText(body);
                    mailSender.send(message);
                } catch (Exception e) {
                    throw new RuntimeException("Erro ao enviar email ao " +employee+ " ERRO: " +e.getMessage());
                }
            }));
    }
}
