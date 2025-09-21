# 📚 Biblioteca API

[![Java](https://img.shields.io/badge/Java-17-red?logo=java)](https://www.oracle.com/java/)  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)  
[![Maven](https://img.shields.io/badge/Maven-3.9-blue?logo=apachemaven)](https://maven.apache.org/)  

API REST para gestionar una **biblioteca** con operaciones CRUD de **libros** y **autores**. Construida con **Java 17 + Spring Boot**, lista para expandirse con búsquedas avanzadas, préstamos y reservas.

---

## 🚀 Tecnologías

- Java 17  
- Spring Boot 3 (Web, Data JPA, Validation)  
- Hibernate  
- Maven  
- H2 Database (dev) / PostgreSQL (prod)  

---

## 📂 Estructura del proyecto

src/main/java/com/biblioteca/
├── controller # Endpoints REST
├── service # Interfaces y lógica de negocio
├── repository # Acceso a datos (JPA)
├── model # Entidades (Libro, Autor)
└── exception # Excepciones custom

## 📌 Endpoints principales

### Libros
- **GET** `/api/libros` → listar todos  
- **GET** `/api/libros/{id}` → buscar por id  
- **POST** `/api/libros` → guardar libro  
- **PUT** `/api/libros/{id}` → actualizar libro  
- **DELETE** `/api/libros/{id}` → eliminar libro  
- **GET** `/api/libros/{id}/existe` → comprobar existencia  

### Autores
- **GET** `/api/autores` → listar todos  
- **GET** `/api/autores/{id}` → buscar por id  
- **POST** `/api/autores` → guardar autor  
- **DELETE** `/api/autores/delete/{id}` → eliminar autor  

---

## 📝 Ejemplo de request

http
POST /api/libros
Content-Type: application/json

{
  "titulo": "Cien Años de Soledad",
  "editorial": "Sudamericana",
  "genero": "Novela",
  "fechaEdicion": "1967-05-30",
  "precio": 1500.0,
  "autor": { "id": 1 }
}

# Clonar el repo
git clone https://github.com/eliasguisolfo11/biblioteca-api.git
cd biblioteca-api

# Compilar y correr
mvn spring-boot:run
