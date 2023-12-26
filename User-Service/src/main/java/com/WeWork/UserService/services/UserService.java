package com.WeWork.UserService.services;

import com.WeWork.UserService.dto.LoginUserRequest;
import com.WeWork.UserService.dto.LoginUserResponse;
import com.WeWork.UserService.dto.RegisterUserRequest;
import com.WeWork.UserService.dto.RegisterUserResponse;

public interface UserService {

    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    public LoginUserResponse loginUser(LoginUserRequest loginUserRequest);

    public void validateToken(String token);
}
