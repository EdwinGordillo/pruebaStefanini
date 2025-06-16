package co.com.prueba.stefanini.PruebaStefanini.feign;

import co.com.prueba.stefanini.PruebaStefanini.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "authClient", url = "https://dummyjson.com")
public interface AuthClient {

    @PostMapping("/auth/login")
    LoginResponseDTO login(@RequestBody LoginRequestDTO request);

    @GetMapping("/auth/me")
    UserMeDTO getCurrentUser(@RequestHeader("Cookie") String accessToken);

    @GetMapping("/users")
    UsersWrapper getUsers(@RequestHeader("Cookie") String accessToken);
}