package com.silverneem.study.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silverneem.study.core.modal.Patient;
import com.silverneem.study.core.modal.PatientProfile;
import com.silverneem.study.core.repository.PatientProfileRepository;
@Service("PatientProfileService")
@Repository
@Transactional
public class PatientProfileServiceImpl implements PatientProfileService {

	@Autowired
	private PatientProfileRepository patientProfileRepository;
	
	@Override
	public PatientProfile create(PatientProfile entity) {
		// TODO Auto-generated method stub
		return patientProfileRepository.save(entity);
	}

	@Override
	public PatientProfile update(PatientProfile entity) {
		// TODO Auto-generated method stub
		return patientProfileRepository.save(entity);
	}

	@Override
	public List<PatientProfile> update(List<PatientProfile> entities) {
		// TODO Auto-generated method stub
		return (List<PatientProfile>) patientProfileRepository.save(entities);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		patientProfileRepository.delete(id);
	}

	@Override
	public void delete(PatientProfile entity) {
		// TODO Auto-generated method stub
		patientProfileRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PatientProfile> entities) {
		// TODO Auto-generated method stub
		patientProfileRepository.delete(entities);
	}

	@Override
	public Iterable<PatientProfile> findAll() {
		// TODO Auto-generated method stub
		return patientProfileRepository.findAll();
	}

	@Override
	public PatientProfile findOne(Long id) {
		// TODO Auto-generated method stub
		return patientProfileRepository.findOne(id);
	}

	@Override
	public List<PatientProfile> findByPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientProfileRepository.findByPatient(patient);
	}

}