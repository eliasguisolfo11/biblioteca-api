package com.springcourse.spring_boot.service;

import com.springcourse.spring_boot.model.Autor;
import com.springcourse.spring_boot.repository.AutorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorDAO autorDAO;

    public List<Autor> traerAutores() {
        return autorDAO.findAll();
    }

    public Optional<Autor> buscaIdAutor(Long id) {
        return autorDAO.findById(id);
    }

    public Autor guardarAutor(Autor autor) {
        return (Autor) autorDAO.save(autor);
    }

    public void eliminarAutor(Long id) {
         autorDAO.deleteById(id);
    }
}
