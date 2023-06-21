package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.accountService.ResourceNotFoundException;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	public String handleResourceNotFoundException(Exception e) {
	return e.getMessage();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	public String handleException(Exception e) {
	return e.getMessage();
	}

}
