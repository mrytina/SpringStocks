package com.stocks.exception;

import java.util.List;

import org.springframework.validation.ObjectError;

public class ValidationException extends RuntimeException {
	private String message;
	private List<ObjectError> details;

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ObjectError> getDetails() {
		return details;
	}

	public void setDetails(List<ObjectError> details) {
		this.details = details;
	}

	public ValidationException(String message, List<ObjectError> details) {
		this.message = message;
		this.details = details;
	}
}
