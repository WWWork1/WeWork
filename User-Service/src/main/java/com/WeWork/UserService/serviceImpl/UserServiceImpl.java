package com.WeWork.UserService.serviceImpl;

import com.WeWork.UserService.config.JwtTokenProvider;
import com.WeWork.UserService.dto.*;
import com.WeWork.UserService.models.User;
import com.WeWork.UserService.repository.UserRepository;
import com.WeWork.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        RegisterUserResponse registerUserResponse=new RegisterUserResponse();

        if(!registerUserRequest.getPassword().equals(registerUserRequest.getConfirmPassword())){
            registerUserResponse.setError("Passwords does not match");
            return registerUserResponse;
        }

        if(userRepository.findByEmail(registerUserRequest.getEmail()).isPresent()){
            registerUserResponse.setError("User with the email Already exists \n Please login ");
            return registerUserResponse;
        }

        User user=new User();
        user.setFirstName(registerUserRequest.getFirstName());
        user.setEmail(registerUserRequest.getEmail());
        user.setDomain(registerUserRequest.getDomain());
        user.setLastName(registerUserRequest.getLastName());
        user.setLocation(registerUserRequest.getLocation());
        user.setRole(registerUserRequest.getRole());
        user.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));

        User savedUser = userRepository.save(user);

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),registerUserRequest.getPassword()));
        String jwt;

        if (authenticate.isAuthenticated()) {
            jwt=  jwtTokenProvider.generateToken(user.getEmail());
        } else {
            throw new RuntimeException("invalid access");
        }

        registerUserResponse.setUserId(savedUser.getUserId());
        registerUserResponse.setSuccess("User registered successfully");
        registerUserResponse.setToken(jwt);

        return registerUserResponse;

    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest loginRequest) {
        LoginUserResponse loginUserResponse =new LoginUserResponse();
//        User user = userRepository.findByEmail(loginUserRequest.getEmail()).orElse(null);
//        if (user == null || !passwordEncoder.matches(loginUserRequest.getPassword(), user.getPassword())) {
//            // Invalid credentials
//            return new LoginUserResponse(null, null, "Invalid credentials", null);
//        }

        // Authentication successful, generate JWT token
//        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
//        String jwt = jwtTokenProvider.generateToken(user.getEmail());
//     System.out.println(jwt);
//        return new LoginUserResponse(user.getUserId(), "Login successful", null, jwt);
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        String jwt;
        if (authenticate.isAuthenticated()) {

            jwt=  jwtTokenProvider.generateToken(loginRequest.getEmail());
            loginUserResponse.setToken(jwt);
            loginUserResponse.setSuccess("Login Successful");
        } else {
            loginUserResponse.setError("Invalid Access");
            throw new RuntimeException("invalid access");
        }
        return loginUserResponse;
    }

    public void validateToken(String token) {
        jwtTokenProvider.validateToken(token);
    }

}
