package com.springcourse.spring_boot.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public ResponseEntity<Libros>guardarLibro(@RequestBody Libros libro) {
        Libros nuevo = service.guardarLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
}
