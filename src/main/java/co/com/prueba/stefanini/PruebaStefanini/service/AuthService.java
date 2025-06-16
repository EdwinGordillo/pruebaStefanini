package co.com.prueba.stefanini.PruebaStefanini.service;

import co.com.prueba.stefanini.PruebaStefanini.dto.LoginRequestDTO;
import co.com.prueba.stefanini.PruebaStefanini.dto.LoginResponseDTO;
import co.com.prueba.stefanini.PruebaStefanini.dto.UserMeDTO;

import java.util.List;

public interface AuthService {

    LoginResponseDTO login(LoginRequestDTO request);

    UserMeDTO getAuthenticatedUser();

    List<UserMeDTO> getAllUsers();
}