package co.com.prueba.stefanini.PruebaStefanini.service;

import co.com.prueba.stefanini.PruebaStefanini.dto.LoginRequestDTO;
import co.com.prueba.stefanini.PruebaStefanini.dto.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO request);
}