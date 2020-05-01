package com.vaaniga.invest.signup.exception;

public class SignupServiceGenericException extends Exception {

	private static final long serialVersionUID = 1L;

	public SignupServiceGenericException(String message, Throwable cause) {
		super(message, cause);
	}

	public SignupServiceGenericException(String message) {
		super(message);
	}

	public SignupServiceGenericException(Throwable cause) {
		super(cause);
	}
}
