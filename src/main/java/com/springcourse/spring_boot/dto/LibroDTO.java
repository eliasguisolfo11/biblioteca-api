package com.springcourse.spring_boot.dto;

import java.time.LocalDate;

import com.springcourse.spring_boot.model.Libros;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LibroDTO {


    private String titulo; 
    private String editorial;
    private String genero;
    private LocalDate fechaEdicion;
    private double precio;
    private AutorDTO autor;

    public LibroDTO(Libros lirodto) {
        this.autor = new AutorDTO(lirodto.getAutor());
        this.editorial = lirodto.getEditorial();
        this.fechaEdicion = lirodto.getFechaEdicion();
        this.genero = lirodto.getGenero();
        this.precio = lirodto.getPrecio();
        this.titulo = lirodto.getTitulo();
    }

}