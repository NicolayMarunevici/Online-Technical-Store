package com.technical.store.online.technical.store.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends RuntimeException{

  public ProductNotFoundException(String message, HttpStatus httpStatus) {
    super(message);
  }
}
