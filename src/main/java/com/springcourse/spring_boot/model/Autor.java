package com.springcourse.spring_boot.model;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Autor {
    @Id

    private Long id;
    private String nombre, apellido, telefono;
}
