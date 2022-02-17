package com.kata.bank.account.domain.model;

import java.math.BigDecimal;

public class WithDrawalRequest {

    private final String accountNumber;

    private final BigDecimal amount;

    public WithDrawalRequest(String accountNumber, BigDecimal amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public static WithDrawalRequest build(final String accountNumber, final BigDecimal amount){
        return new WithDrawalRequest(accountNumber, amount);
    }
}
