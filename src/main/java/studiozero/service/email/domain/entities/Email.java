package studiozero.service.email.domain.entities;

import java.util.List;

public class Email {
    private List<String> to;
    private String subject;
    private String body;

    public Email(List<String> to, String subject, String body) {
        validateEmail();
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public Email() {
    }

    private void validateEmail() {
        if (to == null || to.isEmpty()) {
            throw new IllegalArgumentException("Recipient list cannot be null or empty");
        }
        if (subject == null || subject.isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be null or empty");
        }
        if (body == null || body.isEmpty()) {
            throw new IllegalArgumentException("Body cannot be null or empty");
        }
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
