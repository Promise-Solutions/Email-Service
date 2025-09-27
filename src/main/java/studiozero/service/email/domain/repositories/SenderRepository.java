package studiozero.service.email.domain.repositories;


import java.util.List;

public interface SenderRepository {
    void sendEmail(List<String> to, String subject, String body);
}
