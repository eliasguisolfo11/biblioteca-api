package com.springcourse.spring_boot.controller;

import com.springcourse.spring_boot.model.Libro;
import com.springcourse.spring_boot.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private ILibroService libroServ;

    @GetMapping
    public ResponseEntity<List<Libro>> listarTodos() {
        List<Libro> libros = libroServ.traerLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }
}
