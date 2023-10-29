/**
 * 
 */
package com.devpredator.tiendamusicalservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpredator.tiendamusicaldata.dao.PersonaDao;
import com.devpredator.tiendamusicalentities.entities.Persona;
import com.devpredator.tiendamusicalservices.service.LoginService;

/**
 * @author Axel
 * Clase que implementa las funciones de negocio para la pantalla de login.
 */
@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public Persona consultarUsuarioLogin(String usuario, String password) {
		// TODO Auto-generated method stub
		return personaDao.findByUsuarioAndPassword(usuario, password);
	}

	
	
	@Autowired
	private PersonaDao personaDao;
}
