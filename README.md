# Prueba Técnica - Desarrollador Java Spring Boot (Telefónica)

Este proyecto implementa una API REST en Java usando Spring Boot 3.5 y Java 21, como solución a la prueba técnica propuesta por Telefónica.  
La aplicación consume un servicio externo de autenticación y almacena registros exitosos de login en una base de datos PostgreSQL.

## Funcionalidad

- Expone un endpoint `POST /api/auth/login`
- Autentica usuarios contra `https://dummyjson.com/auth/login`
- Si el login es exitoso, guarda el registro en una tabla `login_log` con los siguientes campos:
  - `username`
  - `access_token`
  - `refresh_token`
  - `login_time`

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.5.0
- Spring Data JPA
- OpenFeign
- PostgreSQL
- Lombok
- JUnit 5

## Requisitos

- Java 21+
- Maven
- Una base de datos PostgreSQL accesible (localhost o Supabase)
- Tabla `login_log`

## Configuración

Edita el archivo `src/main/resources/application.properties` con tu conexión real:

```properties
spring.datasource.url=jdbc:postgresql://<HOST>:5432/postgres?sslmode=require
spring.datasource.username=postgres
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

server.port=8080
```

## Probar con Postman
URL: http://localhost:8080/api/auth/login
Método: POST
Headers: Content-Type: application/json
Body (raw → JSON):
json
```{
  "username": "emilys",
  "password": "emilyspass"
}```