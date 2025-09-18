package com.springcourse.spring_boot.controller;

import com.springcourse.spring_boot.model.Autor;
import com.springcourse.spring_boot.service.IAutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;



@RestController
@RequestMapping("/api/autores")
public class AutorController {


    private final IAutorService service;

    public AutorController(IAutorService service) { this.service = service;}

    @GetMapping
    public ResponseEntity<List<Autor>> listarTodos() {
        List<Autor> autores = service.traerAutores();
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarAutorPorId(@PathVariable Long id) {
        return service.buscaIdAutor(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Autor> guardarAutor(@RequestBody Autor autor) {
        Autor nuevo = service.guardarAutor(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarAutor(@PathVariable Long id) {
        return service.eliminarAutor(id);
    }
}
