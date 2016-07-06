package com.example.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @autor A_Nakonechnyi
 * @date 05.07.2016.
 */

@ResponseStatus(HttpStatus.CONFLICT)
public class InvalidAdStateTransitionException extends RuntimeException {

    public InvalidAdStateTransitionException(String message) {
        super(message);
    }
}
