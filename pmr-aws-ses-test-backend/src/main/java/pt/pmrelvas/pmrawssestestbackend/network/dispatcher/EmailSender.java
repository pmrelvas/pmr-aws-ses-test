package pt.pmrelvas.pmrawssestestbackend.network.dispatcher;

import jdk.jfr.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.pmrelvas.pmrawssestestbackend.domain.entities.Message;
import pt.pmrelvas.pmrawssestestbackend.domain.properties.AwsProperties;
import software.amazon.awssdk.auth.credentials.AnonymousCredentialsProvider;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.Body;
import software.amazon.awssdk.services.ses.model.Content;
import software.amazon.awssdk.services.ses.model.Destination;
import software.amazon.awssdk.services.ses.model.SendEmailRequest;

@Service
@Slf4j
public class EmailSender {

    private final SesClient sesClient;

    @Autowired
    public EmailSender(AwsProperties awsProperties) {
        AwsCredentials awsCredentials = AwsBasicCredentials.create(
                awsProperties.getAccessKeyId(), awsProperties.getSecretAccessKey());
        sesClient = SesClient.builder()
                .region(Region.of(awsProperties.getRegion()))
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .build();
    }
    public void send(Message message) {
        SendEmailRequest sendEmailRequest = SendEmailRequest.builder()
                .destination(Destination.builder()
                        .toAddresses(message.getDestination())
                        .build())
                .message(software.amazon.awssdk.services.ses.model.Message.builder()
                        .subject(Content.builder()
                                .data(message.getSubject())
                                .build())
                        .body(Body.builder()
                                .html(Content.builder()
                                        .data(message.getContent())
                                        .build())
                                .build())
                        .build())
                .source(message.getSender())
                .configurationSetName(message.getConfigurationSet())
                .build();

        log.info("Sending email to '{}'", message.getDestination());
        sesClient.sendEmail(sendEmailRequest);
    }
}
