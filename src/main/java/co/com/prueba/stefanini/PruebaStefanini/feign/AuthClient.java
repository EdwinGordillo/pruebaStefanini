package co.com.prueba.stefanini.PruebaStefanini.feign;

import co.com.prueba.stefanini.PruebaStefanini.dto.LoginRequestDTO;
import co.com.prueba.stefanini.PruebaStefanini.dto.LoginResponseDTO;
import co.com.prueba.stefanini.PruebaStefanini.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "authClient", url = "https://dummyjson.com")
public interface AuthClient {

    @PostMapping("/auth/login")
    LoginResponseDTO login(@RequestBody LoginRequestDTO request);

    @GetMapping("/auth/me")
    UserDTO getCurrentUser(@RequestHeader("Cookie") String accessToken);
}