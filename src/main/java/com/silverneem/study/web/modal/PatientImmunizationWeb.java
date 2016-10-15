package com.silverneem.study.web.modal;

import java.util.Date;

public class PatientImmunizationWeb {

	private Long id;

	private Long patientId;

	private Date dateToBeGiven;

	private Date dateGiven;

	private String age;
	
	private String vaccine;

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
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
