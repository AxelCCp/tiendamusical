/**
 * 
 */
package com.devpredator.tiendamusicalentities.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Axel
 * Clase que contiene los campos comunes de la base de datos q se pueden usar en varias tablas. Esta clase no puede se una entidad.
 */
@MappedSuperclass															//para compartir estos atributos entre entidades.
public class Common {
		
	/**
	 * @return the fechaCreacion
	 */
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the fechaActualizacion
	 */
	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}
	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	/**
	 * @return the estatus
	 */
	public Boolean getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	@Column(name="fechaCreacion", nullable = false)
	private LocalDateTime fechaCreacion;
	@Column(name="fechaModificacion", nullable = false)
	private LocalDateTime fechaActualizacion;
	@Column(name="estatus", nullable = false)
	private Boolean estatus;
}
