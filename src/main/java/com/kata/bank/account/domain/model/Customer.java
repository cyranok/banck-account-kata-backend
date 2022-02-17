package com.kata.bank.account.domain.model;

public class Customer {
    private final String identifier;
    private final String firstName;
    private final String lastName;
    private final Account account;

    public Customer(String identifier, String firstName, String lastName, Account account) {
        this.identifier = identifier;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }
}
