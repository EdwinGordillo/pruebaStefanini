package co.com.prueba.stefanini.PruebaStefanini.controller;

import co.com.prueba.stefanini.PruebaStefanini.dto.*;
import co.com.prueba.stefanini.PruebaStefanini.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserMeDTO> getMe() {
        return ResponseEntity.ok(authService.getAuthenticatedUser());
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserMeDTO>> getAllUsers() {
        return ResponseEntity.ok(authService.getAllUsers());
    }
}