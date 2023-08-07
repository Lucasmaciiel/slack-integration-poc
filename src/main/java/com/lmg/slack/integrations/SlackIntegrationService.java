package com.lmg.slack.integrations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
@Slf4j
public class SlackIntegrationService {

    public static final String CHANNEL_ID = "C05L2CZ359V";

    @Value("${slack.token}")
    private String slackToken;

    public void sendMessage(@NotBlank String message) {
        try {
            Slack slack = Slack.getInstance();
            // Initialize an API Methods client with the given token
            MethodsClient methods = slack.methods(slackToken);

            // Build a request object
            ChatPostMessageRequest request = ChatPostMessageRequest.builder().channel(CHANNEL_ID).text(message).build();

            // Get a response as a Java object
            ChatPostMessageResponse response = methods.chatPostMessage(request);

            if (Objects.nonNull(response.getError())) {
                log.error(response.getError());
            }

        } catch (IOException | SlackApiException e) {
            log.debug(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}