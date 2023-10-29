/**
 * 
 */
package com.devpredator.tiendamusicalservices.service;

import com.devpredator.tiendamusicalentities.entities.Persona;

/**
 * @author Axel
 * Interfaz q realiza la lógica de negocio para el inicio de sesion de la persona.
 */
public interface LoginService {
	
	/**
	 * Metodo q permite consultar un usuario que trata de ingresar a sesion en la tienda musical.
	 * @param usuario {@link String} usuario capturado por la persona.
	 * @param password {@link} password capturado por la persona.
	 * @return {@link Persona} usuario encontrado en la BBDD.
	 */
	Persona consultarUsuarioLogin(String usuario, String password);

}
