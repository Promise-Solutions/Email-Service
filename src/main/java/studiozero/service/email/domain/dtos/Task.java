package studiozero.service.email.domain.dtos;

import java.time.LocalDate;

public record Task(
        String title,
        LocalDate limitDate
) {
}
