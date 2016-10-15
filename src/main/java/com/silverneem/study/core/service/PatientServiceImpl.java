package com.silverneem.study.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silverneem.study.core.modal.Patient;
import com.silverneem.study.core.repository.PatientRepository;

@Service("PatientService")
@Repository
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient create(Patient entity) {
		// TODO Auto-generated method stub
		return patientRepository.save(entity);
	}

	@Override
	public Patient update(Patient entity) {
		// TODO Auto-generated method stub
		return patientRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		patientRepository.delete(id);	
	}

	@Override
	public void delete(Patient entity) {
		// TODO Auto-generated method stub
		patientRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Patient> entities) {
		// TODO Auto-generated method stub
		patientRepository.delete(entities);
	}

	@Override
	public Patient findOne(Long id) {
		// TODO Auto-generated method stub
		return patientRepository.findOne(id);
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public List<Patient> search(String searchterm) {
		// TODO Auto-generated method stub
		return patientRepository.search(searchterm);
	}

	@Override
	public List<Patient> findByMobile(String mobile) {
		// TODO Auto-generated method stub
		return patientRepository.findByMobile(mobile);
	}
	
}