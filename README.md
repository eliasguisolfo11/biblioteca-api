# biblioteca-api

Biblioteca API

API REST desarrollada en Java 17 con Spring Boot para la gestión de libros y autores en una biblioteca. Incluye operaciones CRUD, búsqueda y endpoints preparados para expandirse con préstamos y reservas.

Tecnologías

Java 17

Spring Boot 3

Spring Data JPA

Maven

H2 Database (dev) / PostgreSQL (prod)

Estructura del proyecto
src/main/java/com/biblioteca/
    ├── controller   # Controladores REST
    ├── service      # Interfaces y lógica de negocio
    ├── repository   # Acceso a datos (JPA)
    ├── model        # Entidades (Libro, Autor, etc.)
    └── exception    # Excepciones custom

Endpoints principales
Libros

GET /api/libros → listar todos

GET /api/libros/{id} → buscar por id

POST /api/libros → guardar libro

PUT /api/libros/{id} → actualizar libro

DELETE /api/libros/{id} → eliminar libro

GET /api/libros/{id}/existe → comprobar existencia

Autores

GET /api/autores → listar todos

GET /api/autores/{id} → buscar por id

POST /api/autores → guardar autor

DELETE /api/autores/delete/{id} → eliminar autor

Ejemplo de request
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

Ejecución local
# Clonar repo
git clone https://github.com/eliasguisolfo11/biblioteca-api.git
cd biblioteca-api

# Compilar y correr
mvn spring-boot:run
