package com.silverneem.study.core.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.silverneem.study.core.modal.Patient;
import com.silverneem.study.core.modal.PatientProfile;

/**
 * @author pmjoshi
 *
 */
public interface PatientProfileRepository extends
		PagingAndSortingRepository<PatientProfile, Long> {

	@Query("SELECT DISTINCT patientProfile FROM "
			+ "PatientProfile patientProfile "
			+ "LEFT JOIN FETCH patientProfile.patient patient "
			+ "WHERE patient = ?1 "
			+ "ORDER BY patientProfile.created DESC")
	public List<PatientProfile> findByPatient(Patient patient);

	public List<PatientProfile> findAll();
	
}