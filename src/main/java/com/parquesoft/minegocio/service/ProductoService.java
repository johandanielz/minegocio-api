package com.parquesoft.minegocio.service;

import java.util.List;

import com.parquesoft.minegocio.domain.Producto;

public interface ProductoService {
	
	List<Producto> listarTodos();
	Producto buscarPorId(Long id);
	Producto crear(Producto producto);
	Producto actualizar(Long id, Producto producto);
	void eliminar(Long id);
	
}
