package com.silverneem.study.web.errorcodes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.IM_USED, reason = "Resource already Used.")
public class IMUsedException extends RuntimeException {

	private static final long serialVersionUID = 2618957667680879885L;

}
