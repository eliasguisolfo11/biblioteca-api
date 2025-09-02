package com.springcourse.spring_boot.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
    private Long id;
    private String nombre, apellido, telefono;
}
