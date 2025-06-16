package co.com.prueba.stefanini.PruebaStefanini.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponseDTO {
    private String accessToken;
    private String refreshToken;
    private int id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String image;
}