package com.springcourse.spring_boot.service;

import com.springcourse.spring_boot.model.Libros;


import java.util.List;
import java.util.Optional;

public interface ILibroService {
    List<Libros> traerLibros();
    Optional<Libros> buscaIdLibro(Long id);
    Libros guardarLibro(Libros libro);
    void eliminarLibro(Long id);
}
