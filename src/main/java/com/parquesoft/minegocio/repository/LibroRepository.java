package com.parquesoft.minegocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parquesoft.minegocio.domain.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
