package com.springcourse.spring_boot.service;

import com.springcourse.spring_boot.model.Libros;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ILibroService {

    //------------------------------------CRUD------------------------------------

    List<Libros> traerLibros();

    Optional<Libros> buscaIdLibro(Long id);

    Libros guardarLibro(Libros libro);

    Optional<Libros> actualizarLibro(Long id, Libros libroActualizado);

    ResponseEntity<Object> eliminarLibro(Long id);

    boolean existePorId(Long id);

    //------------------------------------BUSQUEDAS Y FILTROS------------------------------------
/*
    Page<Libros> buscarPorTitulo(String titulo, Pageable pageable);

    Page<Libros> buscarPorAutor(String autor, Pageable pageable);

    Page<Libros> buscarPorGenero(String genero, Pageable pageable);

    Page<Libros> buscarPorEditorial(String editorial, Pageable pageable);

    Page<Libros> buscarPorRangoFechaEdicion(LocalDate desde, LocalDate hasta, Pageable pageable);

    Page<Libros> buscarPorRangoPrecio(BigDecimal min, BigDecimal max, Pageable pageable);

    Page<Libros> buscarTextoLibre(String query, Pageable pageable);



*/
    //------------------------------------PRESTAMOS Y RESERVAS------------------------------------
}
