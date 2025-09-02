package com.springcourse.spring_boot.service;

import com.springcourse.spring_boot.model.Libro;
import com.springcourse.spring_boot.repository.LibroDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroDAO libroDAO;

    public List<Libro> traerLibros() {
        return libroDAO.findAll();
    }

    public Optional<Libro> buscaIdLibro(Long id){
        return libroDAO.findById(id);
    }

    public Libro guardarLibro(Libro libro){
        return (Libro) libroDAO.save(libro);
    }

    public void eliminarLibro(Long id) {
         libroDAO.deleteById(id);
    }
}
