package com.WeWork.UserService.dto;

import jakarta.validation.constraints.Email;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRequest {
    private  String userName;
    @Email
    private String email;
    private String password;
}
