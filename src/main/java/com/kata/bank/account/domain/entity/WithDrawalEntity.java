package com.kata.bank.account.domain.entity;

import com.kata.bank.account.domain.exception.WithDrawException;
import com.kata.bank.account.domain.model.*;
import com.kata.bank.account.domain.port.repository.AccountRepository;

import java.util.Arrays;

public class WithDrawalEntity {

    private final AccountRepository accountRepository;

    public WithDrawalEntity(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public WithDrawalResponse withdraw(WithDrawalRequest request) throws WithDrawException {
        final Operation debitCustomerAccount = new Operation(OperationType.DEBIT, request.getAccountNumber(), request.getAmount().negate());
        final Operation creditSystemAccount = new Operation(OperationType.CREDIT, accountRepository.getSystemAccountNumber(), request.getAmount());
        Account debitedCustomerAccount = accountRepository.processWithDrawal(Arrays.asList(debitCustomerAccount,creditSystemAccount), request.getAccountNumber());
        return new WithDrawalResponse(
                request.getAccountNumber(),
                request.getAmount(),
                debitedCustomerAccount.getBalance()
        );
    }
}
