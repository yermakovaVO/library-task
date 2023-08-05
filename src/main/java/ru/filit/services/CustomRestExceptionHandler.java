package ru.filit.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({HttpClientErrorException.class})
	public ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException ex, WebRequest request) {

		return new ResponseEntity<Object>(
				ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

}
