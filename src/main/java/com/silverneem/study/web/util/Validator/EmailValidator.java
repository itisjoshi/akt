package com.silverneem.study.web.util.Validator;


public class EmailValidator {

	public static boolean isValidEmail (String email) {
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (email.matches(EMAIL_REGEX)) {
			return true;
		}
		return false;
	}
	
}

