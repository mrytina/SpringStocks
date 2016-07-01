package com.stocks.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stocks.exception.ValidationException;

@ControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Object defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		Map<String, String> result = new HashMap<>();
		result.put("error", "Unexpected Error");
		result.put("details", e.getMessage());
		return result;
	}

	@ExceptionHandler(value = ValidationException.class)
	@ResponseBody
	public Object validationErrorHandler(HttpServletRequest req, ValidationException e) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("error", "Validation Exception");
		result.put("details", e.getDetails());
		return result;
	}
}
