package com.demonstration.cadastroPessoaJuridica.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<String> handleValidationException(ResponseStatusException ex){
		String errorMessage = ex.getReason();
		int statusCode = ex.getStatusCode().value();
		
		return ResponseEntity.status(statusCode).body(errorMessage);
	}
	
	@ExceptionHandler(UnrecognizedPropertyException.class)
	public ResponseEntity<String> handleValidationException(UnrecognizedPropertyException ex){
		String message = "Informar um CEP existente";
		
		return ResponseEntity.badRequest().body(message);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            String fieldName = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });		
		return ResponseEntity.badRequest().body(errors);
	}
	

	
}
