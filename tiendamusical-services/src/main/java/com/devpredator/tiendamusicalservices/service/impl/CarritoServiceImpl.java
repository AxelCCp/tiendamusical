package com.devpredator.tiendamusicalservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpredator.tiendamusicaldata.dao.CarritoAlbumDao;
import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDto;
import com.devpredator.tiendamusicalentities.entities.Carrito;
import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;
import com.devpredator.tiendamusicalservices.service.CarritoService;

/**
 * @author Axel
 * Clase que implementa los metodos de la logica de negocio de carrito service para el carrito de compras
 */
@Service
public class CarritoServiceImpl implements CarritoService{

	
	@Override
	public CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDto artistaAlbumDto, Carrito carrito, int cantidadAlbumSeleccionada) {
		// TODO Auto-generated method stub
		CarritoAlbum carritoAlbum = new CarritoAlbum();
		carritoAlbum.setAlbum(artistaAlbumDto.getAlbum());
		carritoAlbum.setCarrito(carrito);
		carritoAlbum.setCantidad(cantidadAlbumSeleccionada);
		carritoAlbum.setEstatus("PENDIENTE");
		this.carritoAlbumDao.save(carritoAlbum);
		return carritoAlbum;
	}

	
	@Override
	public float calcularTotal(Carrito carrito) {
		// TODO Auto-generated method stub
		float total = 0.0F;
		
		//se realiza el total del calculo de la compra.
		for(CarritoAlbum carritoAlbum : carrito.getCarritosAlbum()) {
			
			total += (carritoAlbum.getAlbum().getValor() * carritoAlbum.getCantidad());
			
		}
		
		return total;
	}
	
	
	@Override
	public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
		// TODO Auto-generated method stub
		this.carritoAlbumDao.delete(carritoAlbum);
	}
	
	
	@Override
	public float actualizarAlbumCantidad(CarritoAlbum carritoAlbum, Carrito carrito) {
		// TODO Auto-generated method stub
		this.carritoAlbumDao.save(carritoAlbum);
		return this.calcularTotal(carrito);
	}
	
	@Autowired
	private CarritoAlbumDao carritoAlbumDao;

	
}
