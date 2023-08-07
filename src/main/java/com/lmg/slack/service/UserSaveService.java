package com.lmg.slack.service;

import com.lmg.slack.dto.UserRequest;
import com.lmg.slack.integrations.SlackIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSaveService {

    @Autowired
    private SlackIntegrationService slackIntegrationService;

    public void save(UserRequest userRequest) {
        //action to save new user

        //call slack integration api
        slackIntegrationService.sendMessage(messageUserCreated(userRequest));
    }

    private static String messageUserCreated(UserRequest userRequest) {
        return String.format(":wave: Hi, new user created, User: %s, CPF: %s",
                userRequest.getName(), userRequest.getCpf());
    }

}