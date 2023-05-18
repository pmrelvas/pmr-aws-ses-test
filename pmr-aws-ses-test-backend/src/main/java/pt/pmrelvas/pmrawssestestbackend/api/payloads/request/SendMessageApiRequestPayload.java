package pt.pmrelvas.pmrawssestestbackend.api.payloads.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

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
}
