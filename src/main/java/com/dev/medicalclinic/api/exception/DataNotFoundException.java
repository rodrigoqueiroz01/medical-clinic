package com.dev.medicalclinic.api.exception;

import java.io.Serial;

public class DataNotFoundException extends RuntimeException {

    @Serial
    public static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) {
        super(message);
    }

}
