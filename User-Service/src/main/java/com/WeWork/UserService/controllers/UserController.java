package com.WeWork.UserService.controllers;

import com.WeWork.UserService.config.JwtTokenProvider;
import com.WeWork.UserService.dto.*;
import com.WeWork.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserService authService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/auth/login")
    public ResponseEntity<LoginUserResponse> authenticateUser(@RequestBody LoginUserRequest loginRequest) {

        LoginUserResponse response = authService.loginUser(loginRequest);
        if (response.getSuccess() != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }


    }
    @PostMapping("/auth/register")
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest registerRequest) {
        RegisterUserResponse response = authService.registerUser(registerRequest);
        if (response.getSuccess() != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping("/auth/validate")
    public String validateToke(@RequestParam("token") String token) {
        authService.validateToken(token);
        return "Token is valid";
    }
}
