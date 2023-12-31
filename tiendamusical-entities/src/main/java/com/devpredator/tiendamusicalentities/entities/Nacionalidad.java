package com.devpredator.tiendamusicalentities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Axel
 * Clase q representa entidades de nacionalidades donde surgieron los artistas.
 */
@Entity
@Table(name="nacionalidad")
public class Nacionalidad extends Common{
	
	/**
	 * @return the idNacionalidad
	 */
	public Long getIdNacionalidad() {
		return IdNacionalidad;
	}
	/**
	 * @param idNacionalidad the idNacionalidad to set
	 */
	public void setIdNacionalidad(Long idNacionalidad) {
		IdNacionalidad = idNacionalidad;
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
	 * @return the abreviacion
	 */
	public String getAbreviacion() {
		return abreviacion;
	}
	/**
	 * @param abreviacion the abreviacion to set
	 */
	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdNacionalidad")
	private Long IdNacionalidad;
	@Column(name="descripcion", length = 60, nullable = false)
	private String descripcion;
	@Column(name="abreviacion", length = 60, nullable = false)
	private String abreviacion;
	
}
