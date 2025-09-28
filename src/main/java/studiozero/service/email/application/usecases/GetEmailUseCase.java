package studiozero.service.email.application.usecases;

import studiozero.service.email.domain.repositories.EmailRepository;

import java.util.List;

public class GetEmailUseCase {

    private EmailRepository emailRepository;

    public GetEmailUseCase(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public List<String> execute() {
        List<String> emailList = emailRepository.getEmailAddressList();

        if (emailList.isEmpty()) {
            throw new RuntimeException("No email addresses found");
        }

        return emailList;
    };
}
