package com.silverneem.study.core.modal;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@Entity
@Table(name = "ITEM")
@JsonInclude(Include.NON_EMPTY)
public class Item extends AbstractEntity {
	
	@Column(name = "NAME", length = 250)
	private String name;

	@Column(name = "SHORTCODE", length = 250)
	private String shortCode;
	
	@Column(name = "MEASURETYPE", length = 250)
	private String measureType;
	
	@Column(name = "BALANCE")
	private Double Balance;

	@OneToMany(mappedBy = "item")
	private Set<ItemTransfer> itemTransfers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getMeasureType() {
		return measureType;
	}

	public void setMeasureType(String measureType) {
		this.measureType = measureType;
	}

	public Double getBalance() {
		return Balance;
	}

	public void setBalance(Double balance) {
		Balance = balance;
	}

	public Set<ItemTransfer> getItemTransfers() {
		return itemTransfers;
	}

	public void setItemTransfers(Set<ItemTransfer> itemTransfers) {
		this.itemTransfers = itemTransfers;
	}

}
