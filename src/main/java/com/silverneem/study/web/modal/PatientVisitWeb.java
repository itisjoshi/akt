package com.silverneem.study.web.modal;

import java.util.Date;

public class PatientVisitWeb {
	

	private Long id;

	private Long patientId;

	private Date visitDate;
	
	private String description;

	private String weight;

	private String height;

	private String headCircumference;

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
