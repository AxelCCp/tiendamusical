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
import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;
import com.devpredator.tiendamusicalservices.service.CarritoService;

/**
 * @author Axel
 * Clase que se encarga de controllar el flujo de la pantalla del carrito de compras.
 */
@ManagedBean
@ViewScoped
public class CarritoController {

	/**
	 * inicializa la informacion de la pantalla del carrito.
	 */
	@PostConstruct
	public void init() {
		this.calcularTotal();
	}
	/**
	 * permite calcular el total de la compra con respecto a los albums en el carrito.
	 */
	public void calcularTotal() {
		LOGGER.info("Calculando el total");
		float total = this.carritoServiceImpl.calcularTotal(this.sessionBean.getPersona().getCarrito());
		this.sessionBean.setTotalCompra(total);
	}
	
	/**
	 * Metodo para eliminar el registro de albumCarrito de la BBDD. 
	 * Tambn elimina el obj albumCarrito de la session.
	 * finalmente recalcula el total.
	 * @param carritoAlbum {@link CarritoAlbum} recibe un obj CarritoAlbum a eliminar.
	 */
	public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
		LOGGER.info("Eliminando album " + carritoAlbum.getAlbum().getNombre() + " del carrito");
		this.carritoServiceImpl.eliminarAlbumCarrito(carritoAlbum);
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().remove(carritoAlbum);
		this.calcularTotal();
	}
	
	/**
	 * Metodo que permite actualizar la cantidad y los totales del album a comprar.
	 * @param carritoAlbum {@link CarritoAlbum} obj que contiene el album a actualizar y su cantidad.
	 */
	public void actualizarCantidadCarrito(CarritoAlbum carritoAlbum) {
		float totalCompra = this.carritoServiceImpl.actualizarAlbumCantidad(carritoAlbum, this.sessionBean.getPersona().getCarrito());
		this.sessionBean.setTotalCompra(totalCompra);
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
	 * Obj que contiene la informacion del usuario.
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	/**
	 * obj que realiza la logica de negocio para el carrito de compras.
	 */
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;
	/**
	 * Objeto q nos permite mostrar los mensajes de log en la consola o en un archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(CarritoController.class);
}
