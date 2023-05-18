package pt.pmrelvas.pmrawssestestbackend.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.pmrelvas.pmrawssestestbackend.api.payloads.request.SendMessageApiRequestPayload;
import pt.pmrelvas.pmrawssestestbackend.domain.usecases.message.SendMessageUseCase;

@RestController
@RequestMapping("messages")
@Slf4j
@RequiredArgsConstructor
public class MessageController {

    private final SendMessageUseCase sendMessageUseCase;

    @PostMapping("/send")
    public void send(@Valid @RequestBody SendMessageApiRequestPayload sendMessageApiRequestPayload) {
        log.info("Send messages endpoint called with payload: {}", sendMessageApiRequestPayload.toString());
        sendMessageUseCase.execute(sendMessageApiRequestPayload.toMessage());
    }
}
