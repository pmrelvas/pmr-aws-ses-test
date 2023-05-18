package pt.pmrelvas.pmrawssestestbackend.domain.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Message {

    private String sender;
    private String destination;
    private String content;
    private String subject;
    private String configurationSet;
}
