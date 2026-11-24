package com.dair.portfolio.dto.authDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDTO {
    private String token;
    private String type;
    private Long id;
    private String username;
    private String email;
    private String role;
}
