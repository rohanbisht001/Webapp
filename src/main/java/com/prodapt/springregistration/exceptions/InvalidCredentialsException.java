package com.prodapt.springregistration.exceptions;

import org.springframework.stereotype.Component;

@Component
public class InvalidCredentialsException extends Exception {

	@Override
	public String toString() {
		return "InvalidCredentialsException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;

	public InvalidCredentialsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
