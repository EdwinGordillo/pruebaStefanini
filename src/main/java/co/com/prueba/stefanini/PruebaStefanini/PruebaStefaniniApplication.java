package co.com.prueba.stefanini.PruebaStefanini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PruebaStefaniniApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaStefaniniApplication.class, args);
    }
}