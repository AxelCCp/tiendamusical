/**
 * 
 */
package com.devpredator.tiendamusicaldata.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Axel
 * Clase que proporciona los metodos genericos para todas las clases java entity. Metodos del crud reutilizables.
 * E - Entity.
 * R - Repositorio
 * R extends PagingAndSortingRepository - todos los repositorios van a extender de PagingAndSortingRepository.
 */
public class CommonDao <E, R extends PagingAndSortingRepository<E, Long>>{

	/**
	 * Metodo que permite consultar una lista de datos paginable de una entidad.
	 * @param desde {@link Integer} indica a partir de q valor se obtendran los resultados.
	 * @param hasta {@link Integer} indica hasta donde se obtendran los resultados.
	 * @param orderBy {@link String} indica a partir de q campo se ordenaran los registros.
	 * @return {@link List} lista con los datos consultados paginados.
	 */
	public List<E> consultarListaPaginable(int desde, int hasta, String orderBy) {
		Pageable pageable = PageRequest.of(desde, hasta, Sort.by(orderBy));
		Page<E>page = this.repository.findAll(pageable);
		return page.getContent();
	}
	
	/**
	 * Metodo q permite persistir la infomacion de cualquier identidad.
	 * @param e {@link Object} objeto o entitidad a persistir.
	 * @return {@link Object} devuelve el obj persistido en la BBDD.
	 */
	public E guardar(E e) {
		return this.repository.save(e);
	}
	
	/**
	 * Metodo q permite actualizar la infomacion de cualquier identidad.
	 * @param e {@link Object} objeto o entitidad a actualizar.
	 * @return {@link Object} devuelve el obj actualizado en la BBDD.
	 */
	public E actualizar(E e) {
		return this.repository.save(e);
	}
	
	/**
	 * Metodo q permite eliminar la infomacion de cualquier identidad.
	 * @param e {@link Object} objeto o entitidad a persistir.
	 * @return {@link Object} devuelve el obj persistido en la BBDD.
	 */
	public void eliminar(E e) {
		this.repository.delete(e);
	}
	
	
	
	@Autowired
	protected R repository;
	
}
