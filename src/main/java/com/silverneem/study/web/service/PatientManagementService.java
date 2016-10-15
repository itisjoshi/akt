package com.silverneem.study.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.silverneem.study.core.modal.Patient;
import com.silverneem.study.core.modal.PatientImmunization;
import com.silverneem.study.core.modal.PatientProfile;
import com.silverneem.study.core.modal.PatientVisit;
import com.silverneem.study.core.service.PatientImmunizationService;
import com.silverneem.study.core.service.PatientProfileService;
import com.silverneem.study.core.service.PatientService;
import com.silverneem.study.core.service.PatientVisitService;
import com.silverneem.study.web.errorcodes.BadRequestException;
import com.silverneem.study.web.modal.PatientImmunizationWeb;
import com.silverneem.study.web.modal.PatientProfileWeb;
import com.silverneem.study.web.modal.PatientVisitWeb;
import com.silverneem.study.web.modal.PatientWeb;

@Component
public class PatientManagementService {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientImmunizationService patientImmunizationService;

	@Autowired
	private PatientProfileService patientProfileService;

	@Autowired
	private PatientVisitService patientVisitService;

	public List<PatientWeb> findAll() {
		// TODO Auto-generated method stub
		List<PatientWeb> patientWebs = new ArrayList<PatientWeb>();
		List<Patient> patients = patientService.findAll();
		Iterator<Patient> patientIterator = patients.iterator();
		while (patientIterator.hasNext()) {
			PatientWeb patientWeb = convertPatientToPatientWeb(patientIterator.next());
			patientWebs.add(patientWeb);
		}
		return patientWebs;
	}

	public PatientWeb findPatient(Long id) {
		// TODO Auto-generated method stub
		return convertPatientToPatientWeb(patientService.findOne(id));
	}

	private PatientWeb convertPatientToPatientWeb(Patient patient) {
		// TODO Auto-generated method stub
		PatientWeb patientWeb = new PatientWeb();
		patientWeb.setId(patient.getId());
		patientWeb.setAilment(patient.getAilment());
		patientWeb.setAllergy(patient.getAllergy());
		patientWeb.setDob(patient.getDob());
		patientWeb.setEmail(patient.getEmail());
		patientWeb.setFamilyTree(patient.getFamilyTree());
		patientWeb.setFatherName(patient.getFatherName());
		patientWeb.setGender(patient.getGender());
		patientWeb.setMobile(patient.getMobile());
		patientWeb.setName(patient.getName());
		patientWeb.setPhone(patient.getPhone());
		return patientWeb;
	}

	private Patient convertPatientWebToPatient(PatientWeb patientWeb) {
		// TODO Auto-generated method stub
		Patient patient = new Patient();
		patient.setId(patientWeb.getId());
		patient.setAilment(patientWeb.getAilment());
		patient.setAllergy(patientWeb.getAllergy());
		patient.setDob(patientWeb.getDob());
		patient.setEmail(patientWeb.getEmail());
		patient.setFamilyTree(patientWeb.getFamilyTree());
		patient.setFatherName(patientWeb.getFatherName());
		patient.setGender(patientWeb.getGender());
		patient.setMobile(patientWeb.getMobile());
		patient.setName(patientWeb.getName());
		patient.setPhone(patientWeb.getPhone());
		return patient;
	}

	public List<PatientWeb> search(String searchterm) {
		// TODO Auto-generated method stub
		List<PatientWeb> patientWebs = new ArrayList<PatientWeb>();
		List<Patient> patients = patientService.search(searchterm);
		Iterator<Patient> patientIterator = patients.iterator();
		while (patientIterator.hasNext()) {
			PatientWeb patientWeb = convertPatientToPatientWeb(patientIterator.next());
			patientWebs.add(patientWeb);
		}
		return patientWebs;
	}

	public void createPatient(PatientWeb patientWeb) {
		// TODO Auto-generated method stub
		if(patientService.findByMobile(patientWeb.getMobile()) != null) {
			Patient patient = convertPatientWebToPatient(patientWeb);
			patient = patientService.create(patient);
			generatePatientProfile(patient); 
			generatePatientImmunization(patient); 
		} else {
			throw new BadRequestException();
		}
	}

