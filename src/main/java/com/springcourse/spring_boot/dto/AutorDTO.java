package com.springcourse.spring_boot.dto;

import com.springcourse.spring_boot.model.Autor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorDTO {

    private String nombre, apellido, telefono;

    public AutorDTO(Autor p_autor) {
        this.apellido = p_autor.getApellido();
        this.telefono = p_autor.getTelefono();
        this.nombre = p_autor.getNombre();
    }
}

