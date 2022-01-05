package com.example.rushhour.Exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String email) {

        super(String.format("%s already exists!", email));
    }
}