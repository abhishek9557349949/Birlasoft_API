package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Log the exception or perform additional handling if needed
        e.printStackTrace();

        // Return an appropriate response to the client
        return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        // Log the exception or perform additional handling if needed
        e.printStackTrace();

        // Return a response for entity not found scenario
        return new ResponseEntity<>("Entity not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateEntityException.class)
    public ResponseEntity<String> handleDuplicateEntityException(DuplicateEntityException e) {
        // Log the exception or perform additional handling if needed
        e.printStackTrace();

        // Return a response for duplicate entity scenario
        return new ResponseEntity<>("Entity already exists.", HttpStatus.CONFLICT);
    }

    // Add more exception handlers as needed for specific exceptions in your project
}
