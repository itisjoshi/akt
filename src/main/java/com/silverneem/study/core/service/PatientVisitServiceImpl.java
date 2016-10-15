package com.silverneem.study.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silverneem.study.core.modal.Patient;
import com.silverneem.study.core.modal.PatientVisit;
import com.silverneem.study.core.repository.PatientVisitRepository;
@Service("PatientVisitService")
@Repository
@Transactional
public class PatientVisitServiceImpl implements PatientVisitService {

	@Autowired
	private PatientVisitRepository patientVisitRepository;
	
	@Override
	public PatientVisit create(PatientVisit entity) {
		// TODO Auto-generated method stub
		return patientVisitRepository.save(entity);
	}

	@Override
	public PatientVisit update(PatientVisit entity) {
		// TODO Auto-generated method stub
		return patientVisitRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		patientVisitRepository.delete(id);
	}

	@Override
	public void delete(PatientVisit entity) {
		// TODO Auto-generated method stub
		patientVisitRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PatientVisit> entities) {
		// TODO Auto-generated method stub
		patientVisitRepository.delete(entities);
	}

	@Override
	public Iterable<PatientVisit> findAll() {
		// TODO Auto-generated method stub
		return patientVisitRepository.findAll();
	}

	@Override
	public PatientVisit findOne(Long id) {
		// TODO Auto-generated method stub
		return patientVisitRepository.findOne(id);
	}

	@Override
	public List<PatientVisit> findByPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientVisitRepository.findByPatient(patient);
	}

}