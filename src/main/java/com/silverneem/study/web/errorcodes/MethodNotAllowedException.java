package com.silverneem.study.web.errorcodes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED,
reason = "Operation is not permitted for this resource. Either resource is " 
+ "not in a state to process or you are not allowed to do this" 
+ "operation with this resource.")
public class MethodNotAllowedException extends RuntimeException {

	private static final long serialVersionUID = 6633005766981412890L;

}
