package com.springcourse.spring_boot.repository;


import com.springcourse.spring_boot.model.Libro;

import com.springcourse.spring_boot.model.Libro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LibroDAO extends JpaRepository<Libro, Long> {

public interface LibroDAO extends JpaRepository<Libro, Long> {

}
