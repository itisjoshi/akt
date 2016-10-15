package com.silverneem.study.core.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.silverneem.study.core.modal.Patient;
/**
 * @author pmjoshi
 *
 */
public interface PatientRepository extends
		PagingAndSortingRepository<Patient, Long> {
	
	public List<Patient> findAll();

	@Query("SELECT DISTINCT patient FROM "
			+ "Patient patient "
			+ "WHERE patient.name LIKE CONCAT('%', ?1, '%') "
			+ "OR patient.phone LIKE CONCAT('%', ?1, '%') "
			+ "OR patient.id LIKE CONCAT('%', ?1, '%') "
			+ "OR patient.mobile LIKE CONCAT('%', ?1, '%') "
			+ "OR patient.email LIKE CONCAT('%', ?1, '%')")
	public List<Patient> search(String searchterm);

	public List<Patient> findByMobile(String mobile);
	
}