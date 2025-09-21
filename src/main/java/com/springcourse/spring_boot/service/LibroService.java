package com.springcourse.spring_boot.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.springcourse.spring_boot.model.Libros;
import com.springcourse.spring_boot.repository.LibroDAO;

@Service
public class LibroService implements ILibroService{

    private final LibroDAO dao;

    public LibroService(LibroDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Libros> traerLibros() {
        return dao.findAll();
    }
    @Override
    public Optional<Libros> buscaIdLibro(Long id){
        return dao.findById(id);
    }
    @Override
    public Libros guardarLibro(Libros libro){
        return dao.save(libro);
    }
    @Override
    public ResponseEntity<Object> eliminarLibro(Long id) {

        try {
            Optional<Libros> libroEliminar = dao.findById(id);
            if (libroEliminar.isPresent()) {
                dao.deleteById(id);
                //existe y se elimino correctamente
                return ResponseEntity.noContent().build();
            } else {
                //404 -> no existe o no se encontro
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            //error 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }
    @Override
    public Optional<Libros> actualizarLibro(Long id, Libros libroAct) {
        return dao.findById(id)
                .map(libroExistente -> {
                    libroExistente.setTitulo(libroAct.getTitulo());
                    libroExistente.setEditorial(libroAct.getEditorial());
                    libroExistente.setGenero(libroAct.getGenero());
                    libroExistente.setFechaEdicion(libroAct.getFechaEdicion());
                    libroExistente.setPrecio(libroAct.getPrecio());
                    libroExistente.setAutor(libroAct.getAutor());
                    return dao.save(libroExistente);
                });
                //.orElseThrow(() -> new ConfigDataResourceNotFoundException("El libro con el ID: " + id + " no fue encontrado."));
    }

    @Override
    public boolean existePorId(Long id) {
        return dao.existsById(id);
    }
/*
    @Override
    public Page<Libros> buscarPorTitulo(String titulo, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Libros> buscarPorAutor(String autor, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Libros> buscarPorGenero(String genero, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Libros> buscarPorEditorial(String editorial, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Libros> buscarPorRangoFechaEdicion(LocalDate desde, LocalDate hasta, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Libros> buscarPorRangoPrecio(BigDecimal min, BigDecimal max, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Libros> buscarTextoLibre(String query, Pageable pageable) {
        return null;
    }
*/
}
