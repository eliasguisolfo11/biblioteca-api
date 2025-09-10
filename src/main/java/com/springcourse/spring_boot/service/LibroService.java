package com.springcourse.spring_boot.service;

import com.springcourse.spring_boot.model.Libros;
import com.springcourse.spring_boot.repository.LibroDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements ILibroService{

    @Autowired
    private LibroDAO libroDAO;

    @Override
    public List<Libros> traerLibros() {
        return libroDAO.findAll();
    }
    @Override
    public Optional<Libros> buscaIdLibro(Long id){
        return libroDAO.findById(id);
    }
    @Override
    public Libros guardarLibro(Libros libro){
        return (Libros) libroDAO.save(libro);
    }
    @Override
    public void eliminarLibro(Long id) {
         libroDAO.deleteById(id);
    }
}
