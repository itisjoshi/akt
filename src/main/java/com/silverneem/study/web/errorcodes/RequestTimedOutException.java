package com.silverneem.study.web.errorcodes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT, reason = "Request Timed out")
public class RequestTimedOutException extends RuntimeException {

	private static final long serialVersionUID = 6633005766981412890L;

}