package com.org.flightservice.Exceptions;

import java.io.Serial;

public class RecordNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public RecordNotFoundException(String message){
        super(message);
    }
}

