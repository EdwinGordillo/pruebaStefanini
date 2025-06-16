package co.com.prueba.stefanini.PruebaStefanini.feign;

import co.com.prueba.stefanini.PruebaStefanini.dto.LoginRequestDTO;
import co.com.prueba.stefanini.PruebaStefanini.dto.LoginResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthClientLoginTest {

    @Mock
    private AuthClient authClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void login_shouldReturnCompleteUserInfo_whenCredentialsAreValid() {
        // Arrange
        LoginRequestDTO request = new LoginRequestDTO();
        request.setUsername("emilys");
        request.setPassword("emilyspass");

        LoginResponseDTO expectedResponse = new LoginResponseDTO();
        expectedResponse.setAccessToken("access-token-123");
        expectedResponse.setRefreshToken("refresh-token-456");
        expectedResponse.setId(1);
        expectedResponse.setUsername("emilys");
        expectedResponse.setEmail("emilys@example.com");
        expectedResponse.setFirstName("Emily");
        expectedResponse.setLastName("Smith");
        expectedResponse.setGender("female");
        expectedResponse.setImage("http://example.com/avatar.jpg");

        when(authClient.login(request)).thenReturn(expectedResponse);

        // Act
        LoginResponseDTO actualResponse = authClient.login(request);

        // Assert
        assertNotNull(actualResponse);
        assertEquals("access-token-123", actualResponse.getAccessToken());
        assertEquals("refresh-token-456", actualResponse.getRefreshToken());
        assertEquals(1, actualResponse.getId());
        assertEquals("emilys", actualResponse.getUsername());
        assertEquals("emilys@example.com", actualResponse.getEmail());
        assertEquals("Emily", actualResponse.getFirstName());
        assertEquals("Smith", actualResponse.getLastName());
        assertEquals("female", actualResponse.getGender());
        assertEquals("http://example.com/java.jpg", actualResponse.getImage());

        verify(authClient, times(1)).login(request);
    }
}