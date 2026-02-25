package com.eduardo.viaCep.business.exceptions;

public class InvalidZipCodeException extends RuntimeException {
  public InvalidZipCodeException(String message) {
    super(message);
  }
}
