package com.parquesoft.minegocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parquesoft.minegocio.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
}
