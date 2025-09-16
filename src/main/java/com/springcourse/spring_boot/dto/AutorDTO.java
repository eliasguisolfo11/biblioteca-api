package com.springcourse.spring_boot.dto;

import com.springcourse.spring_boot.model.Autor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorDTO {

    private String nombre;
    private String apellido;
    private String telefono;

    public AutorDTO(Autor autordto) {
        this.nombre = autordto.getNombre();
        this.apellido = autordto.getApellido();
        this.telefono = autordto.getTelefono();
    }
}

