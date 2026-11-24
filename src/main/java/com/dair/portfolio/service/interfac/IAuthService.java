package com.dair.portfolio.service.interfac;

import com.dair.portfolio.dto.authDTO.AuthResponseDTO;
import com.dair.portfolio.dto.authDTO.LoginRequestDTO;
import com.dair.portfolio.dto.authDTO.RegisterRequestDTO;

public interface IAuthService {
    AuthResponseDTO login(LoginRequestDTO loginRequest);
    AuthResponseDTO register(RegisterRequestDTO registerRequest);
}
