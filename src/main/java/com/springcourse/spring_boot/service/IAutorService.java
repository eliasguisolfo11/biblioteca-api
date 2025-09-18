package com.springcourse.spring_boot.service;

import com.springcourse.spring_boot.model.Autor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IAutorService {

    List<Autor> traerAutores();
    Optional<Autor> buscaIdAutor(Long id);
    Autor guardarAutor(Autor autor);
    ResponseEntity<Object> eliminarAutor(Long id);

}
