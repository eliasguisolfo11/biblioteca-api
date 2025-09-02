package com.springcourse.spring_boot.repository;

import com.springcourse.spring_boot.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroDAO extends JpaRepository<Libros, Long> {
}
