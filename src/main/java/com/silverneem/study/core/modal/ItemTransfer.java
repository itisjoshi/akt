package com.silverneem.study.core.modal;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@Entity
@Table(name = "ITEMTRANSFER")
@JsonInclude(Include.NON_EMPTY)
public class ItemTransfer extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name = "ITEMID")
	@JsonBackReference(value = "item-transfer-item")
	private Item item;
			
	@Column(name = "NAME", length = 255)
	private String name;
	
	@Column(name = "BUYER", length = 255)
	private String buyer;
	
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

	@OneToMany(mappedBy = "itemTransfer")
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
