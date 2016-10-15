package com.silverneem.study.core.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.silverneem.study.core.modal.Patient;
import com.silverneem.study.core.modal.PatientVisit;

/**
 * @author pmjoshi
 *
 */
public interface PatientVisitRepository extends
		PagingAndSortingRepository<PatientVisit, Long> {

	@Query("SELECT DISTINCT patientVisit FROM "
			+ "PatientVisit patientVisit "
			+ "LEFT JOIN FETCH patientVisit.patient patient "
			+ "WHERE patient = ?1 "
			+ "ORDER BY patientVisit.created DESC")
	public List<PatientVisit> findByPatient(Patient patient);

	public List<PatientVisit> findAll();
	
}