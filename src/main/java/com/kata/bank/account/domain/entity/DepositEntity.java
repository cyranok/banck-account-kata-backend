package com.kata.bank.account.domain.entity;

import com.kata.bank.account.domain.exception.DepositException;
import com.kata.bank.account.domain.model.Account;
import com.kata.bank.account.domain.model.CreditRequest;
import com.kata.bank.account.domain.model.Operation;
import com.kata.bank.account.domain.model.OperationType;
import com.kata.bank.account.domain.port.repository.AccountRepository;

import java.util.Arrays;

public class DepositEntity {

    private final AccountRepository accountRepository;

    public DepositEntity(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account makeDeposit(final CreditRequest request) throws DepositException {
        final Operation debitSystemAccount = new Operation(OperationType.DEBIT, accountRepository.getSystemAccountNumber(), request.getAmount().negate());
        final Operation creditCustomerAccount = new Operation(OperationType.CREDIT, request.getAccountNumber(), request.getAmount());
        return accountRepository.makeDeposit(Arrays.asList(debitSystemAccount,creditCustomerAccount), request.getAccountNumber());
    }
}
