package com.parquesoft.minegocio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parquesoft.minegocio.domain.Producto;
import com.parquesoft.minegocio.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	
	private final ProductoService productoService;
	
	public ProductoController(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}


	@GetMapping("listarProductos")
	public List<Producto> listarProductos() {
		return productoService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public Producto obtenerPorId(@PathVariable Long id) {
		return productoService.buscarPorId(id);
	}
	
	@PostMapping
	public Producto crear(@RequestBody Producto producto) {
		Producto creado = productoService.crear(producto);
		return creado;
	}
	
	@PutMapping("/{id}")
	public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
		return productoService.actualizar(id, producto);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		productoService.eliminar(id);
	}
}
