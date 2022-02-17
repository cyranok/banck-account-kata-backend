package com.kata.bank.account.domain.entity;

import com.kata.bank.account.domain.exception.WithDrawalChecksException;
import com.kata.bank.account.domain.model.Account;
import com.kata.bank.account.domain.model.WithDrawalRequest;
import com.kata.bank.account.domain.port.repository.AccountRepository;

import java.math.BigDecimal;

public class PreWithDrawalChecker {

    private final AccountRepository accountRepository;

    public PreWithDrawalChecker(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void check(WithDrawalRequest request) throws WithDrawalChecksException {
        // TODO: call checkOwnership() to make sure the customer is the owner of the account
        checkSufficientBalance(request);
    }

    private void checkSufficientBalance(final WithDrawalRequest request) throws WithDrawalChecksException{
        Account account = accountRepository.getAccountByNumber(request.getAccountNumber());
        if(account.getBalance().subtract(request.getAmount()).compareTo(BigDecimal.ZERO)<0){
            throw new WithDrawalChecksException("insufficient account balance");
        }
    }
}
