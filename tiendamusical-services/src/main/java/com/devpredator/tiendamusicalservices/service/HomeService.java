/**
 * 
 */
package com.devpredator.tiendamusicalservices.service;

import java.util.List;

import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDto;

/**
 * @author Axel
 * Interfaz q define los metodos de logica de negocio para la pantalla del home.
 */
public interface HomeService {

	/**
	 * metodo que permite consultar los albums con base al filtro que ingrese el cliente en el buscador de su home.
	 * @param filtro {@link String} texto ingresado por el usuario
	 * @return {@link List} lista de albums que coinciden con el texto ingresado.
	 */
	List<ArtistaAlbumDto>consultarAlbumsFiltro(String filtro);
	
}
