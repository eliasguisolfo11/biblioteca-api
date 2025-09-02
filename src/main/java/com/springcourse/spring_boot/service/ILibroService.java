package com.springcourse.spring_boot.service;

import com.springcourse.spring_boot.model.Autor;
import com.springcourse.spring_boot.model.Libro;

import java.util.List;
import java.util.Optional;

public interface ILibroService {
    List<Libro> traerLibros();
    Optional<Libro> buscaIdLibro(Long id);
    Libro guardarLibro(Libro libro);
    void eliminarLibro(Long id);
}
