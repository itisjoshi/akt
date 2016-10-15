package com.silverneem.study.core.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@Entity
@Table(name = "PATIENTPROFILE")
@JsonInclude(Include.NON_EMPTY)
public class PatientProfile extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name = "PATIENTID")
	@JsonBackReference(value = "patient-profile-patient")
	private Patient patient;
			
	@Column(name = "CATEGORY", length = 255)
	private String category;

	@Column(name = "PROPERTY", length = 255)
	private String property;
	
	@Column(name = "VALUE", length = 255)
	private String value;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
