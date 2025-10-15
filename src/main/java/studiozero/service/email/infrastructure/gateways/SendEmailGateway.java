package studiozero.service.email.infrastructure.gateways;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import studiozero.service.email.domain.repositories.SendEmailRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class SendEmailGateway implements SendEmailRepository {
    private final Logger log = LoggerFactory.getLogger(SendEmailGateway.class);
    private final JavaMailSender mailSender;

    public SendEmailGateway(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async("emailSenderTaskExecutor")
    @Override
    public void sendEmail(List<String> to, String subject, String body) {

        // ======= Realiza o envio de emails paralelamente ===== //
        to.parallelStream()
            .forEach(employee -> CompletableFuture.runAsync(() -> {
                try {
                    SimpleMailMessage message = new SimpleMailMessage();
                    message.setTo(employee);
                    message.setSubject(subject);
                    message.setText(body);
                    mailSender.send(message);
                    log.info("📧 Notification emails sent successfully to: {}", employee);
                } catch (MailException e) {
                    log.error("❌ Error trying to send emails to employees. Cause: {}", e.getMessage(), e);
                } catch (Exception e) {
                    log.error("❌ Unexpected error while executing scheduled email task: {}", e.getMessage(), e);
                }
            }));
    }
}
