package com.kata.bank.account.domain.exception;

public class AcccessSystemAccountForbiddenException extends RuntimeException {

    public AcccessSystemAccountForbiddenException(String message) {
        super(message);
    }
}
