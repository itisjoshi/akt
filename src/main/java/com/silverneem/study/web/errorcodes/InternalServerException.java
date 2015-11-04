package com.silverneem.study.web.errorcodes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, 
reason = "Some problem with server. Please try again / Contact support.")
public class InternalServerException extends RuntimeException {

	private static final long serialVersionUID = 6633005766981412890L;

}
