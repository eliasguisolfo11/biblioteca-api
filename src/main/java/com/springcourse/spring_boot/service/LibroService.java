package com.springcourse.spring_boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springcourse.spring_boot.model.Libros;
import com.springcourse.spring_boot.repository.AutorDAO;
import com.springcourse.spring_boot.repository.LibroDAO;

@Service
public class LibroService implements ILibroService{

    private final LibroDAO dao;
    private final AutorDAO autorDao;

    public LibroService(LibroDAO dao, AutorDAO autorDao) {
        this.dao = dao;
        this.autorDao = autorDao;
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
    public void eliminarLibro(Long id) {
        dao.deleteById(id);
    }
}
