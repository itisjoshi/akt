package com.silverneem.study.core.service;

import java.util.List;

import com.silverneem.study.core.modal.Patient;
import com.silverneem.study.core.modal.PatientImmunization;
public interface PatientImmunizationService extends CrudService<PatientImmunization, Long>{

	public List<PatientImmunization> findByPatient(Patient patient);
	
	public Iterable<PatientImmunization> findAll();

	List<PatientImmunization> update(List<PatientImmunization> entities);

}
