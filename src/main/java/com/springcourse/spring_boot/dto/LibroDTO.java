package com.springcourse.spring_boot.dto;

import com.springcourse.spring_boot.model.Autor;
import com.springcourse.spring_boot.model.Libro;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LibroDTO {


    private String titulo, editorial, genero, fechaEdicion;
    private double precio;
    private AutorDTO autor;

    public LibroDTO(Libro p_libro) {
        AutorDTO autorDTO = new AutorDTO(p_libro.getAutor());
        this.editorial = p_libro.getEditorial();
        this.fechaEdicion = p_libro.getFechaEdicion();
        this.genero = p_libro.getGenero();
        this.precio = p_libro.getPrecio();
        this.titulo = p_libro.getTitulo();
    }
}
