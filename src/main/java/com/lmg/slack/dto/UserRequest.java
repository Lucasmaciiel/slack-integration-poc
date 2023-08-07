package com.lmg.slack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "name cannot be null")
    private String name;

    @NotBlank(message = "name cannot be null")
    private String cpf;

    @Size(min = 4, max = 15)
    private String password;
}