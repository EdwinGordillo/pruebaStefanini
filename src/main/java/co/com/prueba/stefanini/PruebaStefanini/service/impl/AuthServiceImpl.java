package co.com.prueba.stefanini.PruebaStefanini.service.impl;

import co.com.prueba.stefanini.PruebaStefanini.dto.LoginRequestDTO;
import co.com.prueba.stefanini.PruebaStefanini.dto.LoginResponseDTO;
import co.com.prueba.stefanini.PruebaStefanini.dto.UserDTO;
import co.com.prueba.stefanini.PruebaStefanini.entity.LoginLog;
import co.com.prueba.stefanini.PruebaStefanini.feign.AuthClient;
import co.com.prueba.stefanini.PruebaStefanini.repository.LoginLogRepository;
import co.com.prueba.stefanini.PruebaStefanini.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthClient authClient;
    private final LoginLogRepository loginLogRepository;

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {
        LoginResponseDTO response = authClient.login(request);

        // Consulta del usuario autenticado (valida token)
        UserDTO user = authClient.getCurrentUser("accessToken=" + response.getAccessToken());

        // Guardar login exitoso
        LoginLog log = LoginLog.builder()
                .username(user.getUsername())
                .loginTime(LocalDateTime.now())
                .accessToken(response.getAccessToken())
                .refreshToken(response.getRefreshToken())
                .build();

        loginLogRepository.save(log);

        return response;
    }
}