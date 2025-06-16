# Prueba Técnica - Desarrollador(a) Java Spring Boot (Telefónica)

Este proyecto implementa una API REST en Java con Spring Boot 3.5 y Java 21, cumpliendo los requisitos de la prueba técnica para autenticación contra la API externa DummyJSON y registro de accesos exitosos en PostgreSQL.

---

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.5.0
- Spring Data JPA
- PostgreSQL
- OpenFeign
- Lombok
- JUnit 5

---

## Requisitos

- PostgreSQL instalado y en ejecución
- Crear una base de datos llamada `prueba_db`
- Java 21+
- Maven

---

## Configuración

Edita el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/prueba_db
spring.datasource.username=postgres
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
server.port=8080