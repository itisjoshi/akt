package com.silverneem.study.web.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.silverneem.study.core.modal.Item;
import com.silverneem.study.core.modal.ItemTransfer;
import com.silverneem.study.core.service.ItemService;
import com.silverneem.study.core.service.ItemTransferDetailsService;
import com.silverneem.study.core.service.ItemTransferService;
@Component
public class ItemManagementService {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemTransferService itemTransferService;
	
	@Autowired
	private ItemTransferDetailsService itemTransferDetailsService;
	
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return itemService.findAll();
	}

	public List<Item> search(String searchterm) {
		// TODO Auto-generated method stub
		return itemService.search(searchterm);
	}

	public void createItem(Item item) {
		// TODO Auto-generated method stub entity
		item.setBalance(0.0);
		itemService.create(item);
	}

	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		itemService.update(item);
	}

	public void deleteGroup(Item item) {
		// TODO Auto-generated method stub
		List<ItemTransfer> itemTransfers = itemTransferService.findByItem(item);
		Iterator<ItemTransfer> iterator = itemTransfers.iterator();
		while(iterator.hasNext()) {
			itemTransferDetailsService.delete(iterator.next().getItemTransferDetails());			
		}
		itemTransferService.delete(itemTransfers);
		itemService.delete(item);
	}

}
