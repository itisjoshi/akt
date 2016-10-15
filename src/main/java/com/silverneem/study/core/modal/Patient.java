package com.silverneem.study.core.modal;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "PATIENT")
@JsonInclude(Include.NON_EMPTY)
public class Patient extends AbstractEntity {

	@Column(name = "NAME", length = 250)
	private String name;

	@Column(name = "FATHERNAME", length = 250)
	private String fatherName;
	
	@Column(name = "PHONE", length = 250)
	private String phone;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "MOBILE", length = 250)
	private String mobile;

	@Column(name = "EMAIL", length = 250)
	private String email;

	@Column(name = "GENDER", length = 250)
	private String gender;

	@Column(name = "FAMILYTREE", length = 250)
	private String familyTree;

	@Column(name = "AILMENT", length = 3000)
	private String ailment;

	@Column(name = "ALLERGY", length = 3000)
	private String allergy;

	@OneToMany(mappedBy = "patient")
	private Set<PatientVisit> patientVisits;

	@OneToMany(mappedBy = "patient")
	private Set<PatientProfile> patientProfiles;

	@OneToMany(mappedBy = "patient")
	private Set<PatientImmunization> patientImmunizations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFamilyTree() {
		return familyTree;
	}

	public void setFamilyTree(String familyTree) {
		this.familyTree = familyTree;
	}

	public String getAilment() {
		return ailment;
	}

	public void setAilment(String ailment) {
		this.ailment = ailment;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public Set<PatientVisit> getPatientVisits() {
		return patientVisits;
	}

	public void setPatientVisits(Set<PatientVisit> patientVisits) {
		this.patientVisits = patientVisits;
	}

	public Set<PatientProfile> getPatientProfiles() {
		return patientProfiles;
	}

	public void setPatientProfiles(Set<PatientProfile> patientProfiles) {
		this.patientProfiles = patientProfiles;
	}

	public Set<PatientImmunization> getPatientImmunizations() {
		return patientImmunizations;
	}

	public void setPatientImmunizations(Set<PatientImmunization> patientImmunizations) {
		this.patientImmunizations = patientImmunizations;
	}

}
