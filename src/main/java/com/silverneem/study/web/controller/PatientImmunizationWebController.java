package com.silverneem.study.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.silverneem.study.web.modal.PatientImmunizationWeb;
import com.silverneem.study.web.service.PatientManagementService;
@RestController
@RequestMapping(value = "/patientimmunization")
@Secured(value = "ROLE_ADMIN")
public class PatientImmunizationWebController {

	@Autowired
	private PatientManagementService patientManagementService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<PatientImmunizationWeb> getAllGroupsBy(@PathVariable("id") Long id) {
		return patientManagementService.findByPatientId(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void editGroup(@RequestBody List<PatientImmunizationWeb> patientImmunizationWebs) {
		patientManagementService.updatePatientImmunization(patientImmunizationWebs);
	}
			
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<FieldError> processValidationError(
    		MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
 
        return fieldErrors;
    }
}
