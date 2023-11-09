/**
 * 
 */
package com.devpredator.tiendamusicalservices.service;

import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDto;
import com.devpredator.tiendamusicalentities.entities.Carrito;
import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author Axel
 * Interfaz que define los metodos de logica de negocio para el carrito de compras.
 */
public interface CarritoService {
	
	/**
	 * Metodo que permite guardar los albums a comprar en el carrito de compras.
	 * @param artistaAlbumDto {@link ArtistaAlbumDto} obj con la informacion del album en el carrito.
	 * @param carrito {@link Carrito} obj con la informacion del carrito del usuario.
	 * @param cantidadAlbumSeleccionada {@link Integer} cantidad seleccionada del album por el usuario.
	 */
	CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDto artistaAlbumDto, Carrito carrito, int cantidadAlbumSeleccionada);

	/**
	 * Metodo que permite calcular el total de la compra.
	 * @param carrito {@link Carrito} obj con la informacion del carrito a calcular.
	 * @return {@link Float} total calculado.
	 */
	float calcularTotal(Carrito carrito);
	/**
	 * metodo que permite eliminar un album del carrito.
	 * @param carritoAlbum {@link eliminarAlbumCarrito} obj con el album del carrito a eliminar.
	 */
	void eliminarAlbumCarrito(CarritoAlbum carritoAlbum);
	
	/**
	 * Metodo que permite actualizar la cantidad del album a comprar en el carrito.
	 * @param carritoAlbum {@link CarritoAlbum} obj con el album a actualizar en el carrito.
	 * @param carrito {@link Carrito} carrito de compras del usuario.
	 */
	float actualizarAlbumCantidad(CarritoAlbum carritoAlbum, Carrito carrito);
}
