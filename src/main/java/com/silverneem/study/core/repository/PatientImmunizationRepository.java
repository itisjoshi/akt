package com.silverneem.study.core.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.silverneem.study.core.modal.Patient;
import com.silverneem.study.core.modal.PatientImmunization;

/**
 * @author pmjoshi
 *
 */
public interface PatientImmunizationRepository extends
		PagingAndSortingRepository<PatientImmunization, Long> {

	@Query("SELECT DISTINCT patientImmunization FROM "
			+ "PatientImmunization patientImmunization "
			+ "LEFT JOIN FETCH patientImmunization.patient patient "
			+ "WHERE patient = ?1 "
			+ "ORDER BY patientImmunization.created DESC")
	public List<PatientImmunization> findByPatient(Patient patient);

	public List<PatientImmunization> findAll();
	
}