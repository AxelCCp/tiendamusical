/**
 * 
 */
package com.devpredator.tiendamusicalentities.dto;

import java.util.List;

import com.devpredator.tiendamusicalentities.entities.Album;
import com.devpredator.tiendamusicalentities.entities.Artista;

/**
 * @author Axel
 * Clase Dto para obtener la informacion de los albums que el cliente busca a traves de el filtro de busqueda del dashboard
 */
public class ArtistaAlbumDto {

	
	public ArtistaAlbumDto() {
		super();
	}
	
	/**
	 * Constructor q inicializa la informacion consultada para la busqueda de albums.
	 * @param album {@link Album} obj que contiene el album del artista.
	 * @param artista {@link artista} obj que contiene el artista (banda o solista).
	 */
	public ArtistaAlbumDto(Album album, Artista artista) {
		this.album = album;
		this.artista = artista;
	}
	
	
	
	/**
	 * @return the artista
	 */
	public Artista getArtista() {
		return artista;
	}

	/**
	 * @param artista the artista to set
	 */
	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	/**
	 * @return the album
	 */
	public Album getAlbum() {
		return album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}





	/**
	 * obj que contiene la informacion del artista
	 */
	private Artista artista;
	/**
	 * obj que contiene la informacion del album
	 */
	private Album album;
	
}
