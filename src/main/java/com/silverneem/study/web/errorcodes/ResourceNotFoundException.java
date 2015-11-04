package com.silverneem.study.web.errorcodes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,
reason = "Requested resource is not found.")
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	private static final long serialVersionUID = 6633005766981412890L;

}
