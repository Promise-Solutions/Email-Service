package studiozero.service.email.application.usecases;

import studiozero.service.email.domain.dtos.SubJob;
import studiozero.service.email.domain.dtos.Task;
import studiozero.service.email.domain.repositories.SendEmailRepository;
import studiozero.service.email.infrastructure.consumer.ConsumeEmailEventDto;

import java.util.List;

public class SendDailyEmailUseCase {

    private SendEmailRepository sendEmailRepository;

    public SendDailyEmailUseCase(SendEmailRepository sendEmailRepository) {
        this.sendEmailRepository = sendEmailRepository;
    }

    public void execute(ConsumeEmailEventDto eventDto) {
        List<SubJob> subJobsToday = eventDto.subJobs();
        List<Task> tasksToday = eventDto.tasks();

        StringBuilder content = new StringBuilder();
        content.append("Olá, aqui está suas tarefas e atendimentos do dia!.\n\n");
        if (!subJobsToday.isEmpty()) {
            content.append("Atendimentos para hoje:\n");
            for (SubJob sj : subJobsToday) {
                String clientName = sj.clientName() != null ? sj.clientName() : "Não informado";
                content.append("- ").append(sj.title()).append(" (Cliente: ").append(clientName).append(")\n");
            }
            content.append("\n");
        }
        if (!tasksToday.isEmpty()) {
            content.append("Tarefas para hoje:\n");
            for (Task t : tasksToday) {
                content.append("- ").append(t.title()).append(" (Prazo: ").append(t.limitDate()).append(")\n");
            }
        }

        String subject = "StudioZero: Você tem deveres para hoje!";
        sendEmailRepository.sendEmail(eventDto.to(), subject, content.toString());
    };
}
