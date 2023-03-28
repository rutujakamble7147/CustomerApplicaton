package com.rutuja.CustomerApplication.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Could not find customers " + id);
    }
}