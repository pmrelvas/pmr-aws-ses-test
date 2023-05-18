package pt.pmrelvas.pmrawssestestbackend.api.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.pmrelvas.pmrawssestestbackend.api.payloads.request.SendMessageApiRequestPayload;

@RestController
@RequestMapping("messages")
@Slf4j
public class MessageController {

    @PostMapping("/send")
    public void send(@Valid @RequestBody SendMessageApiRequestPayload sendMessageApiRequestPayload) {
        log.info("Send messages endpoint called with payload: {}", sendMessageApiRequestPayload.toString());
    }
}
