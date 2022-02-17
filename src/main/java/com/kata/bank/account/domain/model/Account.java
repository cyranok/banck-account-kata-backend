package com.kata.bank.account.domain.model;

import java.math.BigDecimal;

/**
 * Represents an account in the application
 */
public class Account {

    private final AccountType type;
    private final String number;
    private final BigDecimal balance;


    public Account(AccountType type, String number, BigDecimal balance) {
        this.type = type;
        this.number = number;
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
