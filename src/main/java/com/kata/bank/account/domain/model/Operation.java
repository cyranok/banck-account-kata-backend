package com.kata.bank.account.domain.model;

import java.math.BigDecimal;

public class Operation {
    private final OperationType type;
    private final String accountNumber;
    private final BigDecimal amount;


    public Operation(OperationType type, String accountNumber, BigDecimal amount) {
        this.type = type;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public OperationType getType() {
        return type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
