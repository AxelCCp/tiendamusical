/**
 * 
 */
package com.devpredator.tienda.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.devpredator.tiendamusicalentities.entities.Persona;

/**
 * @author Axel
 * Clase que se encarga de almacenar y administrar la informacion del usuario en session.
 * Este bean se usara en el login controller.
 */
@ManagedBean
@SessionScoped														// con esta,  jsf automaticamente va a generar este bean cuando se ejecute por 1ra vez. al ejecutarse se va a mantener el bean en la session. se elimina al cerrar la session.
public class SessionBean {

	@PostConstruct
	public void init() {
		System.out.println("Creando session... ");
	}
	
		
	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}




	/**
	 * Objeto persona q se mantendrá en la session;
	 */
	private Persona persona;
}