package com.silverneem.study.core.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.silverneem.study.core.modal.ItemTranferDetailsStatus;
import com.silverneem.study.core.modal.ItemTransfer;
import com.silverneem.study.core.modal.ItemTransferDetails;
/**
 * @author pmjoshi
 *
 */
public interface ItemTransferDetailsRepository extends
		PagingAndSortingRepository<ItemTransferDetails, Long> {

	@Query("SELECT DISTINCT itemTransferDetails FROM "
			+ "ItemTransferDetails itemTransferDetails "
			+ "LEFT JOIN FETCH itemTransferDetails.itemTransfer itemTransfer "
			+ "LEFT JOIN FETCH itemTransfer.item item "
			+ "WHERE itemTransfer = ?1 "
			+ "ORDER BY itemTransferDetails.created DESC")
	public List<ItemTransferDetails> findByItemTransfer(ItemTransfer itemTransfer);
	
	public List<ItemTransferDetails> findAll();

	@Query("SELECT DISTINCT itemTransferDetails FROM "
			+ "ItemTransferDetails itemTransferDetails "
			+ "LEFT JOIN FETCH itemTransferDetails.itemTransfer itemTransfer "
			+ "LEFT JOIN FETCH itemTransfer.item item "
			+ "WHERE itemTransfer = ?1 AND "
			+ "itemTransferDetails.itemTranferDetailsStatus = ?2 "
			+ "ORDER BY itemTransferDetails.created DESC")
	public ItemTransferDetails findByItemTransferAndItemTranferDetailsStatus(
			ItemTransfer itemTransfer, ItemTranferDetailsStatus receive);

}