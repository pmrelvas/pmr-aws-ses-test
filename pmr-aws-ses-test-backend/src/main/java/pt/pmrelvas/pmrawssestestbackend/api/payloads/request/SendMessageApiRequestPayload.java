package pt.pmrelvas.pmrawssestestbackend.api.payloads.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import pt.pmrelvas.pmrawssestestbackend.domain.entities.Message;

@Data
@AllArgsConstructor
public class SendMessageApiRequestPayload {

    @NotBlank
    private String sender;
    @NotBlank
    private String destination;
    @NotBlank
    private String subject;
    @NotBlank
    private String htmlContent;
    private String configurationSet;

    public Message toMessage() {
        return Message.builder()
                .sender(sender)
                .destination(destination)
                .subject(subject)
                .content(htmlContent)
                .configurationSet(configurationSet)
                .build();
    }
}
