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

import com.parquesoft.minegocio.domain.Libro;
import com.parquesoft.minegocio.service.LibroService;

@RestController
@RequestMapping("/api/libro")
public class LibroController {
	
	private final LibroService libroService;
	
	public LibroController(LibroService libroService) {
		super();
		this.libroService = libroService;
	}
	
	@GetMapping("listarLibros")
	public List<Libro> listarLibros() {
		return libroService.listarTodos();
	}
	
	
	@GetMapping("/{id}")
	public Libro obtenerPorId(@PathVariable Long id) {
		return libroService.buscarPorId(id);
	}
	
	@PostMapping
	public Libro crear(@RequestBody Libro libro) {
		Libro creado = libroService.crear(libro);
		return creado;
	}
	
	@PutMapping("/{id}")
	public Libro actualizar(@PathVariable Long id, @RequestBody Libro libro) {
		return libroService.actualizar(id, libro);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		libroService.eliminar(id);
	}
	
}
