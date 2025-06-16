package co.com.prueba.stefanini.PruebaStefanini.repository;

import co.com.prueba.stefanini.PruebaStefanini.entity.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LoginLogRepository extends JpaRepository<LoginLog, UUID> {
    Optional<LoginLog> findTopByOrderByLoginTimeDesc();
}