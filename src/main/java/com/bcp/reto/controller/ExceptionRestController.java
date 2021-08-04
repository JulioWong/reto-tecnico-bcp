package com.bcp.reto.controller;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestController {
	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException() {
		
		Map<String, String> err = new HashMap<String, String>();
		err.put("error", "Factor de conversión no encontrado");
		
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
