package com.springcourse.spring_boot.repository;

import com.springcourse.spring_boot.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorDAO extends JpaRepository<Autor, Long> {
}
