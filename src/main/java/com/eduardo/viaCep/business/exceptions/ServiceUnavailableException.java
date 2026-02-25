package com.eduardo.viaCep.business.exceptions;

public class ServiceUnavailableException extends RuntimeException {
    public ServiceUnavailableException(String message) {
        super(message);
    }

    public ServiceUnavailableException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
