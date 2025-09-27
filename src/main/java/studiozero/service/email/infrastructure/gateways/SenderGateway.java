package studiozero.service.email.infrastructure.gateways;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import studiozero.service.email.domain.repositories.SenderRepository;

import java.util.List;

@Repository
public class SenderGateway implements SenderRepository {
    private final JavaMailSender mailSender;

    public SenderGateway(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(List<String> to, String subject, String body) {
        for (String employee : to) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(employee);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
        }
    }
}
