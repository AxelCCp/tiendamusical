/**
 * 
 */
package com.devpredator.tienda.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.devpredator.tienda.utils.CommonUtils;

/**
 * @author Axel
 * controlador q se encarga del flujo y acciones de la barra de navegacion
 */
@ManagedBean
@ViewScoped
public class NavbarController {
	
	/**
	 * inicializando la pantalla del carrito
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("inicializando pantalla carrito...");
	}
	
	/**
	 * metodo que permite redireccionar a la pantalla del carrito de compras.
	 */
	public void redireccionar() {
		try {
			CommonUtils.redireccionar("/pages/cliente/carrito.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Opps!", "Hubo un problema para ingresar a tu carrito...");
			e.printStackTrace();
		}
	}

	/**
	 * Objeto q nos permite mostrar los mensajes de log en la consola o en un archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(NavbarController.class);
}
