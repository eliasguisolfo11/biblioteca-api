package com.springcourse.spring_boot.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    private Long id;
    private String titulo, editorial, genero, fechaEdicion;
    private double precio;
    private Autor autor;
}
