package com.example.rushhour.Exception;

public class UserNotFoundByIdException extends RuntimeException {

    public UserNotFoundByIdException(Long id) {

        super(String.format("User with ID: %d - not found", id));
    }
}