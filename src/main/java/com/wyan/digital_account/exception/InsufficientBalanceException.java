package com.wyan.digital_account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InsufficientBalanceException extends ResponseStatusException {

    public InsufficientBalanceException(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }
}
