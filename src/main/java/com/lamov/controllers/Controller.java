package com.lamov.controllers;

import com.lamov.Token.JwtCore;
import com.lamov.database.MyUser;
import com.lamov.repository.UserRepository;
import com.lamov.services.AppService;
import com.lamov.services.SigninRequest;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {
    private AppService service;
    private UserRepository repository;
    private AuthenticationManager authenticationManager;
    private JwtCore jwtCore;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody MyUser user) {
        if(repository.existsByLogin(user.getLogin())) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose another login"); }
        else if(repository.existsByEmail(user.getLogin())) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose another email"); }
        service.addUser(user);
        return ResponseEntity.ok("User is signed up");
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody SigninRequest signinRequest) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getLogin(), signinRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtCore.generateToken(authentication);
        return ResponseEntity.ok(jwt);
    }

    @GetMapping("/t1")
    public String t1() {
        return "hire me please";
    }
}
