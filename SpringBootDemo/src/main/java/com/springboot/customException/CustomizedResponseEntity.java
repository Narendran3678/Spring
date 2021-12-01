package com.springboot.customException;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntity extends ResponseEntityExceptionHandler{

	public CustomizedResponseEntity() {
		super();
	}
	@ExceptionHandler(CourseNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleAllException(CourseNotFoundException ex,WebRequest request)
	{
		ErrorDetails errorDetail = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetail,HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails errorDetail = new ErrorDetails(new Date(),ex.getMessage(),ex.getBindingResult().toString());
		return new ResponseEntity(errorDetail, HttpStatus.BAD_REQUEST);
	}
	
}
