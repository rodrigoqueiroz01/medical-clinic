package com.dev.medicalclinic.api.exception;

import java.io.Serial;

/**
 * @author rodrigoqueiroz
 */

public class DataBadRequestException extends RuntimeException {

    @Serial
    public static final long serialVersionUID = 1L;

    public DataBadRequestException(String message) {
        super(message);
    }
}
