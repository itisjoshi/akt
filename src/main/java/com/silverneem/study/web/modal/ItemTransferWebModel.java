 package com.silverneem.study.web.modal;

import com.silverneem.study.core.modal.Item;
import com.silverneem.study.core.modal.ItemTranferDetailsStatus;

public class ItemTransferWebModel {

	private Item item;
			
	private String buyer;
	
	private ItemTranferDetailsStatus itemTranferDetailsStatus;
	
	private String name;

	private Double quantity;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public ItemTranferDetailsStatus getItemTranferDetailsStatus() {
		return itemTranferDetailsStatus;
	}

	public void setItemTranferDetailsStatus(
			ItemTranferDetailsStatus itemTranferDetailsStatus) {
		this.itemTranferDetailsStatus = itemTranferDetailsStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	private String recipient;

}
