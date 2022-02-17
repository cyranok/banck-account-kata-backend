package com.kata.bank.account.domain.exception;

public class PostCreditValidationException extends RuntimeException {

    public PostCreditValidationException(String message) {
        super(message);
    }
}
