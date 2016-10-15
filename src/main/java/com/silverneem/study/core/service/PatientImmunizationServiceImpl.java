package com.silverneem.study.core.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silverneem.study.core.modal.Patient;
import com.silverneem.study.core.modal.PatientImmunization;
import com.silverneem.study.core.repository.PatientImmunizationRepository;
@Service("PatientImmunizationService")
@Repository
@Transactional
public class PatientImmunizationServiceImpl implements PatientImmunizationService {

	@Autowired
	private PatientImmunizationRepository patientImmunizationRepository;
	
	@Override
	public PatientImmunization create(PatientImmunization entity) {
		// TODO Auto-generated method stub
		return patientImmunizationRepository.save(entity);
	}

	@Override
	public PatientImmunization update(PatientImmunization entity) {
		// TODO Auto-generated method stub
		return patientImmunizationRepository.save(entity);
	}

	@Override
	public List<PatientImmunization> update(List<PatientImmunization> entities) {
		// TODO Auto-generated method stub
		return (List<PatientImmunization>) patientImmunizationRepository.save(entities);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		patientImmunizationRepository.delete(id);
	}

	@Override
	public void delete(PatientImmunization entity) {
		// TODO Auto-generated method stub
		patientImmunizationRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PatientImmunization> entities) {
		// TODO Auto-generated method stub
		patientImmunizationRepository.delete(entities);
	}

	@Override
	public Iterable<PatientImmunization> findAll() {
		// TODO Auto-generated method stub
		return patientImmunizationRepository.findAll();
	}

	@Override
	public PatientImmunization findOne(Long id) {
		// TODO Auto-generated method stub
		return patientImmunizationRepository.findOne(id);
	}

	@Override
	public List<PatientImmunization> findByPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientImmunizationRepository.findByPatient(patient);
	}

}