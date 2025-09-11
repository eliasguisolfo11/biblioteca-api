package com.springcourse.spring_boot.controller;

import com.springcourse.spring_boot.model.Autor;
import com.springcourse.spring_boot.service.IAutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/autores")
public class AutorController {


    private final IAutorService autorServ;

    public AutorController(IAutorService autorServ) { this.autorServ = autorServ;}

    @GetMapping
    public ResponseEntity<List<Autor>> listarTodos() {
        List<Autor> autores = autorServ.traerAutores();
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarAutorPorId(@PathVariable Long id) {
        return autorServ.buscaIdAutor(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Autor> guardarAutor(@RequestBody Autor autor) {
        Autor nuevo = autorServ.guardarAutor(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
    
}
