/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao.impl;

import com.devpredator.tiendamusicaldata.common.CommonDao;
import com.devpredator.tiendamusicaldata.dao.PersonaDao;
import com.devpredator.tiendamusicalentities.entities.Persona;

/**
 * @author Axel
 * Clase q implementta el crud generico y las funciones de la interfaz persona DAO.
 */
public class PersonaDaoImpl extends CommonDao<Persona, PersonaDao>{
	
	/**
	 * @author Axel
	 * Permite consultar una persona por su usuario y contrasena.
	 * @param usuario {@link String} usuario capturado por la persona.
	 * @param password {@link String} contrasena capturada por la persona.
	 * @return {@link Persona} persona consultada.
	 */
	public Persona findByUsuarioAndPassword(String usuario, String password) {
		return this.repository.findByUsuarioAndPassword(usuario, password);
	}
}
