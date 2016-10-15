package com.silverneem.study.core.service;

import java.util.List;

import com.silverneem.study.core.modal.Patient;

public interface PatientService extends CrudService<Patient, Long>{

	public List<Patient> findAll();

	public List<Patient> search(String searchterm);

	public List<Patient> findByMobile(String mobile);

}
