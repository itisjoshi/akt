package com.silverneem.study.web.modal;

import java.util.Date;
import java.util.Set;

import com.silverneem.study.core.modal.Item;
import com.silverneem.study.core.modal.ItemTransferDetails;

public class ItemTransferWeb {

	private Item item;
	
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String name;
	
	private String buyer;

	private Date created;
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Set<ItemTransferDetails> itemTransferDetails;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Set<ItemTransferDetails> getItemTransferDetails() {
		return itemTransferDetails;
	}

	public void setItemTransferDetails(Set<ItemTransferDetails> itemTransferDetails) {
		this.itemTransferDetails = itemTransferDetails;
	}

}
