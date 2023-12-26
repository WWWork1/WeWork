package com.WeWork.UserService.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserResponse {

    private String success;
    private String error;

    private String token;
}
