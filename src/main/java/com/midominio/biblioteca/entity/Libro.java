package com.midominio.biblioteca.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "libros")
public class Libro {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "id_libro")
	@NotEmpty
	@Size (min = 4, max = 10)
	private String idLibro;
	
	@NotEmpty
	@Size (min = 2, max = 50)
	private String titulo;
	
	@NotEmpty
	@Size (min = 2, max = 50)
	private String autor;
	
	@NotNull
	
	private int lanzamiento;
	
	@NotNull
	
	private int cantidad;
	
	@Column (name = "create_at")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate createAt;
	
	public Libro() {}
	
	@PrePersist
	public void prePersist() {
		createAt = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getLanzamiento() {
		return lanzamiento;
	}

	public void setLanzamiento(int lanzamiento) {
		this.lanzamiento = lanzamiento;
	}

	public String getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(String idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}


	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public LocalDate getCreateAt() {
		return createAt;
	}



	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}
	
	
	
	
}
