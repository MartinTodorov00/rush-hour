package com.example.rushhour.advices;

import com.example.rushhour.Exception.EmailAlreadyExistsException;
import com.example.rushhour.Exception.UserNotFoundByIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundByIdException.class)
    public ResponseEntity<Object> handleUserNotFoundByIdException(UserNotFoundByIdException ex) {
        return new ResponseEntity<>(ExceptionUtil.getBody(ex, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Object> handleEmailAddressAlreadyExistsException(EmailAlreadyExistsException ex) {
        return new ResponseEntity<>(ExceptionUtil.getBody(ex, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
}
