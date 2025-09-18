package com.springcourse.spring_boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springcourse.spring_boot.model.Autor;
import com.springcourse.spring_boot.repository.AutorDAO;

@Service
public class AutorService implements IAutorService {


    private final AutorDAO dao;

    public AutorService(AutorDAO dao) {
        this.dao = dao;
    }

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
    public ResponseEntity<Object> eliminarAutor(Long id) {

        //REFACTORIZAR ESTO USANDO @ControllerAdvice Ppara mas prolijidad

        try {
            Optional<Autor> autorAEliminar = dao.findById(id);

            if (autorAEliminar.isPresent()) {
                dao.deleteById(id);

                //borrado exitoso, sin contenido -> 204
                return ResponseEntity.noContent().build();

            } else {

                //no se encontro al autor -> 404
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {

            //error interno del server -> 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
