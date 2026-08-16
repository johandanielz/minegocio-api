package com.parquesoft.minegocio.service;

import java.util.List;

import com.parquesoft.minegocio.domain.Libro;

public interface LibroService {
	
	List<Libro> listarTodos();
	Libro buscarPorId(Long id);
	Libro crear(Libro libro);
	Libro actualizar(Long id, Libro libro);
	void eliminar(Long id);
	
}
