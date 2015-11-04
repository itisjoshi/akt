package com.silverneem.study.core.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.silverneem.study.core.modal.Item;
/**
 * @author pmjoshi
 *
 */
public interface ItemRepository extends
		PagingAndSortingRepository<Item, Long> {
	
	public List<Item> findAll();

	@Query("SELECT DISTINCT item FROM "
			+ "Item item "
			+ "WHERE item.name LIKE CONCAT('%', ?1, '%') "
			+ "OR item.shortCode LIKE CONCAT('%', ?1, '%')")
	public List<Item> search(String searchterm);
	
}