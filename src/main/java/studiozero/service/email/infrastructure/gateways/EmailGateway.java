package studiozero.service.email.infrastructure.gateways;

import org.springframework.stereotype.Repository;
import studiozero.service.email.domain.repositories.EmailRepository;
import studiozero.service.email.infrastructure.jpa.EmailJpa;

import java.util.List;

@Repository
public class EmailGateway implements EmailRepository {
    private final EmailJpa emailJpa;

    public EmailGateway(EmailJpa emailJpa) {
        this.emailJpa = emailJpa;
    }

    @Override
    public List<String> getEmailAddressList() {
        return null;
    }
}
