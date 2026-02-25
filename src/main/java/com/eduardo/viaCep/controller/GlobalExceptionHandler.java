package com.eduardo.viaCep.controller;

import com.eduardo.viaCep.business.exceptions.InvalidZipCodeException;
import com.eduardo.viaCep.business.exceptions.ServiceUnavailableException;
import com.eduardo.viaCep.business.exceptions.ZipCodeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidZipCodeException.class)
    public ResponseEntity<String> handlerInvalidZipCodeException(InvalidZipCodeException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<String> handlerInvalidZipCodeException(ServiceUnavailableException exception) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(exception.getMessage());
    }

    @ExceptionHandler(ZipCodeNotFoundException.class)
    public ResponseEntity<String> handlerZipCodeNotFoundException(ZipCodeNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
