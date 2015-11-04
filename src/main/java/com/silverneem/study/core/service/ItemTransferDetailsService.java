package com.silverneem.study.core.service;

import java.util.List;

import com.silverneem.study.core.modal.ItemTranferDetailsStatus;
import com.silverneem.study.core.modal.ItemTransfer;
import com.silverneem.study.core.modal.ItemTransferDetails;
public interface ItemTransferDetailsService extends CrudService<ItemTransferDetails, Long>{

	public List<ItemTransferDetails> findByItemTransfer(ItemTransfer itemTransfer);
	
	public List<ItemTransferDetails> findAll();

	public ItemTransferDetails findByItemTransferAndItemTranferDetailsStatus(
			ItemTransfer itemTransfer, ItemTranferDetailsStatus receive);

}
