/**
 * 
 */
package com.devpredator.tienda.session;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.devpredator.tienda.utils.CommonUtils;

/**
 * @author Axel
 * Clase q permite cerrar la sesion del usuario y refireccionar a la pantalla de login.
 */
@ManagedBean
@ViewScoped
public class SessionClosed {

	/**
	 * Metodo que permite cerrar la sesion del usuario.
	 */
	public void cerrarSesion() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			CommonUtils.redireccionar("/login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Oops!", "Hubo un problema al tratar de regresar al login.");
			e.printStackTrace();
		}
	}
}
