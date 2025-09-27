package studiozero.service.email.application.usecases;

import studiozero.service.email.domain.repositories.SenderRepository;

import java.util.List;

public class SendUseCase {

    private SenderRepository senderRepository;

    public SendUseCase(SenderRepository senderRepository) {
        this.senderRepository = senderRepository;
    }

    public void execute(List<String> to, String subject, String body) {
      senderRepository.sendEmail(to, subject, body);
    };
}
