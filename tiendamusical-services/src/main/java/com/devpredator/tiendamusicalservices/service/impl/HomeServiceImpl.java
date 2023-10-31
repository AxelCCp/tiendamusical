/**
 * 
 */
package com.devpredator.tiendamusicalservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpredator.tiendamusicaldata.dao.ArtistaDao;
import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDto;
import com.devpredator.tiendamusicalservices.service.HomeService;

/**
 * @author Axel
 * Clase que implementa los metodos de logica de negocio de la interfaz de loginService.
 */
@Service
public class HomeServiceImpl implements HomeService{

	/**
	 * 
	 */
	@Override
	public List<ArtistaAlbumDto> consultarAlbumsFiltro(String filtro) {
		// TODO Auto-generated method stub
		return artistaDaoImpl.consultarArtistasAlbumsPorFiltro(filtro);
	}

	
	@Autowired
	private ArtistaDao artistaDaoImpl;
}
