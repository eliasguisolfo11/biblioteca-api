package com.springcourse.spring_boot.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springcourse.spring_boot.model.Libros;
import com.springcourse.spring_boot.service.ILibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroController {


    private final ILibroService service;

    public LibroController(ILibroService service) {this.service = service;}

    @GetMapping
    public ResponseEntity<List<Libros>> listarTodos() {
        List<Libros> libros = service.traerLibros();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libros> buscaIdLibro(@PathVariable Long id) {
        return service.buscaIdLibro(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/existe/{id}")
    public ResponseEntity<Boolean> existePorId(@PathVariable Long id) {
        boolean existe = service.existePorId(id);
        return ResponseEntity.ok(existe);
    }
    @PostMapping
    public ResponseEntity<Libros>guardarLibro(@RequestBody Libros libro) {
        Libros nuevo = service.guardarLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @DeleteMapping
    public ResponseEntity<Object> eliminarLibro(@PathVariable Long id) {
        return service.eliminarLibro(id);
    }

    @PutMapping
    public ResponseEntity<Optional<Libros>> actualizarLibro(
            @PathVariable Long id,
            @RequestBody Libros libroActualizado) {

        Optional<Libros> libro = service.actualizarLibro(id, libroActualizado);
        return ResponseEntity.ok(libro); // 200
    }
}
