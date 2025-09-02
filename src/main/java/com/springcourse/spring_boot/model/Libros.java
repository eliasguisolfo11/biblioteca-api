package com.springcourse.spring_boot.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String editorial;
    private String genero;
    private LocalDate fechaEdicion;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "autor_id") // Esto es clave para que Hibernate sepa cómo unir
    private Autor autor;
}
