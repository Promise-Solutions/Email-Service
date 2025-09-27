package studiozero.service.email.domain.dtos;

import java.time.LocalDate;

public record Task(
        String taskTitle,
        LocalDate limitDate
) {
}
