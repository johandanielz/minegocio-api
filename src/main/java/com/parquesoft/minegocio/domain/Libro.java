package com.parquesoft.minegocio.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 200)
	private String titulo;
	
	@Column(nullable =  false, length = 120)
	private String autor;
	
	@Column(length = 20)
	private String isbn;
	
	@Column(name = "anio_publicacion", nullable = true)
	private Integer anioPublicacion;
	
	@Column(nullable = true, length = 60)
	private String genero; 
	
	@Column(nullable = false)
	private boolean disponible;
	
	@Column(name = "fecha_registro", nullable = false, updatable = false, insertable = false)
	private LocalDateTime fechaRegistro;
	
}
