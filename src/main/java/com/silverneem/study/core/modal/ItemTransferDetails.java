package com.silverneem.study.core.modal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@Entity
@Table(name = "ITEMTRANSFERDETAILS")
@JsonInclude(Include.NON_EMPTY)
public class ItemTransferDetails extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "ITEMTRANSFERID")
	@JsonBackReference(value = "item-transfer-details-item-transfer")
	private ItemTransfer itemTransfer;

	@Enumerated(EnumType.STRING)
	@Column(name = "ITEMTRANSFERDETAILSSTATUS")
	private ItemTranferDetailsStatus itemTranferDetailsStatus;
	
	@Column(name = "NAME", length = 250)
	private String name;

	@Column(name = "QUANTITY")
	private Double quantity;

	@Column(name = "RECIPIENT", length = 255)
	private String recipient;

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public ItemTransfer getItemTransfer() {
		return itemTransfer;
	}

	public void setItemTransfer(ItemTransfer itemTransfer) {
		this.itemTransfer = itemTransfer;
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

}
