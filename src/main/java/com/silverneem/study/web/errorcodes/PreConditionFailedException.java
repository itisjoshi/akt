package com.silverneem.study.web.errorcodes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, 
reason = "Validation failed on server.")
public class PreConditionFailedException extends RuntimeException {

	private static final long serialVersionUID = 6633005766981412890L;

}
