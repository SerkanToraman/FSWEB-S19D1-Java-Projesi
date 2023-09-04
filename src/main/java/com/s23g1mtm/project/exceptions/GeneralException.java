package com.s23g1mtm.project.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class GeneralException extends RuntimeException{
    private HttpStatus status;
    public GeneralException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
