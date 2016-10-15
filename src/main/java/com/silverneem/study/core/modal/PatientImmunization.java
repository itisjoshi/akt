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
@Table(name = "PATIENTIMMUNIZATION")
@JsonInclude(Include.NON_EMPTY)
public class PatientImmunization extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name = "PATIENTID")
	@JsonBackReference(value = "patient-immunization-patient")
	private Patient patient;

	@Column(name = "DATETOBEGIVEN", length = 3000)
	private Date dateToBeGiven;

	@Column(name = "DATEGIVEN")
	private Date dateGiven;

	@Column(name = "AGE", length = 3000)
	private String age;
	
	@Column(name = "VACCINE", length = 3000)
	private String vaccine;

	@Column(name = "TYPE", length = 255)
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getDateToBeGiven() {
		return dateToBeGiven;
	}

	public void setDateToBeGiven(Date dateToBeGiven) {
		this.dateToBeGiven = dateToBeGiven;
	}

	public Date getDateGiven() {
		return dateGiven;
	}

	public void setDateGiven(Date dateGiven) {
		this.dateGiven = dateGiven;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
	
}
