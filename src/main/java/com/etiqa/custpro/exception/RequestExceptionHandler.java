package com.etiqa.custpro.exception;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.etiqa.custpro.enumeration.Relationship;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class RequestExceptionHandler {
	private static final Pattern ENUM_MSG = Pattern.compile("values accepted for Enum class: \\[([^\\]])\\]");

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleRequestValidation(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();
		FieldError error = ex.getBindingResult().getFieldError();
		String errorMsg = error.getDefaultMessage();
		log.error(ex);
		errorMap.put(error.getField(), errorMsg);
		
		return errorMap;
		
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidFormatException.class)
	public Map<String, String> handleEnumValidation(InvalidFormatException ex) {
		log.error(ex);
		Map<String, String> errorMap = new HashMap<>();
		if (ex.getTargetType().isAssignableFrom(Relationship.class)) {
			errorMap.put("Relationship", "Value should be: " + Arrays.asList(Relationship.class.getEnumConstants()));
		}

		return errorMap;
	}
}
