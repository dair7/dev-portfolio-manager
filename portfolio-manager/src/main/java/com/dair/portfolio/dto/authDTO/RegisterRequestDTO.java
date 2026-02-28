package com.dair.portfolio.dto.authDTO;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String username;
    private String email;
    private String password;
    private String fullName;
}
