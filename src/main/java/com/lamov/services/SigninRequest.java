package com.lamov.services;

import lombok.Data;

@Data
public class SigninRequest {
    private String login;
    private String password;
}
