package com.org.airportservice.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationErrorHandler extends ResponseEntityExceptionHandler {

    /**
     * for RECORD ALREADY PRESENT EXCEPTION
     */
    @ExceptionHandler(RecordAlreadyPresentException.class)
    public ResponseEntity<ApplicationError> handleRecordAlreadyPresentException(RecordAlreadyPresentException exception, WebRequest webRequest){
        ApplicationError applicationError = new ApplicationError();
        applicationError.setMessage(exception.getMessage());
        return new ResponseEntity<>(applicationError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * for RECORD NOT FOUND EXCEPTION
     */
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ApplicationError> handleRecordNotFoundException(RecordNotFoundException exception, WebRequest webRequest){
        ApplicationError applicationError = new ApplicationError();
        applicationError.setMessage(exception.getMessage());
        return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
    }


}
