/**
 * 
 */
package com.devpredator.tienda.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDto;
import com.devpredator.tiendamusicalservices.service.HomeService;

/**
 * @author Axel
 * Clase q controla el flujo de informacion para la pantalla de home de cualquier tipo de usuario.
 */
@ManagedBean
@ViewScoped    																								//para qe genere un solo bean en todo el momento que nosotros estemos en una pantalla.
public class HomeController {

	/**
	 * metodo que inicializa la pantalla.
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("info");
		LOGGER.warn("warn");
		LOGGER.error("error");
		LOGGER.fatal("fatal");	
	}
	
	/**
	 * metodo que se va a estar llamando cada vez q el usuario este ingresando un texto.
	 * permite obtener los albums de los artistas en bbdd.
	 */
	public void consultarAlbumsArtistasPorFiltro() {
		this.artistasAlbumDto = this.homeServiceImpl.consultarAlbumsFiltro(this.filtro);
		if(this.artistasAlbumDto != null) {
			this.artistasAlbumDto.forEach(artistaAlbumDto -> {
				LOGGER.info("Artista: " + artistaAlbumDto.getArtista().getNombre());
			});
		}
	}
	
	/**
	 * @return the filtro
	 */
	public String getFiltro() {
		return filtro;
	}
	/**
	 * @param filtro the filtro to set
	 */
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	/**
	 * @return the artistasAlbumDto
	 */
	public List<ArtistaAlbumDto> getArtistasAlbumDto() {
		return artistasAlbumDto;
	}
	/**
	 * @param artistasAlbumDto the artistasAlbumDto to set
	 */
	public void setArtistasAlbumDto(List<ArtistaAlbumDto> artistasAlbumDto) {
		this.artistasAlbumDto = artistasAlbumDto;
	}
	/**
	 * @return the homeServiceImpl
	 */
	public HomeService getHomeServiceImpl() {
		return homeServiceImpl;
	}
	/**
	 * @param homeServiceImpl the homeServiceImpl to set
	 */
	public void setHomeServiceImpl(HomeService homeServiceImpl) {
		this.homeServiceImpl = homeServiceImpl;
	}



	/**
	 * texto ingersado por el cliente en el buscador.
	 */
	private String filtro;
	/**
	 * Lista obtenida a partir del filtro ingresado en el buscador.
	 */
	private List<ArtistaAlbumDto> artistasAlbumDto;
	/**
	 * Se inyecta el obj de spring con jsf para obtener los metodos de logica de negocio del home.
	 */
	@ManagedProperty("#{homeServiceImpl}")
	private HomeService homeServiceImpl;
	/**
	 * Objeto q nos permite mostrar los mensajes de log en la consola o en un archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger();
}
