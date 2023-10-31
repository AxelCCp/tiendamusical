/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDto;
import com.devpredator.tiendamusicalentities.entities.Artista;

/**
 * @author Axel
 * Clase que representa el dao para el crud hacia la tabla de artistas.
 */
public interface ArtistaDao extends PagingAndSortingRepository<Artista, Long>{
	
	@Query("select new com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDto(a, ar) " 
			+ "from Album a "
			+ "inner join a.artista ar "
			+ "inner join ar.subGenero sg "
			+ "inner join sg.genero g "
			+ "where ar.nombre like %:filtro% "
			+ "or ar.nombre like %:filtro% "
			+ "or sg.descripcion like %:filtro% "
			+ "or a.nombre like %:filtro% "
			+ "order by ar.nombre")
	List<ArtistaAlbumDto> consultarArtistasAlbumsPorFiltro(@Param("filtro") String filtro);

}
