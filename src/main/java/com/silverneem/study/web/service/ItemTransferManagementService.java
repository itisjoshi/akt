package com.silverneem.study.web.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.silverneem.study.core.modal.Item;
import com.silverneem.study.core.modal.ItemTranferDetailsStatus;
import com.silverneem.study.core.modal.ItemTransfer;
import com.silverneem.study.core.modal.ItemTransferDetails;
import com.silverneem.study.core.service.ItemService;
import com.silverneem.study.core.service.ItemTransferDetailsService;
import com.silverneem.study.core.service.ItemTransferService;
import com.silverneem.study.web.errorcodes.BadRequestException;
import com.silverneem.study.web.modal.ItemTransferWeb;
import com.silverneem.study.web.modal.ItemTransferWebModel;
@Component
public class ItemTransferManagementService {

	@Autowired
	private ItemTransferService itemTransferService;
	
	@Autowired
	private ItemTransferDetailsService itemTransferDetailsService;
	
	@Autowired
	private ItemService itemService;
	
	public List<ItemTransferWeb> findAll() {
		// TODO Auto-generated method stub
		Iterable<ItemTransfer> itemTransfers = itemTransferService.findAll();
		Iterator<ItemTransfer> itemTransferIterator = itemTransfers.iterator();
		List<ItemTransferWeb> itemTransferWebs = new ArrayList<ItemTransferWeb>();
		while(itemTransferIterator.hasNext()) {
			ItemTransfer itemTransfer = itemTransferIterator.next();
			ItemTransferWeb itemTransferWeb = new ItemTransferWeb();
			itemTransferWeb.setItem(itemTransfer.getItem());
			itemTransferWeb.setBuyer(itemTransfer.getBuyer());
			itemTransferWeb.setName(itemTransfer.getName());
			itemTransferWeb.setCreated(itemTransfer.getCreated());
			itemTransferWeb.setId(itemTransfer.getId());
			itemTransferWeb.setItemTransferDetails(itemTransfer.getItemTransferDetails());
			itemTransferWebs.add(itemTransferWeb);
		}
		return itemTransferWebs;
	}

	public List<ItemTransfer> search(String searchterm) {
		// TODO Auto-generated method stub
		return itemTransferService.search(searchterm);
	}

	public void createItemTransfer(ItemTransferWebModel itemTransferWebModel) {
		// TODO Auto-generated method stub entity
		ItemTransfer itemTransfer = new ItemTransfer();
		itemTransfer.setItem(itemTransferWebModel.getItem());
		itemTransfer.setName(itemTransferWebModel.getName());
		itemTransfer.setBuyer(itemTransferWebModel.getBuyer());
		itemTransfer = itemTransferService.create(itemTransfer);
		ItemTransferDetails itemTransferDetails = new ItemTransferDetails();
		itemTransferDetails.setItemTransfer(itemTransfer);
		itemTransferDetails.setItemTranferDetailsStatus(itemTransferWebModel.getItemTranferDetailsStatus());
		itemTransferDetails.setName(itemTransferWebModel.getName());
		itemTransferDetails.setQuantity(itemTransferWebModel.getQuantity());
		itemTransferDetails.setRecipient(itemTransferWebModel.getRecipient());
		itemTransferDetailsService.create(itemTransferDetails);
		ItemTransfer itemTransfer2 = itemTransferService.findById(itemTransfer.getId());
		Item item = itemTransfer2.getItem();
		if(!(item.getBalance() != null)) {
			item.setBalance(0.0);
		}
		item.setBalance(item.getBalance() + itemTransferWebModel.getQuantity());
		itemService.update(item);
	}

	public void updateItemTransfer(ItemTransfer item) {
		// TODO Auto-generated method stub
		itemTransferService.update(item);
	}

	public void deleteTransfer(ItemTransfer itemTransfer) {
		// TODO Auto-generated method stub
			ItemTransferDetails itemTransferDetails = itemTransferDetailsService.findByItemTransferAndItemTranferDetailsStatus(itemTransfer, ItemTranferDetailsStatus.RECEIVE);
			Item item = itemTransfer.getItem();
			if(!(item.getBalance() != null)) {
				item.setBalance(0.0);
			}
			if(itemTransferDetails.getItemTranferDetailsStatus().equals(ItemTranferDetailsStatus.RETURN)) {
				item.setBalance(item.getBalance() + itemTransferDetails.getQuantity());				
			} 
			itemService.update(item);		
			List<ItemTransferDetails> itemTransferDetailss = itemTransferDetailsService.findByItemTransfer(itemTransfer);
			itemTransferDetailsService.delete(itemTransferDetailss);
			itemTransferService.delete(itemTransfer.getId());			
	}

