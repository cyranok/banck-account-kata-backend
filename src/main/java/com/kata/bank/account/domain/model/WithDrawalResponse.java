package com.kata.bank.account.domain.model;

import java.math.BigDecimal;

public class WithDrawalResponse {

    private final String accountNumber;
    private final BigDecimal debitedAmount;
    private final BigDecimal accountBalance;

    public WithDrawalResponse(String accountNumber, BigDecimal debitedAmount, BigDecimal accountBalance) {
        this.accountNumber = accountNumber;
        this.debitedAmount = debitedAmount;
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getDebitedAmount() {
        return debitedAmount;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
}
