package com.kata.bank.account.domain.entity;

import com.kata.bank.account.domain.exception.AcccessSystemAccountForbiddenException;
import com.kata.bank.account.domain.port.repository.AccountRepository;

import java.util.Objects;

public class CheckNotSystemAccountEntity {

    private final AccountRepository accountRepository;

    public CheckNotSystemAccountEntity(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void check(final String accountNumber) throws AcccessSystemAccountForbiddenException {
        if(Objects.equals(accountRepository.getSystemAccountNumber(), accountNumber)){
            throw new AcccessSystemAccountForbiddenException("Operation on system account forbidden");
        }
    }
}
