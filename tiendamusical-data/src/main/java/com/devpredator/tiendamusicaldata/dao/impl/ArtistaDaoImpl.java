package com.devpredator.tiendamusicaldata.dao.impl;

import java.util.List;

import com.devpredator.tiendamusicaldata.common.CommonDao;
import com.devpredator.tiendamusicaldata.dao.ArtistaDao;
import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDto;
import com.devpredator.tiendamusicalentities.entities.Artista;

/**
 * Clase que implementa el crud generico para realizar las transacciones a la tabla de artista.
 */
public class ArtistaDaoImpl extends CommonDao<Artista, ArtistaDao>{
	
	
	public List<ArtistaAlbumDto> consultarArtistaAlbumPorFiltro(String filtro) {
		return this.repository.consultarArtistasAlbumsPorFiltro(filtro);
	}

}
