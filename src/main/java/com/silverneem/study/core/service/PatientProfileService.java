package com.silverneem.study.core.service;

import java.util.List;

import com.silverneem.study.core.modal.Patient;
import com.silverneem.study.core.modal.PatientProfile;
public interface PatientProfileService extends CrudService<PatientProfile, Long>{

	public List<PatientProfile> findByPatient(Patient patient);
	
	public Iterable<PatientProfile> findAll();

	List<PatientProfile> update(List<PatientProfile> entities);

}
