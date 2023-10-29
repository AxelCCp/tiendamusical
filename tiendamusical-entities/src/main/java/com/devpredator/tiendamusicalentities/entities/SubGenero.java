package com.devpredator.tiendamusicalentities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Fanta
 * Clase que representa subgeneros de musica
 */
@Entity
@Table(name="subGenero")
public class SubGenero extends Common{
	
	/**
	 * @return the idSubGenero
	 */
	public Long getIdSubGenero() {
		return idSubGenero;
	}

	/**
	 * @param idSubGenero the idSubGenero to set
	 */
	public void setIdSubGenero(Long idSubGenero) {
		this.idSubGenero = idSubGenero;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the genero
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idSubGenero")
	private Long idSubGenero;
	
	@Column(name="descripcion", length = 100, nullable = false)
	private String descripcion;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idGenero")
	private Genero genero;

}
