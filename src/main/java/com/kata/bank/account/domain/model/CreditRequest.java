package com.kata.bank.account.domain.model;

import java.math.BigDecimal;

public class CreditRequest {
    private final BigDecimal amount;
    private final String accountNumber;

    public CreditRequest(BigDecimal amount, String account) {
        this.amount = amount;
        this.accountNumber = account;
    }

    public static CreditRequest build(String accountNumber, BigDecimal amount) {
        return new CreditRequest(amount, accountNumber);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
