package co.com.prueba.stefanini.PruebaStefanini.service.impl;

import co.com.prueba.stefanini.PruebaStefanini.dto.LoginRequestDTO;
import co.com.prueba.stefanini.PruebaStefanini.dto.LoginResponseDTO;
import co.com.prueba.stefanini.PruebaStefanini.dto.UserDTO;
import co.com.prueba.stefanini.PruebaStefanini.entity.LoginLog;
import co.com.prueba.stefanini.PruebaStefanini.feign.AuthClient;
import co.com.prueba.stefanini.PruebaStefanini.repository.LoginLogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @InjectMocks
    private AuthServiceImpl authService;

    @Mock
    private AuthClient authClient;

    @Mock
    private LoginLogRepository loginLogRepository;

    private LoginRequestDTO loginRequest;
    private LoginResponseDTO loginResponse;
    private UserDTO user;

    @BeforeEach
    void setUp() {
        loginRequest = new LoginRequestDTO();
        loginRequest.setUsername("emilys");
        loginRequest.setPassword("emilyspass");

        loginResponse = new LoginResponseDTO();
        loginResponse.setId(1);
        loginResponse.setUsername("emilys");
        loginResponse.setEmail("emilys@mail.com");
        loginResponse.setAccessToken("access123");
        loginResponse.setRefreshToken("refresh123");

        user = new UserDTO();
        user.setId(1);
        user.setUsername("emilys");
        user.setEmail("emilys@mail.com");
    }

    @Test
    void login_ShouldReturnResponseAndSaveLog() {
        // Arrange
        when(authClient.login(loginRequest)).thenReturn(loginResponse);
        when(authClient.getCurrentUser("accessToken=access123")).thenReturn(user);

        // Act
        LoginResponseDTO result = authService.login(loginRequest);

        // Assert
        assertNotNull(result);
        assertEquals("emilys", result.getUsername());
        assertEquals("access123", result.getAccessToken());

        // Verifica que se haya guardado el login
        verify(loginLogRepository, times(1)).save(any(LoginLog.class));
    }
}