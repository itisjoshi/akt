package com.silverneem.study.core.service;

import java.util.List;

import com.silverneem.study.core.modal.Item;
import com.silverneem.study.core.modal.ItemTransfer;
public interface ItemTransferService extends CrudService<ItemTransfer, Long>{

	public List<ItemTransfer> findByItem(Item item);
	
	public Iterable<ItemTransfer> findAll();

	public List<ItemTransfer> search(String searchterm);

	public ItemTransfer findById(Long id);

}
