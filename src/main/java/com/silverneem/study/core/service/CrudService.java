package com.silverneem.study.core.service;

import java.io.Serializable;

public interface CrudService<E, ID extends Serializable> {

	/*
	 * Creates an Entity E
	 * 
	 * @param	entity	object of E to persist
	 * 
	 * @return	E
	 */
	public E create(E entity);
	
	/*
	 * Updates an Entity E
	 * 
	 * @param	entity	object of E to persist
	 * 
	 * @return E
	 */
	public E update(E entity);
	
	/*
	 * Deletes an Entity E
	 * It could be a soft delete or hard delete based on 
	 * Entity E
	 * 
	 * @param	id		ID of an Entity E
	 * 
	 * @return	void
	 */
	public void delete(ID id);
	
	/*
	 * Deletes an Entity E
	 * It could be a soft delete or hard delete based on 
	 * Entity E
	 * 
	 * @param	entity		object of an Entity E
	 * 
	 * @return	void
	 */
	public void delete(E entity);
	
	/*
	 * Deletes a Collection of Entities E
	 * It could be a soft delete or hard delete based on 
	 * Entity E
	 * 
	 * @param	entities	Collection of objects of an Entity E
	 * 
	 * @return	void
	 */
	public void delete(Iterable<E> entities);
	
	/*
	 * Gets all Entity E
	 * 
	 * @return Iterable<E>
	 */
	public Iterable<E> findAll();
	
	/*
	 * Gets an Entity by ID
	 * 
	 * @param	id		id of an Entity E
	 * 
	 * @return	E
	 */
	public E findOne(ID id);

}
