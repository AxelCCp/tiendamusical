/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author Axel
 * interfaz que implementa los metodos genericos para el crud con Spring jpa hacia la tabla de carritoAlbum.
 */
public interface CarritoAlbumDao extends PagingAndSortingRepository<CarritoAlbum, Long>{

}
