package com.springcourse.spring_boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springcourse.spring_boot.model.Autor;
import com.springcourse.spring_boot.repository.AutorDAO;

@Service
public class AutorService implements IAutorService{

    
    private final AutorDAO dao;

    public AutorService(AutorDAO dao) {this.dao = dao;}
    
    @Override
    public List<Autor> traerAutores() {
        return dao.findAll();
    }
    @Override
    public Optional<Autor> buscaIdAutor(Long id) {
        return dao.findById(id);
    }
    @Override
    public Autor guardarAutor(Autor autor) {
        if (autor.getLibros() != null) {
            autor.getLibros().forEach(l -> l.setAutor(autor));
        }
        return dao.save(autor);
    }
    @Override
    public void eliminarAutor(Long id) {
        dao.deleteById(id);
    }
}
