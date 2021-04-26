package com.org.bookingservice.Exceptions;

import java.io.Serial;

public class RecordAlreadyPresentException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public RecordAlreadyPresentException(String s) {
        super(s);
    }
}

