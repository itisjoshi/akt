package com.silverneem.study.core.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@Entity
@Table(name = "PATIENTVISIT")
@JsonInclude(Include.NON_EMPTY)
public class PatientVisit extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name = "PATIENTID")
	@JsonBackReference(value = "patient-visit-patient")
	private Patient patient;
			
	@Column(name = "VISITDATE")
	private Date visitDate;
	
	@Column(name = "DESCRIPTION", length = 3000)
	private String description;

	@Column(name = "WEIGHT", length = 255)
	private String weight;

	@Column(name = "HEIGHT", length = 255)
	private String height;

	@Column(name = "HEADCIRCUMFERENCE", length = 255)
	private String headCircumference;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getHeadCircumference() {
		return headCircumference;
	}

	public void setHeadCircumference(String headCircumference) {
		this.headCircumference = headCircumference;
	}

}
