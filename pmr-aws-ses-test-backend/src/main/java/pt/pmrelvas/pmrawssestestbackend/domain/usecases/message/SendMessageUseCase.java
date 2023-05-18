package pt.pmrelvas.pmrawssestestbackend.domain.usecases.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pt.pmrelvas.pmrawssestestbackend.domain.entities.Message;
import pt.pmrelvas.pmrawssestestbackend.network.dispatcher.EmailSender;

@Component
@RequiredArgsConstructor
public class SendMessageUseCase {

    private final EmailSender emailSender;

    public void execute(Message message) {
        emailSender.send(message);
    }
}
