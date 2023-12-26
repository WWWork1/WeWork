package com.WeWork.UserService.dto;

import lombok.*;

@Data
@Setter
@Getter

@NoArgsConstructor
public class JwtAuthenticationResponse {

    private String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }


}
