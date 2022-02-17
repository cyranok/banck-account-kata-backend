package com.kata.bank.account.domain.model;

import java.util.List;

public class AccountHistory {

    private final String accountNumber;

    private final List<Operation> operations;

    public AccountHistory(String accountNumber, List<Operation> operations) {
        this.accountNumber = accountNumber;
        this.operations = operations;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
