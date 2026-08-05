package com.parquesoft.minegocio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parquesoft.minegocio.domain.Producto;
import com.parquesoft.minegocio.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	private final ProductoRepository repo;
	
	public ProductoServiceImpl(ProductoRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Producto> listarTodos() {
		return repo.findAll();
	}

	@Override
	public Producto buscarPorId(Long id) {
		return repo.findById(id).orElseThrow( () -> new RuntimeException("Producto no encontrado") );
	}

	@Override
	public Producto crear(Producto producto) {
		// Validar
		return repo.save(producto);
	}

	@Override
	public Producto actualizar(Long id, Producto producto) {

		Producto productoExistente = buscarPorId(id);
		productoExistente.setNombre(producto.getNombre());
		productoExistente.setActivo(producto.isActivo());
		productoExistente.setCategoria(producto.getCategoria());
		productoExistente.setDescripcion(producto.getDescripcion());
		productoExistente.setFechaCreacion(producto.getFechaCreacion());
		productoExistente.setPrecio(producto.getPrecio());
		productoExistente.setStock(producto.getStock());
			  
		return repo.save(productoExistente);
	}

	@Override
	public void eliminar(Long id) {

		Producto producto = buscarPorId(id);
		repo.delete(producto);
	  
	}
	
}
