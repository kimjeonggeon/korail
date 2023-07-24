package com.example.korail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StationRestExceptionHandler {

    // add exception handling code
    @ExceptionHandler
    public ResponseEntity<StationErrorResponse> handleException(StationNotFoundException exc) {

        // create a station error response
        StationErrorResponse error = new StationErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // catch all exception
    @ExceptionHandler
    public ResponseEntity<StationErrorResponse> handleException(Exception exc) {

        // create a station error response
        StationErrorResponse error = new StationErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
