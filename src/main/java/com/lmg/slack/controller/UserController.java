package com.lmg.slack.controller;

import com.lmg.slack.dto.UserRequest;
import com.lmg.slack.service.UserSaveService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@Validated
public class UserController {

    @Autowired
    private UserSaveService userSaveService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid UserRequest userRequest) {
        userSaveService.save(userRequest);
    }
}
