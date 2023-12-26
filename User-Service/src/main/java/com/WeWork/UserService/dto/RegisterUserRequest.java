package com.WeWork.UserService.dto;

import com.WeWork.UserService.models.Domain;
import com.WeWork.UserService.models.Role;
import jakarta.validation.constraints.Email;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String location;

    private Domain domain;

    private Role role;

    private String password;
    private String confirmPassword;

}
