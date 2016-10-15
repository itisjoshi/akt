package com.silverneem.study.core.service;

import java.util.List;

import com.silverneem.study.core.modal.Patient;
import com.silverneem.study.core.modal.PatientVisit;
public interface PatientVisitService extends CrudService<PatientVisit, Long>{

	public List<PatientVisit> findByPatient(Patient patient);
	
	public Iterable<PatientVisit> findAll();

}
