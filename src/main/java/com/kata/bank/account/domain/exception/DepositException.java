package com.kata.bank.account.domain.exception;

public class DepositException extends RuntimeException {
    public DepositException(String message) {
        super(message);
    }
}
