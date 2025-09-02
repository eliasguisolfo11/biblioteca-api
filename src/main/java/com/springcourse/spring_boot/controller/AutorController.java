package com.springcourse.spring_boot.controller;

import com.springcourse.spring_boot.model.Autor;
import com.springcourse.spring_boot.service.AutorService;
import com.springcourse.spring_boot.service.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private IAutorService autorServ;

    @GetMapping
    public ResponseEntity<List<Autor>> listarTodos() {
        List<Autor> autores = autorServ.traerAutores();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }
}
