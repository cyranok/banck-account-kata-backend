package com.kata.bank.account.domain.exception;

public class WithDrawException extends RuntimeException {
    public WithDrawException(String message) {
        super(message);
    }
}
