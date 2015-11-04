package com.silverneem.study.core.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.silverneem.study.core.modal.Item;
import com.silverneem.study.core.modal.ItemTransfer;

/**
 * @author pmjoshi
 *
 */
public interface ItemTansferRepository extends
		PagingAndSortingRepository<ItemTransfer, Long> {

	@Query("SELECT DISTINCT itemTransfer FROM "
			+ "ItemTransfer itemTransfer "
			+ "LEFT JOIN FETCH itemTransfer.itemTransferDetails itemTransferDetails "
			+ "LEFT JOIN FETCH itemTransfer.item item "
			+ "WHERE item = ?1 "
			+ "ORDER BY itemTransfer.created DESC")
	public List<ItemTransfer> findByItem(Item item);

	@Query("SELECT DISTINCT itemTransfer FROM "
			+ "ItemTransfer itemTransfer "
			+ "LEFT JOIN FETCH itemTransfer.itemTransferDetails itemTransferDetails "
			+ "LEFT JOIN FETCH itemTransfer.item item "			
			+ "ORDER BY itemTransfer.created DESC")
	public List<ItemTransfer> findAll();

	@Query("SELECT DISTINCT itemTransfer FROM "
			+ "ItemTransfer itemTransfer "
			+ "LEFT JOIN FETCH itemTransfer.itemTransferDetails itemTransferDetails "
			+ "WHERE itemTransfer.name LIKE CONCAT('%', ?1, '%') "
			+ "ORDER BY itemTransfer.created DESC")
	public List<ItemTransfer> search(String searchterm);

	@Query("SELECT DISTINCT itemTransfer FROM "
			+ "ItemTransfer itemTransfer "
			+ "LEFT JOIN FETCH itemTransfer.itemTransferDetails itemTransferDetails "
			+ "LEFT JOIN FETCH itemTransfer.item item "
			+ "WHERE itemTransfer.id = ?1 "
			+ "ORDER BY itemTransfer.created DESC")
	public ItemTransfer findById(Long id);
	
}