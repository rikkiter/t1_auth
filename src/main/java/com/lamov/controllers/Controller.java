package com.lamov.controllers;

import com.lamov.database.MyUser;
import com.lamov.services.AppService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {
    private AppService service;

    @PostMapping("/sign-up")
    public String signUp(@RequestBody MyUser user) {
        service.addUser(user);
        return "User is signed up";
    }

    @GetMapping("/arina")
    public String arina() {
        return "love";
    }
}
