/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.devpredator.tiendamusicalentities.entities.Persona;

/**
 * @author Axel
 * Interfaz q realiza el crud con SpringJPA para la tabla de personas.
 */
public interface PersonaDao extends PagingAndSortingRepository<Persona, Long>{

	/**
	 * Metodo q permite consultar el usuario q trata de ingresar a sesion. 
	 * @param usuario  {@link String} usuario capturado por la persona.
	 * @param password {@link String} contrasena capturada por la persona.
	 * @return {@link Persona} objeto con la persona encontrada.
	 */
	@Query("select p from Persona p where p.usuario=?1 and p.password=?2")
	Persona findByUsuarioAndPassword(String usuario, String password);
	
}
