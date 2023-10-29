package com.devpredator.tienda.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.devpredator.tienda.session.SessionBean;
import com.devpredator.tienda.utils.CommonUtils;
import com.devpredator.tiendamusicalentities.entities.Persona;
import com.devpredator.tiendamusicalservices.service.LoginService;

/**
 * @author
 * Controlador q se encarga de la pantalla de login.xhml
 */

@ManagedBean
@ViewScoped																			//mantiene la informacion del controlador hasta q te cambies a otra pantalla.
public class LoginController {
	
	@PostConstruct
	public void init() {
		System.out.println("Inicializando login");
	}
	
	
	/**
	 * Metodo q permite a la persona ingresar a su pantalla de home
	 */
	public void ingresar() {
		
		Persona personaConsultada = this.loginService.consultarUsuarioLogin(this.usuario, this.password);	
		
		if(personaConsultada != null) {
			//CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_INFO, "¡EXITOSO!", "Bienvenido al Home :)");
			try {
				this.sessionBean.setPersona(personaConsultada);																					//almacena el usuario en la session.
				CommonUtils.redireccionar("/pages/commons/dashboard.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "¡Error!", "Formato incorrecto con en cual se ingresa a la pantalla deseada :(");
			}
		} else {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "¡Oops!", "Usuario y/o contraseña incorrectos :(");
		}
	}
	

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the loginService
	 */
	public LoginService getLoginService() {
		return loginService;
	}
	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	/**
	 * @return the sessionBean
	 */
	public SessionBean getSessionBean() {
		return sessionBean;
	}
	/**
	 * @param sessionBean the sessionBean to set
	 */
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}





	/**
	 * Usuario capturado por la persona
	 */
	private String usuario;
	/**
	 * Contraseña capturada por la persona.
	 */
	private String password;
	/**
	 * Propiedad de la logica de negocio inyectada con jsf y spring.
	 */
	@ManagedProperty("#{loginServiceImpl}")
	private LoginService loginService;
	
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
}
