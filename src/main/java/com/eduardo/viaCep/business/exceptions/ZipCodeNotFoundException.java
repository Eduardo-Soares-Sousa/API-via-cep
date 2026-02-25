package com.eduardo.viaCep.business.exceptions;

public class ZipCodeNotFoundException extends RuntimeException {
    public ZipCodeNotFoundException(String message) {
        super(message);
    }

    public ZipCodeNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
