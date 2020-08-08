package com.udemy.controllers.exceptions;

import com.udemy.services.exceptions.DatabaseException;
import com.udemy.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandError> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest httpServletRequest){
        String error = "Resource not found";
        HttpStatus  status = HttpStatus.NOT_FOUND;
        StandError standError = new StandError(Instant.now(),status.value(),error, ex.getMessage(),httpServletRequest.getRequestURI());
        return ResponseEntity.status(status).body(standError);

    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandError> database(DatabaseException ex, HttpServletRequest httpServletRequest){
        String error = "database error";
        HttpStatus  status = HttpStatus.BAD_REQUEST;
        StandError standError = new StandError(Instant.now(),status.value(),error, ex.getMessage(),httpServletRequest.getRequestURI());
        return ResponseEntity.status(status).body(standError);

    }
}
