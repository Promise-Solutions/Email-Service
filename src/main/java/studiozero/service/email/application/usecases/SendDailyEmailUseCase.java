package studiozero.service.email.application.usecases;

import studiozero.service.email.domain.dtos.SubJob;
import studiozero.service.email.domain.dtos.Task;
import studiozero.service.email.domain.repositories.SendEmailRepository;
import studiozero.service.email.infrastructure.consumer.ConsumeEmailEventDto;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class SendDailyEmailUseCase {

    private SendEmailRepository sendEmailRepository;

    public SendDailyEmailUseCase(SendEmailRepository sendEmailRepository) {
        this.sendEmailRepository = sendEmailRepository;
    }

    public void execute(ConsumeEmailEventDto eventDto) {
        if(eventDto == null) {
            throw new IllegalArgumentException("Dados recebidos nulos");
        }

        if(eventDto.to() == null || eventDto.to().isEmpty()) {
            throw new IllegalArgumentException("Lista de destinatários vazia ou nula");
        }

        List<SubJob> subJobsToday = eventDto.subJobs() != null ? eventDto.subJobs() : Collections.emptyList() ;
        List<Task> tasksToday = eventDto.tasks() != null ? eventDto.tasks() : Collections.emptyList();

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
                content.append("- ").append(t.title()).append(" (Prazo: ").append(
                        t.limitDate() != null ? t.limitDate() : "Sem prazo")
                        .append(")\n");
            }
        }

        String subject = "StudioZero: Você tem deveres para hoje!";
        sendEmailRepository.sendEmail(eventDto.to(), subject, content.toString());
    };
}
