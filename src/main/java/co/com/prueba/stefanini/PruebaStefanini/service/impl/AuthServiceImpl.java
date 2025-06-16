package co.com.prueba.stefanini.PruebaStefanini.service.impl;

import co.com.prueba.stefanini.PruebaStefanini.dto.*;
import co.com.prueba.stefanini.PruebaStefanini.entity.LoginLog;
import co.com.prueba.stefanini.PruebaStefanini.feign.AuthClient;
import co.com.prueba.stefanini.PruebaStefanini.repository.LoginLogRepository;
import co.com.prueba.stefanini.PruebaStefanini.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthClient authClient;
    private final LoginLogRepository loginLogRepository;

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {
        LoginResponseDTO response = authClient.login(request);

        // Guardar login exitoso
        LoginLog log = LoginLog.builder()
                .username(response.getUsername())
                .loginTime(LocalDateTime.now())
                .accessToken(response.getAccessToken())
                .refreshToken(response.getRefreshToken())
                .build();

        loginLogRepository.save(log);

        return response;
    }

    @Override
    public UserMeDTO getAuthenticatedUser() {
        String token = getLatestAccessToken();
        return authClient.getCurrentUser("accessToken=" + token);
    }

    @Override
    public List<UserMeDTO> getAllUsers() {
        String token = getLatestAccessToken();
        return authClient.getUsers("accessToken=" + token).getUsers();
    }

    private String getLatestAccessToken() {
        return loginLogRepository.findTopByOrderByLoginTimeDesc()
                .map(LoginLog::getAccessToken)
                .orElseThrow(() -> new RuntimeException("No hay un accessToken funcional."));
    }
}