	private void generatePatientImmunization(Patient patient) {
		// TODO Auto-generated method stub
		List<Map<String, String>> categories = new ArrayList<>();

		Map<String, String> map = new HashMap<>();
		map.put("AGE", "BIRTH");
		map.put("VACCINE", "BCG");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "BIRTH");
		map.put("VACCINE", "OPV - 1");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "BIRTH");
		map.put("VACCINE", "HEPATITIS B-1");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "6 WEEKS");
		map.put("VACCINE", "OPV-1 + IPV -1 / OPV DTPW - 1");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "6 WEEKS");
		map.put("VACCINE", "DTPA-1");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "6 WEEKS");
		map.put("VACCINE", "HEPATITIS B-2");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "6 WEEKS");
		map.put("VACCINE", "HIB - 1");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "10 WEEKS");
		map.put("VACCINE", "OPV-2 + IPV -2 / OPV DTPW - 2");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "10 WEEKS");
		map.put("VACCINE", "DTPA - 2");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "10 WEEKS");
		map.put("VACCINE", "HIB -2");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "14 WEEKS");
		map.put("VACCINE", "OPV-3 + IPV -3 / OPV DTPW - 3");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "14 WEEKS");
		map.put("VACCINE", "DTPW-3 DTPA-3");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "14 WEEKS");
		map.put("VACCINE", "HEPATITIS B-3");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "14 WEEKS");
		map.put("VACCINE", "HIB-3");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "9 MONTHS");
		map.put("VACCINE", "MEASLES");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "15TH-18TH MONTH");
		map.put("VACCINE", "DTPW BOOSTER-1 OR DTPA");
		map.put("TYPE", "OLD");
		categories.add(map);		
		map = new HashMap<>();
		map.put("AGE", "15TH-18TH MONTH");
		map.put("VACCINE", "BOOSTER-1");
		map.put("TYPE", "OLD");
		categories.add(map);		
		map = new HashMap<>();
		map.put("AGE", "15TH-18TH MONTH");
		map.put("VACCINE", "OPV-4 + IPV-B1/OPV-4");
		map.put("TYPE", "OLD");
		categories.add(map);		
		map = new HashMap<>();
		map.put("AGE", "15TH-18TH MONTH");
		map.put("VACCINE", "MMR-1");
		map.put("TYPE", "OLD");
		categories.add(map);		
		map = new HashMap<>();
		map.put("AGE", "2 YEARS");
		map.put("VACCINE", "TYPHOID");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "2 YEARS");
		map.put("VACCINE", "REVACCINATION EVERY 3-4 YEARS");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "5 YEARS");
		map.put("VACCINE", "OPV-5");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "5 YEARS");
		map.put("VACCINE", "DTPW BOOSTER-2 OR DTPA BOOSTER-2");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "5 YEARS");
		map.put("VACCINE", "MMR-2");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "10 YEARS");
		map.put("VACCINE", "TDAP");
		map.put("TYPE", "OLD");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "6 WEEKS");
		map.put("VACCINE", "PNEUMOCOCCAL CONJUGATE 1");
		map.put("TYPE", "NEW");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "10 WEEKS");
		map.put("VACCINE", "PNEUMOCOCCAL CONJUGATE 2");
		map.put("TYPE", "NEW");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "14 WEEKS");
		map.put("VACCINE", "PNEUMOCOCCAL CONJUGATE 3");
		map.put("TYPE", "NEW");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "4 TO 8 WEEKS INTERVALS 3 DOSES");
		map.put("VACCINE", "ROTAVIRAL VACCINES - 1 DOSE");
		map.put("TYPE", "NEW");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "4 TO 8 WEEKS INTERVALS 3 DOSES");
		map.put("VACCINE", "ROTAVIRAL VACCINES - 2 DOSE");
		map.put("TYPE", "NEW");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "4 TO 8 WEEKS INTERVALS 3 DOSES");
		map.put("VACCINE", "ROTAVIRAL VACCINES - 3 DOSE");
		map.put("TYPE", "NEW");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "LESS THAN 13 YEARS 1 DOSE MORE THAN 13 YEARS 2 DOSES");
		map.put("VACCINE", "CHICKEN POX (VARICELLA)");
		map.put("TYPE", "NEW");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "AFTER 18 MONTHS 1 DOSE 6-12 MONTHS INTERVAL 2 DOSES");
		map.put("VACCINE", "HEPATITIS-A - 1 DOSE");
		map.put("TYPE", "NEW");
		categories.add(map);
		map = new HashMap<>();
		map.put("AGE", "LESS THAN 13 YEARS 1 DOSE MORE THAN 13 YEARS 2 DOSES");
		map.put("VACCINE", "HEPATITIS-A - 2 DOSE");
		map.put("TYPE", "NEW");
		categories.add(map);

		List<PatientImmunization> patientImmunizations = new ArrayList<>();

		Iterator<Map<String, String>> iterator = categories.iterator();
		while (iterator.hasNext()) {
			Map<String, String> mapObject = iterator.next();
			PatientImmunization patientImmunization = new PatientImmunization();
			patientImmunization.setAge(mapObject.get("AGE"));
			patientImmunization.setVaccine(mapObject.get("VACCINE"));
			patientImmunization.setType(mapObject.get("TYPE"));
			patientImmunization.setPatient(patient);
			patientImmunizations.add(patientImmunization);
		}
		patientImmunizationService.update(patientImmunizations);		
	}

	private void generatePatientProfile(Patient patient) {
		// TODO Auto-generated method stub
		List<Map<String, String>> categories = new ArrayList<>();

		Map<String, String> map = new HashMap<>();
		map.put("CATEGORY", "BIRTH");
		map.put("PROPERTY", "TERM/PRETERM");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "BIRTH");
		map.put("PROPERTY", "NORMAL/LSCS/FORCEPS");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "BIRTH");
		map.put("PROPERTY", "HOSPITAL/HOME");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "BIRTH");
		map.put("PROPERTY", "BIRTHWEIGHT");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "BIRTH");
		map.put("PROPERTY", "CRY/COLOUR/ACTIVITY");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "NEONATAL");
		map.put("PROPERTY", "NEONATAL");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "FAMILY");
		map.put("PROPERTY", "TB/JAUNDICE/SEIZURES");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "DEVELOPMENTAL");
		map.put("PROPERTY", "GROSS MOTOR");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "DEVELOPMENTAL");
		map.put("PROPERTY", "FINE MOTOR");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "DEVELOPMENTAL");
		map.put("PROPERTY", "LANGUAGE");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "DEVELOPMENTAL");
		map.put("PROPERTY", "SOCIAL");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "ALLERGY");
		map.put("PROPERTY", "RESP/DRUGS/SKIN/PETS/OTHERS");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "SENSORY");
		map.put("PROPERTY", "EYES - REFRACTORY ERRORS/STRABISMUS/ALLERGY/FUNDUS");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "SENSORY");
		map.put("PROPERTY", "EARS - TYMPANIC MEMBRAME/HEARIING/EXTERNAL EAR");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "SENSORY");
		map.put("PROPERTY", "NOSE");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "SENSORY");
		map.put("PROPERTY", "ORAL CAVITY - TONGUE/TONSILS/ADENOIDS");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "SENSORY");
		map.put("PROPERTY", "SKIN");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "SENSORY");
		map.put("PROPERTY", "GENITALS");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "SENSORY");
		map.put("PROPERTY", "SPINE AND BACK");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "SENSORY");
		map.put("PROPERTY", "HAIR");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "OTHERS");
		map.put("PROPERTY", "CARDIO VASCULAR SYSTEM");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "OTHERS");
		map.put("PROPERTY", "RESPIRATOY SYSTEM");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "OTHERS");
		map.put("PROPERTY", "ABDOMEN");
		categories.add(map);
		map = new HashMap<>();
		map.put("CATEGORY", "OTHERS");
		map.put("PROPERTY", "CENTRAL NERVOUS SYSTEM");
		categories.add(map);

		List<PatientProfile> patientProfiles = new ArrayList<>();

		Iterator<Map<String, String>> iterator = categories.iterator();
		while (iterator.hasNext()) {
			Map<String, String> mapObject = iterator.next();
			PatientProfile patientProfile = new PatientProfile();
			patientProfile.setCategory(mapObject.get("CATEGORY"));
			patientProfile.setProperty(mapObject.get("PROPERTY"));
			patientProfile.setPatient(patient);
			patientProfiles.add(patientProfile);
		}
		patientProfileService.update(patientProfiles);
	}

	public void updatePatient(PatientWeb patientWeb) {
		// TODO Auto-generated method stub
		Patient patient = convertPatientWebToPatient(patientWeb);
		patientService.update(patient);		
	}

	public void deletePatient(PatientWeb patientWeb) {
		// TODO Auto-generated method stub
		patientService.delete(patientWeb.getId());
	}

	public List<PatientProfileWeb> findById(Long patientid) {
		// TODO Auto-generated method stub
		Patient patient = patientService.findOne(patientid);
		List<PatientProfile> patientProfiles = patientProfileService.findByPatient(patient);
		List<PatientProfileWeb> patientProfileWebs = new ArrayList<PatientProfileWeb>();
		Iterator<PatientProfile> patientProfileIterator = patientProfiles.iterator();
		while(patientProfileIterator.hasNext()) {
			PatientProfileWeb patientProfileWeb = convertPatientProfileWebtoPatientProfile(patientProfileIterator.next());
			patientProfileWebs.add(patientProfileWeb);
		}
		return patientProfileWebs;
	}

	private PatientProfileWeb convertPatientProfileWebtoPatientProfile(PatientProfile patientProfile) {
		// TODO Auto-generated method stub
		PatientProfileWeb patientProfileWeb = new PatientProfileWeb();
		patientProfileWeb.setCategory(patientProfile.getCategory());
		patientProfileWeb.setId(patientProfile.getId());
		patientProfileWeb.setProperty(patientProfile.getProperty());
		patientProfileWeb.setValue(patientProfile.getValue());
		patientProfileWeb.setPatientId(patientProfile.getPatient().getId());
		return patientProfileWeb;
	}

	private PatientProfile convertPatientProfiletoPatientProfileWeb(PatientProfileWeb patientProfileWeb) {
		// TODO Auto-generated method stub
		PatientProfile patientProfile = new PatientProfile();
		patientProfile.setCategory(patientProfileWeb.getCategory());
		patientProfile.setId(patientProfileWeb.getId());
		patientProfile.setProperty(patientProfileWeb.getProperty());
		patientProfile.setValue(patientProfileWeb.getValue());
		patientProfile.setPatient(patientService.findOne(patientProfileWeb.getPatientId()));
		return patientProfile;
	}

	public void updatePatientProfile(List<PatientProfileWeb> patientProfileWebs) {
		// TODO Auto-generated method stub
		List<PatientProfile> patientProfiles = new ArrayList<PatientProfile>();
		Iterator<PatientProfileWeb> patientProfileWebIterator = patientProfileWebs.iterator();
		while(patientProfileWebIterator.hasNext()) {
			PatientProfile patientProfile = convertPatientProfiletoPatientProfileWeb(patientProfileWebIterator.next());
			patientProfiles.add(patientProfile);
		}
		patientProfileService.update(patientProfiles);
	}

	public List<PatientImmunizationWeb> findByPatientId(Long id) {
		// TODO Auto-generated method stub
		Patient patient = patientService.findOne(id);
		List<PatientImmunization> patientImmunizations = patientImmunizationService.findByPatient(patient);
		List<PatientImmunizationWeb> patientImmunizationWebs = new ArrayList<PatientImmunizationWeb>();
		Iterator<PatientImmunization> patientImmunizationIterator = patientImmunizations.iterator();
		while(patientImmunizationIterator.hasNext()) {
			PatientImmunizationWeb patientImmunizationWeb = convertPatientImmunizationWebtoPatientImmunization(patientImmunizationIterator.next());
			patientImmunizationWebs.add(patientImmunizationWeb);
		}
		return patientImmunizationWebs;
	}

	private PatientImmunizationWeb convertPatientImmunizationWebtoPatientImmunization(PatientImmunization patientImmunization) {
		// TODO Auto-generated method stub
		PatientImmunizationWeb patientImmunizationWeb = new PatientImmunizationWeb();
		patientImmunizationWeb.setAge(patientImmunization.getAge());
		patientImmunizationWeb.setId(patientImmunization.getId());
		patientImmunizationWeb.setVaccine(patientImmunization.getVaccine());
		patientImmunizationWeb.setType
		(patientImmunization.getType());
		patientImmunizationWeb.setDateGiven(patientImmunization.getDateGiven());
		patientImmunizationWeb.setDateToBeGiven(patientImmunization.getDateToBeGiven());
		patientImmunizationWeb.setPatientId(patientImmunization.getPatient().getId());
		return patientImmunizationWeb;
	}

	private PatientImmunization convertPatientImmunizationtoPatientImmunizationWeb(PatientImmunizationWeb patientImmunizationWeb) {
		// TODO Auto-generated method stub
		PatientImmunization patientImmunization = new PatientImmunization();
		patientImmunization.setAge(patientImmunizationWeb.getAge());
		patientImmunization.setId(patientImmunizationWeb.getId());
		patientImmunization.setVaccine(patientImmunizationWeb.getVaccine());
		patientImmunization.setDateGiven(patientImmunizationWeb.getDateGiven());
		patientImmunization.setType(patientImmunizationWeb.getType());
		patientImmunization.setDateToBeGiven(patientImmunizationWeb.getDateToBeGiven());
		patientImmunization.setPatient(patientService.findOne(patientImmunizationWeb.getPatientId()));
		return patientImmunization;
	}

	public void updatePatientImmunization(List<PatientImmunizationWeb> patientImmunizationWebs) {
		// TODO Auto-generated method stub
		List<PatientImmunization> patientImmunizations = new ArrayList<PatientImmunization>();
		Iterator<PatientImmunizationWeb> patientImmunizationWebIterator = patientImmunizationWebs.iterator();
		while(patientImmunizationWebIterator.hasNext()) {
			PatientImmunization patientImmunization = convertPatientImmunizationtoPatientImmunizationWeb(patientImmunizationWebIterator.next());
			patientImmunizations.add(patientImmunization);
		}
		patientImmunizationService.update(patientImmunizations);		
	}

	public List<PatientVisitWeb> findAllVisits(Long id) {
		// TODO Auto-generated method stub
		List<PatientVisit> patientVisits = patientVisitService.findByPatient(patientService.findOne(id));
		List<PatientVisitWeb> patientVisitWebs = new ArrayList<PatientVisitWeb>();
		Iterator<PatientVisit> patientVisitIterator = patientVisits.iterator();
		while(patientVisitIterator.hasNext()) {
			PatientVisitWeb patientVisitWeb = convertPatientVisitWebtoPatientVisit(patientVisitIterator.next());
			patientVisitWebs.add(patientVisitWeb);
		}
		return patientVisitWebs;
	}

	private PatientVisitWeb convertPatientVisitWebtoPatientVisit(PatientVisit patientVisit) {
		// TODO Auto-generated method stub
		PatientVisitWeb patientVisitWeb = new PatientVisitWeb();
		patientVisitWeb.setDescription(patientVisit.getDescription());
		patientVisitWeb.setId(patientVisit.getId());
		patientVisitWeb.setHeadCircumference(patientVisit.getHeadCircumference());
		patientVisitWeb.setHeight(patientVisit.getHeight());
		patientVisitWeb.setPatientId(patientVisit.getPatient().getId());
		patientVisitWeb.setVisitDate(patientVisit.getVisitDate());
		patientVisitWeb.setWeight(patientVisit.getWeight());
		return patientVisitWeb;
	}

	public void createPatientVisit(PatientVisitWeb patientVisitWeb) {
		// TODO Auto-generated method stub
		PatientVisit patientVisit = new PatientVisit();
		patientVisit = convertPatientVisittoPatientVisitWeb(patientVisitWeb);
		patientVisitService.create(patientVisit);						
	}

	public void updatePatientVisit(PatientVisitWeb patientVisitWeb) {
		// TODO Auto-generated method stub
		PatientVisit patientVisit = patientVisitService.findOne(patientVisitWeb.getId());
		patientVisit = convertPatientVisittoPatientVisitWeb(patientVisitWeb);
		patientVisitService.update(patientVisit);				
	}

	private PatientVisit convertPatientVisittoPatientVisitWeb(PatientVisitWeb patientVisitWeb) {
		// TODO Auto-generated method stub
		PatientVisit patientVisit = new PatientVisit();
		patientVisit.setDescription(patientVisitWeb.getDescription());
		patientVisit.setId(patientVisitWeb.getId());
		patientVisit.setHeadCircumference(patientVisitWeb.getHeadCircumference());
		patientVisit.setHeight(patientVisitWeb.getHeight());
		patientVisit.setPatient(patientService.findOne(patientVisitWeb.getPatientId()));
		patientVisit.setVisitDate(patientVisitWeb.getVisitDate());
		patientVisit.setWeight(patientVisitWeb.getWeight());
		return patientVisit;
	}

	public void deletePatientVisit(PatientVisitWeb patientWeb) {
		// TODO Auto-generated method stub
		patientVisitService.delete(patientWeb.getId());
	}

}
