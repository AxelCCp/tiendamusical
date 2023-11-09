/**
 * 
 */
package com.devpredator.tienda.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.devpredator.tienda.session.SessionBean;
import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDto;
import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;
import com.devpredator.tiendamusicalservices.service.CarritoService;

/**
 * @author Axel
 * Clase que controla el flujo de la pantalla de detalle.xhtml
 */
@ManagedBean
@ViewScoped
public class DetalleController {

	/**
	 * Inicializa la pantalla del detalle.
	 */
	@PostConstruct
	public void init() {
		this.cantidadAlbumSeleccionada = 1;
	}
	
	/**
	 * Metodo q permite agregar el album seleccionado por el usuario al carrito de compras.
	 * @param artistaAlbumDto {@link ArtistaAlbumDto} obj con el album seleccionado.
	 */
	public void agregarAlbumCarrito(ArtistaAlbumDto artistaAlbumDto) {
		
		LOGGER.info("Agregando album al carrito de compras..." + ", Cantidad " + this.cantidadAlbumSeleccionada);
		
		CarritoAlbum carritosAlbumAgregado = this.carritoServiceImpl.guardarAlbumsCarrito(artistaAlbumDto, this.sessionBean.getPersona().getCarrito(), cantidadAlbumSeleccionada);
		
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().add(carritosAlbumAgregado);
	}
	
	
	
	/**
	 * @return the cantidadAlbumSeleccionada
	 */
	public int getCantidadAlbumSeleccionada() {
		return cantidadAlbumSeleccionada;
	}

	/**
	 * @param cantidadAlbumSeleccionada the cantidadAlbumSeleccionada to set
	 */
	public void setCantidadAlbumSeleccionada(int cantidadAlbumSeleccionada) {
		this.cantidadAlbumSeleccionada = cantidadAlbumSeleccionada;
	}

	/**
	 * @return the carritoServiceImpl
	 */
	public CarritoService getCarritoServiceImpl() {
		return carritoServiceImpl;
	}

	/**
	 * @param carritoServiceImpl the carritoServiceImpl to set
	 */
	public void setCarritoServiceImpl(CarritoService carritoServiceImpl) {
		this.carritoServiceImpl = carritoServiceImpl;
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
	 * Cantidad del producto o album seleccionado.
	 */
	private int cantidadAlbumSeleccionada;
	/**
	 * Objeto q nos permite mostrar los mensajes de log en la consola o en un archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(DetalleController.class);
	/**
	 * Obj que contiene los metodos de la logica de negocio del carrito.
	 */
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;
	/**
	 * Obj que contiene la informacion del usuario en sesion.
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
}
