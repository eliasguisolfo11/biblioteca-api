package com.springcourse.spring_boot.controller;

import com.springcourse.spring_boot.model.Libros;
import com.springcourse.spring_boot.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {


    private final ILibroService libroServ;

    public LibroController(ILibroService libroServ) {this.libroServ = libroServ;}

    @GetMapping
    public ResponseEntity<List<Libros>> listarTodos() {
        List<Libros> libros = libroServ.traerLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libros> buscaIdLibro(@PathVariable Long id) {
        return libroServ.buscaIdLibro(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
