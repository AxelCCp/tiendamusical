/**
 * 
 */
package com.devpredator.tienda.utils;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author Axel
 * Clase generada para crear funciones globales o comunes entre clases de proyecto.
 * 
 */
public class CommonUtils {
	
	/**
	 * Con las funciones de jsf,  este metodo va a mostrar un mensaje a nivel del backend.
	 * @param severity {@link Severity} objeto q indica el tipo de mensaje a mostrar. 
	 * @param summary {@link String} titulo del mensaje.
	 * @param details {@link} detalle del mensaje.
	 */
	public static void mostrarMensaje(Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}
	
	/**
	 * Metodo q pertmite redireccionar entre pantallas del aplicativo.
	 * @param url {@link String} direccion o pantalla a cambiar.
	 * @throws IOException {@link IOException} exception en caso de error al encontrar la pagina.
	 */
	public static void redireccionar(String url) throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String contextPath = externalContext.getRequestContextPath();
		externalContext.redirect(contextPath + url);
	}

}