	public List<ItemTransferWeb> findByItem(Long id) {
		// TODO Auto-generated method stub
		Item item = itemService.findOne(id);
		Iterable<ItemTransfer> itemTransfers = itemTransferService.findByItem(item);
		Iterator<ItemTransfer> itemTransferIterator = itemTransfers.iterator();
		List<ItemTransferWeb> itemTransferWebs = new ArrayList<ItemTransferWeb>();
		while(itemTransferIterator.hasNext()) {
			ItemTransfer itemTransfer = itemTransferIterator.next();
			ItemTransferWeb itemTransferWeb = new ItemTransferWeb();
			itemTransferWeb.setItem(item);
			itemTransferWeb.setBuyer(itemTransfer.getBuyer());
			itemTransferWeb.setName(itemTransfer.getName());
			itemTransferWeb.setCreated(itemTransfer.getCreated());
			itemTransferWeb.setId(itemTransfer.getId());
			itemTransferWeb.setItemTransferDetails(itemTransfer.getItemTransferDetails());
			itemTransferWebs.add(itemTransferWeb);
		}
		return itemTransferWebs;
	}

	public ItemTransferWeb findById(Long id) {
		ItemTransfer itemTransfer = itemTransferService.findById(id);
		ItemTransferWeb itemTransferWeb = new ItemTransferWeb();
		itemTransferWeb.setItem(itemTransfer.getItem());
		itemTransferWeb.setBuyer(itemTransfer.getBuyer());
		itemTransferWeb.setName(itemTransfer.getName());
		itemTransferWeb.setCreated(itemTransfer.getCreated());
		itemTransferWeb.setId(itemTransfer.getId());
		itemTransferWeb.setItemTransferDetails(itemTransfer.getItemTransferDetails());
		return itemTransferWeb;
	}

	public void deleteTransferDetails(ItemTransferDetails itemTransferDetails) {
		// TODO Auto-generated method stub
		try {
			itemTransferDetailsService.delete(itemTransferDetails);
		} catch (Exception ex) {
			
		}
	}

	public void createItemTransferDetail(ItemTransferDetails itemTransferDetails) {
		// TODO Auto-generated method stub
		List<ItemTransferDetails> itemTransferDetailsList = itemTransferDetailsService.findByItemTransfer(itemTransferDetails.getItemTransfer());
		Iterator<ItemTransferDetails> iterator = itemTransferDetailsList.iterator();
		Double balance = 0.0;
		Double received = 0.0;
		while(iterator.hasNext()) {
			ItemTransferDetails itemTransferDetail = iterator.next();
			if(itemTransferDetail.getItemTranferDetailsStatus().equals(ItemTranferDetailsStatus.RECEIVE)) {
				received = itemTransferDetail.getQuantity();
			} else if(itemTransferDetail.getItemTranferDetailsStatus().equals(ItemTranferDetailsStatus.ISSUE)) {
				balance = balance + itemTransferDetail.getQuantity();
			} else if(itemTransferDetail.getItemTranferDetailsStatus().equals(ItemTranferDetailsStatus.RETURN)) {
				balance = balance - itemTransferDetail.getQuantity();
			}
		}
		if(itemTransferDetails.getItemTranferDetailsStatus().equals(ItemTranferDetailsStatus.ISSUE)) {
			balance = balance + itemTransferDetails.getQuantity();
		} else if(itemTransferDetails.getItemTranferDetailsStatus().equals(ItemTranferDetailsStatus.RETURN)) {
			balance = balance - itemTransferDetails.getQuantity();
		}
		
		if(received < balance || balance < 0) {
			throw new BadRequestException();
		}
		itemTransferDetailsService.create(itemTransferDetails);
		Item item = itemService.findOne(itemTransferDetails.getItemTransfer().getItem().getId());
		item.setBalance(received - balance);
		itemService.update(item);
	}

}
