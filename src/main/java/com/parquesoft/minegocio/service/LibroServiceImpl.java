package com.parquesoft.minegocio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parquesoft.minegocio.domain.Libro;
import com.parquesoft.minegocio.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{

	private final LibroRepository repo;
	
	public LibroServiceImpl(LibroRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public List<Libro> listarTodos() {
		return repo.findAll();
	}
	
	@Override
	public Libro buscarPorId(Long id) {
		return repo.findById(id).orElseThrow( () -> new RuntimeException("Libro no encontrado") );
	}
	
	@Override
	public Libro crear(Libro libro) {
		return repo.save(libro);
	}
	
	@Override
	public Libro actualizar(Long id, Libro libro) {
		Libro libroExiste = buscarPorId(id);
		libroExiste.setTitulo(libro.getTitulo());
		libroExiste.setAutor(libro.getAutor());
		libroExiste.setIsbn(libro.getIsbn());
		libroExiste.setAnioPublicacion(libro.getAnioPublicacion());
		libroExiste.setGenero(libro.getGenero());
		libroExiste.setDisponible(libro.isDisponible());
		libroExiste.setFechaRegistro(libro.getFechaRegistro());
		
		return repo.save(libroExiste);
	}
	
	@Override
	public void eliminar(Long id) {
		Libro libro = buscarPorId(id);
		repo.delete(libro);
	}
	
}
